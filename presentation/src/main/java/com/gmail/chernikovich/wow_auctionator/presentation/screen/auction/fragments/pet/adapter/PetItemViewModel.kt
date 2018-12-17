package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.adapter

import andrey.chernikovich.domain.entity.pet.Pet
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseRecyclerViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.utils.EMPTY
import com.gmail.chernikovich.wow_auctionator.presentation.utils.HEALTH
import com.gmail.chernikovich.wow_auctionator.presentation.utils.POWER
import com.gmail.chernikovich.wow_auctionator.presentation.utils.SPEED

class PetItemViewModel : BaseRecyclerViewModel<Pet>() {

    val name = ObservableField<String>(EMPTY)
    val icon = ObservableField<String>(EMPTY)
    val family = ObservableField<String>(EMPTY)

    val powerImage = ObservableField<String>(EMPTY)
    val powerText = ObservableInt()
    val healthImage = ObservableField<String>(EMPTY)
    val healthText = ObservableInt()
    val speedImage = ObservableField<String>(EMPTY)
    val speedText = ObservableInt()

    val textColor = ObservableInt()


    override fun bindItem(entity: Pet, position: Int) {
        name.set(entity.name)
        icon.set(entity.icon)
        family.set(entity.family)
        healthImage.set(HEALTH)
        healthText.set(entity.stats.health)
        powerImage.set(POWER)
        powerText.set(entity.stats.power)
        speedImage.set(SPEED)
        speedText.set(entity.stats.speed)
        textColor.set(entity.qualityId)
    }
}