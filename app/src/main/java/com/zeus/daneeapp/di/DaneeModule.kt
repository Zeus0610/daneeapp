package com.zeus.daneeapp.di

import com.zeus.daneeapp.data.api.RestClient
import com.zeus.daneeapp.data.api.RickAndMortyServices
import com.zeus.daneeapp.data.repository.CharactersRepositoryImpl
import com.zeus.daneeapp.domian.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaneeModule {


    @Provides
    fun provideRickAndMortyServices(): RickAndMortyServices {
        return RestClient.create("https://rickandmortyapi.com/api/")
    }

    @Provides
    fun provideCharacterRepository(services: RickAndMortyServices): CharactersRepository {
        return CharactersRepositoryImpl(services)
    }
}