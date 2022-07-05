package com.nikolai.lostpetsapplication.services.network.retrofit

import com.nikolai.lostpetsapplication.model.user.LoginUserData
import com.nikolai.lostpetsapplication.model.user.UserTokens
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface API {
    @GET("tech/healthcheck")
    suspend fun healthcheck(): Response<Void>

    @POST("login/email")
    suspend fun login(@Body loginUserData: LoginUserData): Response<UserTokens>
}