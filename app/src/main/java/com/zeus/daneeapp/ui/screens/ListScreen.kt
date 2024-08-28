package com.zeus.daneeapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zeus.daneeapp.DaneeApp
import com.zeus.daneeapp.ui.components.PersonItem
import com.zeus.daneeapp.ui.viewModel.ListScreenViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    viewModel: ListScreenViewModel = viewModel {
        val application = this[APPLICATION_KEY]
        (application as DaneeApp).getListScreenViewModel()
    }
) {
    val state = viewModel.state.value

    LaunchedEffect(key1 = Unit) {
        viewModel.getCharacters()
    }

    Column {
        LazyColumn {
            stickyHeader {
                Text(text = "Lista de personajes")
            }

            items(state.characters) { character ->
                PersonItem(
                    modifier = Modifier.fillMaxWidth(),
                    name = character.name
                )
            }
        }
    }
}