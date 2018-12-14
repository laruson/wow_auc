package com.gmail.chernikovich.wow_auctionator.presentation.utils.adapters

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.gmail.chernikovich.wow_auctionator.presentation.utils.*
import com.squareup.picasso.Picasso

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("android:src")
fun srcImage(view: ImageView, url: String) {
    picasso(url, view)
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

private fun picassoPetFamily(url: String, view: ImageView) {
    Picasso.get()
            .load(url)
            .into(view)
}

private fun picassoPetStats(url: String, view: ImageView) {
    Picasso.get()
            .load(url)
            .into(view)
}

private fun picasso(url: String, view: ImageView) {
    Picasso.get()
            .load(url)
            .into(view)
}