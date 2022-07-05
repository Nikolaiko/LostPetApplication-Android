package com.nikolai.lostpetsapplication.di

import com.nikolai.lostpetsapplication.services.network.NetworkLayer
import com.nikolai.lostpetsapplication.services.network.retrofit.RetrofitNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideNetworkService(): NetworkLayer = RetrofitNetwork()

}