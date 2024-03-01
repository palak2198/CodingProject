package com.example.codingproject.data.repository

import com.example.codingproject.data.api.ApiService
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(private val apiService: ApiService) : CatsRepository {

    override suspend fun getCats() =  apiService.getCats()

}