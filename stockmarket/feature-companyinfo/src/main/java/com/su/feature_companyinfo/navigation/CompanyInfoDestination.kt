package com.su.feature_companyinfo.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.su.core_commom.navigation.KnwNavigationDestination
import com.su.feature_companyinfo.CompanyInfoRoute
import com.su.feature_companyinfo.navigation.CompanyInfoDestination.symbolArgs

object CompanyInfoDestination: KnwNavigationDestination {
    override val route = "company_info_route"
    override val destination = "company_info_destination"
    const val symbolArgs = "topicId"
}

fun NavGraphBuilder.companyInfoGraph(
    onBack: () -> Unit,
) {
    composable(route = "${CompanyInfoDestination.route}/{${symbolArgs}}",
    arguments = listOf(
        navArgument(symbolArgs) {
            type = NavType.StringType
        }
    )) {
        CompanyInfoRoute(onBack = {onBack()})
    }
}