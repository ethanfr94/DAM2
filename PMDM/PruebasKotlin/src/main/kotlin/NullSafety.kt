package org.example

import java.util.Scanner

fun main(){
    var texto:String?="hola" // texto admite nulidad
    var teclado:Scanner=Scanner(System.`in`)
    val num=teclado.nextInt()
    texto=null
    println(texto)
    println("escribe un texto")
    texto= readln() //recoge por teclado no admite nulo
    println(texto)
    println("escribe un texto")
    texto= readLine() //recoge por teclado admite nulo
    println(texto)

}