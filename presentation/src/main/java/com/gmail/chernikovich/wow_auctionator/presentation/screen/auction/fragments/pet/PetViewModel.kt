package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet

import andrey.chernikovich.data.sharedpref.IS_FIRST_RUN
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.adapter.PetItemAdapter
import io.reactivex.rxkotlin.subscribeBy

class PetViewModel : BaseViewModel<AuctionRouter>() {
    val getPets = UseCaseProvide.provideGetPetsUseCase()
    val adapter = PetItemAdapter()

    init {
        getPets.getPetsDao().subscribeBy(
                onNext = {
                    adapter.addItems(it)
                },
                onError = {
                    router?.showError(it)
                }
        )
    }
}