package com.gmail.chernikovich.wow_auctionator.presenter.screen.token

import android.arch.lifecycle.ViewModelProviders
import android.view.Menu
import android.view.MenuItem
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentWowTokenBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

class TokenFragment : BaseMvvmFragment<
        TokenViewModel,
        AuctionRouter,
        FragmentWowTokenBinding>() {

    companion object {
        fun getInstance():TokenFragment{
            return TokenFragment()
        }
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_wow_token
    }

    override fun provideViewModel(): TokenViewModel {
        return ViewModelProviders.of(this).get(TokenViewModel::class.java)
    }
}