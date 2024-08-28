package com.zeus.daneeapp.ui.states

import com.zeus.daneeapp.domian.models.Character

data class ListScreenState(
    val characters: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
