package com.su.koenawin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.su.koenawin.navigation.Destinations
import com.su.koenawin.navigation.KnwAppNavHost
import com.su.koenawin.ui.theme.KoeNaWinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KoeNaWinApp(){
    KoeNaWinTheme {
        val navController: NavHostController = rememberNavController()
        // NavController is passed via parameter
        val backStackEntry = navController.currentBackStackEntryAsState()
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ) {
                        val bottomNavItems = listOf(
                            BottomNavItem(
                                name = "ကိုးနဝင်း",
                                route = Destinations.HOME_ROUTE,
                                icon = Icons.Rounded.Home,
                            ),
                            BottomNavItem(
                                name = "မေတ္တာပွားရန်",
                                route = Destinations.MITTAR_ROUTE,
                                icon = Icons.Rounded.FavoriteBorder,
                            ),
                            BottomNavItem(
                                name = "Settings",
                                route = Destinations.SETTING_ROUTE,
                                icon = Icons.Rounded.Settings,
                            ),
                        )

                        bottomNavItems.forEach { item ->
                            val selected =
                                item.route == backStackEntry.value?.destination?.route

                            NavigationBarItem(
                                selected = selected,
                                onClick = { navController.navigate(item.route) },
                                label = {
                                    Text(
                                        text = item.name,
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                },
                                icon = {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = "${item.name} Icon",
                                    )
                                }
                            )
                        }
                    }
                },
                content = { padding ->

                    KnwAppNavHost(navController = navController, modifier = Modifier.padding(padding))


                })
        }
    }
}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)