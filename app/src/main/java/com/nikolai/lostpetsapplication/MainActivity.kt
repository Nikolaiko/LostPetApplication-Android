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
import com.nikolai.lostpetsapplication.services.localStorage.UserDataStorage
import com.nikolai.lostpetsapplication.ui.theme.LostPetsApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userDataRepository: UserDataStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startingLocation = when(userDataRepository.getTokens()) {
            null -> "Auth"
            else -> "Main"
        }

        setContent {
            val navigationController = rememberNavController()

            LostPetsApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavHost(navController = navigationController, startDestination = startingLocation) {
                        navigation(startDestination = "AuthScreen", route = "Auth") {
                            composable(route = "AuthScreen") {
                                val viewModel = hiltViewModel<AuthScreenViewModel>()
                                AuthScreenView(
                                    viewModel = viewModel
                                )
                            }
                        }
                        navigation(startDestination = "MainScreen", route = "Main") {
                            composable(route = "MainScreen") {
                                MainScreenView()
                            }
                        }
                    }
                }
            }
        }
    }
}