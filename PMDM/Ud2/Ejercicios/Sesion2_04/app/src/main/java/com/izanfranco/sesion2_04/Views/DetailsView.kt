package com.izanfranco.sesion2_03.Views

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.izanfranco.sesion2_03.Components.EspacioVertical
import com.izanfranco.sesion2_03.Components.MainButton
import com.izanfranco.sesion2_03.Components.MainIconButton
import com.izanfranco.sesion2_03.Components.TitleBar
import com.izanfranco.sesion2_03.Components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun DetailsView(navController: NavController) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { TitleBar(texto = "TOP BAR DETAIL") },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    // este icono nos lleva a la pantalla anterior mediante el navController
                    // en este caso se utiliza un icono en lugar de un texto
                    // al pulsarlo ejecuta la funcion que se le pasa como parametro
                    navigationIcon = {
                        MainIconButton( icon = Icons.Filled.ArrowBack)
                        {
                            navController.popBackStack()
                        }
                    }
                )
            }
        ) {
            ContentDetailView(navController)
        }
    }

    @Composable
    fun ContentDetailView(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleView(name = "Detail")
            EspacioVertical(20.dp)
            // este boton nos lleva a la pantalla anterior mediante el navController
            MainButton(name = "Return Home")
            {
                // navController.popBackStack() nos lleva a la pantalla anterior
            navController.popBackStack()
            }
        }
    }

