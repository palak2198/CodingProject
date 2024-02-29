package com.example.codingproject.view.cat

import android.os.Bundle
import android.view.LayoutInflater
import com.example.codingproject.databinding.FragmentCatBinding
import com.example.codingproject.view.base.BaseFragment

class CatFragment : BaseFragment<FragmentCatBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentCatBinding
        get() = FragmentCatBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}