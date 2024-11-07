package com.izanfranco.sesion2_03.Views

import android.annotation.SuppressLint
import android.text.Layout.Alignment
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.izanfranco.sesion2_03.Components.EspacioVertical
import com.izanfranco.sesion2_03.Components.MainButton
import com.izanfranco.sesion2_03.Components.TitleBar
import com.izanfranco.sesion2_03.Components.TitleView


import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


    @Composable
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    fun HomeView(navController: NavController) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {TitleBar(texto = "TOP BAR") },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.onPrimaryContainer))
            },
            //floatingActionButton = { ActionButton() }
        ){
            ContentHomeView(navController)
        }
    }



    @Composable
    fun ContentHomeView(navController: NavController) {
        val num = 123
        val user = "Izan"
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ){
            TitleView(name = "Home")
            EspacioVertical(20.dp)
            MainButton(name = "To Detail", onClick = { navController.navigate("DetailsView/${num}/${user}")
            })
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
