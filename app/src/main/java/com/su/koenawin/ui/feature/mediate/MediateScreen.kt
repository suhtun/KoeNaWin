package com.su.koenawin.ui.feature.mediate

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MediateScreen(id: String,viewModel: MediateViewModel = hiltViewModel()) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()){
            val koeNaWinUiData= viewModel.findKoeNaWin(id)
            koeNaWinUiData?.totalCount?.let { viewModel.calculateTotalCount(it) }
            Column(modifier = Modifier.align(Alignment.TopCenter).padding(top = 60.dp)) {
                Text(text = "${koeNaWinUiData?.goneDaw}${koeNaWinUiData?.countName}",fontSize=28.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
                Text(modifier = Modifier
                    .padding(top = 16.dp), text = "${koeNaWinUiData?.goneDawDesc}${koeNaWinUiData?.countName}",fontSize=16.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
            }
            OutlinedButton(onClick = { viewModel.decreaseCount() },
                modifier= Modifier
                    .align(Alignment.Center)
                    .size(250.dp),  //avoid the oval shape
                shape = CircleShape,
                border= BorderStroke(8.dp, Color.Yellow),
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Yellow)
            ) {
                Text(text = viewModel.showCurrentValue(),fontSize=28.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}