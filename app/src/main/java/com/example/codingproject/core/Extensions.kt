package com.example.codingproject.core

import android.os.Build
import android.text.Html
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

internal fun BottomNavigationView.checkItem(actionId: Int) {
    menu.findItem(actionId)?.isChecked = true
}

fun FragmentManager.getFragmentAtStackTop() : Fragment? {
    return this.fragments.firstOrNull()?.childFragmentManager?.fragments?.lastOrNull()
}

fun AppCompatTextView.htmlText(text: String?) {
    this.text = if (!validateHtml(text)) {
        text
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(text)
        }

    }

}