package com.nikolai.lostpetsapplication.services.navigation

import androidx.navigation.NavHostController
import com.nikolai.lostpetsapplication.model.navigation.AppDestinations

class ControllerNavigation : AppNavigation {

    override var controller: NavHostController? = null

    override fun navigateTo(destination: AppDestinations) {
        println("Navigation: $destination")
        println("Controller: $controller")
        controller?.navigate(destination.name)
    }
}