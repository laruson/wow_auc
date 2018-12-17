package com.gmail.chernikovich.wow_auctionator.app

import andrey.chernikovich.data.sharedpref.ACCESS_TOKEN
import andrey.chernikovich.data.sharedpref.IS_LOAD_COMPLITE
import andrey.chernikovich.data.sharedpref.LOCALE
import andrey.chernikovich.domain.sharedpref.SharedPref
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.gmail.chernikovich.wow_auctionator.di.components.AppComponent
import com.gmail.chernikovich.wow_auctionator.di.components.DaggerAppComponent
import com.gmail.chernikovich.wow_auctionator.di.moduls.AppModule
import io.fabric.sdk.android.Fabric
import javax.inject.Inject


class App : Application(){
    companion object {
        lateinit var instance: App
        @JvmStatic
        lateinit var appComponent: AppComponent
        private const val ACCESS_TOKEN_APP = "UScyWT4QeIgWremVAHTEj6aaHSlW22UD2S"
        private const val LOCALE_APP ="en_US"

    }
    init {
        instance = this
        appComponent =  DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()

        Fabric.with(this, Crashlytics())
    }
}


