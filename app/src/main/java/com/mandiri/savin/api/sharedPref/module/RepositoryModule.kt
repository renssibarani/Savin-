package com.mandiri.savin.api.sharedPref.module

import com.mandiri.savin.api.sharedPref.local.LocalDataSource
import com.mandiri.savin.api.sharedPref.repository.UserRepository
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
    fun provideUserRepository(datasource: LocalDataSource) =
        UserRepository(datasource)
}