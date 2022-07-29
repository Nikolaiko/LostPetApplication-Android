package com.nikolai.lostpetsapplication.features.mainScreen.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolai.lostpetsapplication.model.tabBar.BottomBarItem

@Composable
fun MainScreenView() {

    val tabsNavigator = rememberNavController()
    val currentTab = remember { MutableLiveData(BottomBarItem.ListTabItem.route) }
    val currentTabObservable = currentTab.observeAsState(BottomBarItem.ListTabItem.route)

    Scaffold(
        bottomBar = {
            BottomBarView(
                currentRoute = currentTabObservable.value,
                onItemClick = {
                    tabsNavigator.navigate(it) {
                        tabsNavigator.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                        currentTab.postValue(it)
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(
                PaddingValues(0.dp, 0.dp, 0.dp, it.calculateBottomPadding())
            )
        ) {
            NavHost(navController = tabsNavigator, startDestination = BottomBarItem.ListTabItem.route) {
                composable(route = BottomBarItem.ListTabItem.route) {
                    Text(text = "LIST")
                }
                composable(route = BottomBarItem.AddTabItem.route) {
                    Text(text = "Add")
                }
                composable(route = BottomBarItem.ProfileTabItem.route) {
                    Text(text = "Profile")
                }
            }
        }
    }
}