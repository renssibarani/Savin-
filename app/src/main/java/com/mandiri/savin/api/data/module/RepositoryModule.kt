package com.mandiri.savin.api.data.module

import com.mandiri.savin.api.data.service.ActivityDetailsRemoteDataSourceImpl
import com.mandiri.savin.api.data.service.ActivityRemoteDataSource
import com.mandiri.savin.api.data.service.ProfilRemoteDataSourceImpl
import com.mandiri.savin.api.data.repository.ActivityDetailsRepository
import com.mandiri.savin.api.data.repository.ActivityDetailsRepositoryImpl
import com.mandiri.savin.api.data.repository.ActivityRepository
import com.mandiri.savin.api.data.repository.ActivityRepositoryImpl
import com.mandiri.savin.api.data.repository.ProfilRepository
import com.mandiri.savin.api.data.repository.ProfilRepositoryImpl
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
    fun provideActivityRepository(datasource: ActivityRemoteDataSource): ActivityRepository =
        ActivityRepositoryImpl(datasource)

    @Provides
    @Singleton
    fun provideActivityDetailsRepository(datasource: ActivityDetailsRemoteDataSourceImpl): ActivityDetailsRepository =
        ActivityDetailsRepositoryImpl(datasource)

    @Provides
    @Singleton
    fun provideProfilRepository(datasource: ProfilRemoteDataSourceImpl): ProfilRepository =
        ProfilRepositoryImpl(datasource)
}