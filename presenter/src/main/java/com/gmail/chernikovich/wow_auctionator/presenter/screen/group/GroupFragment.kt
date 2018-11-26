package com.gmail.chernikovich.wow_auctionator.presenter.screen.group

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentGroupBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

class GroupFragment: BaseMvvmFragment<
        GroupViewModel,
        AuctionRouter,
        FragmentGroupBinding>() {

    companion object {
        fun getInstance():GroupFragment{
            return GroupFragment()
        }
    }

    override fun provideViewModel(): GroupViewModel {
        return ViewModelProviders.of(this).get(GroupViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_group

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = viewModel.adapter
        binding.recycler.layoutManager = LinearLayoutManager(view.context)
        binding.recycler.setHasFixedSize(true)
    }
}