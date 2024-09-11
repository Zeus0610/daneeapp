package com.zeus.daneeapp.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

    Row {
        Text(text = state.character.name)
        IconButton(
            onClick = viewModel::addToFavorites
        ) {
            Icon(
                imageVector = if (state.character.isFavorite) {
                    Icons.Default.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                },
                contentDescription = "Favorito"
            )
        }
    }
}
