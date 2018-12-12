package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.group.GroupFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.find.FindItemFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.pet.PetFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.token.TokenFragment

class FragmentViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    private val title = arrayOf("loadItems","group","pets","token")

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FindItemFragment.getInstance()
            1 -> GroupFragment.getInstance()
            2 -> PetFragment.getInstance()
            else -> TokenFragment.getInstance()
        }
    }

    override fun getCount(): Int = title.size

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}