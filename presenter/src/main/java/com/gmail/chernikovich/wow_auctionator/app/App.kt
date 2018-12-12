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
        private const val ACCESS_TOKEN_ = "USt4bd4huAL6Rvn11K4vAwBhDBxtcufsfg"
        private const val REGION_ = "us"
        private const val NAMESPACE_ = "dynamic-us"
        private const val LOCALE_ ="en_US"
    }

    init {
        instance = this

    }

    override fun onCreate() {
        super.onCreate()
        sharedPref = PreferenceManager.getDefaultSharedPreferences(instance)
        sharedPref.edit().putString(ACCESS_TOKEN, ACCESS_TOKEN_).apply()
        sharedPref.edit().putString(REGION, REGION_).apply()
        sharedPref.edit().putString(NAMESPACE, NAMESPACE_).apply()
        sharedPref.edit().putString(LOCALE, LOCALE_).apply()
        Fabric.with(this, Crashlytics())

    }
}


