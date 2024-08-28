package com.zeus.daneeapp.domian.interactors

import com.zeus.daneeapp.domian.mappers.toCharacterDomain
import com.zeus.daneeapp.domian.models.Character
import com.zeus.daneeapp.domian.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    suspend operator fun invoke(): Flow<List<Character>> {
        return flow {
            val response = charactersRepository.getCharacters()

            emit(response.map { it.toCharacterDomain() })
        }
    }
}