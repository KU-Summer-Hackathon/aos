package com.yjooooo.doreandroid.di

import android.content.SharedPreferences
import com.yjooooo.doreandroid.data.local.LocalPreferencesDataSource
import com.yjooooo.doreandroid.data.local.LocalPreferencesDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Provides
    @Singleton
    fun provideLocalPreferencesImpl(localPreferences: SharedPreferences): LocalPreferencesDataSource =
        LocalPreferencesDataSourceImpl(localPreferences)

}
