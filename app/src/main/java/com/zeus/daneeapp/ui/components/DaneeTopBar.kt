package com.zeus.daneeapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaneeTopBar(
    navigateBack: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(text = "DaneeApp")
        },
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {
                    navigateBack.invoke()
                },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back"
            )
        }
    )
}