package com.zeus.daneeapp.di

import android.content.Context
import com.zeus.daneeapp.data.api.RestClient
import com.zeus.daneeapp.data.api.RickAndMortyServices
import com.zeus.daneeapp.data.repository.CharactersRepositoryImpl
import com.zeus.daneeapp.domian.repository.CharactersRepository
import com.zeus.roomdb.DaneeDB
import com.zeus.roomdb.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaneeModule {


    @Provides
    fun provideRickAndMortyServices(): RickAndMortyServices {
        return RestClient.create("https://rickandmortyapi.com/api/")
    }

    @Provides
    fun provideCharacterRepository(services: RickAndMortyServices, characterDao: CharacterDao): CharactersRepository {
        return CharactersRepositoryImpl(services, characterDao)
    }

    @Provides
    fun provideCharacterDao(@ApplicationContext context: Context): CharacterDao {
        return DaneeDB.getInstance(context).characterDao()
    }
}