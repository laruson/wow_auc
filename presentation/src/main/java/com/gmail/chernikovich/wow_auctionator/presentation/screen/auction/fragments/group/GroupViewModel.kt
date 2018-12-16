package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group

import andrey.chernikovich.domain.usecase.group.GetGroupItemUseCase
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group.adapter.GroupItemAdapter
import com.gmail.chernikovich.wow_auctionator.presentation.utils.ITEM_CONTENT
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class GroupViewModel : BaseViewModel<AuctionRouter>() {

    @Inject
    lateinit var getGroupItems: GetGroupItemUseCase

    val adapter = GroupItemAdapter()

    init {
        App.appComponent.injectViewModel(this)

        addToDisposable(adapter.clickItemSubject.subscribeBy(
                onNext = {
                    router?.goToInfo(it.item.id, it.item.image, ITEM_CONTENT)
                },
                onError = {
                    router?.showError(it)
                }
        ))

        addToDisposable(getGroupItems.getGroupItems().subscribeBy(
                onNext = {
                    adapter.addItems(it)
                },
                onError = {
                    router?.showError(it)
                }
        ))
    }
}