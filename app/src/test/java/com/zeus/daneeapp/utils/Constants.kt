package com.zeus.daneeapp.utils

import com.zeus.daneeapp.domian.models.Character
import com.zeus.daneeapp.domian.models.Location

object Constants {

    val character = Character(
        id = "1",
        name = "Rick Sanchez",
        status = "Alive",
        species = "Humna",
        gender = "Male",
        image = "asdfasdf",
        created = "00000",
        episode = "1",
        location = Location(),
        origin = Location(),
        isFavorite = false
    )

    val favoriteCharacter = Character(
        id = "1",
        name = "Rick Sanchez",
        status = "Alive",
        species = "Humna",
        gender = "Male",
        image = "asdfasdf",
        created = "00000",
        episode = "1",
        location = Location(),
        origin = Location(),
        isFavorite = true
    )
}