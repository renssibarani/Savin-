package com.mandiri.savin.data.network.module

import com.mandiri.savin.data.ServiceSavin
import com.mandiri.savin.data.network.remote.ActivityDetailsRemoteDataSource
import com.mandiri.savin.data.network.remote.ActivityDetailsRemoteDataSourceImpl
import com.mandiri.savin.data.network.remote.ActivityRemoteDataSource
import com.mandiri.savin.data.network.remote.ActivityRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideActivityRemoteDataSource(serviceSavin: ServiceSavin): ActivityRemoteDataSource =
        ActivityRemoteDataSourceImpl(serviceSavin)
    @Provides
    @Singleton
    fun provideActivityDetailsRemoteDataSource(serviceSavin: ServiceSavin): ActivityDetailsRemoteDataSource =
        ActivityDetailsRemoteDataSourceImpl(serviceSavin)
}