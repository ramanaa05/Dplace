package com.example.dplace

sealed class Screen(val route: String) {
    data object LoginPage : Screen("login_page")
}