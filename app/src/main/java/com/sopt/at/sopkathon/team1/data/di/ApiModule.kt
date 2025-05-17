package com.sopt.at.sopkathon.team1.data.di

import com.sopt.at.sopkathon.team1.data.service.Team1Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providesUberService(retrofit: Retrofit): Team1Service =
        retrofit.create(Team1Service::class.java)

}