package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.find

import andrey.chernikovich.data.db.assets.isLoadComplite
import andrey.chernikovich.domain.entity.ItemSearch
import android.databinding.ObservableBoolean
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.find.adapter.ItemsItemAdapter
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

        isProgressEnabled.set(!isLoadComplite)
        addToDisposable(itemsUseCase.getItems().subscribeBy(
                onNext = {
                    Log.e("Item", it.size.toString())
                    adapter.addItems(it)
                    isProgressEnabled.set(false)
                },
                onError = {
                    isProgressEnabled.set(false)
                    router?.showError(it)
                }
        ))
        Log.e("AA", "NotHer")


    }

    fun search(name: String) {
        val search = ItemSearch(name)

        addToDisposable(searchItem.search(search).subscribeBy(
                onNext = {
                    adapter.addItems(it)
                    adapter.notifyDataSetChanged()

                },
                onError = {
                    router?.showError(it)
                }
        ))
    }
}