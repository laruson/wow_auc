package com.gmail.chernikovich.wow_auctionator.factory

import andrey.chernikovich.data.db.databases.AuctionDatabase
import andrey.chernikovich.data.net.rest.service.RestServiceItem
import andrey.chernikovich.data.net.rest.service.RestServiceRealm
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.data.net.rest.service.RestServisePet
import andrey.chernikovich.data.repository.*
import andrey.chernikovich.data.sharedpref.REGION
import andrey.chernikovich.data.sharedpref.SharedPrefImpl
import andrey.chernikovich.domain.usecase.group.DeleteGroupItemUseCase
import andrey.chernikovich.domain.usecase.group.GetGroupItemUseCase
import andrey.chernikovich.domain.usecase.group.SaveGroupItemUseCase
import andrey.chernikovich.domain.usecase.item.*
import andrey.chernikovich.domain.usecase.pet.GetPetsUseCase
import andrey.chernikovich.domain.usecase.pet.SavePetsUseCase
import andrey.chernikovich.domain.usecase.realm.GetRealmsUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenUseCase
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.executer.UIThread

//
object UseCaseProvide {
    private val thread = UIThread()

    private val shared = SharedPrefImpl(App.sharedPref)

    private val blizzardURL = "https://${shared.getValue(REGION)}.api.blizzard.com/"

    //rest
    private val restServiceToken = RestServiceToken(blizzardURL)
    private val restServiceRealm = RestServiceRealm(blizzardURL)
    private val restServiceItem = RestServiceItem("http://api.tradeskillmaster.com/")
    private val restServisePet = RestServisePet(blizzardURL)

    //data
    private val database = AuctionDatabase.getInstance(App.instance.applicationContext)

    private val itemDao = database.itemDao()
    private val realmDao = database.realmDao()
    private val groupItemDao = database.groupItemDao()
    private val petDao = database.petDao()

    //repo
    private val itemGroupRep = GroupItemRepositoryImpl(groupItemDao)
    private val itemRep = ItemRepositoryImpl(restServiceItem, itemDao)
    private val petRep = PetRepositoryImpl(restServisePet, petDao, shared)

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

    //pets

    fun provideGetPetsUseCase(): GetPetsUseCase {
        return GetPetsUseCase(thread, petRep)
    }

    fun provideSavePetsUseCase(): SavePetsUseCase{
        return SavePetsUseCase(thread, petRep)
    }
}