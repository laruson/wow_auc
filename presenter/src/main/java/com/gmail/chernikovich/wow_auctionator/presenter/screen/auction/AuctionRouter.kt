package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.ItemActivity


class AuctionRouter(activity: AuctionActivity) : BaseRouter<AuctionActivity>(activity) {
    val ID_EXTRA = "ID_EXTRA"
    val IMG_EXTRA = "IMG_EXTRA"

    fun gotoItemInfo(id: String, img: String) {
        val intent = Intent(activity, ItemActivity::class.java)
        intent.putExtra(ID_EXTRA, id)
        intent.putExtra(IMG_EXTRA, img)
        activity.startActivity(intent)
        activity.finish()
    }
}