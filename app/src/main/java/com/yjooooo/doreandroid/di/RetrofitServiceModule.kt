package com.yjooooo.doreandroid.di

import com.yjooooo.doreandroid.data.remote.service.AuthService
import com.yjooooo.doreandroid.data.remote.service.HelpService
import com.yjooooo.doreandroid.data.remote.service.MessageService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitServiceModule {
    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun providesHelpService(retrofit: Retrofit): HelpService =
        retrofit.create(HelpService::class.java)

    @Provides
    @Singleton
    fun providesMessageService(retrofit: Retrofit): MessageService =
        retrofit.create(MessageService::class.java)
}
