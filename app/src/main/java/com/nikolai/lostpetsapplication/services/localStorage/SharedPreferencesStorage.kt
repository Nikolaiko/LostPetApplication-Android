package com.nikolai.lostpetsapplication.services.localStorage

import android.content.Context
import com.google.gson.Gson
import com.nikolai.lostpetsapplication.model.user.UserTokens
import javax.inject.Inject

class SharedPreferencesStorage @Inject constructor(
    context: Context
) : UserDataStorage {

    private val parser = Gson()
    private val storage = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveTokens(tokens: UserTokens) {
        val parsedTokens = parser.toJson(tokens)
        storage
            .edit()
            .putString(TOKENS_FIELD_NAME, parsedTokens)
            .apply()
    }

    override fun getTokens(): UserTokens? {
        return when(val storedTokens = storage.getString(TOKENS_FIELD_NAME, null)) {
            null -> null
            else -> parser.fromJson(storedTokens, UserTokens::class.java)
        }
    }

    companion object {
        private const val PREFS_NAME = "UserData"
        private const val TOKENS_FIELD_NAME = "user_tokens"
    }
}