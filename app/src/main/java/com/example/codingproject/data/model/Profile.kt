package com.example.codingproject.data.model

import com.google.gson.annotations.SerializedName

data class Profile(

	@field:SerializedName("profile")
	val profile: Profile? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("education")
	val education: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("work_experience")
	val workExperience: String? = null
)
