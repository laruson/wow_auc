package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.token

import andrey.chernikovich.domain.usecase.token.GetTokenUseCase
import android.databinding.*
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter
import io.reactivex.rxkotlin.subscribeBy
import java.text.DateFormat
import javax.inject.Inject

class TokenViewModel : BaseViewModel<AuctionRouter>() {

    @Inject
    lateinit var token : GetTokenUseCase

    val gold = ObservableField<String>()
    val lastUpdate = ObservableField<String>()
    val isProgress = ObservableBoolean(true)

    init {
        show()
    }

    private fun show(){
        App.appComponent.injectViewModel(this)

        addToDisposable(token.getToken().subscribeBy(
                onNext = {
                    isProgress.set(true)
                    val date = DateFormat
                            .getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM)
                            .format(it.lastUpdate.toLong())
                    lastUpdate.set("Last update: $date")
                    val price = it.price.substring(0, it.price.length - 4)
                    if (price.length <= 6)
                        gold.set("Buyout: " + price.substring(0, 3) + "," + price.substring(3))
                    isProgress.set(false)
                },
                onError = {
                    router?.showError(it)
                }
        ))
    }
}