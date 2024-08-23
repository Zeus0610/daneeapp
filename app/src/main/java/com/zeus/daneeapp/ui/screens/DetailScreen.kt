package com.zeus.daneeapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zeus.daneeapp.ui.viewModel.DetailsViewModel

@Composable
fun DetailsScreen(
    message: String,
    viewModel: DetailsViewModel = viewModel()
) {
    Text(text = message)
}
