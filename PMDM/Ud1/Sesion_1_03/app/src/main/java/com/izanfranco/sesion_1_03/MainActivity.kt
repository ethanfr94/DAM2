package com.izanfranco.sesion_1_03

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izanfranco.sesion_1_03.ui.theme.Sesion_1_03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sesion_1_03Theme {
            Surface(Modifier.fillMaxSize(),
                color = Color.LightGray) {
            }
        }
            Content()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Content() {
    columna()
}

@Composable
fun columna() {
    //definimos un column
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp))
    {
        BotonNormal1()
        Espacio(20.dp)
        BotonNormal2()
        Espacio(20.dp)
        BotonBorde("Boton 3", 30.sp)
        Espacio(20.dp)
        BotonElevado("Boton 4", 30.sp)
        Espacio(20.dp)
        BotonTexto("Boton 5", 30.sp)
        Espacio(20.dp)
        BotonIcono()
        Espacio(20.dp)
        BotonNormalIcono()
    }
}

@Composable
fun BotonIcono() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.AccountCircle,
             contentDescription = "Icono de usuario",
             tint = Color.Red,
            modifier = Modifier.size(60.dp)
        )
    }
}
@Composable
fun BotonNormalIcono() {
    Button(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Favorite,
            contentDescription = "Icono de favoritos",
            tint = Color.Red,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier =Modifier.width(4.dp))
        Text(text = "Favoritos", fontSize = 9.sp)
    }
}

@Composable
fun BotonNormal1() {
    var n:Int = 0
    Button(onClick = {n++
        Log.d("Contador", "Has Pulsado $n veces el boton 1")},
        contentPadding = PaddingValues(top=20.dp, bottom=20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.Cyan
        ),
        //shape = MaterialTheme.shapes.extraLarge
        shape = RoundedCornerShape(60.dp),
    ){
        Text(text = "Boton 1", fontSize = 30.sp)
    }
}
@Composable
fun BotonNormal2() {
    var n:Int = 0
    FilledTonalButton(onClick = {n++
        Log.d("Contador", "Has Pulsado $n veces el boton 2")},
        contentPadding = PaddingValues(top=20.dp, bottom=20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.Cyan
        ),
        //shape = MaterialTheme.shapes.extraLarge
        shape = RoundedCornerShape(60.dp),
        enabled = false,
    ){
        Text(text = "Boton 2", fontSize = 30.sp)
    }
}
@Composable
fun BotonBorde(s:String, sp: TextUnit) {
    var n:Int = 0
    OutlinedButton(onClick = {n++
        Log.d("Contador", "Has Pulsado $n veces el boton 3")},
        contentPadding = PaddingValues(top=20.dp, bottom=20.dp),
        border = BorderStroke(width = 2.dp, color = Color.Red),
    )
    {
        Text(text = s, fontSize = sp, color = Color.Red)
    }
}
@Composable
fun BotonElevado(s:String, sp: TextUnit) {
    var n:Int = 0
    ElevatedButton(onClick = {Log.d("Contador", "Has Pulsado $n veces el boton 4")},
        contentPadding = PaddingValues(top=20.dp, bottom=20.dp),
    ){
        Text(text = "Boton 4", fontSize = 30.sp, color = Color.Red)
    }
}
@Composable
fun BotonTexto(s:String, sp: TextUnit) {
    var n:Int = 0
    TextButton(onClick = {Log.d("Contador", "Has Pulsado $n veces el boton 5")},
            contentPadding = PaddingValues(top=20.dp, bottom=20.dp),)
    {
        Text(text =s, fontSize = sp, color = Color.Red)
    }
}
@Composable
fun Espacio(dp: Dp){
    Spacer(modifier = Modifier.height(dp))
}
