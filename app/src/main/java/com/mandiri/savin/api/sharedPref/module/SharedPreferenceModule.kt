package com.mandiri.savin.api.sharedPref.module

import android.content.Context
import android.content.SharedPreferences
import com.mandiri.savin.api.sharedPref.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    private const val SHARED_PREF = "shared_pref"

    @Provides
    @Singleton
    fun proviedSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSharedPrefHelper(sharedPref: SharedPreferences) =
        SharedPref(sharedPref)
}