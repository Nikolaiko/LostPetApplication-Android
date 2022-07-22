package com.nikolai.lostpetsapplication.services.localStorage

import com.nikolai.lostpetsapplication.model.user.UserTokens

interface UserDataStorage {
    fun saveTokens(tokens: UserTokens)
    fun getTokens(): UserTokens?
}