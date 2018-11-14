package com.gmail.chernikovich.wow_auctionator.presenter.screen.item.info

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentItemInfoBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.ItemRouter

class InfoItemFragment : BaseMvvmFragment<
        InfoItemViewModel,
        ItemRouter,
        FragmentItemInfoBinding>() {

    companion object {
        private const val ID_EXTRA = "ID_EXTRA"

        fun getInstance(id: Int): InfoItemFragment {
            val fragment = InfoItemFragment()
            val bundle = Bundle()
            bundle.putInt(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel(): InfoItemViewModel {
        return ViewModelProviders.of(this).get(InfoItemViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_item_info

}