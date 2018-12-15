package com.gmail.chernikovich.wow_auctionator.presentation.screen.info

import andrey.chernikovich.data.sharedpref.REALM
import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.usecase.group.SaveGroupItemUseCase
import andrey.chernikovich.domain.usecase.item.GetItemByIdUseCase
import android.content.SharedPreferences
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import com.gmail.chernikovich.wow_auctionator.presentation.utils.EMPTY
import com.gmail.chernikovich.wow_auctionator.presentation.utils.transform
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class InfoViewModel : BaseViewModel<InfoRouter>() {

}