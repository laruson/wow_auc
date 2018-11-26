package com.gmail.chernikovich.wow_auctionator.presenter.screen.item

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionActivity

class ItemRouter(activity: ItemActivity) : BaseRouter<ItemActivity>(activity) {
    val ID_EXTRA = "ID_EXTRA"
    val IMG_EXTRA = "IMG_EXTRA"

    fun goToAuction() {
        val intent = Intent(activity, AuctionActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}