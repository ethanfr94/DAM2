package com.izanfranco.sesion1_02

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izanfranco.sesion1_02.ui.theme.Sesion1_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Content()
            Content2("Hola mundo")
            }
        }
    }
//@Preview(showBackground = true)
@Composable
fun Content(){
    Text(text = "paparruchas de las gordas y las flacas",
        color= Color.Red,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 4,
        textAlign = TextAlign.Center,
        lineHeight = 50.sp
    )
}

@Composable
fun Content2(msg: String){
    Text(text = msg,
        color= Color.Red,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 4,
        textAlign = TextAlign.Center,
        lineHeight = 50.sp,
        modifier = Modifier.fillMaxSize().background(Color.Black)
            .padding(20.dp).clickable { Log.d("ONCONTENT2", "has hecho clic en el texto") }
    )
    
}
