package org.example

fun main(){
    //al igual que las listas y dets pueden ser mutables o inmutables
    val alumnos:MutableMap<Int, String> = mutableMapOf(1 to "Ana", 21 to "Jose", 12 to "Alberto")
    //mostrar
    println(alumnos)
    println("------------")
    //recorrer con lambda (for each)
    alumnos.forEach{println("${it.key} - ${it.value}")}
    println("------------")
    // recorrer con un for
    for((clave, valor) in alumnos){
        println("$clave .. $valor")
    }
    println("------------")
    //buscar por clave
    println("el alumno 21 es ${alumnos.get(21)}")
    println("el alumno 20 es ${alumnos.get(20)}")
    println("el alumno 20 es ${alumnos.getOrDefault(20, "Desconocido")}")
    //añadir valor
    alumnos.put(3, "Ana")
    println("el alumno 3 es ${alumnos.get(3)}")
    //modificar valor
    alumnos.put(3, "Alba")
    println("el alumno 3 es ${alumnos.get(3)}")
    //eliminar entrada
    alumnos.remove(21)
    println(alumnos)




}