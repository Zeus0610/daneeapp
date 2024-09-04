package com.zeus.daneeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zeus.daneeapp.ui.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToList: () -> Unit = {},
    onNavigateToDetails: (String) -> Unit = {}
) {
   Column {
       Button(
           onClick = onNavigateToList
       ) {
           Text(text = "Navigate to List")
       }
       Button(
           onClick = {
               onNavigateToDetails.invoke("Hola Mundo")
           }
       ) {
           Text(text = "Send data")
       }
   }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}