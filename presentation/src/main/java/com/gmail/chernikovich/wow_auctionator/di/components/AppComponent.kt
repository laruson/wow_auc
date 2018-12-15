package com.gmail.chernikovich.wow_auctionator.di.components

import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.di.moduls.AppModule
import com.gmail.chernikovich.wow_auctionator.di.moduls.data.DaoModule
import com.gmail.chernikovich.wow_auctionator.di.moduls.data.DataModule
import com.gmail.chernikovich.wow_auctionator.di.moduls.data.RestServiceModule
import com.gmail.chernikovich.wow_auctionator.di.moduls.repository.RepositoryModule
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.AuctionActivity
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.find.FindItemViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.group.GroupViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.pet.PetViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.auction.fragments.token.TokenViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.item.ItemInfoViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.screen.settings.SettingsActivity
import com.gmail.chernikovich.wow_auctionator.presentation.screen.settings.SettingsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DaoModule::class,
    DataModule::class,
    RestServiceModule::class,
    RepositoryModule::class,
    AppModule::class])
interface AppComponent {

    fun inject(app: App)

    fun injectActivity(activity: AuctionActivity)

    fun injectActivity(activity: SettingsActivity)

    fun injectViewModel(viewModel: FindItemViewModel)

    fun injectViewModel(viewModel: ItemInfoViewModel)

    fun injectViewModel(viewModel: GroupViewModel)

    fun injectViewModel(viewModel: PetViewModel)

    fun injectViewModel(viewModel: TokenViewModel)

    fun injectViewModel(viewModel: InfoViewModel)

    fun injectViewModel(viewModel: SettingsViewModel)


}