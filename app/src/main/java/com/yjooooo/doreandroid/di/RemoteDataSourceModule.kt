package com.yjooooo.doreandroid.di

import com.yjooooo.doreandroid.data.remote.datasource.AuthDataSource
import com.yjooooo.doreandroid.data.remote.datasource.AuthDataSourceImpl
import com.yjooooo.doreandroid.data.remote.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Provides
    @Singleton
    fun providesAuthDataSource(authService: AuthService): AuthDataSource = AuthDataSourceImpl(authService)
}
