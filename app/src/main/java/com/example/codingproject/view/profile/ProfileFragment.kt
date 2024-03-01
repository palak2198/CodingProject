package com.example.codingproject.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.codingproject.core.htmlText
import com.example.codingproject.core.loadImage
import com.example.codingproject.databinding.FragmentProfileBinding
import com.example.codingproject.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObserver()
        profileViewModel.getProfile()
    }

    private fun subscribeObserver() {
        profileViewModel.profileResponseLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                ivProfile.loadImage(it?.profile?.image)
                etName.text = it?.profile?.name
                etWorkExperience.htmlText(it?.profile?.workExperience)
                etEducation.htmlText(it?.profile?.education)
            }
        }

        profileViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }
}