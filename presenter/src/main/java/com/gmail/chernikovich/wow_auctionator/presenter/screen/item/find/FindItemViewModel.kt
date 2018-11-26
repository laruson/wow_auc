package com.gmail.chernikovich.wow_auctionator.presenter.screen.item.find

import andrey.chernikovich.domain.entity.ItemSearch
import android.databinding.ObservableBoolean
import android.view.View
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.ItemRouter
import com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters.ItemsListAdapter
import io.reactivex.rxkotlin.subscribeBy

class FindItemViewModel : BaseViewModel<AuctionRouter>() {

    private val itemsUseCase = UseCaseProvide.provideGetItemsUseCase()
    private val searchItem = UseCaseProvide.provideSearchItem()

    val isProgressEnabled = ObservableBoolean(true)

    val adapter = ItemsListAdapter()

    init {

        adapter.setClicker {
            router?.gotoItemInfo(it.id, it.image)
        }

        isProgressEnabled.set(true)
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
                    adapter.notifyDataSetChanged()

                },
                onError = {
                    router?.showError(it)
                }
        ))
    }
}