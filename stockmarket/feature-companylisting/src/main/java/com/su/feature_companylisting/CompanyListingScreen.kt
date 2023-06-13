package com.su.feature_companylisting

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.su.core_model.CompanyListUiData

@Composable
fun CompanyListingRoute(
    modifier: Modifier = Modifier,
    navigateToCompanyInfo: (symbol:String) -> Unit,
    viewModel: CompanyListingViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    CompanyListingScreen(modifier = modifier, uiState = uiState.stockMarketState, onClick = {
        Log.d("dsafdsaf","asdaa")
        navigateToCompanyInfo(it)})
}

@Composable
fun CompanyListingScreen(modifier: Modifier, uiState: StockMarketState,onClick:(symbol:String) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        when (uiState) {
            is StockMarketState.Success -> {
                uiState.companies.let { company ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(uiState.companies.size) { i ->
                            val company = uiState.companies[i]
                            CompanyItem(
                                company = company,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        Log.d("dsafdsaf","asdff")
                                        onClick(company.symbol)
                                    }
                                    .padding(16.dp)
                            )
                            if (i < uiState.companies.size) {
                                Divider(
                                    modifier = Modifier.padding(
                                        horizontal = 16.dp
                                    )
                                )
                            }
                        }
                    }
                }
            }

            StockMarketState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            else -> {}
        }
    }
}

@Composable
fun CompanyItem(
    company: CompanyListUiData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = company.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = company.exchange,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "(${company.symbol})",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

