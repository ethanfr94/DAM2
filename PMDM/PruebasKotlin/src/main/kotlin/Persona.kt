package org.example

open class Persona(protected var nombre:String="Sin nombre", protected var edad:Int?=null) {
    internal fun setNombre(nombre:String){
        this.nombre=nombre
    }
    open internal fun getNombre():String{
        return this.nombre
    }
    internal fun setEdad(edad:Int){
        this.edad=edad
    }
    internal fun getEdad():Int?{
        return this.edad
    }

}

class deportista(nombre:String, edad:Int?, private var deporte:String="petanca"):Persona(nombre, edad){

    fun setDeporte(deporte:String){
        this.deporte=deporte
    }
    fun getDeporte():String{
        return this.deporte
    }
    override fun getNombre():String{
        return "Deportista: "+super.getNombre()
    }
}