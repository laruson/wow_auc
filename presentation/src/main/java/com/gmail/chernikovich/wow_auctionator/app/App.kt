package com.gmail.chernikovich.wow_auctionator.app

import andrey.chernikovich.data.sharedpref.*
import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;


class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var sharedPref: SharedPreferences
        private const val ACCESS_TOKEN_APP = "UScyWT4QeIgWremVAHTEj6aaHSlW22UD2S"
        private const val LOCALE_APP ="en_US"
    }

    init {
        instance = this

    }

    override fun onCreate() {
        super.onCreate()
        sharedPref = PreferenceManager.getDefaultSharedPreferences(instance)
        sharedPref.edit().putString(ACCESS_TOKEN, ACCESS_TOKEN_APP).apply()
        sharedPref.edit().putString(LOCALE, LOCALE_APP).apply()
        sharedPref.edit().putBoolean(IS_LOAD_COMPLITE, false).apply()

        Fabric.with(this, Crashlytics())

    }
}


