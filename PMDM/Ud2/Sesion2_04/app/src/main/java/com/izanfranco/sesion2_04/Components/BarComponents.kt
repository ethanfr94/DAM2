package com.izanfranco.sesion2_03.Components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

    @Composable
    fun TitleBar(texto: String){
        Text(text = texto,
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.primaryContainer)
    }


