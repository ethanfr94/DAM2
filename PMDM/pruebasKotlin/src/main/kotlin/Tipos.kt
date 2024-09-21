package org.example

fun main(){
    val nombres=arrayOf("Luis","Ana","Alberto")
    //Tipos numericos
    var numInt:Int=0 //declaracion variable declarando el tipo
    var numByte:Byte=127 //declaracion variable tipo Byte
    numByte=numInt.toByte() //pasar de un tipo a otro
    var numUByte:UByte=128u // unsigned
    var numDouble:Double=0.0
    var numFloat:Float=25.7F
    var res=numFloat+numDouble
    // String y Char
    var letra:Char='A'
    var texto:String="hola kotlin"
    //operadores
    println("numInt incrementado ${numInt++}")
    println("numInt incrementado ${numInt}")
    println("----------------")
    numInt=0
    println("numInt incrementado ${++numInt}")
    println("numInt incrementado ${numInt}")
    println("----------------")
    numInt=7
    numByte=3
    println("resultado de numInt/numByte ${numInt/numByte}") //division entera
    println("resto de numInt/numByte ${numInt%numByte}") // resto
    println("resultado de numInt/numByte con decimales ${numInt.toDouble()/numByte}") //division real
    println("----------------")
    numInt +=5
    println("resultado de asignacion suma $numInt")
    println("----------------")
    println("\"$texto\" tiene ${texto.length} caracteres")
    println("la letra es $letra")

}