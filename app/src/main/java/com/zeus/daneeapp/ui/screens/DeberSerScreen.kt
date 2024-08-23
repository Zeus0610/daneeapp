package com.zeus.daneeapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zeus.daneeapp.ui.components.ExtendedButton
import com.zeus.daneeapp.ui.components.PersonItem
import com.zeus.daneeapp.ui.viewModel.DeberSerViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DeberSerScreen(
    modifier: Modifier = Modifier,
    viewModel: DeberSerViewModel = viewModel()
) {
    val state = viewModel.state.value

    Column {
        LazyColumn {
            stickyHeader {
                Text(text = "Lista de personas")
            }

            items(state.personList) { person ->
                PersonItem(
                    modifier = Modifier.fillMaxWidth(),
                    name = person
                )
            }
        }
        ExtendedButton(
            onTextChange = viewModel::addPerson
        )
    }
}