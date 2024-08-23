package com.zeus.daneeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.zeus.daneeapp.ui.components.DaneeTopBar
import com.zeus.daneeapp.ui.theme.DaneeAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DaneeAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        DaneeTopBar(
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                ) { paddings ->
                    MainNavHost(
                        modifier = Modifier.padding(paddings),
                        navController = navController
                    )
                }
            }
        }
    }
}



interface Impresora {
    fun imprimir(mensaje: String)
    fun limpiarCabezales()
}

interface Escaner {
    fun escanear(): String
}

class ImpresoraDeZeus: Impresora {
    override fun imprimir(mensaje: String) {
        println(mensaje)
    }

    override fun limpiarCabezales() {
        TODO("Not yet implemented")
    }

}

class MultifuncionalDeDanee: Impresora, Escaner {
    override fun imprimir(mensaje: String) {
        println("$mensaje by Danee")
    }

    override fun limpiarCabezales() {
        TODO("Not yet implemented")
    }

    override fun escanear(): String {
        return "Escaneado"
    }
}

data class Ejemplo(val nombreCompleto: String)

fun getName(): String = "Zeus"
fun getApellido(): String = "Orea"

fun getNombreCompleto(): String {
    return getName() + " " + getApellido()
}

fun main() {
    val ejemplo1 = Ejemplo(getName())
    val ejemplo2 = Ejemplo(getName())

    val ekemplo3 = Ejemplo(getNombreCompleto())
}