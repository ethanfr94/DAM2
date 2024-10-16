package com.izanfranco.sesion1__05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izanfranco.sesion1__05.ui.theme.Sesion1__05Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {//Función que se ejecuta al iniciar la actividad
        super.onCreate(savedInstanceState)//Llamada al constructor de la clase padre
        enableEdgeToEdge()//Habilita el modo de pantalla completa
        setContent {//Establece el contenido de la actividad
            Sesion1__05Theme {
                Content()
            }
        }
    }
}

@Composable
fun BotonAceptar(s: String, onClick: () -> Unit) {//Función que recibe un texto y una función
    Button(onClick = onClick) {//Botón que ejecuta la función al hacer clic
        Text(text= s, fontSize = 20.sp)//Texto del botón con tamaño de fuente 20
    }
}

@Composable
fun BotonColor(s: String, onClick: () -> Unit) {//
    Button(onClick = onClick) {//Botón que ejecuta la función al hacer clic
        Text(text= s, fontSize = 20.sp)//Texto del botón con tamaño de fuente 20
    }
}

@Composable
fun Texto(mens:String){//Función que recibe un texto
    Text(text = mens,//Texto que se muestra
        fontSize = 20.sp,//Tamaño de fuente
        fontWeight = FontWeight.Bold,// Tipo de fuente
        color = Color.Blue,//Color del texto
        modifier = Modifier.fillMaxWidth()//Ocupa todo el ancho
    )
}

@Composable
fun Caja(color: Color){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color)) {
    }
}

@Preview(showBackground = true)
@Composable
fun Content() {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.White) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(50.dp))
        TextField(value = nombre, onValueChange = {nombre = it},
            label = { Text("Nombre") },
            textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth())
        OutlinedTextField(value = apellidos, onValueChange = {apellidos = it},
            label = { Text("Apellidos") },
            textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth())
        Spacer(modifier = Modifier.height(15.dp))
        BotonAceptar("Aceptar", onClick = {msg = "Hola $nombre $apellidos"})
        Spacer(modifier = Modifier.height(15.dp))
        Texto(msg)
        Spacer(modifier = Modifier.height(15.dp))
        BotonColor("Rojo", onClick = {color = Color.Red})
        BotonColor("Azul", onClick = {color = Color.Blue})
        BotonColor("Verde", onClick = {color = Color.Green})
        Caja(color)
    }
}