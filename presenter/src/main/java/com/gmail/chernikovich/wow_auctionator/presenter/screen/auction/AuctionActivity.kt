package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction

import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityAuctionMainBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity

class AuctionActivity : BaseMvvmActivity<
        AuctionViewModel,
        AuctionRouter,
        ActivityAuctionMainBinding>() {

    private lateinit var prefs: SharedPreferences

    override fun provideViewModel(): AuctionViewModel {
        return ViewModelProviders.of(this).get(AuctionViewModel::class.java)
    }

    override fun provideRouter(): AuctionRouter {
        return AuctionRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_auction_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ifFirstRun()
    }

    private fun ifFirstRun() {
        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE)
        if (prefs.getBoolean("firstrun", true)) {
            router.goToRealmFragment()
            prefs.edit().putBoolean("firstrun", false).apply();
        } else
            router.goToAuctionFragment()
    }
}