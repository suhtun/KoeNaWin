package com.su.koenawin.ui.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.su.core_model.KoeNaWinUiData
import com.su.koenawin.R
import com.su.koenawin.ui.KnwLoadingWheel


@Composable
fun HomeRoute(
    onNavigateToMediate: (uiData: KoeNaWinUiData?) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState: HomeScreenUiState by viewModel.userFlow.collectAsState()

    HomeScreen(
        koeNaWinUiState = uiState.koeNaWinUiState,
        onClick = { onNavigateToMediate(viewModel.findKoeNaWin(it)) },
        modifier = modifier,
    )
}

@Composable
internal fun HomeScreen(
    koeNaWinUiState: KoeNaWinUiState,
    onClick: (koeNaWinUiDataId: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column() {
        AppTopBar(onBackPress = {})

        Spacer(Modifier.heightIn(min = 20.dp))

        when (koeNaWinUiState) {
            KoeNaWinUiState.Loading -> {
                KnwLoadingWheel(
                    modifier = modifier,
                    contentDesc = stringResource(id = R.string.loading)
                )
            }

            is Error -> {}
            is KoeNaWinUiState.Success -> {
                GridView(koeNaWinList = koeNaWinUiState.koeNaWin, onClick = { onClick(it) })
            }

            else -> {}
        }
    }

}


@Composable
fun AppTopBar(onBackPress: () -> Unit) {
    Row(Modifier.fillMaxWidth()) {
        IconButton(onClick = onBackPress) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(R.string.ic_profile)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "        ကိုးနဝင်းမိုးလင်းမှသိမယ် - ပထမ အဆင့်",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Yellow
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun GridView(koeNaWinList: List<KoeNaWinUiData>, onClick: (koeNaWinUiDataId: Int) -> Unit) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(koeNaWinList.size) {
            Card(
                onClick = { onClick(koeNaWinList[it].id) },
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(top = 1.dp, start = 1.dp, end = 2.dp, bottom = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Yellow)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "${koeNaWinList[it].dayString}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFff8d00)
                    )
                    Text(
                        text = "${koeNaWinList[it].gontaw}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Text(
                        text = "${koeNaWinList[it].showCount}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                }
            }
        }
    }

}