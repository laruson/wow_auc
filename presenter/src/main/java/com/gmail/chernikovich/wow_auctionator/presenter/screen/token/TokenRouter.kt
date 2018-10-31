package com.gmail.chernikovich.wow_auctionator.presenter.screen.token

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionActivity
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.FindGroupActivity

class TokenRouter(activity: TokenActivity):BaseRouter<TokenActivity>(activity) {
    fun goToMainMenu(){
        activity.startActivity(Intent(activity, AuctionActivity::class.java))
        activity.finish()
    }
}