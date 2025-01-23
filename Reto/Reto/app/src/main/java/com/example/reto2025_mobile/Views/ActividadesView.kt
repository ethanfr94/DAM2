package com.example.reto2025_mobile.Views

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reto2025_mobile.Componentes.ActividadesTopAppBar
import com.example.reto2025_mobile.Componentes.BottomAppBar
import com.example.reto2025_mobile.Componentes.normalizeString
import com.example.reto2025_mobile.R
import com.example.reto2025_mobile.ViewModel.ActividadViewModel
import com.example.reto2025_mobile.ViewModel.GrupoParticipanteViewModel
import com.example.reto2025_mobile.ViewModel.ProfParticipanteViewModel
import com.example.reto2025_mobile.data.Actividad
import com.example.reto2025_mobile.data.GrupoParticipante
import com.example.reto2025_mobile.data.ProfParticipante
import com.example.reto2025_mobile.ui.theme.BlueContainer


@Composable
fun ActividadesView(
    navController: NavController,
    actividadViewModel: ActividadViewModel,
    profParticipanteViewModel: ProfParticipanteViewModel,
    grupoParticipanteViewModel: GrupoParticipanteViewModel
) {
    val grupoParticipantes: List<GrupoParticipante> by grupoParticipanteViewModel.gruposParticipantes.observeAsState(
        emptyList()
    )
    val profesParticipantes: List<ProfParticipante> by profParticipanteViewModel.profesoresParticipantes.observeAsState(
        emptyList()
    )
    val context = LocalContext.current
    val actividades: List<Actividad> by actividadViewModel.actividades.observeAsState(emptyList())
    var actividFiltered: MutableList<Actividad> by remember { mutableStateOf(mutableListOf()) }
    var showActividades: List<Actividad> by remember { mutableStateOf(emptyList()) }
    val estados: List<String> = listOf("APROBADA", "CANCELADA", "REALIZADA", "SOLICITADA", "DENEGADA", "REALIZANDOSE")
    var expEstado by remember { mutableStateOf(false) }
    var expGrupo by remember { mutableStateOf(false) }
    var expProf by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { ActividadesTopAppBar(navController) },
        bottomBar = { BottomAppBar(navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { showActividades = actividades },
                        modifier = Modifier.weight(0.2f))
                    {
                        Text("Todas")
                    }
                    Button(
                        onClick = { expEstado = true },
                        modifier = Modifier.weight(0.2f)
                    ) {
                        Text("Estado")
                    }
                    Button(
                        onClick = { expProf = true },
                        modifier = Modifier.weight(0.2f)
                    ) {
                        Text("Profesor")
                    }
                    Button(
                        onClick = { expGrupo = true },
                        modifier = Modifier.weight(0.2f)
                    ) {
                        Text("Grupo")
                    }
                    if (expEstado) {
                        AlertDialog(
                            onDismissRequest = { expEstado = false },
                            confirmButton = { },
                            title = {
                                Text("Filtrar por Estado")
                            },
                            text = {
                                LazyColumn {
                                    items(estados) { est ->
                                        Button(
                                            onClick = {
                                                expEstado = false
                                                // filtrar actividades por estado
                                                for (actividad in actividades) {
                                                    if (actividad.estado.equals( est, ignoreCase = true)) {
                                                        actividFiltered.add(actividad)
                                                        showActividades = actividFiltered
                                                    }
                                                }
                                                if (actividFiltered.isEmpty()) {
                                                    Toast.makeText(
                                                        context,
                                                        "No hay actividades con ese estado",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                            },
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Text(est)
                                        }
                                    }
                                }
                            }
                        )
                    }
                    val uniqueGroups = mutableSetOf<String>()
                    if (expGrupo) {
                        AlertDialog(
                            onDismissRequest = { expGrupo = false },
                            confirmButton = { },
                            title = {
                                Text("Filtrar por grupo")
                            },
                            text = {
                                Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
                                    grupoParticipantes.forEach { grupo ->
                                        val groupCode = grupo.grupo.codGrupo
                                        if (uniqueGroups.add(groupCode)) {
                                            Button(
                                                onClick = {
                                                    expGrupo = false
                                                    // filtrar actividades por estado
                                                    for (actividad in actividades) {
                                                        if (actividad.id == grupo.actividades.id) {
                                                            actividFiltered.add(actividad)
                                                            showActividades = actividFiltered
                                                        }
                                                    }

                                                    if (actividFiltered.isEmpty()) {
                                                        Toast.makeText(
                                                            context,
                                                            "No hay actividades para ese grupo",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }
                                                },
                                                modifier = Modifier.fillMaxWidth()
                                            ) {
                                                Text(grupo.grupo.codGrupo)
                                            }
                                        }
                                    }
                                }
                            }
                        )
                    }
                    val uniqueProfs = mutableSetOf<String>()
                    if (expProf) {
                        AlertDialog(
                            onDismissRequest = { expProf = false },
                            confirmButton = { },
                            title = {
                                Text("Filtrar por profesor")
                            },
                            text = {
                                Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
                                    profesParticipantes.forEach { prof ->
                                        val profe = prof.profesor.uuid
                                        if (uniqueProfs.add(profe)) {
                                            Button(
                                                onClick = {
                                                    expProf = false
                                                    // filtrar actividades por profesor
                                                    for (actividad in actividades) {
                                                        if (actividad.id == prof.actividad.id) {
                                                            actividFiltered.add(actividad)
                                                            showActividades = actividFiltered
                                                        }
                                                    }

                                                    if (actividFiltered.isEmpty()) {
                                                        Toast.makeText(
                                                            context,
                                                            "No hay actividades para ese profesor",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }
                                                },
                                                modifier = Modifier.fillMaxWidth()
                                            ) {
                                                Text("${prof.profesor.nombre} ${prof.profesor.apellidos}")
                                            }
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {

                    var busqueda by remember { mutableStateOf("") }
                    var normalizedBusqueda = normalizeString(busqueda)

                    OutlinedTextField(
                        value = busqueda,
                        onValueChange = { busqueda = it },
                        label = { Text("Buscar") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier.weight(0.6f).padding(10.dp)
                    )
                    IconButton(
                        onClick = { showActividades = actividades.filter { normalizeString(it.titulo).contains(normalizedBusqueda) } },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Busqueda",
                            modifier = Modifier.size(35.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn {
                    items(showActividades) { actividad ->
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .fillMaxHeight(),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = BlueContainer),
                            onClick = {
                                actividadViewModel.getActividadById(actividad.id)
                                profParticipanteViewModel.getProfesoresParticipantes()
                                grupoParticipanteViewModel.getGruposParticipantes()
                                navController.navigate("details")
                            }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Spacer(modifier = Modifier.width(25.dp))
                                Text(
                                    text = actividad.titulo,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF000000),
                                    modifier = Modifier.padding(bottom = 8.dp),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
// dialogs de filtrado


    BackHandler {
        navController.navigate("home")
    }
}