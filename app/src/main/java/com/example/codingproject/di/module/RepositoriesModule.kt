package com.example.codingproject.di.module

import com.example.codingproject.data.repository.CatsRepository
import com.example.codingproject.data.repository.CatsRepositoryImpl
import com.example.codingproject.data.repository.ProfileRepository
import com.example.codingproject.data.repository.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    fun catsRepository(catsRepositoryImpl: CatsRepositoryImpl): CatsRepository

    @Binds
    fun profileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository
}