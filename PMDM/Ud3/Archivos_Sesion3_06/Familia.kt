package com.example.sesion3_06.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "familias")
data class Familia(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "nom_fam")
    val nombre: String,

    @ColumnInfo(name = "desc_fam")
    val descripcion: String =""
)
