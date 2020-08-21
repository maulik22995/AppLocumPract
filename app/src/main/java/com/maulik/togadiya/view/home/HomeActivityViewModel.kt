package com.maulik.togadiya.view.home

import androidx.lifecycle.viewModelScope
import com.maulik.togadiya.base.BaseState
import com.maulik.togadiya.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeActivityViewModel(private val state: HomeActivityState) : BaseViewModel() {


    override fun provideState(): BaseState = state

    init {
        getAlumbs()
    }

    fun getAlumbs() {
        viewModelScope.launch {
            state.albumAPIState.postValue(HomeActivityState.AlbumResponse.Loading)
            viewModelScope.launch {
                runCatching {
                    apiService.getPhotos()
                }.onSuccess {
                    state.albumAPIState.postValue(
                        HomeActivityState.AlbumResponse.Success(
                            it
                        )
                    )
                }.onFailure {
                    state.albumAPIState.postValue(
                        HomeActivityState.AlbumResponse.Failure(
                            it
                        )
                    )
                }
            }
        }
    }
}