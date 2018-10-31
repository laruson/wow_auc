package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.menu

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentAuctionMenuBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionActivity
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

class AuctionMenuFragment : BaseMvvmFragment<
        AuctionMenuViewModel,
        AuctionRouter,
        FragmentAuctionMenuBinding>() {

    companion object {
        fun getInstance(): AuctionMenuFragment{
            return AuctionMenuFragment()
        }
    }

    override fun provideViewModel(): AuctionMenuViewModel {
        return ViewModelProviders.of(this).get(AuctionMenuViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_auction_menu
    }
}