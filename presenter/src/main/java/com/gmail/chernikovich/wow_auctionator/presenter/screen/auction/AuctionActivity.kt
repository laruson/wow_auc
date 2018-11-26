package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction

import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityAuctionMainBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity
import com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters.FragmentViewPagerAdapter

class AuctionActivity : BaseMvvmActivity<
        AuctionViewModel,
        AuctionRouter,
        ActivityAuctionMainBinding>() {

    override fun provideViewModel(): AuctionViewModel {
        return ViewModelProviders.of(this).get(AuctionViewModel::class.java)
    }

    override fun provideRouter(): AuctionRouter {
        return AuctionRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_auction_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tab = binding.tab
        val viewPager = binding.viewPager
        val adapter = FragmentViewPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)

    }
}