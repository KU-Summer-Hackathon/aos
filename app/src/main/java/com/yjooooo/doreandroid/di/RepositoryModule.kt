package com.yjooooo.doreandroid.di

import com.yjooooo.doreandroid.data.local.LocalPreferencesDataSource
import com.yjooooo.doreandroid.data.remote.datasource.AuthDataSource
import com.yjooooo.doreandroid.data.remote.datasource.HelpDataSource
import com.yjooooo.doreandroid.data.remote.datasource.MessageDataSource
import com.yjooooo.doreandroid.data.remote.repository.AuthRepository
import com.yjooooo.doreandroid.data.remote.repository.AuthRepositoryImpl
import com.yjooooo.doreandroid.data.remote.repository.HelpRepository
import com.yjooooo.doreandroid.data.remote.repository.HelpRepositoryImpl
import com.yjooooo.doreandroid.data.remote.repository.MessageRepository
import com.yjooooo.doreandroid.data.remote.repository.MessageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesAuthRepository(
        localPreferencesDataSource: LocalPreferencesDataSource,
        authDataSource: AuthDataSource
    ): AuthRepository =
        AuthRepositoryImpl(localPreferencesDataSource, authDataSource)

    @Provides
    @Singleton
    fun providesHelpRepository(
        helpDataSource: HelpDataSource
    ): HelpRepository =
        HelpRepositoryImpl(helpDataSource)

    @Provides
    @Singleton
    fun providesMessageRepository(
        messageDataSource: MessageDataSource
    ): MessageRepository =
        MessageRepositoryImpl(messageDataSource)

}
