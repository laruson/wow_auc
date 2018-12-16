package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.item

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentItemInfoBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoRouter
import com.gmail.chernikovich.wow_auctionator.presentation.utils.ID_EXTRA
import com.gmail.chernikovich.wow_auctionator.presentation.utils.IMG_EXTRA
import com.gmail.chernikovich.wow_auctionator.presentation.utils.QUALITY_EXTRA

class ItemInfoFragment : BaseMvvmFragment<
        ItemInfoViewModel,
        InfoRouter,
        FragmentItemInfoBinding>() {

    companion object {
        fun getInstance(id: String, img: String, qualityId:String): ItemInfoFragment {
            val fragment = ItemInfoFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            bundle.putString(IMG_EXTRA, img)
            bundle.putString(QUALITY_EXTRA, qualityId)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel()
            : ItemInfoViewModel = ViewModelProviders.of(this).get(ItemInfoViewModel::class.java)

    override fun provideLayoutId(): Int = R.layout.fragment_item_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.get(ID_EXTRA) as String
        val img = arguments?.get(IMG_EXTRA) as String
        val qualityId = arguments?.get(QUALITY_EXTRA) as String

        viewModel.setInfoItem(id, img, qualityId)
    }
}