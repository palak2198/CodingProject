package com.example.codingproject.core

import android.content.res.AssetManager
import android.text.Html
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.example.codingproject.R

fun AppCompatTextView.htmlText(text: String?) {
    this.text = if (!validateHtml(text)) {
        text
    } else {
        Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
    }
}

fun AppCompatImageView.loadImage(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_profile)
        .error(R.drawable.ic_profile)
        .into(this)
}

fun AssetManager.readAssetsFile(filename: String) = open(filename).bufferedReader().use { it.readText() }