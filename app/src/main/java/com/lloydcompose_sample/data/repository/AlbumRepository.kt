package com.lloydcompose_sample.data.repository

import com.lloydcompose_sample.data.service.ApiService
import com.lloydcompose_sample.domain.DataState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AlbumRepository @Inject constructor(private val service: ApiService) {

    fun getAlbums() = flow {
        emit(DataState.success(service.getAlbums()))
    }.catch { emit(DataState.error(it)) }
}