package com.maulik.togadiya.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maulik.togadiya.api.ApiService
import kotlinx.coroutines.cancel
import org.koin.core.KoinComponent
import org.koin.core.context.GlobalContext
import org.koin.core.context.KoinContextHandler.get
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(),KoinComponent {

    abstract fun provideState() : BaseState

    protected val apiService: ApiService by inject()

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}