package com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.find

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentFindItemBinding
import com.gmail.chernikovich.wow_auctionator.presenter.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presenter.screen.auction.AuctionRouter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.subscribeBy

class FindItemFragment : BaseMvvmFragment<
        FindItemViewModel,
        AuctionRouter,
        FragmentFindItemBinding>() {

    companion object {
        fun getInstance(): FindItemFragment {
            return FindItemFragment()
        }
    }

    override fun provideViewModel(): FindItemViewModel {
        return ViewModelProviders.of(this).get(FindItemViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_find_item


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = viewModel.adapter
        binding.recycler.layoutManager = LinearLayoutManager(view.context)
        binding.recycler.setHasFixedSize(true)
        RxTextView.textChanges(binding.itemSearch)
                .subscribeBy {
                    viewModel.search(it.toString())
                }
    }
}