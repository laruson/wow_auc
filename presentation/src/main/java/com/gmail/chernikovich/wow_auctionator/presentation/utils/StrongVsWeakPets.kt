package com.gmail.chernikovich.wow_auctionator.presentation.utils

fun strong(petType: Int): Int {
    var strong = 0
    when (petType) {
        0 -> strong = 1
        1 -> strong = 5
        2 -> strong = 8
        3 -> strong = 0
        4 -> strong = 3
        5 -> strong = 2
        6 -> strong = 9
        7 -> strong = 4
        8 -> strong = 6
        9 -> strong = 7
    }
    return strong
}

fun weak(petType: Int): Int {
    var weak = 0
    when (petType) {
        0 -> weak = 7
        1 -> weak = 3
        2 -> weak = 1
        3 -> weak = 8
        4 -> weak = 0
        5 -> weak = 9
        6 -> weak = 4
        7 -> weak = 2
        8 -> weak = 5
        9 -> weak = 6
    }
    return weak
}