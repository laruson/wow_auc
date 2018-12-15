package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentPetInfoBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoRouter

class PetInfoFragment : BaseMvvmFragment<
        PetInfoViewModel,
        InfoRouter,
        FragmentPetInfoBinding>() {

    companion object {
        fun getInstance(): PetInfoFragment {

            return PetInfoFragment()
        }
    }

    override fun provideViewModel()
            : PetInfoViewModel = ViewModelProviders.of(this).get(PetInfoViewModel::class.java)

    override fun provideLayoutId()
            : Int = R.layout.fragment_pet_info
}