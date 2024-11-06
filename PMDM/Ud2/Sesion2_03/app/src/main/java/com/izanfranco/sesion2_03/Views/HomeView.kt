package com.izanfranco.sesion2_03.Views

import android.annotation.SuppressLint
import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
                CenterAlignedTopAppBar(
                    title = {TitleBar(texto = "TOP BAR") },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.onPrimaryContainer))
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
