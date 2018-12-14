package com.gmail.chernikovich.wow_auctionator.presentation.screen.item

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityItemInfoBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmActivity

class ItemActivity : BaseMvvmActivity<ItemViewModel, ItemRouter, ActivityItemInfoBinding>() {
    override fun provideRouter(): ItemRouter {
        return ItemRouter(this)
    }


    override fun provideViewModel(): ItemViewModel {
        return ViewModelProviders.of(this).get(ItemViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_item_info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra(router.ID_EXTRA)
        val img = intent.getStringExtra(router.IMG_EXTRA)
        viewModel.setInfoItem(id, img)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        router.goToAuction()
    }
}