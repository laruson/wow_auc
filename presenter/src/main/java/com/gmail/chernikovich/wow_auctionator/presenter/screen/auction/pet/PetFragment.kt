package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.pet

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentPetsBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

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
}