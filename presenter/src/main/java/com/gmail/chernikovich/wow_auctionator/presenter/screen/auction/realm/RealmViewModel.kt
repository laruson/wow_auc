package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.realm

import android.databinding.ObservableArrayList
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

class RealmViewModel : BaseViewModel<AuctionRouter>() {


    val spinner = ObservableArrayList<String>()

    init {

    }

}