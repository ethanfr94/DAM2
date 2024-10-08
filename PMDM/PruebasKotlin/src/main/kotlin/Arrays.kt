package org.example

fun main(){
    val numeros:Array<Int> = arrayOf(7,4,8,5,9) //declaracion de un array no reasignable(numero o tipo de valores)
    numeros[1]=8
    // numeros.set(1,8)
    println("en la tercera posicion hay ${numeros[2]}")
    println("------ acceder a todos los elementos por su indice")
    for (i in 0..numeros.size-1){
        println("$i - ${numeros.get(i)}")
    }
    for (i in numeros.indices){
        println("$i - ${numeros.get(i)}")
    }
    //como for each
    for(it in numeros){
        println(it)
    }
    // si numeros fuese var en lugar de val podriamos reasignar es decir
    // numeros=arrayOf(4.20.11)

    println("---------------- array con 10 numeros Double a 0")
    val notas:Array<Double> =Array(10){0.0} // no puede haber nulos
    val notas2:Array<Double?> =Array(10){null}// posibilidad de nulos


}