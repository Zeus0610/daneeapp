package com.zeus.daneeapp.domian.repository

import com.zeus.daneeapp.data.models.CharacterDTO

interface CharactersRepository {
    suspend fun getCharacters(): List<CharacterDTO>

    suspend fun getCharacterById(id:String): CharacterDTO?

    suspend fun addCharacterToFavorites(character: CharacterDTO)
}