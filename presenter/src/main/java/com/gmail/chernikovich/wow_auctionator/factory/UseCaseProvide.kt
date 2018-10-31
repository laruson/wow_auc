package com.gmail.chernikovich.wow_auctionator.factory

import andrey.chernikovich.data.net.RestService
import andrey.chernikovich.data.repository.ItemRepositoryImpl
import andrey.chernikovich.data.repository.TokenRepositoryImpl
import andrey.chernikovich.domain.usecase.GetItemsUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenEuUseCase
import andrey.chernikovich.domain.usecase.token.GetTokenUsUseCase
import com.gmail.chernikovich.wow_auctionator.executer.UIThread


object UseCaseProvide {
    private val thread = UIThread()
    private val restServiceEu = RestService("https://eu.api.battle.net/")
    private val restServiceUs = RestService("https://us.api.battle.net/")

    fun provideGetTokenEuUseCase() : GetTokenEuUseCase {
        return GetTokenEuUseCase(thread, TokenRepositoryImpl(restServiceEu))
    }
    fun provideGetTokenUsUseCase() : GetTokenUsUseCase {
        return GetTokenUsUseCase(thread, TokenRepositoryImpl(restServiceUs))
    }

    fun provideGetItemsUseCase():GetItemsUseCase{
        return GetItemsUseCase(thread, ItemRepositoryImpl())
    }
}