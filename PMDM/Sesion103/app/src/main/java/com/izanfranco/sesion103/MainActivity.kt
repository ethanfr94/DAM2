package com.izanfranco.sesion103

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izanfranco.sesion103.ui.theme.Sesion103Theme
//private var n:Int = 0
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        Sesion1.03Theme {
            Surface(Modifier.fillMaxSize()) {


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
            .fillMaxWidth())
    {
        BotonNormal1()
        BotonNormal2()
        BotonNormal3()
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
        enabled = false
    ){
        Text(text = "Boton 1", fontSize = 30.sp)
    }
}
@Composable
fun BotonNormal2() {
    var n:Int = 0
    Button(onClick = {n++
        Log.d("Contador", "Has Pulsado $n veces el boton 2")},
        contentPadding = PaddingValues(top=20.dp, bottom=20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.Cyan
        ),
        //shape = MaterialTheme.shapes.extraLarge
        shape = RoundedCornerShape(60.dp)
    ){
        Text(text = "Boton 2", fontSize = 30.sp)
    }
}
@Composable
fun BotonNormal3() {
    var n:Int = 0
    Button(onClick = {n++
        Log.d("Contador", "Has Pulsado $n veces el boton 3")},
        contentPadding = PaddingValues(top=20.dp, bottom=20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.Cyan
        ),
        //shape = MaterialTheme.shapes.extraLarge
        shape = RoundedCornerShape(60.dp)
    ){
        Text(text = "Boton 3", fontSize = 30.sp)
    }
}
