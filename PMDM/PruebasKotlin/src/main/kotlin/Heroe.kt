package org.example

class Heroe {
    var id: Int = 0
    var nombre: String = ""
    var isSuperheroe: Boolean = true
    var poder: String = ""
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