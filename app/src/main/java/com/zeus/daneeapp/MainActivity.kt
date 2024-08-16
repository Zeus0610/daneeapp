package com.zeus.daneeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.zeus.daneeapp.ui.screens.DeberSerScreen
import com.zeus.daneeapp.ui.screens.HomeScreen
import com.zeus.daneeapp.ui.theme.DaneeAppTheme
import com.zeus.daneeapp.ui.viewModel.DeberSerViewModel

class MainActivity : ComponentActivity() {

    val deberSerViewModel: DeberSerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //enableEdgeToEdge()
        setContent {
            DaneeAppTheme {
                DeberSerScreen(viewModel = deberSerViewModel)
                //HomeScreen()
            }
        }
    }
}