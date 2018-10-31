package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create

import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.realm.RealmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.add.AddItemFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.create.CreateGroupFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.original.NewGroupFragment

class CreateGroupRouter(activity: CreateGroupActivity) : BaseRouter<CreateGroupActivity>(activity) {
    fun goToNewGroup() {
        replaceFragment(CreateGroupFragment.getInstance(),
                activity.supportFragmentManager,
                NewGroupFragment.getInstance(),
                R.id.conteiner_create_group,
                true)
    }

    fun goToCreateGroup() {
        replaceFragment(CreateGroupFragment.getInstance(),
                activity.supportFragmentManager,
                CreateGroupFragment.getInstance(),
                R.id.conteiner_create_group,
                true)
    }

    fun goToAddItem() {
        replaceFragment(CreateGroupFragment.getInstance(),
                activity.supportFragmentManager,
                AddItemFragment.getInstance(),
                R.id.conteiner_create_group,
                true)
    }
}