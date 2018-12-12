package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.find.adapter

import andrey.chernikovich.domain.entity.BaseItem
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.presenter.base.recycler.BaseRecyclerAdapter

class ItemsItemAdapter : BaseRecyclerAdapter<
        BaseItem,
        ItemsItemViewModel>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int)
            : ItemsItemViewHolder {

        return ItemsItemViewHolder.create(viewGroup, ItemsItemViewModel())
    }
}