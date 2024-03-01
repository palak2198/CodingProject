package com.example.codingproject.data.repository

import com.example.codingproject.data.model.Profile

interface ProfileRepository {

    suspend fun getProfile(): Profile
}