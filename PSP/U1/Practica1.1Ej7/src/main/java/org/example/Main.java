package org.example;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bw = new BufferedReader(isr);
        String entrada = null;
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String com = "java -jar src\\Aleatorio.jar";
        try {
            p = r.exec(com);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = p.getOutputStream();
            System.out.println("Introduce texto (fin para terminar):");
            while((entrada = bw.readLine()) != null && !entrada.equalsIgnoreCase("fin")) {
                entrada = entrada + "\n";
                os.write(entrada.getBytes());
                os.flush();
                System.out.println("Numero aleatorio: " +br.readLine() );
            }
            entrada += "\n";
            os.write(entrada.getBytes());
            os.flush();
            os.close();
            int exitVal = p.waitFor();
            System.out.println("Valor salida: " + exitVal);
        }
        catch (IOException ex){
            System.out.println("error: "+ex.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

