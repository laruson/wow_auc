package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.realm

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentRealmBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

class RealmFragment : BaseMvvmFragment<
        RealmViewModel,
        AuctionRouter,
        FragmentRealmBinding>() {

    companion object {
        fun getInstance():RealmFragment{
            return RealmFragment()
        }
    }

    override fun provideViewModel() = ViewModelProviders.of(this).get(RealmViewModel::class.java)

    override fun provideLayoutId() = R.layout.fragment_realm

}