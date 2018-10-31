package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.create

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityCreateGroupBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity

class CreateGroupActivity : BaseMvvmActivity<CreateGroupViewModel, CreateGroupRouter, ActivityCreateGroupBinding>() {

    override fun provideViewModel(): CreateGroupViewModel = ViewModelProviders.of(this).get(CreateGroupViewModel::class.java)

    override fun provideRouter(): CreateGroupRouter = CreateGroupRouter(this)

    override fun provideLayoutId(): Int = R.layout.activity_create_group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router.goToCreateGroup()
    }
}