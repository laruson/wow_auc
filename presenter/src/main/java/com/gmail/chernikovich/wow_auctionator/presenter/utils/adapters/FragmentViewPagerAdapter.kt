package com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.gmail.chernikovich.wow_auctionator.presenter.screen.group.GroupFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.item.find.FindItemFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.token.TokenFragment

class FragmentViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    private val title = arrayOf("items","group","token")

    override fun getItem(position: Int): Fragment {
        if (position==0)
            return FindItemFragment.getInstance()
        else if(position==1)
            return GroupFragment.getInstance()
        else
            return TokenFragment.getInstance()
    }

    override fun getCount(): Int = title.size

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}