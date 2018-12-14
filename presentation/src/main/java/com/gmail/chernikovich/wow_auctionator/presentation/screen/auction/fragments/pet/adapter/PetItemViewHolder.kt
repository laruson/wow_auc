package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.adapter

import andrey.chernikovich.domain.entity.pet.Pet
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.databinding.ItemPetBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseViewHolder

class PetItemViewHolder (binding: ItemPetBinding,
                         viewModel: PetItemViewModel)
    : BaseViewHolder<
        Pet,
        PetItemViewModel,
        ItemPetBinding>(binding, viewModel) {

    companion object {

        fun create(parent: ViewGroup,
                   viewModel: PetItemViewModel): PetItemViewHolder {

            val binding = ItemPetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PetItemViewHolder(binding, viewModel)
        }

    }
}