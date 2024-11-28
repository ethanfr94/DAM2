package com.example.sesion2_05.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sesion2_05.components.ActionButton
import com.example.sesion2_05.components.TitleBar
import com.example.sesion2_05.components.TitleView
import com.example.sesion2_05.models.Grupo
import com.example.sesion2_05.models.grupos

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeleccionGrupoView(navController: NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
               title={ TitleBar(texto = "TOP BAR")},
                colors=TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor =  MaterialTheme.colorScheme.primary))
          },
        floatingActionButton = {
            ActionButton()
        }
    ){ //inicialmente da un error porque necesita parametros de padding
        ContentSeleccionGrupoView(navController)
    }
}

@Composable
fun ContentSeleccionGrupoView(  navController: NavController) {
    var selectedId by remember { mutableStateOf<Int?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        TitleView(name ="Selecciona un Grupo" )
        grupos.forEach { grupo ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedId == grupo.id,
                    onClick = { selectedId = grupo.id }
                )
                Text(
                    text = grupo.nombre,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Button(
            onClick = { selectedId?.let { id -> grupos.find { it.id == id } }
                      DetallesGrupoView(navController = navController, grupo = selectedId)},
            modifier = Modifier.padding(top = 16.dp),
            enabled = selectedId != null
        ) {
            Text("Ver Detalles")
        }
    }
}

@Composable
fun DetallesGrupoView(navController: NavController, grupo: Int?) {

}
