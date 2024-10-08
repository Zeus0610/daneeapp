package com.zeus.daneeapp.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeus.daneeapp.domian.interactors.GetCharactersUseCase
import com.zeus.daneeapp.ui.states.ListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _state = mutableStateOf(ListScreenState())
    val state: State<ListScreenState> = _state

    fun getCharacters() = viewModelScope.launch {
        getCharactersUseCase.invoke().collect { characters ->
            _state.value = _state.value.copy(
                characters = characters
            )
        }
    }
}