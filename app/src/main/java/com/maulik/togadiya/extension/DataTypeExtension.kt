package com.maulik.togadiya.extension

import android.util.Patterns

/**
 * Extension function Valid Email Address
 * */

fun String.isEmailAddressValidPattern(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}