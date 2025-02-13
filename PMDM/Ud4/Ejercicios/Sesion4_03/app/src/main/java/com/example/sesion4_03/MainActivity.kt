package com.example.sesion4_03

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.sesion4_03.ui.theme.Sesion4_03Theme
import android.Manifest
import android.os.Looper
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion4_03Theme {
                HomeView()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(){

    var txtLatitud by remember { mutableStateOf("Latitud no disponible") }
    var txtLongitud by remember { mutableStateOf("Longitud no disponible") }
    val context = LocalContext.current
    //cliente que se usa para acceder a la ubicación del dispositivo
    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context) }
    // Estado para saber si está obteniendo la ubicación
    val isTracking = remember { mutableStateOf(false) }
    val locationRequest = remember {
        // Usa GPS para obtener la ubicación más precisa.
        // Cada 5 segundos actualiza la ubicación
        LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000)
            .setMinUpdateDistanceMeters(1f)
            .build()
    }
    //estado que obtiene el ciclo de vida de la Activity
    // que lanzo el composable (mainactivity)
    val lifecycleOwner = LocalLifecycleOwner.current


    //objeto que recibirá las actualizaciones de ubicación
    val locationCallback = remember {
        //El objeto implementa el interface LocationCallback
        object : LocationCallback() {
            // Si se recibe una actualización de ubicación se hace esto
            override fun onLocationResult(locationResult: LocationResult) {
                // si se recibió una actualización se actualizan latitud y longitud
                locationResult.lastLocation?.let { location ->
                    txtLatitud = "Lat: ${location.latitude}"
                    txtLongitud = "Long: ${location.longitude}"
                }
            }
        }
    }

    //detiene la actualización de ubicación
    fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    //Función para iniciar la actualización de ubicación
    fun startLocationUpdates() {
        //Verificamos si el usuario ha dado permisos
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED) {
            // Si ha dado permisos se inicia la actualización de ubicación
            //se pasa la solicitud y el callback
            //y se pasa el Looper para que se ejecute en el hilo principal
            fusedLocationClient.requestLocationUpdates(locationRequest,
                locationCallback,
                Looper.getMainLooper())
            //se cambia el estado a true (para que se use en el Button)
            isTracking.value = true
        }
    }

    //se ejecuta cuando el composable se crea y se destruye
    // cuando se sale de la pantalla
    DisposableEffect(lifecycleOwner) {
        //observador que escucha los cambios en el ciclo de vida del owner
        // (de la mainactivity)
        // _ es el LifecycleOwner (no lo usamos, lo ignoramos)
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                // Reiniciar ubicación cuando entra pantalla
                Lifecycle.Event.ON_RESUME -> startLocationUpdates()
                // Detener ubicación cuando sale de pantalla
                Lifecycle.Event.ON_STOP -> stopLocationUpdates()
                else -> {}
            }
        }
        //añadir el observador al ciclo de vida del owner
        lifecycleOwner.lifecycle.addObserver(observer)
        //cuando se sale de la pantalla se elimina el observador
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    DisposableEffect(lifecycleOwner) {
        //observador que escucha los cambios en el ciclo de vida del owner
        // (de la mainactivity)
        // _ es el LifecycleOwner (no lo usamos, lo ignoramos)
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                // Detener ubicación al terminar la app
                Lifecycle.Event.ON_DESTROY -> stopLocationUpdates()
                else -> {}
            }
        }
        //añadir el observador al ciclo de vida del owner
        lifecycleOwner.lifecycle.addObserver(observer)
        //cuando se sale de la pantalla se elimina el observador
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }


    var enable by remember { mutableStateOf(true) }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {
                    enable = false
                },
                enabled = enable,
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = "Iniciar localizacion")
            }
            Row {
                Text(text = txtLatitud)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = txtLongitud)
            }

        }
    }

    if (!enable) {
        RequestLocationPermission {
            startLocationUpdates()
        }
    }
}





@Composable
//La función recibirá una función onGranted
fun RequestLocationPermission(onGranted: () -> Unit) {
    val context = LocalContext.current
    //llamada a funcion para solicitar permisos
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->  //si el usuario ha dado permisos se ejecuta la funcion onGranted
        if (isGranted) onGranted()
    }
    //Codigo que se carga la primera vez que se inicia el composable
    LaunchedEffect(Unit) {
        //Comprobamos si el usuario ha dado permisos
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            //Si el usuario no ha dado permisos se solicitan
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            //Si el usuario ha dado permisos se ejecuta la funcion onGranted
            onGranted()
        }
    }
}


