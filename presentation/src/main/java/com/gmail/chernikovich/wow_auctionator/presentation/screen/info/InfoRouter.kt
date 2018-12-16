package com.gmail.chernikovich.wow_auctionator.presentation.screen.info

import android.content.Intent
import com.gmail.chernikovich.wow_auctionator.R.id.container
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseRouter
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionActivity
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.item.ItemInfoFragment
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet.PetInfoFragment

class InfoRouter(activity: InfoActivity) : BaseRouter<InfoActivity>(activity) {

    fun goToAuction() {
        val intent = Intent(activity, AuctionActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    fun showPetInfo(id:String, qualityId:Int){
        replaceFragment(activity.supportFragmentManager,
                PetInfoFragment.getInstance(id, qualityId),
                container, true)
    }

    fun showItemInfo(id:String, img:String, qualityId:String){
        replaceFragment(activity.supportFragmentManager,
                ItemInfoFragment.getInstance(id, img, qualityId),
                container, true)
    }
}