package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.find.adapter

import andrey.chernikovich.domain.entity.item.BaseItem
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseRecyclerAdapter

class ItemsItemAdapter : BaseRecyclerAdapter<
        BaseItem,
        ItemsItemViewModel>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int)
            : ItemsItemViewHolder {

        return ItemsItemViewHolder.create(viewGroup, ItemsItemViewModel())
    }
}