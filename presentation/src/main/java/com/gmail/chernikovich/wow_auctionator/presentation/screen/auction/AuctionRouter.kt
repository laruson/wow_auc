package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoActivity
import com.gmail.chernikovich.wow_auctionator.presentation.screen.settings.SettingsActivity
import com.gmail.chernikovich.wow_auctionator.presentation.utils.*


class AuctionRouter(activity: AuctionActivity) : BaseRouter<AuctionActivity>(activity) {

    fun goToInfo(id: String, img: String="", content:String, qualityId:Int=0) {
        val intent = Intent(activity, InfoActivity::class.java)

        intent.putExtra(CONTENT, content)
        intent.putExtra(ID_EXTRA, id)
        intent.putExtra(QUALITY_EXTRA, qualityId)
        intent.putExtra(IMG_EXTRA, img)

        activity.startActivity(intent)
        activity.finish()
    }

    fun goToFirstScreen() {
        val intent = Intent(activity, SettingsActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}