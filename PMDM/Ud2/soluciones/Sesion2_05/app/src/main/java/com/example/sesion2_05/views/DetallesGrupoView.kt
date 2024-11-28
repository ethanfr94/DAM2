package com.example.sesion2_05.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.example.sesion2_05.components.MainIconButton
import com.example.sesion2_05.components.SpaceV
import com.example.sesion2_05.components.TitleBar
import com.example.sesion2_05.components.TitleView
import com.example.sesion2_05.models.Grupo
import com.example.sesion2_05.models.grupos

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetallesGuupoView(navController: NavController, id:Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(texto = "TOP BAR DETAIL") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetallesGrupoView(navController,id)
    }
}

@Composable
fun ContentDetallesGrupoView(navController: NavController,id: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Detalles del Grupo")
        SpaceV(16.dp)
        grupo=grupos.find { it.id==id }
        TitleView(grupo.nombre)
        TitleView(grupo.estilo)
    }
}


