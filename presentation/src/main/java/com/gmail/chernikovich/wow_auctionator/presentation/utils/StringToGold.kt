package com.gmail.chernikovich.wow_auctionator.presentation.utils

import android.util.Log

fun transform(value: String): ArrayList<Int> {
    val list = ArrayList<Int>()
    var string = value
    if (value.length < 6) {
        while (string.length < 6) {
            string = "0$string"
        }
    }

    val copper = string.subSequence(string.length - 2, string.length).toString()
    if (copper == "00")
        list.add(0)
    else
        list.add(copper.toInt())


    val silver = string.subSequence(string.length - 4, string.length - 2).toString()
    if (silver == "00")
        list.add(0)
    else
        list.add(silver.toInt())

    val gold = string.subSequence(0, string.length - 4).toString()
    if (gold == "00")
        list.add(0)
    else
        list.add(gold.toInt())

    return list
}