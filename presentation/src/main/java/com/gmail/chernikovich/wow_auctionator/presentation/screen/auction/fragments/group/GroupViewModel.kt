package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group

import andrey.chernikovich.domain.usecase.group.GetGroupItemUseCase
import android.util.Log
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
                    router?.goToInfo(id = it.item.id,
                            img = it.item.image,
                            content = ITEM_CONTENT,
                            qualityId = it.item.quality.toInt())
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