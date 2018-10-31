package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.menu.AuctionMenuFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.realm.RealmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.CreateGroupActivity
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.FindGroupActivity
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.ItemActivity
import com.gmail.chernikovich.wow_auctionator.presenter.screen.token.TokenActivity


class AuctionRouter(activity: AuctionActivity) : BaseRouter<AuctionActivity>(activity) {

    fun goToFindItem() {
        activity.startActivity(Intent(activity, ItemActivity::class.java))
        activity.finish()
    }

    fun goToFindMyGroup() {
        activity.startActivity(Intent(activity, FindGroupActivity::class.java))
        activity.finish()
    }

    fun goToWowToken() {
        activity.startActivity(Intent(activity, TokenActivity::class.java))
        activity.finish()
    }

    fun goToCreateGroup() {
        activity.startActivity(Intent(activity, CreateGroupActivity::class.java))
        activity.finish()
    }

    fun goToRealmFragment() {
        replaceFragment(AuctionMenuFragment.getInstance(),
                activity.supportFragmentManager,
                AuctionMenuFragment.getInstance(),
                R.id.conteiner_auction_menu,
                true)
    }

    fun goToAuctionFragment() {
        replaceFragment(RealmFragment.getInstance(),
                activity.supportFragmentManager,
                AuctionMenuFragment.getInstance(),
                R.id.conteiner_auction_menu,
                true)
    }
}