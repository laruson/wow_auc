package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.add

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentAddItemBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.CreateGroupRouter

class AddItemFragment : BaseMvvmFragment<
        AddItemViewModel,
        CreateGroupRouter,
        FragmentAddItemBinding>() {

    companion object {
        fun getInstance(): AddItemFragment {
            return AddItemFragment()
        }
    }

    override fun provideViewModel(): AddItemViewModel = ViewModelProviders.of(this).get(AddItemViewModel::class.java)


    override fun provideLayoutId(): Int = R.layout.fragment_add_item
}