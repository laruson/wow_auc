package com.gmail.chernikovich.wow_auctionator.di.moduls.data

import andrey.chernikovich.data.net.rest.service.RestServiceItem
import andrey.chernikovich.data.net.rest.service.RestServiceRealm
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.data.net.rest.service.RestServicePet
import andrey.chernikovich.data.sharedpref.REGION
import andrey.chernikovich.domain.sharedpref.SharedPref
import android.util.Log
import com.gmail.chernikovich.wow_auctionator.di.ITEM_URL
import com.gmail.chernikovich.wow_auctionator.di.REST_URL
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RestServiceModule{

    @Provides
    fun provideRestServiceItem(@Named(ITEM_URL) url:String):RestServiceItem{
        return RestServiceItem(url)
    }

    @Provides
    fun provideRestServicePet(@Named(REST_URL) url:String): RestServicePet {
        return RestServicePet(url)
    }

    @Provides
    fun provideRestServiceRealm(@Named(REST_URL) url:String):RestServiceRealm{
        return RestServiceRealm(url)
    }

    @Provides
    fun provideRestServiceToken(@Named(REST_URL) url:String): RestServiceToken {
        return RestServiceToken(url)
    }

    @Provides
    @Named(REST_URL)
    fun provideUrl(sharedPref: SharedPref):String{
        return "https://${sharedPref.getValue(REGION, "eu")}.api.blizzard.com/"
    }

    @Provides
    @Named(ITEM_URL)
    fun provideItemUrl():String{
        return "http://api.tradeskillmaster.com/"
    }
}