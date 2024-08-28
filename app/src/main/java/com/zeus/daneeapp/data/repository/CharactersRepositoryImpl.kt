package com.zeus.daneeapp.data.repository

import com.zeus.daneeapp.data.api.RickAndMortyServices
import com.zeus.daneeapp.data.models.CharacterDTO
import com.zeus.daneeapp.domian.repository.CharactersRepository

class CharactersRepositoryImpl(
    private val retrofitClient: RickAndMortyServices
): CharactersRepository {


    override suspend fun getCharacters(): List<CharacterDTO> {
        val response = retrofitClient.getCharacters()
        return response.results?: emptyList()
    }
}