package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Padre.aleatorios();
    }
}
//ejercicio 7 Escribe un programa Aleatorios que haga lo siguiente:
//I. Cree un proceso hijo que está encargado de generar números aleatorios.
//  Para su creación se puede usar el ejemplo dejado en el campus. Este
//  proceso hijo escribirá en su salida estándar un número aleatorio del 0 al 10
//  cada vez que reciba una petición de ejecución por parte del padre. Se creará
//  el ejecutable .jar y será invocado desde el proceso padre
//II. El proceso padre lee líneas de la entrada estándar y por cada línea que lea
//  solicitará al hijo que le envíe un número aleatorio, lo leerá y lo imprimirá en
//  pantalla
//III. Cuando el proceso padre reciba la palabra “fin”, finalizará la ejecución del
//  hijo y procederá a finalizar su ejecución
