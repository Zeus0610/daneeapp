package com.zeus.daneeapp.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeus.daneeapp.domian.interactors.GetCharacterByIdUseCase
import com.zeus.daneeapp.ui.states.DetailsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
): ViewModel() {

    private val _state: MutableState<DetailsScreenState> = mutableStateOf(DetailsScreenState())
    val state: State<DetailsScreenState> = _state

    fun getCharacterById(id: String) = viewModelScope.launch {
        getCharacterByIdUseCase.invoke(id).collect { character ->
            character?.let {
                _state.value = _state.value.copy(
                    character = it
                )
            }
        }
    }
}