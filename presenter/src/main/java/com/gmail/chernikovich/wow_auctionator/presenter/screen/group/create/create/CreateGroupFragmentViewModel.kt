package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.create

import android.view.View
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create.CreateGroupRouter

class CreateGroupFragmentViewModel : BaseViewModel<CreateGroupRouter>() {
    fun showNew(view: View){
        router?.goToNewGroup()
    }
    fun showAdd(view: View){
        router?.goToAddItem()
    }
}