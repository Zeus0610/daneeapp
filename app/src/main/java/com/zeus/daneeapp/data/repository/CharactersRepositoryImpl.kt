package com.zeus.daneeapp.data.repository

import com.zeus.daneeapp.data.api.RickAndMortyServices
import com.zeus.daneeapp.data.mappers.toCharacterDTO
import com.zeus.daneeapp.data.mappers.toCharacterEntity
import com.zeus.daneeapp.data.models.CharacterDTO
import com.zeus.daneeapp.domian.repository.CharactersRepository
import com.zeus.roomdb.dao.CharacterDao
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val retrofitClient: RickAndMortyServices,
    private val characterDao: CharacterDao
): CharactersRepository {


    override suspend fun getCharacters(): List<CharacterDTO> {
        val response = retrofitClient.getCharacters()
        return response.results?: emptyList()
    }

    override suspend fun getCharacterById(id: String): CharacterDTO? {
        val characterLocal = characterDao.getCharacterById(id)
        return characterLocal?.toCharacterDTO() ?: retrofitClient.getCharacterById(id)
    }

    override suspend fun addCharacterToFavorites(character: CharacterDTO) {
        characterDao.addCharacterToFavorites(character.toCharacterEntity())
    }
}