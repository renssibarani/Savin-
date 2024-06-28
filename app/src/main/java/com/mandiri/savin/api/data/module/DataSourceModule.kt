package com.mandiri.savin.api.data.module

import com.mandiri.savin.api.data.remote.ServiceSavin
import com.mandiri.savin.api.data.service.ActivityDetailsRemoteDataSource
import com.mandiri.savin.api.data.service.ActivityDetailsRemoteDataSourceImpl
import com.mandiri.savin.api.data.service.ActivityRemoteDataSource
import com.mandiri.savin.api.data.service.ActivityRemoteDataSourceImpl
import com.mandiri.savin.api.data.service.ProfilRemoteDataSource
import com.mandiri.savin.api.data.service.ProfilRemoteDataSourceImpl
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

    @Provides
    @Singleton
    fun provideProfilRemoteDataSource(serviceSavin: ServiceSavin): ProfilRemoteDataSource =
        ProfilRemoteDataSourceImpl(serviceSavin)
}