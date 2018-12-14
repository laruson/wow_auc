package com.gmail.chernikovich.wow_auctionator.presentation.screen.item

import andrey.chernikovich.data.sharedpref.REALM
import andrey.chernikovich.domain.entity.item.BaseItem
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.utils.EMPTY
import com.gmail.chernikovich.wow_auctionator.presentation.utils.transform
import io.reactivex.rxkotlin.subscribeBy

class ItemViewModel : BaseViewModel<ItemRouter>() {
    private val itemById = UseCaseProvide.provideGetItemByIdUseCase()
    private val saveItem = UseCaseProvide.provideSaveItemUseCase()
    private lateinit var item: BaseItem

    val img = ObservableField<String>(EMPTY)
    val serverName = ObservableField<String>(EMPTY)
    val itemName = ObservableField<String>(EMPTY)

    val minBuyoutServerGold = ObservableField<String>(EMPTY)
    val minBuyoutServerSilver = ObservableField<String>(EMPTY)
    val minBuyoutServerCopper = ObservableField<String>(EMPTY)

    val marketValueServerGold = ObservableField<String>(EMPTY)
    val marketValueServerSilver = ObservableField<String>(EMPTY)
    val marketValueServerCopper = ObservableField<String>(EMPTY)

    val historicalPriceServerGold = ObservableField<String>(EMPTY)
    val historicalPriceServerSilver = ObservableField<String>(EMPTY)
    val historicalPriceServerCopper = ObservableField<String>(EMPTY)

    val quantityServer = ObservableField<String>("")
    val isVisibility = ObservableBoolean(false)

    fun setInfoItem(id: String, img: String) {
        var money: ArrayList<Int>
        isVisibility.set(false)
        addToDisposable(itemById
                .getItemById(id)
                .subscribeBy(
                        onNext = {
                            item = BaseItem(it.id, it.name, img)
                            this.img.set(img)
                            serverName.set(App.sharedPref.getString(REALM, EMPTY))
                            itemName.set(it.name)

                            money = transform(it.minimumBuyout)
                            minBuyoutServerCopper.set(money[0].toString())
                            minBuyoutServerSilver.set(money[1].toString())
                            minBuyoutServerGold.set(money[2].toString())
                            money = transform(it.marketValue)
                            marketValueServerCopper.set(money[0].toString())
                            marketValueServerSilver.set(money[1].toString())
                            marketValueServerGold.set(money[2].toString())
                            money = transform(it.historicalPrice)
                            historicalPriceServerCopper.set(money[0].toString())
                            historicalPriceServerSilver.set(money[1].toString())
                            historicalPriceServerGold.set(money[2].toString())
                            quantityServer.set(it.quantity)
                            isVisibility.set(true)
                        },
                        onError = {
                            router?.showError(it)
                        }
                ))
    }

    fun addItem(view: View) {
        saveItem.saveGroupItem(item)
        router?.goToAuction()
    }
}