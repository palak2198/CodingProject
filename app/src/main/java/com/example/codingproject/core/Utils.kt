package com.example.codingproject.core

import android.content.Context
import android.text.TextUtils
import com.example.codingproject.domain.model.Profile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.regex.Pattern

fun readJsonFromAssets(context: Context, fileName: String): String {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}

fun parseJsonToModel(jsonString: String): Profile {
    val gson = Gson()
    return gson.fromJson(jsonString, object : TypeToken<Profile>() {}.type)
}

fun validateHtml(text: String?): Boolean {
    val htmlTagPattern: String? = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>"
    val htmlValidator =
        if (TextUtils.isEmpty(htmlTagPattern)) null else Pattern.compile(htmlTagPattern)
    return htmlValidator?.matcher(text)?.find() ?: false
}