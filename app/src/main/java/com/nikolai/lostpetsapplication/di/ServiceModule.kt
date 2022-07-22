package com.nikolai.lostpetsapplication.di

import android.content.Context
import com.nikolai.lostpetsapplication.services.localStorage.SharedPreferencesStorage
import com.nikolai.lostpetsapplication.services.localStorage.UserDataStorage
import com.nikolai.lostpetsapplication.services.network.NetworkLayer
import com.nikolai.lostpetsapplication.services.network.retrofit.RetrofitNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideNetworkService(): NetworkLayer = RetrofitNetwork()

    @Provides
    fun provideLocalStorage(
        @ApplicationContext
        context: Context
    ): UserDataStorage = SharedPreferencesStorage(context)

}