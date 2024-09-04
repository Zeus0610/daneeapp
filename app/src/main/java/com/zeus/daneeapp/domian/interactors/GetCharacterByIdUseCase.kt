package com.zeus.daneeapp.domian.interactors

import com.zeus.daneeapp.domian.mappers.toCharacterDomain
import com.zeus.daneeapp.domian.models.Character
import com.zeus.daneeapp.domian.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor (
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(id: String): Flow<Character?> {
        return flow {
            val response = charactersRepository.getCharacterById(id)
            emit(response?.toCharacterDomain())
        }
    }
}