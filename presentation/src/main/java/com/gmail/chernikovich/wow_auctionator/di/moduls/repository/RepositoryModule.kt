package com.gmail.chernikovich.wow_auctionator.di.moduls.repository

import andrey.chernikovich.data.db.dao.GroupItemDao
import andrey.chernikovich.data.db.dao.ItemDao
import andrey.chernikovich.data.db.dao.PetDao
import andrey.chernikovich.data.db.dao.RealmDao
import andrey.chernikovich.data.net.rest.service.RestServiceItem
import andrey.chernikovich.data.net.rest.service.RestServicePet
import andrey.chernikovich.data.net.rest.service.RestServiceRealm
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.data.repository.*
import andrey.chernikovich.domain.repository.*
import andrey.chernikovich.domain.sharedpref.SharedPref
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    fun provideGroupItemRepository(groupItemDao: GroupItemDao): GroupItemRepository {
        return GroupItemRepositoryImpl(groupItemDao)
    }

    @Provides
    fun provideItemRepository(restServiceItem: RestServiceItem,
                              itemDao: ItemDao): ItemRepository {
        return ItemRepositoryImpl(restServiceItem, itemDao)
    }

    @Provides
    fun providePetRepository(restServicePet: RestServicePet,
                             petDao: PetDao,
                             sharedPref: SharedPref): PetRepository {
        return PetRepositoryImpl(restServicePet, petDao, sharedPref)
    }

    @Provides
    fun provideRealmRepository(restServiceRealm: RestServiceRealm,
                               realmDao: RealmDao,
                               sharedPref: SharedPref): RealmRepository {
        return RealmRepositoryImpl(restServiceRealm, realmDao, sharedPref)
    }

    @Provides
    fun provideTokenRepository(restServiceToken: RestServiceToken,
                               sharedPref: SharedPref): TokenRepository {
        return TokenRepositoryImpl(restServiceToken, sharedPref)
    }
}