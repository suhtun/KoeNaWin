package com.su.koenawin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
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
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.su.koenawin.Destinations.HOME_ROUTE
import com.su.koenawin.Destinations.MITTAR_ROUTE
import com.su.koenawin.Destinations.SETTING_ROUTE
import com.su.koenawin.ui.theme.KoeNaWinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoeNaWinTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    KoeNaWinAppNavHost()
//                }
                val navController: NavHostController = rememberNavController()
                // NavController is passed via parameter
                val backStackEntry = navController.currentBackStackEntryAsState()
                Scaffold(
                    bottomBar = {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ) {
                            val bottomNavItems = listOf(
                                BottomNavItem(
                                    name = "ကိုးနဝင်း",
                                    route = HOME_ROUTE,
                                    icon = Icons.Rounded.Home,
                                ),
                                BottomNavItem(
                                    name = "မေတ္တာပွားရန်",
                                    route = MITTAR_ROUTE,
                                    icon = Icons.Rounded.FavoriteBorder,
                                ),
                                BottomNavItem(
                                    name = "Settings",
                                    route = SETTING_ROUTE,
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
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            KoeNaWinAppNavHost(navController = navController)
                        }

                    })
            }
        }
    }
}

