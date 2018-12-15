package com.gmail.chernikovich.wow_auctionator.presentation.utils.adapters

import android.content.Context
import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.TextView
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.app.App
import javax.inject.Inject

@BindingAdapter("android:text")
fun textInt(view: TextView, value: Int) {
    view.text = value.toString()
}

@BindingAdapter("android:textColor")
fun textColor(view: TextView, value: Int) {
    when (value) {
        0 -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.poor))
        1 -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.common))
        2 -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.uncommon))
        3 -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.rare))
        4 -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.epic))
        5 -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.legendary))
    }
}

@BindingAdapter("android:textColor")
fun textColor(view: TextView, value: String) {
    when (value) {
        "0" -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.poor))
        "1" -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.common))
        "2" -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.uncommon))
        "3" -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.rare))
        "4" -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.epic))
        "5" -> view.setTextColor(ContextCompat.getColor(App.instance, R.color.legendary))
    }
}