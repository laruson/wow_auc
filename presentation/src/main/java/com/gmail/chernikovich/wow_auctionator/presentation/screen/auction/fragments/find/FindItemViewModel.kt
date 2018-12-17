package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.find

import andrey.chernikovich.domain.entity.item.ItemSearch
import andrey.chernikovich.domain.usecase.item.GetItemsUseCase
import andrey.chernikovich.domain.usecase.item.SearchItemUseCase
import android.databinding.ObservableBoolean
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.find.adapter.ItemsItemAdapter
import com.gmail.chernikovich.wow_auctionator.presentation.utils.ITEM_CONTENT
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class FindItemViewModel : BaseViewModel<AuctionRouter>() {

    @Inject
    lateinit var itemsUseCase: GetItemsUseCase
    @Inject
    lateinit var searchItem: SearchItemUseCase

    val isProgressEnabled = ObservableBoolean(true)

    val adapter = ItemsItemAdapter()

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