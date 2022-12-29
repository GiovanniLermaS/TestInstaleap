package com.example.testinstaleap.view.main

import com.example.testinstaleap.repository.main.IMainActivityRepository
import com.example.testinstaleap.repository.main.MainActivityRepository
import com.example.testinstaleap.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideAboutRepository(apiInterface: ApiInterface): IMainActivityRepository {
        return MainActivityRepository(apiInterface)
    }
}