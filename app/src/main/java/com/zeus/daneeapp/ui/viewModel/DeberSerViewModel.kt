package com.zeus.daneeapp.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.zeus.daneeapp.ui.states.DeberSerScreenState

class DeberSerViewModel: ViewModel() {

    private val _state = mutableStateOf(DeberSerScreenState())
    val state: State<DeberSerScreenState> = _state

    fun addPerson(name: String) {
        _state.value = _state.value.copy(
            personList = _state.value.personList.plus(name)
        )
    }
}