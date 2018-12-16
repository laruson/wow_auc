package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet

import andrey.chernikovich.domain.usecase.pet.GetPetsUseCase
import android.databinding.ObservableBoolean
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.adapter.PetItemAdapter
import com.gmail.chernikovich.wow_auctionator.presentation.utils.PET_CONTENT
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PetViewModel : BaseViewModel<AuctionRouter>() {
    val visibility = ObservableBoolean(true)

    @Inject
    lateinit var getPets: GetPetsUseCase

    val adapter = PetItemAdapter()

    init {
        App.appComponent.injectViewModel(this)

        addToDisposable(adapter.clickItemSubject.subscribeBy(
                onNext = {
                    router?.goToInfo(id = it.item.stats.speciesId.toString(),
                            content = PET_CONTENT,
                            qualityId = it.item.qualityId)
                },
                onError = {
                    router?.showError(it)
                }
        ))

        addToDisposable(getPets.getPetsDao().subscribeBy(
                onNext = {
                    adapter.setItems(it)
                    visibility.set(false)
                },
                onError = {
                    router?.showError(it)
                }
        ))
    }
}