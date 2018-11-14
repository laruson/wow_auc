package com.gmail.chernikovich.wow_auctionator.factory

import andrey.chernikovich.data.db.databases.ItemDatabase
import andrey.chernikovich.data.net.rest.service.RestServiceItem
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.data.repository.ItemRepositoryImpl
import andrey.chernikovich.data.repository.TokenRepositoryImpl
import andrey.chernikovich.domain.usecase.item.GetItemsUseCase
import andrey.chernikovich.domain.usecase.item.SearchItemUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenEuUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenUsUseCase
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.executer.UIThread

//
object UseCaseProvide {
    private val thread = UIThread()
    private val restServiceTokenEu = RestServiceToken("https://eu.api.battle.net/")
    private val restServiceTokenUs = RestServiceToken("https://us.api.battle.net/")
    private val restServiceItem = RestServiceItem("https://raw.githubusercontent.com/")

    private val dao= ItemDatabase.getInstance(App.instance.applicationContext).itemDao()
//    private val dao = CopyDb.getInstance(App.instance.applicationContext).getDb().itemDao()

    fun provideGetTokenEuUseCase() : GetTokenEuUseCase {
        return GetTokenEuUseCase(thread, TokenRepositoryImpl(restServiceTokenEu))
    }

    fun provideGetTokenUsUseCase() : GetTokenUsUseCase {
        return GetTokenUsUseCase(thread, TokenRepositoryImpl(restServiceTokenUs))
    }

    fun provideGetItemsUseCase(): GetItemsUseCase {
        return GetItemsUseCase(thread, ItemRepositoryImpl(restServiceItem, dao))
    }

    fun provideSearchItem():SearchItemUseCase{
        return SearchItemUseCase(thread,ItemRepositoryImpl(restServiceItem, dao))
    }
}