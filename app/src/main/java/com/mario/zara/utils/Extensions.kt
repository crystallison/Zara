package com.mario.zara.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.toFullMonthDate(): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)
    val date = LocalDate.parse(this, inputFormatter)
    return outputFormatter.format(date)
}
