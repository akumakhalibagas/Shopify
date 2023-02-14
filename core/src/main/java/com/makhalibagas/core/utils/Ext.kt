package com.makhalibagas.core.utils

import java.text.NumberFormat
import java.util.*

fun String.toRupiahFormat(): String {
    val localeID = Locale("in", "ID")
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)
    return numberFormat.format(this.toDouble())
}