package com.maulik.togadiya.extension

import androidx.lifecycle.MutableLiveData

/**
 * Extension Function for initializing [MutableLiveData] with some initial value
 * @param data is the initial value
 * */
fun <T> MutableLiveData<T>.initWith(data: T): MutableLiveData<T> = this.apply {
    value = data
}