package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet.adapter

import andrey.chernikovich.domain.entity.pet.PetAbility
import andrey.chernikovich.domain.entity.pet.PetSpecies
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseItemViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.utils.EMPTY
import com.gmail.chernikovich.wow_auctionator.presentation.utils.strong
import com.gmail.chernikovich.wow_auctionator.presentation.utils.weak

class PetAbilityItemViewModel : BaseItemViewModel<PetAbility>() {

    val abilityIcon = ObservableField<String>(EMPTY)
    val skillType = ObservableInt()
    val skillName = ObservableField<String>(EMPTY)
    val vsUpIcon = ObservableInt()
    val vsDownIcon = ObservableInt()
    val vsUpType = ObservableInt()
    val vsDownType = ObservableInt()

    override fun bindItem(entity: PetAbility, position: Int) {
        val vsStrong = strong(entity.petTypeId)
        val vsWeak = weak(entity.petTypeId)
        abilityIcon.set("https://wow.zamimg.com/images/wow/icons/large/${entity.icon}.jpg")
        skillType.set(entity.petTypeId)
        skillName.set(entity.name)
        vsUpIcon.set(vsStrong)
        vsDownIcon.set(vsWeak)
        vsUpType.set(vsStrong)
        vsDownType.set(vsWeak)
    }
}