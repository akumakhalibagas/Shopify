package com.makhalibagas.core.utils

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputEditText.getString() = this.text.toString().trim()

fun AppCompatEditText.getString() = this.text.toString()

fun TextInputLayout.isErrorEnabled(state: Boolean) {
    this.isErrorEnabled = state
}

fun AppCompatButton.isEnabled(state: Boolean) {
    this.isEnabled = state
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isVisible(state: Boolean, isGone: Boolean = false) {
    if (state) this.visible() else if (isGone) this.gone() else this.hide()
}