package com.mandiri.savin.data.network.module

import com.mandiri.savin.data.network.remote.ActivityDetailsRemoteDataSourceImpl
import com.mandiri.savin.data.network.remote.ActivityRemoteDataSource
import com.mandiri.savin.data.network.remote.ProfilRemoteDataSourceImpl
import com.mandiri.savin.data.network.repository.ActivityDetailsRepository
import com.mandiri.savin.data.network.repository.ActivityDetailsRepositoryImpl
import com.mandiri.savin.data.network.repository.ActivityRepository
import com.mandiri.savin.data.network.repository.ActivityRepositoryImpl
import com.mandiri.savin.data.network.repository.ProfilRepository
import com.mandiri.savin.data.network.repository.ProfilRepositoryImpl
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