package com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("android:src")
fun srcImage(view: ImageView, url:String){
    Picasso
            .get()
            .load(url)
            .into(view)
}