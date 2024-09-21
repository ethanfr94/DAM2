package org.example

fun main(){
    saludar()
    saludar("Manolo")
    saludar(nombre= "pepe")
    felicitar("pepe", "aprobar")
    felicitar(motivo= "aprobar", nombre="julio")
    felicitacion("jorge")
    felicitacion("jorge", "tu cumple")

}

fun saludar(){
    println("hola")
}

fun saludar(nombre:String){
    println("hola $nombre")
}

fun felicitar(nombre:String, motivo:String){
    println("Felicidades $nombre por $motivo")
}

// funcion con valor por defecto
fun felicitacion(nombre:String, motivo:String="suspender"){
    println("Felicidades $nombre por $motivo")
}