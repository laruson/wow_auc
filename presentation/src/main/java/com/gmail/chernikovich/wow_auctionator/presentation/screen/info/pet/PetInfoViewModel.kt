package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet

import andrey.chernikovich.domain.usecase.pet.GetPetSpeciesUseCase
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet.adapter.PetAbilityItemAdapter
import com.gmail.chernikovich.wow_auctionator.presentation.utils.EMPTY
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PetInfoViewModel : BaseViewModel<InfoRouter>() {

    @Inject
    lateinit var petSpecies : GetPetSpeciesUseCase

    val adapter = PetAbilityItemAdapter()

    val isVisibility = ObservableBoolean(false)
    val icon = ObservableField<String>(EMPTY)
    val petName = ObservableField<String>(EMPTY)
    val petNameColor = ObservableField<String>(EMPTY)
    val petDescription = ObservableField<String>(EMPTY)

    init {
        App.appComponent.injectViewModel(this)
    }

    fun setInfoPet(id: String, qualityId: Int) {
        petNameColor.set(qualityId.toString())
        addToDisposable(petSpecies.getPetSpecies(id).subscribeBy(
                onNext = {
                    icon.set(it.icon)
                    petName.set(it.name)
                    adapter.setItems(it.petAbility)
                    isVisibility.set(true)
                    petDescription.set(it.description)
                },
                onError = {
                    router?.showError(it)
                }
        ))

    }
}