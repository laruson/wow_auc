package com.gmail.chernikovich.wow_auctionator.presenter.screen.group

import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters.GroupListAdapter
import com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters.ItemsListAdapter
import io.reactivex.rxkotlin.subscribeBy

class GroupViewModel : BaseViewModel<AuctionRouter>() {

    private val getItems = UseCaseProvide.provideGetSaveItemsUseCase()
    private val isLongClick = ObservableBoolean(false)

    val adapter = GroupListAdapter()

    init {
        isLongClick.set(false)

        adapter.setClicker {
            router?.gotoItemInfo(it.id, it.image)
        }

        adapter.setLongClicker{
            Log.e("AAA",isLongClick.get().toString())
            isLongClick.set(true)
            Log.e("AAA",isLongClick.get().toString())
        }

        getItems.getSaveItems().subscribeBy(
                onNext = {
                    adapter.setItems(it)
                },
                onError = {
                    router?.showError(it)
                }
        )

    }
}