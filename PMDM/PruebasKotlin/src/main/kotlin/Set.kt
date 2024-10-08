package org.example

fun main(){
    val clientes:Set<String> = setOf("Ana", "Beatriz", "Carlos", "Ana") // inmutable
    println(clientes)
    println("----------- acceder a todos los elememtos")
    clientes.forEach{println(it)}
    val colores:MutableSet<String> = mutableSetOf("Blanco", "Amarillo", "Verde")
    colores.add("Rojo")
    colores.add("Rojo")
    colores.add("ROJO")
    println(colores)
    println("----------- comprobar si contiene un elemento por su contenido")
    println(colores.contains("Rojo"))
    println(colores.contains("Negro"))
    println("----------- comprobar si contiene un elemento por su contenido")
    println(colores.contains("Rojo"))
    println(colores.contains("Negro"))
    println("---------------")
    val contiene=colores.any{it.equals("VERDE", ignoreCase = true)}
    println(contiene)
}