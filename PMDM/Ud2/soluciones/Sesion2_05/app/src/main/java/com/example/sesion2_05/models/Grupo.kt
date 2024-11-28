package com.example.sesion2_05.models

import android.os.Parcel
import android.os.Parcelable


data class Grupo(
    val id: Int,
    val nombre: String,
    val estilo: String
)

val grupos = listOf(
    Grupo(1, "The Beatles", "Rock"),
    Grupo(2, "Queen", "Rock"),
    Grupo(3, "The Rolling Stones", "Rock"),
    Grupo(4, "ABBA", "Pop")
)
