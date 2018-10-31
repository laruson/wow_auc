package com.gmail.chernikovich.wow_auctionator.presenter.screen.item

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityFindItemBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity

class ItemActivity : BaseMvvmActivity<ItemViewModel, ItemRouter, ActivityFindItemBinding>() {

    override fun provideViewModel(): ItemViewModel {
        return ViewModelProviders.of(this).get(ItemViewModel::class.java)
    }

    override fun provideRouter(): ItemRouter = ItemRouter(this)

    override fun provideLayoutId(): Int = R.layout.activity_find_item
}