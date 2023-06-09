package com.su.koenawin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.su.koenawin.Destinations.HOME_ROUTE
import com.su.koenawin.Destinations.MEDIATE_ROUTE
import com.su.koenawin.ui.feature.home.HomeScreen
import com.su.koenawin.ui.feature.mediate.MediateScreen
import androidx.navigation.compose.composable

object Destinations {
    const val HOME_ROUTE = "home"
    const val MEDIATE_ROUTE = "mediate/{id}"
}

@Composable
fun KoeNaWinAppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
    ) {
        composable(HOME_ROUTE) {
            HomeScreen(onNavigateToMediate = {navController.navigate(route = "mediate/$it")})
        }

        composable(MEDIATE_ROUTE) {
            val id = it.arguments?.getString("id")
            MediateScreen(id?:"")
        }
    }
}