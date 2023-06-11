package com.su.koenawin.ui.feature.home

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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.su.core_commom.Result
import com.su.core_model.KoeNaWinUiData
import com.su.koenawin.R
import java.lang.Error

@Composable
fun HomeScreen(onNavigateToMediate: (koeNaWinUiDataId: KoeNaWinUiData) -> Unit, viewModel: HomeViewModel= hiltViewModel()) {
    val uiState: HomeScreenUiState by viewModel.userFlow.collectAsState()
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(){
            AppTopBar(onBackPress = {})
            Spacer(Modifier.heightIn(min = 20.dp))
            val koeNaWinUiState = uiState.koeNaWinUiState
            when(koeNaWinUiState){
                KoeNaWinUiState.Loading -> {}
                KoeNaWinUiState.Error -> {}
                is KoeNaWinUiState.Success ->{

                    GridView(koeNaWinList = koeNaWinUiState.koeNaWin, onClick ={ viewModel.findKoeNaWin(koeNaWinUiState.koeNaWin,it)
                        ?.let { it1 -> onNavigateToMediate(it1) } } )
                }
            }
        }
    }
}

@Composable
fun AppTopBar(onBackPress: () -> Unit){
    Row(Modifier.fillMaxWidth()) {
        IconButton(onClick = onBackPress) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(R.string.ic_profile)
            )
        }
        Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)){
            Text(text = "        ကိုးနဝင်းမိုးလင်းမှသိမယ် - ပထမ အဆင့်",fontSize=16.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridView(koeNaWinList:List<KoeNaWinUiData>, onClick: (koeNaWinUiDataId:String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 138.dp)
    ) {
        items(koeNaWinList.size) {
            Card(onClick = {onClick(koeNaWinList[it].id)}, shape = RoundedCornerShape(20.dp), modifier = Modifier.padding(top = 1.dp, start = 1.dp, end = 2.dp, bottom = 8.dp), colors = CardDefaults.cardColors(containerColor = Color.Yellow)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
                    .fillMaxWidth().padding(10.dp)) {
                    Text( text = "${koeNaWinList[it].dayString}",fontSize=16.sp, fontWeight = FontWeight.Bold, color = Color(0xFFff8d00))
                    Text( text = "${koeNaWinList[it].goneDaw}",fontSize=16.sp, fontWeight = FontWeight.Normal, color = Color.Black)
                    Text( text = "${koeNaWinList[it].countName}",fontSize=16.sp, fontWeight = FontWeight.Normal, color = Color.Black)
                }
            }
        }
    }

}