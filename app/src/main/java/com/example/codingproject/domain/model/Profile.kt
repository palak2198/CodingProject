package com.example.codingproject.domain.model

data class Profile(
    val profile: ProfileInformation
)

data class ProfileInformation(
    val image: String,
    val name: String,
    val work_experience: String,
    val education: String
)