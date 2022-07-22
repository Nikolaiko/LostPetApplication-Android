package com.nikolai.lostpetsapplication.features.authScreens.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikolai.lostpetsapplication.features.authScreens.model.AuthScreenState
import com.nikolai.lostpetsapplication.features.authScreens.model.AuthScreenType
import com.nikolai.lostpetsapplication.model.user.LoginUserData
import com.nikolai.lostpetsapplication.services.localStorage.UserDataStorage
import com.nikolai.lostpetsapplication.services.network.NetworkLayer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val network: NetworkLayer,
    private val userDataStorage: UserDataStorage
) : ViewModel() {
    private val selectedType = MutableLiveData<AuthScreenType>()

    var state = AuthScreenState(
        selectedType = selectedType
    )

    var loginEmail: String = ""
    var loginPassword: String = ""

    var registerEmail: String = ""
    var registerPassword: String = ""
    var registerConfirmPassword: String = ""
    var registerName: String = ""

    fun setAuthScreenType(screenType: AuthScreenType) {
        selectedType.postValue(screenType)
    }

    fun onLoginEmailChange(newValue: String) {
        loginEmail = newValue
    }

    fun onLoginPasswordChange(newValue: String) {
        loginPassword = newValue
    }

    fun onRegisterEmailChange(newValue: String) {
        registerEmail = newValue

    }

    fun onRegisterPasswordChange(newValue: String) {
        registerPassword = newValue
    }

    fun onRegisterPasswordConfirmChange(newValue: String) {
        registerConfirmPassword = newValue
    }

    fun onRegisterNameChange(newValue: String) {
        registerName = newValue
    }

    fun tryToLogin() {
        viewModelScope.launch {
            val loginData = LoginUserData(email = loginEmail, password = loginPassword)
            when(val loginTokens = network.loginRequest(loginData)) {
                null -> { }
                else -> {
                    userDataStorage.saveTokens(loginTokens)
                }
            }
        }
    }

    fun tryToRegister() {
        network.registerRequest("Some", "Some")
    }


}