package com.example.codingproject.data.repository

import com.example.codingproject.data.model.CatsResponseItem

interface CatsRepository {

    suspend fun getCats(): List<CatsResponseItem>
}