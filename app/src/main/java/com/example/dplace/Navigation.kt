package com.example.dplace

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginPage.route) {
        composable(
            route = Screen.LoginPage.route
        ) {
            LoginPage(navController)
        }
    }
}