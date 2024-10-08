package org.example
const val IVA=0.21 //definicion de constante
    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val number=80 //declaracion de un valor (Int inferido)
    var numReal=7.5 //declaraccion de un valor (Double inferido)
    numReal = numReal+6
    println(numReal)
    ejemplo()
}
fun ejemplo(){
    val n=4
    println(4*IVA)
}