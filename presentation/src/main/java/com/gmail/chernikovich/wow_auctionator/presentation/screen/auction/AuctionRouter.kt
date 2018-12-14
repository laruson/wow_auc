package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.item.ItemActivity
import com.gmail.chernikovich.wow_auctionator.presentation.screen.settings.SettingsActivity


class AuctionRouter(activity: AuctionActivity) : BaseRouter<AuctionActivity>(activity) {
    val ID_EXTRA = "ID_EXTRA"
    val IMG_EXTRA = "IMG_EXTRA"

    fun goToItemInfo(id: String, img: String) {
        val intent = Intent(activity, ItemActivity::class.java)
        intent.putExtra(ID_EXTRA, id)
        intent.putExtra(IMG_EXTRA, img)
        activity.startActivity(intent)
        activity.finish()
    }

    fun goToFirstScreen() {
        val intent = Intent(App.instance, SettingsActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}