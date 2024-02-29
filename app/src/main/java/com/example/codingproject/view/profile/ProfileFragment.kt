package com.example.codingproject.view.profile

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.codingproject.R
import com.example.codingproject.core.htmlText
import com.example.codingproject.core.parseJsonToModel
import com.example.codingproject.core.readJsonFromAssets
import com.example.codingproject.databinding.FragmentProfileBinding
import com.example.codingproject.view.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonString = readJsonFromAssets(requireContext(), "profile.json")
        val profileInfo = parseJsonToModel(jsonString)

        Glide.with(requireContext()).load(profileInfo.profile.image).into(binding.ivProfile)
        binding.etName.text = profileInfo.profile.name
        binding.etWorkExperience.htmlText(profileInfo.profile.work_experience)
        binding.etEducation.htmlText(profileInfo.profile.education)
    }

}