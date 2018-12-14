package com.gmail.chernikovich.wow_auctionator.presentation.screen.settings

import andrey.chernikovich.data.sharedpref.NAMESPACE
import andrey.chernikovich.data.sharedpref.REGION
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.app.App
import com.gmail.chernikovich.wow_auctionator.databinding.ActivitySettingsBinding
import com.gmail.chernikovich.wow_auctionator.factory.UseCaseProvide
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmActivity
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

        readyRegionButton.setOnClickListener {
            val text = regionEditText.text.toString()
            if (text == "eu" || text == "us") {
                Log.e("AA", text)
                App.sharedPref.edit().putString(REGION, text).apply()
                App.sharedPref.edit().putString(NAMESPACE, "dynamic-$text").apply()
                realmAutoComp.setAdapter(viewModel.adapter)
                viewModel.loadRealm()
                viewModel.regionVisibility.set(false)
            } else {
                router.showError("Incorrect region")

            }
        }

        readyButton.setOnClickListener {
            router.goToAuction()
        }

    }



}