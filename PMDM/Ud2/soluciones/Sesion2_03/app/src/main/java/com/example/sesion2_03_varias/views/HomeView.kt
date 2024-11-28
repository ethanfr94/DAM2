package com.example.sesion2_03_varias.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.collection.emptyLongSet
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sesion2_03_varias.components.ActionButton
import com.example.sesion2_03_varias.components.MainButton
import com.example.sesion2_03_varias.components.SpaceV
import com.example.sesion2_03_varias.components.TitleBar
import com.example.sesion2_03_varias.components.TitleView
import com.example.sesion2_03_varias.models.Usuario

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController:NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
               title={ TitleBar(texto = "TOP BAR")},
                colors=TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor =  MaterialTheme.colorScheme.primary))
          },
        floatingActionButton = {
            ActionButton()
        }
    ){ //inicialmente da un error porque necesita parametros de padding
    ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController) {
    val n=123
    val usuario="Ana Alonso"
    //val mens:String?="hola"
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TitleView(name="Home View")
        SpaceV(20.dp)

        MainButton(name = "To Detail",
            onClick = {
                navController.navigate("Detail/${n}/${usuario}")
            })
    }
}