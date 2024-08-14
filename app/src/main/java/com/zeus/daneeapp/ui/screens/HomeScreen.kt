package com.zeus.daneeapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zeus.daneeapp.ui.components.PersonItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    personList: List<String> = listOf()
) {
    Column {
        LazyColumn {
            stickyHeader {
                Text(text = "Lista de personas")
            }

            items(personList) { person ->
                PersonItem(
                    modifier = Modifier.fillMaxWidth(),
                    name = person
                )
            }
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    HomeScreen(
        personList = listOf("Zeus", "Vale", "Danee")
    )
}