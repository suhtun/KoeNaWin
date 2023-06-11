package com.su.koenawin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.su.koenawin.Destinations.HOME_ROUTE
import com.su.koenawin.Destinations.MEDIATE_ROUTE
import com.su.koenawin.ui.feature.home.HomeScreen
import com.su.koenawin.ui.feature.mediate.MediateScreen
import androidx.navigation.compose.composable
import com.su.koenawin.ui.feature.MittarScreen
import com.su.koenawin.ui.feature.SettingScreen

object Destinations {
    const val HOME_ROUTE = "home"
    const val MITTAR_ROUTE = "mittar"
    const val SETTING_ROUTE = "setting"
    const val MEDIATE_ROUTE = "mediate/{gontaw}/{gontawTranslation}/{viewCount}/{count}"
}

@Composable
fun KoeNaWinAppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
    ) {
        composable(HOME_ROUTE) {
            HomeScreen(onNavigateToMediate = {navController.navigate(route = "mediate/${it.goneDaw}/${it?.goneDawDesc}/${it?.countName}/${it?.totalCount}")})
        }

        composable(MEDIATE_ROUTE) {
            val gontaw = it.arguments?.getString("gontaw")
            val gontawTranslation = it.arguments?.getString("gontawTranslation")
            val viewcount = it.arguments?.getString("viewCount")
            val count = it.arguments?.getString("count")?.toInt()
            MediateScreen(gonTaw =gontaw ?:"",gonTawTranslation = gontawTranslation ?:"", showCount =viewcount ?:"", count = count ?: 0)
        }

        composable(Destinations.MITTAR_ROUTE){
            MittarScreen()
        }

        composable(Destinations.SETTING_ROUTE){
            SettingScreen()
        }
    }
}