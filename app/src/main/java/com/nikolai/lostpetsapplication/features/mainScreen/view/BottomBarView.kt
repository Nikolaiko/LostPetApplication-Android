package com.nikolai.lostpetsapplication.features.mainScreen.view

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.nikolai.lostpetsapplication.model.tabBar.BottomBarItem
import com.nikolai.lostpetsapplication.model.typedefs.StringCallback
import com.nikolai.lostpetsapplication.ui.colors.mainBlue
import com.nikolai.lostpetsapplication.ui.colors.mainWhite

@Composable
fun BottomBarView(
    currentRoute: String,
    onItemClick: StringCallback? = {}
) {
    val items = listOf(
        BottomBarItem.ListTabItem,
        BottomBarItem.AddTabItem,
        BottomBarItem.ProfileTabItem
    )

    BottomAppBar(
        contentColor = Color.Red,
        backgroundColor = mainBlue
    ) {
        items.forEach { item ->
            println(item.route)
            println(currentRoute == item.route)
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.iconId), contentDescription = item.route) },
                selected = currentRoute == item.route,
                selectedContentColor = Color.Yellow,
                alwaysShowLabel = true,
                label =  { Text(item.route) },
                onClick = { onItemClick?.invoke(item.route) }
            )
        }
    }
}