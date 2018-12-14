package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group.adapter

import andrey.chernikovich.domain.entity.item.BaseItem
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.databinding.ItemMyGroupItemBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseViewHolder

class GroupItemViewHolder (binding: ItemMyGroupItemBinding,
                           viewModel: GroupItemViewModel)
    : BaseViewHolder<
        BaseItem,
        GroupItemViewModel,
        ItemMyGroupItemBinding>(binding, viewModel) {

    companion object {

        fun create(parent: ViewGroup,
                   viewModel: GroupItemViewModel): GroupItemViewHolder {

            val binding = ItemMyGroupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return GroupItemViewHolder(binding, viewModel)
        }

    }
}