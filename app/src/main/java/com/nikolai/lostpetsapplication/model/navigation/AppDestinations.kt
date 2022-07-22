package com.nikolai.lostpetsapplication.model.navigation

sealed class AppDestinations(
    val name: String
) {
    object AuthScreen: AppDestinations(authScreenName)
    object MainScreen: AppDestinations(mainScreenName)
}
