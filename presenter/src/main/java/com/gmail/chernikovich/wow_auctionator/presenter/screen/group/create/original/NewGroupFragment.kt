package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.original

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentNewGroupBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.CreateGroupRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.CreateGroupViewModel

class NewGroupFragment : BaseMvvmFragment<
        CreateGroupViewModel,
        CreateGroupRouter,
        FragmentNewGroupBinding>() {

    companion object {
        fun getInstance(): NewGroupFragment {
            return NewGroupFragment()
        }
    }

    override fun provideViewModel(): CreateGroupViewModel = ViewModelProviders.of(this).get(CreateGroupViewModel::class.java)


    override fun provideLayoutId(): Int = R.layout.fragment_new_group
}