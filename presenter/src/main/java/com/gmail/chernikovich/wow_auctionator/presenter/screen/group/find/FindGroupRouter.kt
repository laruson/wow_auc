package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find

import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.delete.DeleteMyGroupItemFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find.group.FindMyGroupFragment


class FindGroupRouter(activity: FindGroupActivity) : BaseRouter<FindGroupActivity>(activity) {

    fun goToFindMyGroup(){
        replaceFragment(FindMyGroupFragment.getInstance(),
                activity.supportFragmentManager,
                FindMyGroupFragment.getInstance(),
                R.id.conteiner_my_group,
                true)
    }

    fun goToDeleteMyGroup(){
        replaceFragment(FindMyGroupFragment.getInstance(),
                activity.supportFragmentManager,
                DeleteMyGroupItemFragment.getInstance(),
                R.id.conteiner_my_group,
                true)
    }
}