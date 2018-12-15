package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group.adapter

import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.usecase.group.DeleteGroupItemUseCase
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseRecyclerAdapter
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.item_my_group_item.view.*
import javax.inject.Inject

class GroupItemAdapter : BaseRecyclerAdapter<
        BaseItem,
        GroupItemViewModel>() {

    @Inject
    lateinit var deleteItem : DeleteGroupItemUseCase

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int)
            : GroupItemViewHolder {

        return GroupItemViewHolder.create(viewGroup, GroupItemViewModel())
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<BaseItem, GroupItemViewModel, *>) {
        super.onViewAttachedToWindow(holder)
        val position = holder.adapterPosition
        holder.itemView.buttonDelete.setOnClickListener {
            val item = itemList[position]
            removeItem(item)
            deleteItem.deleteItem(item)
        }
    }
}