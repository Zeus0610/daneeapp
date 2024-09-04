package com.zeus.daneeapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.zeus.daneeapp.ui.viewModel.DetailsViewModel

@Composable
fun DetailsScreen(
    characterId: String,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        viewModel.getCharacterById(characterId)
    }

    Text(text = state.character.name)
}
