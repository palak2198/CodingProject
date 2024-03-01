package com.example.codingproject.data.api

import com.example.codingproject.data.model.CatsResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET("v1/breeds")
    suspend fun getCats(): List<CatsResponseItem>

}