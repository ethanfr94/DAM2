package com.example.sesion2_09.model

data class Artist (
    val id: Int,
    val name: String,
    val genre: String,
    val city: String,
    val country: String,
    val comments: String?=null,
    val foundationYear: Int?=null,
    val imageUrl:String?=null
)