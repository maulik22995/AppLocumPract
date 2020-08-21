package com.maulik.togadiya.view.home

import androidx.lifecycle.MutableLiveData
import com.maulik.togadiya.base.BaseState
import com.maulik.togadiya.extension.initWith
import com.maulik.togadiya.model.AlbumData

class HomeActivityState : BaseState {
    val isLoading = MutableLiveData<Boolean>().initWith(false)
    val data = MutableLiveData<ArrayList<AlbumData>>()
    val albumAPIState = MutableLiveData<AlbumResponse>()

    /**
     * Comments API State
     */
    sealed class AlbumResponse {
        object Loading : AlbumResponse()
        data class Success(val data: ArrayList<AlbumData>) : AlbumResponse()
        data class Failure(val throwable: Throwable) : AlbumResponse()
    }

    sealed class ClickEvent() {
        object articalImageClicked : ClickEvent()
        object articalDescClicked : ClickEvent()
    }
}