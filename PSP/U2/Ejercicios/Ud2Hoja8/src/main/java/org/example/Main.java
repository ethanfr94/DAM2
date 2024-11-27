package org.example;

public class Main {
    public static void main(String[] args) {

    }
}

/*
Debido a haber estado encerrado sin salir de tu habitación por ciertas
asignaturas en concreto, te ves obligado a ir a la última fiesta del curso
En la fiesta hay dos barras (en cada una hay un camarero) donde sirven bebida.
El camarero tarda 100 ms en servir una copa.
Para no perder tiempo y que salga rentable la noche, eliges la barra del bar que
menos cola tenga y esperas a que te sirvan. Después de esto te vas a bailar o a
ligar un rato (no más de 600 msg.), hasta que se te gaste la bebida y de nuevo
tengas que ir a por otra bebida.
Para evitar problemas alcohólicos, las personas como máximo podrán tomar 5
bebidas en total.
Cuando no se pueden servir más copas la fiesta termina.
Codifica el programa que cumpla estas restricciones sin bloqueos ni inanición
para 50 personas usando monitores.

PISTAS

Para solucionar el problema puedes crear tres tareas: Cliente, Camarero(o barra)
y Fiesta que representan respectivamente a los fiesteros, los camareros (o barras
de bar) y una clase que actúa como un monitor para consultar el número de
personas que hay en cada cola de las barras del bar.
El cliente que esté de fiesta, lo único que hará será mirar la cola de espera más
corta, irse hacia ese lado y pedir el turno, hasta que el camarero le atienda,
después se marchara de la cola de esa barra.
Algunos de los métodos del problema podrían ser para la clase Fiesta:
DimeLado(): consulta cuál de las dos colas del bar es más corta, y según la que
sea vas a una barra o a la otra y te pones a la cola.
DejarColaDcha( ), DejarColaIzda() dejas la barra del bar (según el lado que sea),
habrá uno menos esperando a ser atendido.
Implementa un sleep durante la creación de los clientes para que no pidan todos
a la vez.
*/