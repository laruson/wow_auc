package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.group

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentFindMyGroupBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.FindGroupRouter

class FindMyGroupFragment : BaseMvvmFragment<
        FindMyGroupViewModel,
        FindGroupRouter,
        FragmentFindMyGroupBinding>() {

    companion object {
        fun getInstance():FindMyGroupFragment{
            return FindMyGroupFragment()
        }
    }

    override fun provideViewModel(): FindMyGroupViewModel {
        return ViewModelProviders.of(this).get(FindMyGroupViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_find_my_group
    }
}