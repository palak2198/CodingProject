package com.example.codingproject.view.cat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingproject.data.model.CatsResponseItem
import com.example.codingproject.domain.ResultWrapper
import com.example.codingproject.domain.usecase.GetCatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(private val getCatsUseCase: GetCatsUseCase): ViewModel() {

    val catResponseLiveData = MutableLiveData<List<CatsResponseItem>?>()
    val errorLiveData = MutableLiveData<Exception>()

    fun getCats() {
        viewModelScope.launch {
            getCatsUseCase.getCats().collect {
                when(it) {
                    is ResultWrapper.Success -> {
                        catResponseLiveData.value = it.data
                    }
                    is ResultWrapper.Error -> {
                        errorLiveData.value = it.exception
                    }
                }
            }
        }
    }
}