package com.zeus.daneeapp

import android.app.Application
import com.zeus.daneeapp.data.api.RestClient
import com.zeus.daneeapp.data.api.RickAndMortyServices
import com.zeus.daneeapp.data.repository.CharactersRepositoryImpl
import com.zeus.daneeapp.domian.interactors.GetCharactersUseCase
import com.zeus.daneeapp.domian.repository.CharactersRepository
import com.zeus.daneeapp.ui.viewModel.ListScreenViewModel

class DaneeApp: Application() {

    private val retrofitClient = RestClient.create("https://rickandmortyapi.com/api/")

    fun getRetrofitClient(): RickAndMortyServices {
        return retrofitClient
    }

    fun getCharactersRepository(): CharactersRepository {
        return CharactersRepositoryImpl(getRetrofitClient())
    }

    fun getGetCharactersUseCase(): GetCharactersUseCase {
        return GetCharactersUseCase(getCharactersRepository())
    }

    fun getListScreenViewModel(): ListScreenViewModel {
        return ListScreenViewModel(getGetCharactersUseCase())
    }
}