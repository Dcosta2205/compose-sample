package com.lloydcompose_sample.data.service

import com.lloydcompose_sample.data.network.response.AlbumResponse
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getAlbums(): List<AlbumResponse>
}