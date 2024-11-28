package com.example.sesion2_03_varias.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavType
import com.example.sesion2_03_varias.components.MainButton
import com.example.sesion2_03_varias.components.MainIconButton
import com.example.sesion2_03_varias.components.SpaceV
import com.example.sesion2_03_varias.components.TitleBar
import com.example.sesion2_03_varias.components.TitleView
import com.example.sesion2_03_varias.models.Usuario

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, num:Int,nameUsuario:String) {
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
        ContentDetailView(navController,num,nameUsuario)
    }
}

@Composable
fun ContentDetailView(navController: NavController, num: Int,nameUsuario: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Detail View")
        SpaceV(20.dp)
        TitleView(name = num.toString())
        TitleView(name = nameUsuario)

//        MainButton(name = "Return home") {
//            navController.popBackStack()  //Volver atrás
//        }
    }
}


