package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.menu

import android.view.View
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

class AuctionMenuViewModel : BaseViewModel<AuctionRouter>() {
    fun showFindItem(view: View) {
        router?.goToFindItem()
    }

    fun showFindMyGroup(view: View) {
        router?.goToFindMyGroup()
    }

    fun showToken(view: View) {
        router?.goToWowToken()
    }

    fun showCreateGroup(view: View) {
        router?.goToCreateGroup()
    }
}