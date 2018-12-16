package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet.adapter

import andrey.chernikovich.domain.entity.pet.PetAbility
import andrey.chernikovich.domain.entity.pet.PetSpecies
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.databinding.ItemPetAbilityBinding
import com.gmail.chernikovich.wow_auctionator.databinding.ItemPetBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseViewHolder
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.adapter.PetItemViewHolder
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.adapter.PetItemViewModel

class PetAbilityItemViewHolder(binding: ItemPetAbilityBinding,
                               viewModel: PetAbilityItemViewModel)
    : BaseViewHolder<
        PetAbility,
        PetAbilityItemViewModel,
        ItemPetAbilityBinding>(binding, viewModel) {
    companion object {

        fun create(parent: ViewGroup,
                   viewModel: PetAbilityItemViewModel): PetAbilityItemViewHolder {

            val binding = ItemPetAbilityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PetAbilityItemViewHolder(binding, viewModel)
        }

    }
}