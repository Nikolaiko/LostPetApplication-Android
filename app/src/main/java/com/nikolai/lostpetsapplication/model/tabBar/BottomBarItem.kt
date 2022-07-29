package com.nikolai.lostpetsapplication.model.tabBar

import com.nikolai.lostpetsapplication.R

sealed class BottomBarItem(
    val route: String,
    val iconId: Int
) {
    object ListTabItem : BottomBarItem("homeTab", R.drawable.bottom_par_pawn)
    object ProfileTabItem : BottomBarItem("settingsTab", R.drawable.bottom_bar_profile)
    object AddTabItem : BottomBarItem("addTab", R.drawable.bottom_bar_plus)
}
