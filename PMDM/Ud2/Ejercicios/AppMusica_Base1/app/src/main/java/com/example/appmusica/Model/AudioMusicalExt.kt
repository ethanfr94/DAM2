package com.example.appmusica.Model

import com.example.appmusica.R
import java.time.LocalDate

data class AudioMusicalExt(
    val titulo:String,
    val artist:String,
    val urlImagen : String,
    val urlAudio:String,
    val fecha: LocalDate,
    val estrellas:Double)

val audiosMusicalesExt = listOf(
    AudioMusical(
        titulo = "El Encuentro",
        artist = "Vetusta Morla",
        urlImagen = "",
        urlAudio = "",
        fecha = LocalDate.of(2024, 11, 4),
        estrellas = 4.6
    ),
    AudioMusical(
        titulo = "Baile Existencialista",
        artist = "León Benavente",
        urlImagen = R.drawable.leon_benavente_baile_existencialista,
        urlAudio = 2,
        fecha = LocalDate.of(2024, 11, 5),
        estrellas = 4.7
    ),
    AudioMusical(
        titulo = "Devenir Paisaje",
        artist = "Fin del Mundo",
        urlImagen = R.drawable.fin_del_mundo_devenir_paisaje,
        urlAudio = 3,
        fecha = LocalDate.of(2024, 11, 12),
        estrellas = 4.6
    ),
    AudioMusical(
        titulo = "Brujería!",
        artist = "Judeline",
        urlImagen = R.drawable.judeline_brujeria,
        urlAudio = 4,
        fecha = LocalDate.of(2024, 11, 8),
        estrellas = 4.4
    ),
    AudioMusical(
        titulo = "Nos Volveremos a Ver",
        artist = "La La Love You",
        urlImagen = R.drawable.la_la_love_you_nos_volveremos_a_ver,
        urlAudio = 5,
        fecha = LocalDate.of(2024, 11, 6),
        estrellas = 4.6
    ),
    AudioMusical(
        titulo = "Tenemos la respuesta",
        artist = "ELYELLA feat. Lori Meyers",
        urlImagen = R.drawable.elyella_tenemos_la_respuesta,
        urlAudio = 6,
        fecha = LocalDate.of(2024, 11, 10),
        estrellas = 4.5
    )
)

