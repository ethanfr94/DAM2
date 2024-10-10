package com.izanfranco.sesion1__05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion1__05Theme {
                Content()
            }
        }
    }
}

@Composable
fun BotonAceptar(s: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text= "Aceptar", fontSize = 20.sp)
    }
    Text(text = s,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Texto(mens:String){
    Text(text = mens,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun Content() {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
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
        BotonAceptar("Aceptar", onClick = {msg = "Hola $nombre $apellidos"})
        Texto(msg)



    }
}