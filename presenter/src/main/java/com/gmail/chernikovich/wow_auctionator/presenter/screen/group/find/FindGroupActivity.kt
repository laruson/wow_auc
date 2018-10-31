package com.gmail.chernikovich.wow_auctionator.presenter.screen.group.find

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.ArrayAdapter
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.ActivityFindItemBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmActivity
import kotlinx.android.synthetic.main.activity_find_my_group.*

class FindGroupActivity : BaseMvvmActivity<
        FindGroupViewModel,
        FindGroupRouter,
        ActivityFindItemBinding>() {

    var languages = arrayOf("C", "C++", "Java", "C#", "PHP", "JavaScript", "jQuery", "AJAX", "JSON")

    override fun provideViewModel(): FindGroupViewModel {
        return ViewModelProviders.of(this).get(FindGroupViewModel::class.java)
    }

    override fun provideRouter(): FindGroupRouter {
        return FindGroupRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_find_my_group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            router.goToFindMyGroup()
        }
        var adapter = ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, languages)
        myGroups.threshold=1
        myGroups.setAdapter(adapter)
    }
}