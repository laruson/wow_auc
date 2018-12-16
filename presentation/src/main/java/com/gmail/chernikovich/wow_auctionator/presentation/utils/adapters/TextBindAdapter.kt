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

@BindingAdapter("android:textPetType")
fun petType(view: TextView, value: Int) {
    when (value) {
        0 -> view.text = App.instance.getString(R.string.humanoid)
        1 -> view.text = App.instance.getString(R.string.dragonkin)
        2 -> view.text = App.instance.getString(R.string.flying)
        3 -> view.text = App.instance.getString(R.string.undead)
        4 -> view.text = App.instance.getString(R.string.critter)
        5 -> view.text = App.instance.getString(R.string.magical)
        6 -> view.text = App.instance.getString(R.string.elemental)
        7 -> view.text = App.instance.getString(R.string.beast)
        8 -> view.text = App.instance.getString(R.string.water)
        9 -> view.text = App.instance.getString(R.string.mechanical)

    }
}