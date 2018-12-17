package com.gmail.chernikovich.wow_auctionator.presentation.base.recycler

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.android.databinding.library.baseAdapters.BR

abstract class BaseViewHolder<
        Entity,
        VM : BaseRecyclerViewModel<Entity>,
        B : ViewDataBinding>
(val binding: B, val viewModel: VM)
    : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.setVariable(BR.viewModel, viewModel)
    }

    fun bind(item: Entity, position: Int) {
        viewModel.bindItem(item, position)
        binding.executePendingBindings()
    }
}