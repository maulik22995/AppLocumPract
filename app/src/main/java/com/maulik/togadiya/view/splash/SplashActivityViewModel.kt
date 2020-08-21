package com.maulik.togadiya.view.splash

import androidx.lifecycle.viewModelScope
import com.maulik.togadiya.base.BaseState
import com.maulik.togadiya.base.BaseViewModel
import com.maulik.togadiya.preferances.DefaultPreference
import com.maulik.togadiya.utils.DELAY_TIME
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivityViewModel(
    val state: SplashActivityState,
    private val defaultPreference: DefaultPreference
) : BaseViewModel() {
    override fun provideState(): BaseState = state

    init {
        viewModelScope.launch {
            delay(DELAY_TIME)
            state.delayState.value = defaultPreference.data.isLoggedIn
        }
    }
}