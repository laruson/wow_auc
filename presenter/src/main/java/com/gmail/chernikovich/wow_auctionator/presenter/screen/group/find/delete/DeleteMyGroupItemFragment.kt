package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.delete

import android.arch.lifecycle.ViewModelProviders
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentDeleteItemMyGroupBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.FindGroupRouter

class DeleteMyGroupItemFragment : BaseMvvmFragment<
        DeleteMyGroupItemViewModel,
        FindGroupRouter,
        FragmentDeleteItemMyGroupBinding>() {

    companion object {
        fun getInstance(): DeleteMyGroupItemFragment {
            return DeleteMyGroupItemFragment()
        }
    }

    override fun provideViewModel(): DeleteMyGroupItemViewModel {
        return ViewModelProviders.of(this).get(DeleteMyGroupItemViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_delete_item_my_group

}