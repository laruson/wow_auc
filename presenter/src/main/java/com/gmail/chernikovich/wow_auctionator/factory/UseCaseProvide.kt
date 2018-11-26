package com.gmail.chernikovich.wow_auctionator.factory

import andrey.chernikovich.data.db.databases.GroupItemDatabase
import andrey.chernikovich.data.db.databases.ItemDatabase
import andrey.chernikovich.data.net.rest.service.RestServiceItem
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.data.repository.GroupItemRepositoryImpl
import andrey.chernikovich.data.repository.ItemRepositoryImpl
import andrey.chernikovich.data.repository.TokenRepositoryImpl
import andrey.chernikovich.domain.usecase.item.*
import andrey.chernikovich.domain.usecase.token.GetTokenEuUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenUsUseCase
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.executer.UIThread

//
object UseCaseProvide {
    private val thread = UIThread()
    private val restServiceTokenEu = RestServiceToken("https://eu.api.battle.net/")
    private val restServiceTokenUs = RestServiceToken("https://us.api.battle.net/")
    //    http://api.tradeskillmaster.com/v1/item/EU/aegwynn/33470?format=json&apiKey=hAkf3v5YsC1w9DuEmnSQRRAAVetuR-qb
    private val restServiceItem = RestServiceItem("http://api.tradeskillmaster.com/")

    private val itemDao= ItemDatabase.getInstance(App.instance.applicationContext).itemDao()
    private val groupItemDao = GroupItemDatabase.getInstance(App.instance.applicationContext).groupItemDao()

    private val itemGroupRep = GroupItemRepositoryImpl(groupItemDao)
    private val itemRep = ItemRepositoryImpl(restServiceItem, itemDao)

    fun provideGetTokenEuUseCase() : GetTokenEuUseCase {
        return GetTokenEuUseCase(thread, TokenRepositoryImpl(restServiceTokenEu))
    }

    fun provideGetTokenUsUseCase() : GetTokenUsUseCase {
        return GetTokenUsUseCase(thread, TokenRepositoryImpl(restServiceTokenUs))
    }

    fun provideGetItemsUseCase(): GetItemsUseCase {
        return GetItemsUseCase(thread, itemRep)
    }

    fun provideSearchItem():SearchItemUseCase{
        return SearchItemUseCase(thread,itemRep)
    }

    fun provideGetItemByIdUseCase():GetItemByIdUseCase{
        return GetItemByIdUseCase(thread,itemRep)
    }

    fun provideSaveItemUseCase():SaveItemUseCase{
        return SaveItemUseCase(thread, itemGroupRep)
    }

    fun provideGetSaveItemsUseCase():GetSaveItemUseCase{
        return GetSaveItemUseCase(thread, itemGroupRep)
    }
}