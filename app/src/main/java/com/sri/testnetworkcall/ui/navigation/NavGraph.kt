package com.sri.testnetworkcall.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sri.testnetworkcall.ui.screens.detail.view.DetailsScreen
import com.sri.testnetworkcall.ui.screens.home.view.UsersListScreen

enum class ScreenName {
    USERS,
    DETAILS
}

sealed class Screen(val route: String) {

    data object Users : Screen(ScreenName.USERS.name)

    data object Details : Screen(ScreenName.DETAILS.name)
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screen.Users.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Users.route) {
            UsersListScreen(navController)
        }
        composable(Screen.Details.route) {
            DetailsScreen(navController)
        }
    }
}