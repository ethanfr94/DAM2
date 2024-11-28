@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.sesion_10.views

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion_10.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun HomeView(){
    Scaffold(
        topBar = {TopMenuBar()}

        ,
        content={ ContentHomeView()}
    )
}



@Composable
fun TopMenuBar() {

    var showMenu by remember { mutableStateOf(false) }

    var context = LocalContext.current

    TopAppBar(
        title = { Text(text = "Sesión 10") },
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Abrir menú")
            }
        },
        actions = {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "Configurar")

            }

            IconButton(onClick = { showMenu = true }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")
            }


            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(text = { Text("Previsualizar") }, onClick = {
                    Log.d("PRUEBA", "Pulsado Previsualizar")
                    Toast.makeText(context, "Previsualizar", Toast.LENGTH_SHORT).show()
                    showMenu = false
                })
                DropdownMenuItem(text = { Text("Compartir") }, onClick = {
                    Log.d("PRUEBA", "Pulsado Compartir")
                    Toast.makeText(context, "Compartir", Toast.LENGTH_SHORT).show()
                    showMenu = false
                }, leadingIcon = {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir")


                })
                DropdownMenuItem(text = { Text("Copiar enlace") }, onClick = {
                    Log.d("PRUEBA", "Pulsado Copiar enlace")
                    Toast.makeText(context, "Copiar enlace", Toast.LENGTH_SHORT).show()
                    showMenu = false
                })
                DropdownMenuItem(text = { Text("Descargar") }, onClick = {
                    Log.d("PRUEBA", "Pulsado Descargar")
                    Toast.makeText(context, "Descargar", Toast.LENGTH_SHORT).show()
                    showMenu = false
                }, enabled = false)
                HorizontalDivider(thickness = 5.dp, color = Color.Red)
                DropdownMenuItem(text = { Text("Denunciar") }, onClick = {
                    Log.d("PRUEBA", "Pulsado Denunciar")
                    Toast.makeText(context, "Denunciar", Toast.LENGTH_SHORT).show()
                    showMenu = false
                })
            }
        }
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentHomeView(){

    var myText by remember { mutableStateOf("Hola") }
    var showMenu by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var inputText by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 75.dp)) {
        Text(
            text = "Contenido",
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),

        )
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = myText,
                fontSize = 50.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .combinedClickable(onClick = {}, onLongClick = { showMenu = true })
            )
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                modifier = Modifier.align(Alignment.Center)
            ) {
                DropdownMenuItem(
                    text = { Text("Borrar") },
                    onClick = {
                        showMenu = false
                        Log.d("MENU", "Opción Borrar seleccionada")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Duplicar") },
                    onClick = {
                        showMenu = false
                        Log.d("MENU", "Opción Duplicar seleccionada")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Editar") },
                    onClick = {
                        showDialog = true
                        showMenu = false
                        Log.d("MENU", "Opción Editar seleccionada")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Asignar") },
                    onClick = {
                        showMenu = false
                        Log.d("MENU", "Opción Asignar seleccionada")
                    }
                )

            }
            if (showDialog) {
                AlertDialog(
                    //Cuando se clica fuera del cuadro de diálogo
                    onDismissRequest = { showDialog = false },
                    title = { Text(text = "Editar texto") },
                    text = {
                        Column {
                            TextField(
                                //Una variable de estado iniciada a ""
                                value = inputText,
                                onValueChange = { inputText = it },
                                label = { Text("Nuevo texto?") }
                            )
                        }
                    },
                    //Definición del botón confirmar y acciones que realiza
                    confirmButton = {
                        TextButton(onClick = {
                            myText = inputText // Actualizar el texto principal
                            showDialog = false
                        }) {
                            Text("Aceptar")
                        }
                    },
                    //definición del botón de cancelación y acciones
                    dismissButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("Cancelar")
                        }
                    }
                )
            }
        }

    }
}