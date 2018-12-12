package com.gmail.chernikovich.wow_auctionator.presenter.screen.settings

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionActivity

class SettingsRouter(activity:SettingsActivity) : BaseRouter<SettingsActivity>(activity) {

    fun goToAuction(){
        val intent = Intent(App.instance, AuctionActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}