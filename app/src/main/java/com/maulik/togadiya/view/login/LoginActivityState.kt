package com.maulik.togadiya.view.login

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import com.maulik.togadiya.base.BaseState
import com.maulik.togadiya.extension.initWith

class LoginActivityState :BaseState{
    var email = MutableLiveData<String>().initWith("")
    var password = MutableLiveData<String>().initWith("")
    val validationLiveData = MutableLiveData<ErrorMessage>()
    val clickEvent = MutableLiveData<ClickEvent>()
    data class ErrorMessage(@StringRes val invalidEmail: Int = 0, @StringRes val emptyEmail: Int = 0, @StringRes val emptyPassword: Int = 0,@StringRes val invalidUser: Int = 0, @StringRes val isValid: Int = 0)
}

sealed class ClickEvent(){
    object loginButton : ClickEvent()
}