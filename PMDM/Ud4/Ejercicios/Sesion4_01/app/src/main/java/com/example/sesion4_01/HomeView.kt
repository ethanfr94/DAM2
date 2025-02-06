package com.example.sesion4_01

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(viewModel: ConnectivityViewModel) {
    // Snackbar para mensajes de error
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->

        var textUrlState by remember { mutableStateOf("") }
        val content by viewModel.content.observeAsState("")
        val isConnected by viewModel.isConnected.observeAsState(false)
        val isUsingMobileData by viewModel.isUsingMobileData.observeAsState(false)
        val errorMessage by viewModel.errorMessage.observeAsState("")
        val showMobileDataDialog by viewModel.showMobileDataDialog.observeAsState(false)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = textUrlState,
                onValueChange = { textUrlState = it },
                label = { Text("Ingrese la URL") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Button(
                onClick = { viewModel.downloadContent(textUrlState)
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Descargar")
            }
            Text(
                text = content,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }

        // Mostrar Snackbar si hay mensaje de error
        LaunchedEffect(errorMessage) {
            if (errorMessage.isNotEmpty()) {
                snackbarHostState.showSnackbar(errorMessage)
            }
        }

        // Diálogo para datos móviles
        if (showMobileDataDialog) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Usar datos móviles") },
                text = { Text("No se detectó conexión WiFi. ¿Desea usar datos móviles?") },
                confirmButton = {
                    TextButton(onClick = { viewModel.acceptUsingMobileData() }) {
                        Text("Sí")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { /* No hacer nada */ }) {
                        Text("No")
                    }
                }
            )
        }

        if (isConnected || isUsingMobileData) {
            // aquí van todos los componentes que había en column
        }



    }
}