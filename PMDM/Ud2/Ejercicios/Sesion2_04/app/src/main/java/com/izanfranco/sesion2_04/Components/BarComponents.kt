package com.izanfranco.sesion2_03.Components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

    @Composable
    fun TitleBar(texto: String){
        Text(text = texto,
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.primaryContainer)
    }

    @Composable
    fun MainIconButton(icon: ImageVector, OnClick: () -> Unit){
        IconButton(onClick = OnClick) {
            Icon(imageVector = icon, contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary)
        }
    }


