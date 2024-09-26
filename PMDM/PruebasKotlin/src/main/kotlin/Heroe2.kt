package org.example

class Heroe2 ( private var id: Int = 0,
        private var nombre: String = "No name"){

    private var isSuperheroe: Boolean = true
    private var poder: String = ""

    fun getId():Int{
        return this.id
    }
    fun setId(id:Int){
        this.id=id
    }
    fun getNombre():String{
        return this.nombre
    }
    fun setNombre(nombre:String){
        this.nombre=nombre
    }
    fun isSuperheroe():Boolean{
        return isSuperheroe
    }
    fun setIsSuperheroe(isSuperheroe:Boolean){
        this.isSuperheroe=isSuperheroe
    }
    fun getPoder():String{
        return this.poder
    }
    fun setPoder(poder:String){
        this.poder=poder
    }

    override fun toString(): String {
        return "Heroe(id=$id, nombre='$nombre', isSuperheroe=$isSuperheroe, poder='$poder')"
    }
    fun addPoder(power:String){
        if(this.poder=="") this.poder+=power
        else this.poder+=", "+power
    }
    fun cambiar(){
        this.isSuperheroe=!this.isSuperheroe
    }
}