package com.su.koenawin.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.su.koenawin.navigation.Destinations.HOME_ROUTE
import com.su.koenawin.navigation.Destinations.MEDIATE_ROUTE
import com.su.koenawin.ui.feature.home.HomeRoute
import com.su.koenawin.ui.feature.mediate.MediateRoute
import com.su.koenawin.ui.feature.mittar.MittarScreen
import com.su.koenawin.ui.feature.setting.SettingScreen

object Destinations {
    const val HOME_ROUTE = "home"
    const val MITTAR_ROUTE = "mittar"
    const val SETTING_ROUTE = "setting"
    const val MEDIATE_ROUTE = "mediate/{gontaw}/{gontawTranslation}/{viewCount}/{count}"
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun KnwAppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        modifier = modifier
    ) {
        composable(HOME_ROUTE) {
            HomeRoute(onNavigateToMediate = { navController.navigate(route = "mediate/${it?.gontaw}/${it?.gontawTranslation}/${it?.showCount}/${it?.count}") })
        }

        composable(MEDIATE_ROUTE) {
            val gontaw = it.arguments?.getString("gontaw")
            val gontawTranslation = it.arguments?.getString("gontawTranslation")
            val viewcount = it.arguments?.getString("viewCount")
            val count = it.arguments?.getString("count")?.toInt()
            MediateRoute(
                gonTaw = gontaw ?: "",
                gonTawTranslation = gontawTranslation ?: "",
                showCount = viewcount ?: "",
                count = count ?: 0,
                onBackClick = { navController.navigateUp() })
        }

        composable(Destinations.MITTAR_ROUTE) {
            MittarScreen()
        }

        composable(Destinations.SETTING_ROUTE) {
            SettingScreen()
        }
    }
}