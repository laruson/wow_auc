package com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.adapter

import andrey.chernikovich.domain.entity.pet.Pet
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.presentation.base.recycler.BaseRecyclerAdapter

class PetItemAdapter : BaseRecyclerAdapter<
        Pet,
        PetItemViewModel>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int)
            : PetItemViewHolder {

        return PetItemViewHolder.create(viewGroup, PetItemViewModel())
    }
}