package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.find.adapter

import andrey.chernikovich.domain.entity.BaseItem
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.databinding.ItemItemBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.recycler.BaseViewHolder

class ItemsItemViewHolder (binding: ItemItemBinding,
                           viewModel: ItemsItemViewModel)
    : BaseViewHolder<
        BaseItem,
        ItemsItemViewModel,
        ItemItemBinding>(binding, viewModel) {

    companion object {

        fun create(parent: ViewGroup,
                   viewModel: ItemsItemViewModel): ItemsItemViewHolder {

            val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemsItemViewHolder(binding, viewModel)
        }

    }
}