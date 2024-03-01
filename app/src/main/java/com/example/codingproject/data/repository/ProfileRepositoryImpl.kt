package com.example.codingproject.data.repository

import android.content.res.AssetManager
import com.example.codingproject.core.readAssetsFile
import com.example.codingproject.data.model.Profile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val assetManager: AssetManager,
    private val gson: Gson
): ProfileRepository {
    override suspend fun getProfile(): Profile {
        val jsonString = assetManager.readAssetsFile("profile.json")
        return gson.fromJson(jsonString, object : TypeToken<Profile>() {}.type)
    }
}