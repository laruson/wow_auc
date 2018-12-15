package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.item

import andrey.chernikovich.data.sharedpref.REALM
import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.usecase.group.SaveGroupItemUseCase
import andrey.chernikovich.domain.usecase.item.GetItemByIdUseCase
import android.content.SharedPreferences
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoRouter
import com.gmail.chernikovich.wow_auctionator.presentation.utils.EMPTY
import com.gmail.chernikovich.wow_auctionator.presentation.utils.transform
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ItemInfoViewModel: BaseViewModel<InfoRouter>() {
    @Inject
    lateinit var itemById : GetItemByIdUseCase
    @Inject
    lateinit var saveItem : SaveGroupItemUseCase
    @Inject
    lateinit var sharedPreferences: SharedPreferences

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

    init {
        App.appComponent.injectViewModel(this)
    }

    fun setInfoItem(id: String, img: String) {
        var money: ArrayList<Int>
        isVisibility.set(false)
        addToDisposable(itemById
                .getItemById(id)
                .subscribeBy(
                        onNext = {
                            item = BaseItem(it.id, it.name, img)
                            this.img.set(img)
                            serverName.set(sharedPreferences.getString(REALM, EMPTY))
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