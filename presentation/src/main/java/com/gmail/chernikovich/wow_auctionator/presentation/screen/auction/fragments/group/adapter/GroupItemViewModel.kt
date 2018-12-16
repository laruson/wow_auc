package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group.adapter

import andrey.chernikovich.domain.entity.item.BaseItem
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseItemViewModel

class GroupItemViewModel : BaseItemViewModel<BaseItem>() {

    val name = ObservableField<String>("")
    val image = ObservableField<String>("")
    val isProgress = ObservableBoolean(true)

    override fun bindItem(entity: BaseItem, position: Int) {
        name.set(entity.name)
        image.set(entity.image)
        isProgress.set(false)
    }
}