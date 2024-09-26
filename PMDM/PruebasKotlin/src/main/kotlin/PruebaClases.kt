package org.example

fun main(){
    var heroe=Heroe()
    println(heroe.id)
    heroe.id=1
    heroe.nombre="Superman"
    heroe.poder="Volar"
    heroe.toString()
    heroe.addPoder("petanca")
    heroe.cambiar()
    println(heroe.toString())
    println("-------------------encapsulamiento y otras cosas-------------------")
    var heroe2=Heroe2()
    heroe2.setNombre("Batman")
    heroe2.setId(2)
    heroe2.setPoder("Dinero")
    println(heroe2.toString())
    println("-------------------construir con parametros-------------------")
    heroe2=Heroe2(nombre = "Spiderman")
    println(heroe2.toString())
    println("--------------------------Herencia--------------------------")
    var persona=Persona("Juan", 25)
    persona.setEdad(26)
    println(persona.getEdad())
    var deportista=deportista("Pepe", 30, "Ping Pong")
    println(deportista.getDeporte())

}