package com.zeus.daneeapp.ui.states

import com.zeus.daneeapp.domian.models.Character

data class DetailsScreenState(
    val hasError: Boolean = false,
    val character: Character = Character(),
)
