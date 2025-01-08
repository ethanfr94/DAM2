package com.example.sesion3_06.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animales",)
data class Animal(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int=0,

    @ColumnInfo(name = "nombre")
    val nombre: String,

    @ColumnInfo(name = "caracteristicas")
    val caracteristicas: String="",

    @ColumnInfo(name = "imagen_url")
    val imagenUrl: String="",

    @ColumnInfo(name = "familia_id")
    val familiaId: Int
)