package com.zeus.daneeapp.domian.mappers

import com.zeus.daneeapp.data.models.CharacterDTO
import com.zeus.daneeapp.domian.models.Character

fun CharacterDTO.toCharacterDomain(): Character {
    return Character(
        id = this.id?: "",
        name = this.name?: ""
    )
}

/*
fun Character.toCharacterDTO(): CharacterDTO {
    return CharacterDTO(
        id = this.id,
        name = this.name
    )
}*/
