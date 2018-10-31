package com.gmail.chernikovich.wow_auctionator.presenter.screen.item.find

import android.databinding.ObservableBoolean
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.ItemRouter
import com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters.ItemsListAdapter
import io.reactivex.rxkotlin.subscribeBy

class FindItemViewModel : BaseViewModel<ItemRouter>() {

    private val itemsUseCase = UseCaseProvide.provideGetItemsUseCase()

    val isProgressEnabled = ObservableBoolean(true)
    lateinit var adapter: ItemsListAdapter

    init {
        itemsUseCase.getItems().subscribeBy { listItems ->
            adapter = ItemsListAdapter { item ->
                router?.gotoItemInfo(item.id)
            }
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
}