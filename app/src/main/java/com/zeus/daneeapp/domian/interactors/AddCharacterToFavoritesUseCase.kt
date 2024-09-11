package com.zeus.daneeapp.domian.interactors

import com.zeus.daneeapp.domian.mappers.toCharacterDTO
import com.zeus.daneeapp.domian.models.Character
import com.zeus.daneeapp.domian.repository.CharactersRepository
import javax.inject.Inject

class AddCharacterToFavoritesUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    suspend operator fun invoke(character: Character) {
        charactersRepository.addCharacterToFavorites(character.toCharacterDTO())
    }
}