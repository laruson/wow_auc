package com.gmail.chernikovich.wow_auctionator.presenter.screen.item.info

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentItemInfoBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.ItemRouter

class InfoItemFragment : BaseMvvmFragment<
        InfoItemViewModel,
        ItemRouter,
        FragmentItemInfoBinding>() {

    companion object {
        fun getInstance(): InfoItemFragment {
            return InfoItemFragment()
        }
    }

    override fun provideViewModel(): InfoItemViewModel {
        return ViewModelProviders.of(this).get(InfoItemViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_item_info

}