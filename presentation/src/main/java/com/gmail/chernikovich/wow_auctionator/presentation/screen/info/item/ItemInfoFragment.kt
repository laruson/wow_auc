package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.item

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentItemInfoBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoRouter

class ItemInfoFragment : BaseMvvmFragment<
        ItemInfoViewModel,
        InfoRouter,
        FragmentItemInfoBinding>() {

    companion object {
        fun getInstance():ItemInfoFragment{

            return ItemInfoFragment()
        }
    }

    override fun provideViewModel()
            : ItemInfoViewModel = ViewModelProviders.of(this).get(ItemInfoViewModel::class.java)

    override fun provideLayoutId(): Int = R.layout.fragment_item_info
}