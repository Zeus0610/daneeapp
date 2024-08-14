package com.zeus.daneeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zeus.daneeapp.ui.screens.HomeScreen
import com.zeus.daneeapp.ui.theme.DaneeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val personList = listOf(
            "Zeus",
            "Vale",
            "Danee"
        )

        //enableEdgeToEdge()
        setContent {
            DaneeAppTheme {
                HomeScreen(personList = personList)
            }
        }
    }
}