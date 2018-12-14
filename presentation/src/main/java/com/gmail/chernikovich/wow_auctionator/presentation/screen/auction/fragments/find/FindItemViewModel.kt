package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.find

import andrey.chernikovich.domain.entity.item.ItemSearch
import android.databinding.ObservableBoolean
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.find.adapter.ItemsItemAdapter
import io.reactivex.rxkotlin.subscribeBy

class FindItemViewModel : BaseViewModel<AuctionRouter>() {

    private val itemsUseCase = UseCaseProvide.provideGetItemsUseCase()
    private val searchItem = UseCaseProvide.provideSearchItem()

    val isProgressEnabled = ObservableBoolean(true)

    val adapter = ItemsItemAdapter()

    init {

        adapter.clickItemSubject.subscribeBy (
                onNext = {
                    router?.goToItemInfo(it.item.id,it.item.image)
                },
                onError = {
                    router?.showError(it)
                }
        )

        addToDisposable(itemsUseCase.getItems().subscribeBy(
                onNext = {
                    adapter.setItems(it)
                    isProgressEnabled.set(false)
                },
                onError = {
                    isProgressEnabled.set(false)
                    router?.showError(it)
                }
        ))
    }

    fun search(name: String) {
        val search = ItemSearch(name)

        addToDisposable(searchItem.search(search).subscribeBy(
                onNext = {
                    adapter.setItems(it)
                },
                onError = {
                    router?.showError(it)
                }
        ))
    }
}