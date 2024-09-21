package org.example

fun main(){
    //val provincias:List<String> = listOf("Cantabria", "Asturias")//lista inmutable
    val provincias:MutableList<String> = mutableListOf("Cantabria", "Asturias")//lista mutable
    println("---------------- obtener elementos lista")
    for (prov in provincias){
        println(prov)
    }
    println("---------------- obtener elementos lista e indices")
    for (i in provincias.indices){
        println("$i - ${provincias.get(i)}")
    }
    println("---------------- obtener elementos lista con lambda")
    provincias.forEach{println(it)} // en un for each cada elemento de la lista se denomina it
    println("---------------- añadir a lista mutable")
    provincias.add("Leon")
    provincias.add("Lugo")
    provincias.add("Cantabria")
    println(provincias)
    println("---------------- eliminar elementos ")
    provincias.remove("Cantabria")//eliminar un elemento por nombre (elimina la primera que encuentre)
    println(provincias)
    println("---------------- eliminar elementos sin diferenciar mayus/minus")
    provincias.removeIf{it.equals("LUGO", ignoreCase = true)}
    println(provincias)
    println(provincias.none())//nos indica con un boolean si la lista tiene valores o no
}