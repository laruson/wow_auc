package com.gmail.chernikovich.wow_auctionator.presentation.screen.settings

import android.content.Intent
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionActivity

class SettingsRouter(activity:SettingsActivity) : BaseRouter<SettingsActivity>(activity) {

    fun goToAuction(){
        val intent = Intent(App.instance, AuctionActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    fun goToLoadingScreen(){
        Log.e("AAA", "типо загрузка")
    }
}