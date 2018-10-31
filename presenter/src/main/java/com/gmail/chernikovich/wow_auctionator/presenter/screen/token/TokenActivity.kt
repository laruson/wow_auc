package com.gmail.chernikovich.wow_auctionator.presenter.screen.token

import android.arch.lifecycle.ViewModelProviders
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityWowTokenBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity

class TokenActivity : BaseMvvmActivity<TokenViewModel, TokenRouter, ActivityWowTokenBinding>() {
    override fun provideViewModel(): TokenViewModel {
        return ViewModelProviders.of(this).get(TokenViewModel::class.java)
    }

    override fun provideRouter(): TokenRouter {
        return TokenRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_wow_token

    override fun onBackPressed() {
        router.goToMainMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_region, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.eu)
            provideViewModel().showEuToken()
        else if (item?.itemId == R.id.us)
            provideViewModel().showUsToken()

        return true
    }
}