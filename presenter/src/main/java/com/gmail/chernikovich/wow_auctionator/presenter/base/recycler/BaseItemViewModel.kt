package com.gmail.chernikovich.wow_auctionator.presenter.base.recycler

abstract class BaseItemViewModel<Entity> {
    abstract fun bindItem(entity: Entity, position: Int)

    open fun onItemClick() {
    }
}