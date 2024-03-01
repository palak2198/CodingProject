package com.example.codingproject.view.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingproject.data.model.Profile
import com.example.codingproject.domain.ResultWrapper
import com.example.codingproject.domain.usecase.ProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileUseCase: ProfileUseCase): ViewModel() {

    val profileResponseLiveData = MutableLiveData<Profile?>()
    val errorLiveData = MutableLiveData<Exception>()

    fun getProfile() {
        viewModelScope.launch {
            profileUseCase.getProfile().collect {
                when(it) {
                    is ResultWrapper.Success -> {
                        profileResponseLiveData.value = it.data
                    }
                    is ResultWrapper.Error -> {
                        errorLiveData.value = it.exception
                    }
                }
            }
        }
    }
}