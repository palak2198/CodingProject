package com.example.codingproject.core

import android.text.TextUtils
import java.util.regex.Pattern

fun validateHtml(text: String?): Boolean {
    val htmlTagPattern = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>"
    val htmlValidator =
        if (TextUtils.isEmpty(htmlTagPattern)) null else Pattern.compile(htmlTagPattern)
    return text?.let { htmlValidator?.matcher(it)?.find() } ?: false
}