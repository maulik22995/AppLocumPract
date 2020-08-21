package com.maulik.togadiya.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager

inline fun <reified T : Activity> Activity.navigateTo() =
        this.startActivity(Intent(this,T::class.java))

inline fun <reified T : Activity> Activity.navigateToAndFinish() =
    this.apply {
        startActivity(Intent(this,T::class.java))
        finish()
    }


/**
 * Extension function to hide keyboard
 **/
fun Activity.hideKeyBoard() {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
        currentFocus?.windowToken,
        0
    )
}