package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentPetsBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter

class PetFragment : BaseMvvmFragment<
        PetViewModel,
        AuctionRouter,
        FragmentPetsBinding>() {


    companion object {
        fun getInstance():PetFragment{
            return PetFragment()
        }
    }

    override fun provideViewModel()
            : PetViewModel = ViewModelProviders.of(this).get(PetViewModel::class.java)

    override fun provideLayoutId(): Int = R.layout.fragment_pets

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = viewModel.adapter
        binding.recycler.layoutManager = LinearLayoutManager(view.context)
        binding.recycler.setHasFixedSize(true)
    }
}