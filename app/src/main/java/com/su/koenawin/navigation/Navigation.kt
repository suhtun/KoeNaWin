package com.su.koenawin.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.su.feature_companyinfo.navigation.CompanyInfoDestination
import com.su.feature_companyinfo.navigation.companyInfoGraph
import com.su.feature_companylisting.navigation.CompanyListingDestination
import com.su.feature_companylisting.navigation.companyListingGraph
@Composable
fun KnwAppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = CompanyListingDestination.route,
        modifier = modifier
    ) {
        companyListingGraph(navigateToCompanyInfo = { navController.navigate("${CompanyInfoDestination.route}/${it}") },
            nestedGraphs = {
                companyInfoGraph(onBack = { navController.popBackStack() })
            })
    }
}