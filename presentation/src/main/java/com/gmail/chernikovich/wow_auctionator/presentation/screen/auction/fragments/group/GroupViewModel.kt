package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group

import android.databinding.ObservableBoolean
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group.adapter.GroupItemAdapter
import io.reactivex.rxkotlin.subscribeBy

class GroupViewModel : BaseViewModel<AuctionRouter>() {

    private val getItems = UseCaseProvide.provideGetSaveItemsUseCase()

    val adapter = GroupItemAdapter()

    init {
        adapter.clickItemSubject.subscribeBy(
                onNext = {
                    router?.goToItemInfo(it.item.id, it.item.image)
                },
                onError = {
                    router?.showError(it)
                }
        )

        getItems.getGroupItems().subscribeBy(
                onNext = {
                    adapter.addItems(it)
                },
                onError = {
                    router?.showError(it)
                }
        )
    }
}