package com.gmail.chernikovich.wow_auctionator.presentation.screen.info

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityItemInfoBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmActivity

class InfoActivity : BaseMvvmActivity<InfoViewModel, InfoRouter, ActivityItemInfoBinding>() {
    override fun provideRouter(): InfoRouter {
        return InfoRouter(this)
    }

    override fun provideViewModel(): InfoViewModel {
        return ViewModelProviders.of(this).get(InfoViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra(router.ID_EXTRA)
        val img = intent.getStringExtra(router.IMG_EXTRA)
//        viewModel.setInfoItem(id, img)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        router.goToAuction()
    }
}