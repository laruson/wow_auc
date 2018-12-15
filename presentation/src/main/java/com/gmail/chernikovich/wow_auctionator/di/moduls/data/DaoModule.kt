package com.gmail.chernikovich.wow_auctionator.di.moduls.data

import andrey.chernikovich.data.db.dao.GroupItemDao
import andrey.chernikovich.data.db.dao.ItemDao
import andrey.chernikovich.data.db.dao.PetDao
import andrey.chernikovich.data.db.dao.RealmDao
import andrey.chernikovich.data.db.databases.AuctionDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    @Provides
    @Singleton
    fun provideGroupItemDao(auctionDatabase: AuctionDatabase): GroupItemDao{
        return auctionDatabase.groupItemDao()
    }

    @Provides
    @Singleton
    fun provideItemDao(auctionDatabase: AuctionDatabase): ItemDao{
        return auctionDatabase.itemDao()
    }

    @Provides
    @Singleton
    fun providePetDao(auctionDatabase: AuctionDatabase): PetDao {
        return auctionDatabase.petDao()
    }

    @Provides
    @Singleton
    fun provideRealmDao(auctionDatabase: AuctionDatabase): RealmDao{
        return auctionDatabase.realmDao()
    }

}