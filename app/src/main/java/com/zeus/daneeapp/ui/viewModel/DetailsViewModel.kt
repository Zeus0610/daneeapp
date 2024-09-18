package com.zeus.daneeapp.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeus.daneeapp.domian.interactors.AddCharacterToFavoritesUseCase
import com.zeus.daneeapp.domian.interactors.GetCharacterByIdUseCase
import com.zeus.daneeapp.ui.states.DetailsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val addCharacterToFavoritesUseCase: AddCharacterToFavoritesUseCase
): ViewModel() {

    private val _state: MutableState<DetailsScreenState> = mutableStateOf(DetailsScreenState())
    val state: State<DetailsScreenState> = _state

    fun getCharacterById(id: String) = viewModelScope.launch {
        getCharacterByIdUseCase.invoke(id)
            .catch {
                _state.value = _state.value.copy(
                    hasError = true
                )
            }
            .collect { character ->
            character?.let {
                _state.value = _state.value.copy(
                    character = it
                )
            }
        }
    }

    fun addToFavorites() = viewModelScope.launch {
        addCharacterToFavoritesUseCase.invoke(_state.value.character)
    }
}