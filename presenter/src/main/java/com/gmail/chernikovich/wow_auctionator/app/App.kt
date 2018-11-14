package com.gmail.chernikovich.wow_auctionator.app

import andrey.chernikovich.data.db.utils.ioThread
import andrey.chernikovich.data.db.utils.items
import android.app.Application

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

            items(this)

    }
}

