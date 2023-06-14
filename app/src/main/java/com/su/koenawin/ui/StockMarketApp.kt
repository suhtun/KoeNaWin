package com.su.koenawin.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.su.koenawin.navigation.KnwAppNavHost
import com.su.koenawin.ui.theme.KoeNaWinTheme

@Composable
fun StockMarketApp() {
    KoeNaWinTheme {
        val navController: NavHostController = rememberNavController()
        // NavController is passed via parameter
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            KnwAppNavHost(navController = navController)
        }
    }
}
