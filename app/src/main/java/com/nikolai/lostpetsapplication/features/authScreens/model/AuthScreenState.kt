package com.nikolai.lostpetsapplication.features.authScreens.model

import androidx.lifecycle.LiveData

data class AuthScreenState(
    val selectedType: LiveData<AuthScreenType>,
    val loginValue: LiveData<String>,
    val loginPasswordValue: LiveData<String>
)
