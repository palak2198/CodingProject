package com.example.codingproject.domain.usecase

import com.example.codingproject.data.repository.ProfileRepository
import com.example.codingproject.domain.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) {

    suspend fun getProfile() = flow {
        try{
            val result = profileRepository.getProfile()
            emit(ResultWrapper.Success(result))
        }
        catch(e: Exception){
            emit(ResultWrapper.Error(e))
        }
    }.flowOn(Dispatchers.IO)

}