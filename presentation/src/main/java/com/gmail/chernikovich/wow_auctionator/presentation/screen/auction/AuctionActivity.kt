package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction

import andrey.chernikovich.data.db.assets.loadItems
import andrey.chernikovich.data.sharedpref.IS_FIRST_RUN
import andrey.chernikovich.domain.sharedpref.SharedPref
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityAuctionMainBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmActivity
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.adapter.FragmentViewPagerAdapter
import javax.inject.Inject

class AuctionActivity : BaseMvvmActivity<
        AuctionViewModel,
        AuctionRouter,
        ActivityAuctionMainBinding>() {

    @Inject
    lateinit var sharedPreferences: SharedPref

    override fun provideViewModel(): AuctionViewModel {
        return ViewModelProviders.of(this).get(AuctionViewModel::class.java)
    }

    override fun provideRouter(): AuctionRouter {
        return AuctionRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_auction_main

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.injectActivity(this)
        super.onCreate(savedInstanceState)
        isFirstRun()
        val tab = binding.tab
        val viewPager = binding.viewPager
        val adapter = FragmentViewPagerAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)


    }


    private fun isFirstRun() {
        if (!sharedPreferences.getValueBoolean(IS_FIRST_RUN)) {
            loadItems(this, sharedPreferences)
            router.goToFirstScreen()
            sharedPreferences.putValueBoolean(IS_FIRST_RUN, true)
        }
    }
}