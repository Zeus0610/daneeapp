package com.zeus.daneeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zeus.daneeapp.ui.screens.DeberSerScreen
import com.zeus.daneeapp.ui.screens.DetailsScreen
import com.zeus.daneeapp.ui.screens.HomeScreen

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavScreens.HomeScreen.route
    ) {
        composable(NavScreens.HomeScreen.route) {
            HomeScreen(
                onNavigateToList = {
                    navController.navigate(NavScreens.ListScreen.route)
                },
                onNavigateToDetails = { message ->
                    navController.navigate(NavScreens.DetailsScreen.createRoute(message))
                }
            )
        }

        composable(NavScreens.ListScreen.route) {
            DeberSerScreen()
        }

        composable(NavScreens.DetailsScreen.route,
            arguments = listOf(
                navArgument("message") {
                    defaultValue = ""
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { backStack ->
            val message = backStack.arguments?.getString("message")?: ""

            DetailsScreen(
                message = message
            )
        }
    }
}

sealed class NavScreens(val route: String) {
    data object HomeScreen: NavScreens("Home")
    data object ListScreen: NavScreens("List")
    data object DetailsScreen: NavScreens("Details?message={message}") { /** algo/path,  algo?message=Hola-Mundo     */
        fun createRoute(message: String) = "Details?message=$message"
    }
}