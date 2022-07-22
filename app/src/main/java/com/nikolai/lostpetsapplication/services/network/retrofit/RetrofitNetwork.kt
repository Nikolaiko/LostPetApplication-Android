package com.nikolai.lostpetsapplication.services.network.retrofit

import com.google.gson.GsonBuilder
import com.nikolai.lostpetsapplication.model.user.LoginUserData
import com.nikolai.lostpetsapplication.model.user.UserTokens
import com.nikolai.lostpetsapplication.services.network.NetworkLayer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitNetwork : NetworkLayer {

    private val client = OkHttpClient.Builder()
        .callTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    private val stagingRetrofit = Retrofit.Builder()
        .baseUrl("https://petsproject.issart.com/api/1.0.0/")
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    private val sandboxService = stagingRetrofit.create(API::class.java)

    override suspend fun loginRequest(loginUserData: LoginUserData): UserTokens? {
        val response = sandboxService.login(loginUserData)
        return when(response.code()) {
            200 -> response.body()
            else -> null
        }
    }

    override fun registerRequest(login: String, password: String) {

    }
}