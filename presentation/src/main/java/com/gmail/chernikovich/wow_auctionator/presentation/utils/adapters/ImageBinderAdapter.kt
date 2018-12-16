package com.gmail.chernikovich.wow_auctionator.presentation.utils.adapters

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.gmail.chernikovich.wow_auctionator.presentation.utils.*
import com.gmail.chernikovich.wow_auctionator.presentation.utils.transform.CircularTransformation
import com.gmail.chernikovich.wow_auctionator.presentation.utils.transform.RoundedTransformation
import com.squareup.picasso.Picasso

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("android:src")
fun srcImage(view: ImageView, url: String) {
    picasso(url, view)
}

@BindingAdapter("android:srcPetStats")
fun srcPetStats(view: ImageView, url: String) {
    picassoPetStats(url, view)
}


@BindingAdapter("android:srcFamily")
fun srcFamily(view: ImageView, family: String) {
    when (family) {
        "humanoid" -> picassoPetFamily(HUMANOID, view)
        "dragonkin" -> picassoPetFamily(DRAGONKIN, view)
        "flying" -> picassoPetFamily(FLYING, view)
        "undead" -> picassoPetFamily(UNDEAD, view)
        "critter" -> picassoPetFamily(CRITTER, view)
        "magical" -> picassoPetFamily(MAGICAL, view)
        "elemental" -> picassoPetFamily(ELEMENTAL, view)
        "beast" -> picassoPetFamily(BEAST, view)
        "water" -> picassoPetFamily(WATER, view)
        "mechanical" -> picassoPetFamily(MECHANICAL, view)
    }
}

@BindingAdapter("android:srcFamily")
fun srcFamily(view: ImageView, family: Int) {
    when (family) {
        0 -> picassoPetFamily(HUMANOID, view)
        1 -> picassoPetFamily(DRAGONKIN, view)
        2 -> picassoPetFamily(FLYING, view)
        3 -> picassoPetFamily(UNDEAD, view)
        4 -> picassoPetFamily(CRITTER, view)
        5 -> picassoPetFamily(MAGICAL, view)
        6 -> picassoPetFamily(ELEMENTAL, view)
        7 -> picassoPetFamily(BEAST, view)
        8 -> picassoPetFamily(WATER, view)
        9 -> picassoPetFamily(MECHANICAL, view)
    }
}

private fun picassoPetFamily(url: String, view: ImageView) {
    Picasso.get()
            .load(url)
            .transform(CircularTransformation())
            .into(view)
}

private fun picassoPetStats(url: String, view: ImageView) {
    Picasso.get()
            .load(url)
            .transform(RoundedTransformation(100,0))
            .into(view)
}

private fun picasso(url: String, view: ImageView) {
    Picasso.get()
            .load(url)
            .transform(RoundedTransformation(10,0))
            .into(view)
}