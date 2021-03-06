package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.token

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentWowTokenBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter

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