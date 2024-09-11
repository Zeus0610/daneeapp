package com.zeus.daneeapp.domian.models

data class Character(
    val id: String = "",
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val gender: String = "",
    val image: String = "",
    val created: String = "",
    val episode: String = "",
    val location: Location = Location(),
    val origin: Location = Location(),
    val isFavorite: Boolean = false
)
