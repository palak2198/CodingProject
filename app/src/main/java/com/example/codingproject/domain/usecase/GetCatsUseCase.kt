package com.example.codingproject.domain.usecase

import com.example.codingproject.data.repository.CatsRepository
import com.example.codingproject.domain.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(private val catsRepository: CatsRepository) {

    suspend fun getCats() = flow {
        try{
            val result = catsRepository.getCats()
            emit(ResultWrapper.Success(result))
        }
        catch(e: Exception){
            emit(ResultWrapper.Error(e))
        }
    }.flowOn(Dispatchers.IO)

}