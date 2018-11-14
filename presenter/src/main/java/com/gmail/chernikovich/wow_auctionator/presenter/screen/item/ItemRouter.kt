package com.gmail.chernikovich.wow_auctionator.presenter.screen.item

import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.find.FindItemFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.info.InfoItemFragment

class ItemRouter(activity: ItemActivity) : BaseRouter<ItemActivity>(activity) {
    fun gotoItemInfo(id: Int) {
        replaceFragment(FindItemFragment.getInstance(),
                activity.supportFragmentManager,
                InfoItemFragment.getInstance(id),
                R.id.conteiner_find_item,
                true)
    }

    fun goToFindItem(){
        replaceFragment(FindItemFragment.getInstance(),
                activity.supportFragmentManager,
                FindItemFragment.getInstance(),
                R.id.conteiner_find_item,
                true)
    }
}