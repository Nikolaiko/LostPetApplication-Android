package com.nikolai.lostpetsapplication.services.navigation

import androidx.navigation.NavHostController
import com.nikolai.lostpetsapplication.model.navigation.AppDestinations

interface AppNavigation {
    var controller: NavHostController?

    fun navigateTo(destination: AppDestinations)
}