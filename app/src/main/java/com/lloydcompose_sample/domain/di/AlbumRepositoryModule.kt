package com.lloydcompose_sample.domain.di

import com.lloydcompose_sample.data.repository.AlbumRepository
import com.lloydcompose_sample.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object AlbumRepositoryModule {

    @Provides
    fun provideAlbumRepository(apiService: ApiService): AlbumRepository =
        AlbumRepository(apiService)
}