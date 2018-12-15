package com.gmail.chernikovich.wow_auctionator.presentation.screen.settings

import andrey.chernikovich.domain.entity.realm.Realm
import andrey.chernikovich.domain.usecase.realm.GetRealmsUseCase
import android.R
import android.databinding.ObservableBoolean
import android.widget.ArrayAdapter
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class SettingsViewModel : BaseViewModel<SettingsRouter>() {

    @Inject
    lateinit var getRealms: GetRealmsUseCase

    val regionVisibility= ObservableBoolean(true)
    val realmVisibility= ObservableBoolean(false)
    val buttonVisibility= ObservableBoolean(false)

    private val realms= mutableListOf<Realm>()

    val adapter = ArrayAdapter<String>(App.instance, R.layout.simple_dropdown_item_1line)

    init {
        App.appComponent.injectViewModel(this)
    }

    fun loadRealm(){
        getRealms.getRealms().subscribeBy(
                onNext = {
                    realms.addAll(it)
                    it.map {
                        adapter.add(it.name)
                    }
                },
                onError = {
                    router?.showError(it)
                },
                onComplete = {
                    realmVisibility.set(true)
                }
        )
    }

    fun isCorrectRealm(userText:String):Boolean{
        for(realm:Realm in realms){
            if (realm.name == userText)
                return true
        }
        return false
    }


}