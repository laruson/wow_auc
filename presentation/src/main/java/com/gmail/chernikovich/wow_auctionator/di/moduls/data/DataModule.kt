package com.gmail.chernikovich.wow_auctionator.di.moduls.data

import andrey.chernikovich.data.db.databases.AuctionDatabase
import andrey.chernikovich.data.sharedpref.*
import andrey.chernikovich.domain.sharedpref.SharedPref
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context): AuctionDatabase {
        return AuctionDatabase.getInstance(context.applicationContext)
    }

    @Provides
    @Singleton
    fun provideSharedPref(sharedPreferences: SharedPreferences): SharedPref {
        val shared = SharedPrefImpl(sharedPreferences)
        shared.putValue(ACCESS_TOKEN, ACCESS_TOKEN_APP)
        shared.putValue(LOCALE, LOCALE_APP)
        return shared
    }
}