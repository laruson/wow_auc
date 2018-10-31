package com.gmail.chernikovich.wow_auctionator.presenter.screen.item.find

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentFindItemBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.ItemRouter

class FindItemFragment : BaseMvvmFragment<
        FindItemViewModel,
        ItemRouter,
        FragmentFindItemBinding>() {

    companion object {
        fun getInstance() : FindItemFragment{
            return FindItemFragment()
        }
    }

    override fun provideViewModel(): FindItemViewModel {
        return ViewModelProviders.of(this).get(FindItemViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_find_item
}