package com.gmail.chernikovich.wow_auctionator.presentation.screen.info.pet

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.databinding.FragmentPetInfoBinding
import com.gmail.chernikovich.wow_auctionator.presentation.base.BaseMvvmFragment
import com.gmail.chernikovich.wow_auctionator.presentation.screen.info.InfoRouter
import com.gmail.chernikovich.wow_auctionator.presentation.utils.ID_EXTRA
import com.gmail.chernikovich.wow_auctionator.presentation.utils.IMG_EXTRA
import com.gmail.chernikovich.wow_auctionator.presentation.utils.QUALITY_EXTRA

class PetInfoFragment : BaseMvvmFragment<
        PetInfoViewModel,
        InfoRouter,
        FragmentPetInfoBinding>() {

    companion object {
        fun getInstance(id:String, qualityId:Int): PetInfoFragment {
            val fragment = PetInfoFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            bundle.putInt(QUALITY_EXTRA, qualityId)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun provideViewModel()
            : PetInfoViewModel = ViewModelProviders.of(this).get(PetInfoViewModel::class.java)

    override fun provideLayoutId()
            : Int = R.layout.fragment_pet_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.get(ID_EXTRA) as String
        val qualityId = arguments?.get(QUALITY_EXTRA) as Int

        viewModel.setInfoPet(id, qualityId)
        binding.recycler.adapter = viewModel.adapter
        binding.recycler.layoutManager = LinearLayoutManager(view.context)
        binding.recycler.setHasFixedSize(true)
    }
}