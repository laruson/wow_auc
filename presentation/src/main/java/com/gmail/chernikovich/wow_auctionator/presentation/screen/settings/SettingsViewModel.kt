package com.gmail.chernikovich.wow_auctionator.presentation.screen.settings

import android.R
import android.databinding.ObservableBoolean
import android.util.Log
import android.widget.ArrayAdapter
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsViewModel : BaseViewModel<SettingsRouter>() {

    val regionVisibility= ObservableBoolean(true)
    val realmVisibility= ObservableBoolean(false)
    val buttonVisibility= ObservableBoolean(false)

    val adapter = ArrayAdapter<String>(App.instance, R.layout.simple_dropdown_item_1line)

    fun loadRealm(){
        UseCaseProvide.provideGetRealmsUseCase().getRealms().subscribeBy(
                onNext = {
                    Log.e("Realms", it.toString())
                    it.map {
                        adapter.add(it.name)
                    }
                },
                onError = {
//                    router?.showError(it)
                    Log.e("AAA", it.message)
                    router?.showError("Hello")
                },
                onComplete = {
                    realmVisibility.set(true)
                }
        )
    }


}