package com.gmail.chernikovich.wow_auctionator.presenter.utils.clickers

import andrey.chernikovich.domain.entity.Item

interface OnItemClick {
    fun onClick(Item: Item)
}