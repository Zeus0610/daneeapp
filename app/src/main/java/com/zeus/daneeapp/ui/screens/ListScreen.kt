package com.zeus.daneeapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zeus.daneeapp.ui.components.PersonItem
import com.zeus.daneeapp.ui.viewModel.ListScreenViewModel

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    viewModel: ListScreenViewModel = hiltViewModel(),
    onNavigateToDetails: (String) -> Unit = {}
) {
    val state = viewModel.state.value

    LaunchedEffect(key1 = Unit) {
        viewModel.getCharacters()
    }

    Column (modifier = Modifier
        .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){

        Text(
            text = "Lista de personajes",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            )

        LazyColumn {

            items(state.characters) { character ->
                PersonItem(
                    modifier = Modifier.fillMaxWidth()
                        .clickable {
                            onNavigateToDetails.invoke(character.id)
                        },
                    name = character.name,
                    status = character.status,
                    species = character.species,
                    gender = character.gender,
                    image = character.image,
                    created = character.created,
                    location = character.location
                )
            }
        }
    }
}