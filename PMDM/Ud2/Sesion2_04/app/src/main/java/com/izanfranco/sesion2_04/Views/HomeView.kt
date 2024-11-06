package com.izanfranco.sesion2_03.Views

import android.annotation.SuppressLint
import android.text.Layout.Alignment
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izanfranco.sesion2_03.Components.EspacioVertical
import com.izanfranco.sesion2_03.Components.MainButton
import com.izanfranco.sesion2_03.Components.TitleBar
import com.izanfranco.sesion2_03.Components.TitleView


import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


    @Composable
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    fun HomeView() {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {TitleBar(texto = "TOP BAR") },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.onPrimaryContainer))
            },
            floatingActionButton = { ActionButton() }
        ){
            ContentHomeView()
            TitleView(name = "Home View")
            EspacioVertical(20.dp)
            MainButton(name = "To Detail", onClick = { Log.d("Prueba", "Boton presionado Detail")
            })
        }
    }

    @Composable
    fun ContentHomeView() {
        Column(){
            Text(text = "Zona de ContentHOmeView",
                fontSize = 20.sp)
        }
    }

    @Composable
    fun ActionButton() {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.primary
        ){
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Agregar"
            )
        }
    }
