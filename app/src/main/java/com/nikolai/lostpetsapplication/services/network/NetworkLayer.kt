package com.nikolai.lostpetsapplication.services.network

import com.nikolai.lostpetsapplication.model.user.LoginUserData
import com.nikolai.lostpetsapplication.model.user.UserTokens

interface NetworkLayer {
    suspend fun loginRequest(loginUserData: LoginUserData): UserTokens?
    fun registerRequest(login: String, password: String)
}