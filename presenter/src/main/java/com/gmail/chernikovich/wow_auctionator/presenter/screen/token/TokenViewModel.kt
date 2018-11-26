package com.gmail.chernikovich.wow_auctionator.presenter.screen.token

import andrey.chernikovich.domain.usecase.token.TokenUseCase
import android.databinding.*
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter
import io.reactivex.rxkotlin.subscribeBy
import java.text.DateFormat

class TokenViewModel : BaseViewModel<AuctionRouter>() {
    private lateinit var token: TokenUseCase
    val gold = ObservableField<String>()
    val lastUpdate = ObservableField<String>()
    val isProgress = ObservableBoolean(true)

    init {
        token = UseCaseProvide.provideGetTokenEuUseCase()
        show()
    }

    fun showEuToken(){
        isProgress.set(true)
        token = UseCaseProvide.provideGetTokenUsUseCase()
        show()
    }

    fun showUsToken(){
        isProgress.set(true)
        token = UseCaseProvide.provideGetTokenUsUseCase()
        show()
    }

    private fun show(){
        addToDisposable(token.getToken().subscribeBy(
                onNext = {
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