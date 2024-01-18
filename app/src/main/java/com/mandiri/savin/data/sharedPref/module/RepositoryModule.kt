package com.mandiri.savin.data.sharedPref.module

import com.mandiri.savin.data.sharedPref.local.LocalDataSource
import com.mandiri.savin.data.sharedPref.repository.UserRepository
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