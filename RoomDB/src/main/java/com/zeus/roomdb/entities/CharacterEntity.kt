package com.zeus.roomdb.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val created: String,
    @Embedded(prefix = "origin_")
    val origin: LocationEntity?,
    @Embedded(prefix = "location_")
    val location: LocationEntity?
)
