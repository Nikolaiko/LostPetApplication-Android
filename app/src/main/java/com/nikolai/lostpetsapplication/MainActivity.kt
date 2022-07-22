package com.nikolai.lostpetsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.nikolai.lostpetsapplication.features.authScreens.viewModel.AuthScreenViewModel
import com.nikolai.lostpetsapplication.features.authScreens.views.AuthScreenView
import com.nikolai.lostpetsapplication.features.mainScreen.view.MainScreenView
import com.nikolai.lostpetsapplication.model.navigation.AppDestinations
import com.nikolai.lostpetsapplication.model.navigation.authGraph
import com.nikolai.lostpetsapplication.model.navigation.mainGraph
import com.nikolai.lostpetsapplication.services.localStorage.UserDataStorage
import com.nikolai.lostpetsapplication.services.navigation.AppNavigation
import com.nikolai.lostpetsapplication.ui.theme.LostPetsApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userDataRepository: UserDataStorage

    @Inject
    lateinit var navigation: AppNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startingLocation = when(userDataRepository.getTokens()) {
            null -> authGraph
            else -> authGraph
        }

        setContent {
            val navigationController = rememberNavController()
            navigation.controller = navigationController

            LostPetsApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavHost(navController = navigationController, startDestination = startingLocation) {

                        navigation(startDestination = AppDestinations.AuthScreen.name, route = authGraph) {
                            composable(route = AppDestinations.AuthScreen.name) {
                                val viewModel = hiltViewModel<AuthScreenViewModel>()
                                AuthScreenView(
                                    viewModel = viewModel
                                )
                            }
                        }

                        navigation(startDestination = AppDestinations.MainScreen.name, route = mainGraph) {
                            composable(route = AppDestinations.MainScreen.name) {
                                MainScreenView()
                            }
                        }
                    }
                }
            }
        }
    }
}