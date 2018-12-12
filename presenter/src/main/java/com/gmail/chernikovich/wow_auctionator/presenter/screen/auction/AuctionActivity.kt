package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction

import andrey.chernikovich.data.db.assets.loadItems
import andrey.chernikovich.data.sharedpref.IS_FIRST_RUN
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityAuctionMainBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.adapter.FragmentViewPagerAdapter

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

        if(!isFirstRun()){

        }
        val tab = binding.tab
        val viewPager = binding.viewPager
        val adapter = FragmentViewPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)


    }


    private fun isFirstRun() : Boolean{
        val isFirst = App.sharedPref.getBoolean(IS_FIRST_RUN, false)
        if(!isFirst){
            loadItems(this)
            router.goToFirstScreen()
            App.sharedPref.edit().putBoolean(IS_FIRST_RUN,true).apply()
        }
        return isFirst
    }
}