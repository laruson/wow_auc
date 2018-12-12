package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.group.adapter

import andrey.chernikovich.domain.entity.BaseItem
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.gmail.chernikovich.wow_auctionator.presenter.base.recycler.BaseItemViewModel

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