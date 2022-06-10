package com.nikolai.lostpetsapplication.features.authScreens.consts

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nikolai.lostpetsapplication.ui.colors.mainWhite
import com.nikolai.lostpetsapplication.ui.colors.neutralBlack
import com.nikolai.lostpetsapplication.ui.fonts.poppinsFamily

val authSelectorStyle = TextStyle(
    fontSize = 16.sp,
    fontFamily = poppinsFamily,
    fontWeight = FontWeight.Bold,
    color = neutralBlack
)

val pawButtonStyle = TextStyle(
    fontSize = 16.sp,
    fontFamily = poppinsFamily,
    fontWeight = FontWeight.Bold,
    color = mainWhite
)

val textButtonStyle = TextStyle(
    fontSize = 16.sp,
    fontFamily = poppinsFamily,
    fontWeight = FontWeight.SemiBold,
    color = neutralBlack
)