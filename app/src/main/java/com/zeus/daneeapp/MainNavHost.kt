package com.zeus.daneeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zeus.daneeapp.ui.screens.DetailsScreen
import com.zeus.daneeapp.ui.screens.HomeScreen
import com.zeus.daneeapp.ui.screens.ListScreen

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
            ListScreen(
                onNavigateToDetails = { characterId ->
                    navController.navigate(NavScreens.DetailsScreen.createRoute(characterId))
                }
            )
        }

        composable(NavScreens.DetailsScreen.route,
            arguments = listOf(
                navArgument("characterId") {
                    defaultValue = ""
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { backStack ->
            val characterId = backStack.arguments?.getString("characterId")?: ""

            DetailsScreen(
                characterId = characterId
            )
        }
    }
}

sealed class NavScreens(val route: String) {
    data object HomeScreen: NavScreens("Home")
    data object ListScreen: NavScreens("List")
    data object DetailsScreen: NavScreens("Details?characterId={characterId}") { /** algo/path,  algo?message=Hola-Mundo     */
        fun createRoute(characterId: String) = "Details?characterId=$characterId"
    }
}