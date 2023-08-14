package com.lloydcompose_sample.presentation.album

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lloydcompose_sample.data.network.response.AlbumResponse
import com.lloydcompose_sample.data.repository.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(repository: AlbumRepository) : ViewModel() {

    val albumList = mutableStateListOf<AlbumResponse>()

    init {
        repository.getAlbums().onEach { dataState ->
            dataState.data?.let { response ->
                Log.d("Lloyd Dcosta", "Data is here baby")
                delay(1000)
                albumList.addAll(response.toMutableList())
            }
            dataState.error?.message?.let { error -> Log.e("Error", error) }
        }.launchIn(viewModelScope)

    }
}