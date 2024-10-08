package com.zeus.daneeapp.domian.mappers

import com.zeus.daneeapp.data.models.CharacterDTO
import com.zeus.daneeapp.data.models.LocationDTO
import com.zeus.daneeapp.domian.models.Character
import com.zeus.daneeapp.domian.models.Location

fun CharacterDTO.toCharacterDomain(): Character {
    return Character(
        id = this.id?: "",
        name = this.name?: "",
        status = this.status?: "",
        species = this.species?: "",
        gender = this.gender?: "",
        image = this.image?: "",
        created = this.created?: "",
        origin = this.origin?.toLocationDomain()?: Location(),
        location = this.location?.toLocationDomain()?: Location(),
        isFavorite = this.isFavorite
    )
}

fun LocationDTO.toLocationDomain(): Location {
    return Location(
        name = this.name?: "",
        url = this.url?: ""
    )
}

fun Location.toLocationDTO(): LocationDTO {
    return LocationDTO(
        name = this.name,
        url = this.url
    )
}

fun Character.toCharacterDTO(): CharacterDTO {
    return CharacterDTO(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        gender = this.gender,
        image = this.image,
        created = this.created,
        origin = this.origin.toLocationDTO(),
        location = this.location.toLocationDTO()
    )
}
