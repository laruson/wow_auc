package com.gmail.chernikovich.wow_auctionator.presenter.utils.picasso

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import android.databinding.BindingAdapter


fun setImage(url: String, image: ImageView, progressItem: ProgressBar) {
    Picasso.get()
            .load(url)
//            .transform(CircularTransformation())
            .into(image, object : Callback {
                override fun onSuccess() {
                    progressItem.visibility = View.GONE
                }

                override fun onError(e: Exception) {
                }
            })
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso.get()
            .load(imageUrl)
            .into(view)
}