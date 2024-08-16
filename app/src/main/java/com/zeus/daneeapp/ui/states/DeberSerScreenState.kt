package com.zeus.daneeapp.ui.states

data class DeberSerScreenState(
    val personList: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
