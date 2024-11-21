package com.example.appmusica.Model

import com.example.appmusica.R
import java.time.LocalDate

data class AudioMusicalExt(
    val titulo:String,
    val artist:String,
    val urlImagen : String,
    //val urlAudio:String,
    val fecha: LocalDate,
    val estrellas:Double)

val audiosMusicalesExt = listOf(
    AudioMusicalExt(
        titulo = "El Encuentro",
        artist = "Vetusta Morla",
        urlImagen = "https://live.staticflickr.com/65535/50547142131_7fcab7e0db_q_d.jpg",
        fecha = LocalDate.of(2024, 11, 4),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Baile Existencialista",
        artist = "León Benavente",
        urlImagen = "https://www.flickr.com/photos/martij27/8557689211/sizes/sq/",
        fecha = LocalDate.of(2024, 11, 5),
        estrellas = 4.7
    ),
    AudioMusicalExt(
        titulo = "Devenir Paisaje",
        artist = "Fin del Mundo",
        urlImagen = "https://live.staticflickr.com/2482/3703337927_693368f57e_q_d.jpg",
        fecha = LocalDate.of(2024, 11, 12),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Brujería!",
        artist = "Judeline",
        urlImagen = "https://live.staticflickr.com/5323/6937747562_68cfd7857d_w_d.jpg",
        fecha = LocalDate.of(2024, 11, 8),
        estrellas = 4.4
    ),
    AudioMusicalExt(
        titulo = "Nos Volveremos a Ver",
        artist = "La La Love You",
        urlImagen = "https://live.staticflickr.com/63/201488691_135c463130_q_d.jpg",
        fecha = LocalDate.of(2024, 11, 6),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Tenemos la respuesta",
        artist = "ELYELLA feat. Lori Meyers",
        urlImagen = "https://www.flickr.com/photos/andrelaine/4373558858/sizes/sq/",
        fecha = LocalDate.of(2024, 11, 10),
        estrellas = 4.5
    )
)

