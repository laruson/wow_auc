package com.gmail.chernikovich.wow_auctionator.presenter.screen.settings.general

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentSettingsBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter

class GeneralSettingsFragment : BaseMvvmFragment<
        GeneralSettingsViewModel,
        AuctionRouter,
        FragmentSettingsBinding>(){
    override fun provideViewModel(): GeneralSettingsViewModel {
        return ViewModelProviders.of(this).get(GeneralSettingsViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_settings

}