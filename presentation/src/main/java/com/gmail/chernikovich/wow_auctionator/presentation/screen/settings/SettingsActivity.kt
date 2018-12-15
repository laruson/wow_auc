package com.gmail.chernikovich.wow_auctionator.presentation.screen.settings

import andrey.chernikovich.data.sharedpref.IS_LOAD_COMPLITE
import andrey.chernikovich.data.sharedpref.NAMESPACE
import andrey.chernikovich.data.sharedpref.REALM
import andrey.chernikovich.data.sharedpref.REGION
import andrey.chernikovich.domain.sharedpref.SharedPref
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.databinding.ActivitySettingsBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmActivity
import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity : BaseMvvmActivity<
        SettingsViewModel,
        SettingsRouter,
        ActivitySettingsBinding>() {

    @Inject
    lateinit var sharedPreferences: SharedPref

    override fun provideViewModel()
            : SettingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)

    override fun provideRouter()
            : SettingsRouter = SettingsRouter(this)

    override fun provideLayoutId()
            : Int = R.layout.activity_settings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.injectActivity(this)

        readyRegionButton.setOnClickListener {
            val text = regionEditText.text.toString()
            if (text == "eu" || text == "us") {
                sharedPreferences.putValue(REGION, text)
                sharedPreferences.putValue(NAMESPACE, "dynamic-$text")
                realmAutoComp.setAdapter(viewModel.adapter)
                viewModel.loadRealm()
                viewModel.regionVisibility.set(false)
            } else {
                router.showError("Incorrect region")
                return@setOnClickListener
            }
        }

        readyButton.setOnClickListener {
            val text = realmAutoComp.text.toString()
            if(!viewModel.isCorrectRealm(text)){
                router.showError("Faice realm")
                return@setOnClickListener
            }

            sharedPreferences.putValue(REALM, text)
            val load = sharedPreferences.getValueBoolean(IS_LOAD_COMPLITE)
            if (!load) {
                router.goToLoadingScreen()
            } else
                router.goToAuction()
        }

    }


}