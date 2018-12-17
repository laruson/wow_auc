package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.find.adapter

import andrey.chernikovich.domain.entity.item.BaseItem
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseRecyclerViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.utils.EMPTY

class ItemsItemViewModel : BaseRecyclerViewModel<BaseItem>() {

    val name = ObservableField<String>(EMPTY)
    val image = ObservableField<String>(EMPTY)
    val textColor = ObservableField<String>(EMPTY)
    val isProgress = ObservableBoolean(true)

    override fun bindItem(entity: BaseItem, position: Int) {
        name.set(entity.name)
        image.set(entity.image)
        textColor.set(entity.quality)
        isProgress.set(false)
    }
}