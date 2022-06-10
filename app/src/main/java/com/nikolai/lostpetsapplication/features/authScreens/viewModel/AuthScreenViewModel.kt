package com.nikolai.lostpetsapplication.features.authScreens.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikolai.lostpetsapplication.features.authScreens.model.AuthScreenState
import com.nikolai.lostpetsapplication.features.authScreens.model.AuthScreenType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(

) : ViewModel() {
    private val selectedType = MutableLiveData<AuthScreenType>()

    val state = AuthScreenState(
        selectedType = selectedType
    )

    fun setAuthScreenType(screenType: AuthScreenType) {
        selectedType.postValue(screenType)
    }
}