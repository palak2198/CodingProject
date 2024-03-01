package com.example.codingproject.view.cat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.codingproject.data.model.CatsResponseItem
import com.example.codingproject.databinding.FragmentCatBinding
import com.example.codingproject.view.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CatFragment : BaseFragment<FragmentCatBinding>() {

    @Inject
    lateinit var catAdapter: CatAdapter

    override val bindingInflater: (LayoutInflater) -> FragmentCatBinding
        get() = FragmentCatBinding::inflate

    private val catViewModel: CatViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catViewModel.getCats()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        catViewModel.catResponseLiveData.observe(viewLifecycleOwner) { response ->
            response?.let {
                setAdapter(it)
            }
        }

        catViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAdapter(catList: List<CatsResponseItem>) {
        catAdapter.addAll(catList)
        catAdapter.itemClickListener = object : CatAdapter.ItemClickListener {
            override fun onItemClick(catsResponseItem: CatsResponseItem) {
                val action = CatFragmentDirections.actionCatFragmentToCatDetailsFragment(
                    extraCatDetails = catsResponseItem
                )
                findNavController().navigate(action)
            }

        }
        binding.rvCats.adapter = catAdapter

    }
}