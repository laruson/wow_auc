package com.gmail.chernikovich.wow_auctionator.factory

import andrey.chernikovich.data.db.databases.GroupItemDatabase
import andrey.chernikovich.data.db.databases.ItemDatabase
import andrey.chernikovich.data.net.rest.service.RestServiceItem
import andrey.chernikovich.data.net.rest.service.RestServiceRealm
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.data.repository.GroupItemRepositoryImpl
import andrey.chernikovich.data.repository.ItemRepositoryImpl
import andrey.chernikovich.data.repository.RealmRepositoryImpl
import andrey.chernikovich.data.repository.TokenRepositoryImpl
import andrey.chernikovich.data.sharedpref.SharedPrefImpl
import andrey.chernikovich.domain.usecase.group.DeleteGroupItemUseCase
import andrey.chernikovich.domain.usecase.group.GetGroupItemUseCase
import andrey.chernikovich.domain.usecase.group.SaveGroupItemUseCase
import andrey.chernikovich.domain.usecase.item.*
import andrey.chernikovich.domain.usecase.realm.GetRealmsUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenUseCase
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.executer.UIThread

//
object UseCaseProvide {
    private val thread = UIThread()

    private val shared = SharedPrefImpl(App.sharedPref)

    private val blizzardURL = "https://${shared.getRegion()}.api.blizzard.com/"

    private val restServiceToken = RestServiceToken(blizzardURL)
    private val restServiceRealm = RestServiceRealm(blizzardURL)
    private val restServiceItem = RestServiceItem("http://api.tradeskillmaster.com/")

    //    private val restServiceTokenEu = RestServiceToken("https://eu.api.blizzard.com/")
//    private val restServiceTokenUs = RestServiceToken("https://us.api.blizzard.com/")
//    http://api.tradeskillmaster.com/v1/item/EU/aegwynn/33470?format=json&apiKey=hAkf3v5YsC1w9DuEmnSQRRAAVetuR-qb

    private val itemDao = ItemDatabase.getInstance(App.instance.applicationContext).itemDao()
    private val realmDao = ItemDatabase.getInstance(App.instance.applicationContext).realmDao()
    private val groupItemDao = GroupItemDatabase.getInstance(App.instance.applicationContext).groupItemDao()

    private val itemGroupRep = GroupItemRepositoryImpl(groupItemDao)
    private val itemRep = ItemRepositoryImpl(restServiceItem, itemDao)

    //token

    fun provideGetTokenUseCase(): GetTokenUseCase {
        return GetTokenUseCase(thread, TokenRepositoryImpl(restServiceToken, shared))
    }


    //realm

    fun provideGetRealmsUseCase(): GetRealmsUseCase {
        return GetRealmsUseCase(thread, RealmRepositoryImpl(restServiceRealm, realmDao, shared))
    }

    //item

    fun provideGetItemsUseCase(): GetItemsUseCase {
        return GetItemsUseCase(thread, itemRep)
    }

    fun provideSearchItem(): SearchItemUseCase {
        return SearchItemUseCase(thread, itemRep)
    }

    fun provideGetItemByIdUseCase(): GetItemByIdUseCase {
        return GetItemByIdUseCase(thread, itemRep)
    }

    fun provideSaveItems(): SaveItemUseCase {
        return SaveItemUseCase(thread, itemRep)
    }

    //group

    fun provideSaveItemUseCase(): SaveGroupItemUseCase {
        return SaveGroupItemUseCase(thread, itemGroupRep)
    }

    fun provideGetSaveItemsUseCase(): GetGroupItemUseCase {
        return GetGroupItemUseCase(thread, itemGroupRep)
    }

    fun provideDeleteGroupItemUseCase(): DeleteGroupItemUseCase {
        return DeleteGroupItemUseCase(thread, itemGroupRep)
    }
}