package com.gmail.chernikovich.wow_auctionator.factory

import andrey.chernikovich.data.net.RestServiceItem
import andrey.chernikovich.data.net.RestServiceToken
import andrey.chernikovich.data.repository.ItemRepositoryImpl
import andrey.chernikovich.data.repository.TokenRepositoryImpl
import andrey.chernikovich.domain.usecase.GetItemsUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenEuUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenUsUseCase
import com.gmail.chernikovich.wow_auctionator.executer.UIThread


object UseCaseProvide {
    private val thread = UIThread()
    private val restServiceTokenEu = RestServiceToken("https://eu.api.battle.net/")
    private val restServiceTokenUs = RestServiceToken("https://us.api.battle.net/")
    private val restServiceItem = RestServiceItem("https://raw.githubusercontent.com/")

    fun provideGetTokenEuUseCase() : GetTokenEuUseCase {
        return GetTokenEuUseCase(thread, TokenRepositoryImpl(restServiceTokenEu))
    }
    fun provideGetTokenUsUseCase() : GetTokenUsUseCase {
        return GetTokenUsUseCase(thread, TokenRepositoryImpl(restServiceTokenUs))
    }

    fun provideGetItemsUseCase():GetItemsUseCase{
        return GetItemsUseCase(thread, ItemRepositoryImpl(restServiceItem))
    }
}