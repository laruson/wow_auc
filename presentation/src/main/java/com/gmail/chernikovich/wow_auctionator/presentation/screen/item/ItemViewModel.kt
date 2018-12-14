package com.gmail.chernikovich.wow_auctionator.presentation.screen.item

import andrey.chernikovich.domain.entity.item.BaseItem
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.utils.transform
import io.reactivex.rxkotlin.subscribeBy

class ItemViewModel : BaseViewModel<ItemRouter>() {
    private val itemById = UseCaseProvide.provideGetItemByIdUseCase()
    private val saveItem = UseCaseProvide.provideSaveItemUseCase()
    private lateinit var item: BaseItem

    val img = ObservableField<String>("empty")
    val serverName = ObservableField<String>("")
    val regionName = ObservableField<String>("")
    val itemName = ObservableField<String>("")

    val minBuyoutServerGold = ObservableField<String>("")
    val minBuyoutServerSilver = ObservableField<String>("")
    val minBuyoutServerCopper = ObservableField<String>("")

    val minBuyoutRegionGold = ObservableField<String>("")
    val minBuyoutRegionSilver = ObservableField<String>("")
    val minBuyoutRegionCopper = ObservableField<String>("")

    val marketValueServerGold = ObservableField<String>("")
    val marketValueServerSilver = ObservableField<String>("")
    val marketValueServerCopper = ObservableField<String>("")

    val marketValueRegionGold = ObservableField<String>("")
    val marketValueRegionSilver = ObservableField<String>("")
    val marketValueRegionCopper = ObservableField<String>("")

    val historicalPriceServerGold = ObservableField<String>("")
    val historicalPriceServerSilver = ObservableField<String>("")
    val historicalPriceServerCopper = ObservableField<String>("")

    val historicalPriceRegionGold = ObservableField<String>("")
    val historicalPriceRegionSilver = ObservableField<String>("")
    val historicalPriceRegionCopper = ObservableField<String>("")

    val quantityServer = ObservableField<String>("")
    val quantityRegion = ObservableField<String>("")
    val isVisibility = ObservableBoolean(false)

    fun setInfoItem(id: String, img: String) {
        var money = ArrayList<Int>()
        Log.e("AAA", id)
        isVisibility.set(false)
        addToDisposable(itemById
                .getItemById(id)
                .subscribeBy(
                        onNext = {
                            item = BaseItem(it.id, it.name, img)
                            this.img.set(img)
                            serverName.set("Aegwynn(EU)")
                            regionName.set("Region(EU)")
                            itemName.set(it.name)

                            money = transform(it.minimumBuyout)
                            minBuyoutServerCopper.set(money[0].toString())
                            minBuyoutServerSilver.set(money[1].toString())
                            minBuyoutServerGold.set(money[2].toString())
                            money = transform(it.regionMinimumBuyout)
                            minBuyoutRegionCopper.set(money[0].toString())
                            minBuyoutRegionSilver.set(money[1].toString())
                            minBuyoutRegionGold.set(money[2].toString())
                            money = transform(it.marketValue)
                            marketValueServerCopper.set(money[0].toString())
                            marketValueServerSilver.set(money[1].toString())
                            marketValueServerGold.set(money[2].toString())
                            money = transform(it.regionMarketValue)
                            marketValueRegionCopper.set(money[0].toString())
                            marketValueRegionSilver.set(money[1].toString())
                            marketValueRegionGold.set(money[2].toString())
                            money = transform(it.historicalPrice)
                            historicalPriceServerCopper.set(money[0].toString())
                            historicalPriceServerSilver.set(money[1].toString())
                            historicalPriceServerGold.set(money[2].toString())
                            money = transform(it.regionHistoricalPrice)
                            historicalPriceRegionCopper.set(money[0].toString())
                            historicalPriceRegionSilver.set(money[1].toString())
                            historicalPriceRegionGold.set(money[2].toString())
                            quantityServer.set(it.quantity)
                            quantityRegion.set(it.regionQuantity)
                            isVisibility.set(true)
                        },
                        onError = {
                            router?.showError(it)
                            Log.e("QQ", it.message)
                        }
                ))
    }

    fun addItem(view: View){
        saveItem.saveGroupItem(item)
        router?.goToAuction()
    }
}