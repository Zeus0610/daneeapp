package com.zeus.daneeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DaneeApp: Application() {

    /*private val retrofitClient = RestClient.create("https://rickandmortyapi.com/api/")

    fun getRetrofitClient(): RickAndMortyServices {
        return retrofitClient
    }

    fun getCharactersRepository(): CharactersRepository {
        return CharactersRepositoryImpl(getRetrofitClient())
    }

    fun getGetCharactersUseCase(): GetCharactersUseCase {
        return GetCharactersUseCase(getCharactersRepository())
    }

    fun getCharacterByIdUseCase(): GetCharacterByIdUseCase {
        return GetCharacterByIdUseCase(getCharactersRepository())
    }

    fun getListScreenViewModel(): ListScreenViewModel {
        return ListScreenViewModel(getGetCharactersUseCase())
    }

    fun getDetailsViewModel(): DetailsViewModel {
        return DetailsViewModel(getCharacterByIdUseCase())
    }*/
}