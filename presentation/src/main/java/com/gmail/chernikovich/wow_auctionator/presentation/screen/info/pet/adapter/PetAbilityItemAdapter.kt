package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet.adapter

import andrey.chernikovich.domain.entity.pet.PetAbility
import andrey.chernikovich.domain.entity.pet.PetSpecies
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseRecyclerAdapter
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseViewHolder

class PetAbilityItemAdapter : BaseRecyclerAdapter<
        PetAbility,
        PetAbilityItemViewModel>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int)
            : BaseViewHolder<PetAbility, PetAbilityItemViewModel, *> {
        return PetAbilityItemViewHolder.create(viewGroup, PetAbilityItemViewModel())
    }
}