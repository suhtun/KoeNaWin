package com.su.koenawin.ui.feature.mediate

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.su.core_model.KoeNaWinUiData
import com.su.koenawin.ui.feature.home.HomeScreenUiState

@Composable
fun MediateRoute(gonTaw:String, gonTawTranslation:String, showCount:String, count:Int, onBackClick:()-> Unit,viewModel: MediateViewModel = hiltViewModel()){
    viewModel.calculateTotalCount(count)
    val uiData: MediateUiData by viewModel.totalCount.collectAsState()
    MediateScreen(gonTaw = gonTaw, gonTawTranslation = gonTawTranslation, showCount = showCount, currentCount = uiData.totalCount.toString() , onClick = {viewModel.decreaseCount()} )
    BackHandler {
        onBackClick()
    }
}
@Composable
fun MediateScreen(gonTaw:String, gonTawTranslation:String, currentCount:String, showCount:String,onClick: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()){
            Column(modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 60.dp)) {
                Text(text = "${gonTaw}${showCount}",fontSize=28.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
                Text(modifier = Modifier
                    .padding(top = 16.dp), text = "${gonTawTranslation}",fontSize=16.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
            }
            OutlinedButton(onClick = { onClick() },
                modifier= Modifier
                    .align(Alignment.Center)
                    .size(250.dp),  //avoid the oval shape
                shape = CircleShape,
                border= BorderStroke(8.dp, Color.Yellow),
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Yellow)
            ) {
                Text(text = currentCount,fontSize=28.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}