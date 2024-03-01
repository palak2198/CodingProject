package com.example.codingproject.view.cat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.codingproject.core.htmlText
import com.example.codingproject.data.model.CatsResponseItem
import com.example.codingproject.databinding.FragmentCatDetailsBinding
import com.example.codingproject.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatDetailsFragment : BaseFragment<FragmentCatDetailsBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentCatDetailsBinding
        get() = FragmentCatDetailsBinding::inflate

    private val args: CatDetailsFragmentArgs by navArgs()

    private val catDetails: CatsResponseItem? by lazy {
        args.extraCatDetails
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
    }

    private fun initializeUI() {
        catDetails?.let {
            with(binding) {
                tvName.text = it.name
                tvTemparament.htmlText("<b>Temperament:</b><br> ${it.temperament}")
                tvOrigin.htmlText("<b>Origin:</b><br> ${it.origin}")
                tvDescription.htmlText("<b>Description:</b><br> ${it.description}")
                tvLifeSpan.htmlText("<b>Life Span:</b><br> ${it.lifeSpan}")
                tvAdaptability.htmlText("<b>Adaptability:</b><br> ${it.adaptability}")
                tvAffectionLevel.htmlText("<b>Affection Level:</b><br> ${it.affectionLevel}")
                tvChildFriendly.htmlText("<b>Child Friendly:</b><br> ${it.childFriendly}")
                tvDogFriendly.htmlText("<b>Dog Friendly:</b><br> ${it.dogFriendly}")
                tvEnergyLevel.htmlText("<b>Energy Level:</b><br> ${it.energyLevel}")
                tvGrooming.htmlText("<b>Grooming:</b><br> ${it.grooming}")
                tvHealthIssues.htmlText("<b>Health Issues:</b><br> ${it.healthIssues}")
                tvIntelligence.htmlText("<b>Intelligence:</b><br> ${it.intelligence}")
                tvSheddingLevel.htmlText("<b>Shedding Level:</b><br> ${it.sheddingLevel}")
                tvSocialNeeds.htmlText("<b>Social Needs:</b><br> ${it.socialNeeds}")
                tvStrangerFriendly.htmlText("<b>Stranger Friendly:</b><br> ${it.strangerFriendly}")
                tvWikipediaUrl.htmlText("<b>Wikipedia URL:</b><br> ${it.wikipediaUrl}")
            }
        }
    }
}