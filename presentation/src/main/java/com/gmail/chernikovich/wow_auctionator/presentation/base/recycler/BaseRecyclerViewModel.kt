package com.gmail.chernikovich.wow_auctionator.presentation.base.recycler

abstract class BaseRecyclerViewModel<Entity> {
    abstract fun bindItem(entity: Entity, position: Int)

    open fun onItemClick() {
    }
}