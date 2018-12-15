package com.gmail.chernikovich.wow_auctionator.di.moduls

import andrey.chernikovich.domain.executor.PostExecutorThread
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.executer.UIThread
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class AppModule(private val app:App) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun providePostExecutorThread(): PostExecutorThread {
        return UIThread()
    }

    @Provides
    @Singleton
    fun provideSharedPreference():SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(app)
    }
}