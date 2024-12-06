package com.izanfranco.sesion2_03.Components

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// este componente es un titulo que se le pasa un string y lo muestra en pantalla
// se lo pasaremos al scaffold como parametro
    @Composable
    fun TitleView(name: String){
        Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
    }

// este componente es un espacio vertical que se le pasa un dp y crea un espacio vertical de esa medida
    @Composable
    fun EspacioVertical(dp: Dp){
        Spacer(modifier = Modifier.height(dp))
    }
// este componente es un boton que se le pasa un string y una funcion que se ejecutara al pulsarlo
    @Composable
    fun MainButton(name: String, onClick:() -> Unit){
        Button(onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            )){
           Text(text = name)
        }
    }