package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.create

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentCreateGroupBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.CreateGroupRouter

class CreateGroupFragment : BaseMvvmFragment<
        CreateGroupFragmentViewModel,
        CreateGroupRouter,
        FragmentCreateGroupBinding>() {

    companion object {
        fun getInstance(): CreateGroupFragment {
            return CreateGroupFragment()
        }
    }


    override fun provideViewModel(): CreateGroupFragmentViewModel {
        return ViewModelProviders.of(this).get(CreateGroupFragmentViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_create_group


}