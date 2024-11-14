package com.example.appmusica.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmusica.Model.Reflexion
import com.example.appmusica.Model.getReflexionDelDia
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ContentHomeView(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        FrasedelDia()
    }
}

@Composable
fun FrasedelDia(){
    Box(modifier = Modifier.fillMaxWidth().padding(7.dp)){
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,){
            Text(text = "Frase del día", fontWeight = FontWeight.Bold, fontSize = 30.sp, )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.small
                )
                ){
                Column(modifier = Modifier.fillMaxWidth()){
                    Text(getReflexionDelDia().frase,overflow = TextOverflow.Ellipsis, fontStyle = FontStyle.Italic)
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("- "+getReflexionDelDia().autor, modifier = Modifier.align(Alignment.End), fontWeight = FontWeight.Bold)
                }
            }
        }

    }
}

@Composable
fun AudioMasReciente(){
    Box(modifier = Modifier.fillMaxWidth()){
        Column (modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalAlignment = Alignment.Start,){
            Text(text = "AudioMasReciente", fontWeight = FontWeight.Bold, fontSize = 30.sp, )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.medium
                )
                ){
                Column(modifier = Modifier.fillMaxWidth()){
                    Text(getReflexionDelDia().frase,overflow = TextOverflow.Ellipsis, fontStyle = FontStyle.Italic)
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("- "+getReflexionDelDia().autor, modifier = Modifier.align(Alignment.End), fontWeight = FontWeight.Bold)
                }
            }
        }

    }
}