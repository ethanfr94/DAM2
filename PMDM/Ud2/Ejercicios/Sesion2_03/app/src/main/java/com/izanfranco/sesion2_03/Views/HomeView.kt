package com.izanfranco.sesion2_03.Views

import android.annotation.SuppressLint
import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.izanfranco.sesion2_03.Components.TitleBar


import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


    @Composable
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    fun HomeView() {
        Scaffold(
            topBar = {
                // centramos el texto del top bar
                CenterAlignedTopAppBar(
                    // en la siguiente línea le pasamos el texto del top bar directamente
                    //title = { Text(text = "TOP BAR", fontSize = 25.sp, color = MaterialTheme.colorScheme.primaryContainer) },

                    // le pasamos el texto del top bar a un componente que hemos creado en otro archivo
                    title = { TitleBar("TOP BAR") },
                    // le damos un color de fondo al top bar y al texto del top bar le damos un color de la paleta de colores
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
                )
            }
        ){
            ContentHomeView()
        }
    }

    @Composable
    fun ContentHomeView() {
        Column(){
            Text(text = "Zona de ContentHOmeView",
                fontSize = 20.sp)
        }
    }
    /*
    @Composable
    public fun Scaffold(
        modifier: Modifier = Modifier,
        topBar: @Composable () -> Unit = {},
        bottomBar: @Composable () -> Unit = {},
        snacbarHost: @Composable () -> Unit = {},
        floatingActionButton: @Composable () -> Unit = {},
        floatingActionButtonPosition: FabPosition = FabPosition.End,
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = contentColorFor(containerColor),
        contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
        content: @Composable (PaddingValues) -> Unit
    ): Unit {
    }*/