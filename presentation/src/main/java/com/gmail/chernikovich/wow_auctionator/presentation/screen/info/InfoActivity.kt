package com.gmail.chernikovich.wow_auctionator.presentation.screen.info

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityInfoBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmActivity
import com.gmail.chernikovich.wow_auctionator.presentation.utils.*

class InfoActivity : BaseMvvmActivity<InfoViewModel, InfoRouter, ActivityInfoBinding>() {
    override fun provideRouter(): InfoRouter {
        return InfoRouter(this)
    }

    override fun provideViewModel(): InfoViewModel {
        return ViewModelProviders.of(this).get(InfoViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra(ID_EXTRA)
        val img = intent.getStringExtra(IMG_EXTRA)
        val qualityId = intent.getIntExtra(QUALITY_EXTRA,1)
        val content = intent.getStringExtra(CONTENT)
        if(content == PET_CONTENT){
            router.showPetInfo(id, qualityId)
        }
        else{
            router.showItemInfo(id, img, qualityId.toString())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        router.goToAuction()
    }
}