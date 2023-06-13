package com.su.feature_companylisting.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.su.core_commom.navigation.KnwNavigationDestination
import com.su.feature_companylisting.CompanyListingRoute

object CompanyListingDestination: KnwNavigationDestination {
    override val route = "company_listing_route"
    override val destination = "company_listing_destination"
}

fun NavGraphBuilder.companyListingGraph(
    navigateToCompanyInfo: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    composable(route = CompanyListingDestination.route) {
        CompanyListingRoute(navigateToCompanyInfo = {navigateToCompanyInfo(it)})
    }
    nestedGraphs()
}