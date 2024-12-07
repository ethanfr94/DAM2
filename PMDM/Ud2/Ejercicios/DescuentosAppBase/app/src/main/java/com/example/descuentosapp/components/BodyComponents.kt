package com.example.descuentosapp.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun SpaceH(size: Dp = 5.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceW(size: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(size))
}

// textfield para introducir el precio y el descuento
@OptIn(ExperimentalMaterial3Api::class)
@Composable
// onvaluechange es la funcion que se ejecuta cuando se cambia el valor del textfield
fun MainTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        // se le pasa el valor, la funcion para cambiar el valor y el label
        onValueChange = onValueChange,
        label = { Text(text = label) },
        // el teclado es de tipo numerico para que solo se puedan introducir numeros
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )
}

// boton para calcular el descuento y mostrar el dialogo o para limpiar los campos
@Composable
fun MainButton(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    // si se pone unit es que no devuelve nada y se podra ejecutar la funcion que se le pase al boton sin problemas
    onClick: () -> Unit
) {
    OutlinedButton(
        // el boton es de tipo outlined y se le pasa el color y el texto
        onClick = onClick, colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(text = text)
    }
}






