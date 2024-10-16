package com.izanfranco.sesion2_01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izanfranco.sesion2_01.ui.theme.Sesion2_01Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion2_01Theme {
                Content()
            }
        }
    }
}

val nombreSHeroe = listOf("Spider-Man", "Iron Man", "Captain America", "Thor", "Hulk",
    "Black Widow", "Doctor Strange", "Scarlet Witch", "Black Panther", "Ant-Man",
    "Captain Marvel", "Hawkeye", "Vision", "War Machine", "Falcon",
    "Winter Soldier", "Star-Lord", "Gamora", "Rocket Raccoon", "Groot",
    "Drax", "Mantis", "Nebula", "Wasp", "Shang-Chi",
    "Deadpool", "Wonder Woman", "Superman", "Batman", "Aquaman"
)

@Composable
fun Titulo(){
    Text(text = "Superhéroes",//Texto del título
        fontSize = 30.sp,//Tamaño de fuente
        color = Color.Red,//Color del texto
        modifier = Modifier//Modificador
            .fillMaxWidth()//Ocupa todo el ancho
            .padding(20.dp),//Espacio alrededor del texto
        fontWeight = FontWeight.Bold,//Tipo de fuente
        textAlign = TextAlign.Center,//Alineación del texto
        )
}

@Composable
fun ListaColumn(){
    Column (
        modifier = Modifier//Modificador
            .fillMaxSize()//Ocupa todo el tamaño
            .padding(16.dp)//Espacio alrededor de la columna
            .verticalScroll(rememberScrollState()),//Scroll vertical
        horizontalAlignment = Alignment.CenterHorizontally//Alineación horizontal
    ){
        Espacio(dp = 20.dp)
        Titulo()
        for (nombre in nombreSHeroe){
            TextSHeroe(nombre)
            Espacio(10.dp)
        }
    }
}
@Composable
fun FilaSHeroe(name: String) {
    val contexto = LocalContext.current
    var isChecked by remember { mutableStateOf(false) }
    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF8899FF), shape = RoundedCornerShape(8.dp))
            ) {
        Text(text = name,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        )



        Checkbox(checked = isChecked,
            onCheckedChange = {checked-> isChecked = checked
            Toast(contexto,"superheroe $name seleccionado",Toast.LENGTH_SHORT).show()
            })


    }
}

@Composable
fun ListaLazyColumn(){
    LazyColumn (//Lista que carga los elementos a medida que se desplaza
        verticalArrangement = Arrangement.spacedBy(10.dp),//Espacio entre elementos
        modifier = Modifier
            .fillMaxWidth()//Ocupa todo el ancho
            .padding(16.dp)//Espacio alrededor de la lista
    ) {
        item { Titulo() }//Título de la lista
        items(nombreSHeroe) {//Recorre la lista de nombres
                name -> FilaSHeroe(name)//Muestra el nombre
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Content() {
    //ListaColumn()
    ListaLazyColumn()
}

@Composable
fun Espacio(dp: Dp) {
    Spacer(modifier = Modifier.height(dp))//Espacio entre elementos
}

@Composable
fun TextSHeroe(name: String) {
    Text(
        text = name,
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF8899FF),
                shape = RoundedCornerShape(8.dp)//Borde redondeado
            )
            .padding(16.dp)

    )


}

