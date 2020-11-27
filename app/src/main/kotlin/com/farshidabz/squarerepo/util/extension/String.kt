package com.farshidabz.squarerepo.util.extension

import java.util.*

/**
 * Extension function to check is string is not empty, null or even "null"
 * */
fun String?.isNotNullOrEmpty(): Boolean {
    if (this.isNullOrEmpty()) return false
    if (this.toLowerCase(Locale.getDefault()) == "null") return false

    return true
}