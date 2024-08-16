package com.zeus.daneeapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ExtendedButton(
    onTextChange: (String) -> Unit = {}
) {
    val text = remember { mutableStateOf("") }
    Column {
        TextField(
            value = text.value,
            onValueChange = { textFieldValue ->
                text.value = textFieldValue
            }
        )
        Button(
            onClick = {
                onTextChange.invoke(text.value)
                text.value = ""
            }
        ) {
            Text(text = "Add person")
        }
    }
}