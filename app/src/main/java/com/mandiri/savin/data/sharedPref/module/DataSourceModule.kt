package com.mandiri.savin.data.sharedPref.module

import com.mandiri.savin.data.sharedPref.SharedPref
import com.mandiri.savin.data.sharedPref.local.LocalDataSource
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
    fun provideLocalDatasource(sharedPref: SharedPref) =
        LocalDataSource(sharedPref)
}