package org.example

fun main(){
    /*saludar()
    saludar("Manolo")
    saludar(nombre= "pepe")
    felicitar("pepe", "aprobar")
    felicitar(motivo= "aprobar", nombre="julio")
    felicitacion("jorge")
    felicitacion("jorge", "tu cumple")*/
    printHola(null)
    printHola("pepe")
    println("---------------doble de 7")
    print(doble(7))

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
//Tipo Unit es lo mismo que void en java
fun printHola(name:String?):Unit{
    if (name != null) {
        println("Holaaaaaaaa")
    } else {
        println("Hola $name")
    }
}
// funcion que devuelve el doble del valor del parametro
fun doble(x:Int):Int{
    return x*2
}
//fun doble(x:Int):Int= x*2 es lo mismo que la funcion de arriba