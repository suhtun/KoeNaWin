package com.su.feature_stockmarket.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.su.core_commom.navigation.KnwNavigationDestination
import com.su.feature_stockmarket.ui.StockMarketMainRoute


object StockMarketDestination : KnwNavigationDestination {
    override val route = "stock_market_route"
    override val destination = "stock_market_destination"
}

fun NavGraphBuilder.stockMarketGraph(
    navigateToTopic: (String) -> Unit,
) {
    composable(route = StockMarketDestination.route) {
        StockMarketMainRoute(onClick = {navigateToTopic("a")})
    }


}