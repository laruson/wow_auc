package com.gmail.chernikovich.wow_auctionator.presenter.screen.settings

import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.entity.Realm
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivitySettingsBinding
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : BaseMvvmActivity<
        SettingsViewModel,
        SettingsRouter,
        ActivitySettingsBinding>() {

    private val list = mutableListOf<String>()

    override fun provideViewModel()
            : SettingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)

    override fun provideRouter()
            : SettingsRouter = SettingsRouter(this)

    override fun provideLayoutId()
            : Int = R.layout.activity_settings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readyButton.setOnClickListener {
            router.goToAuction()
        }
        UseCaseProvide.provideGetRealmsUseCase().getRealms().subscribeBy(
                onNext = {
                    Log.e("Realms", it.toString())
                    it.map {
                        list.add(it.name)
                    }
                    realmAutoComp.setAdapter(ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list))

                },
                onError = {
                    router.showError(it)
                }
        )
    }

}