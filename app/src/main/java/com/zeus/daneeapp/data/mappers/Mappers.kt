package com.zeus.daneeapp.data.mappers

import com.zeus.daneeapp.data.models.CharacterDTO
import com.zeus.daneeapp.data.models.LocationDTO
import com.zeus.roomdb.entities.CharacterEntity
import com.zeus.roomdb.entities.LocationEntity

fun CharacterDTO.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id?: "",
        name = this.name?: "",
        status = this.status?: "",
        species = this.species?: "",
        gender = this.gender?: "",
        image = this.image?: "",
        created = this.created?: "",
        origin = this.origin?.toLocationEntity(),
        location = this.location?.toLocationEntity()
    )
}

fun LocationDTO.toLocationEntity(): LocationEntity {
    return LocationEntity(
        name = this.name?: "",
        url = this.url?: ""
    )
}

fun LocationEntity.toLocationDTO(): LocationDTO {
    return LocationDTO(
        name = this.name,
        url = this.url
    )
}

fun CharacterEntity.toCharacterDTO(): CharacterDTO {
    return CharacterDTO(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        gender = this.gender,
        image = this.image,
        created = this.created,
        origin = this.origin?.toLocationDTO(),
        location = this.location?.toLocationDTO(),
        isFavorite = true
    )
}

