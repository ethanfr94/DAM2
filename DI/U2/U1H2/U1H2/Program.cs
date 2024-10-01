// See https://aka.ms/new-console-template for more information
// 1.Convert, switch.Escribe un programa que me solicite un número entero (operando1), seguido que me solicite un operador, seguido que me solicite un número entero (operando2). El programa mostrara por pantalla el resultado con el siguiente formato. "El resultado de 'operando1''operador''operando2' es igual a 'resultado calculado'" Los operadores disponibles soportados serán: +, -, *, /, %

/*
Console.WriteLine("Introduce un número entero");
int operando1 = Convert.ToInt32(Console.ReadLine());
Console.WriteLine("Introduce un operador");
string operador = Console.ReadLine();
Console.WriteLine("Introduce un número entero");
int operando2 = Convert.ToInt32(Console.ReadLine());
int resultado = 0;

switch (operador)
{
    case "+":
        resultado = operando1 + operando2;
        Console.WriteLine("El resultado de " + operando1 + operador + operando2 + " es igual a " + resultado);
        break;
    case "-":
        resultado = operando1 - operando2;
        Console.WriteLine("El resultado de " + operando1 + operador + operando2 + " es igual a " + resultado);
        break;
    case "*":
        resultado = operando1 * operando2;
        Console.WriteLine("El resultado de " + operando1 + operador + operando2 + " es igual a " + resultado);
        break;
    case "/":
        resultado = operando1 / operando2;
        Console.WriteLine("El resultado de " + operando1 + operador + operando2 + " es igual a " + resultado);
        break;
    case "%":
        resultado = operando1 % operando2;
        Console.WriteLine("El resultado de " + operando1 + operador + operando2 + " es igual a " + resultado);
        break;
    default:
        Console.WriteLine("Operador no soportado");
        break;
}
*/

// 2. do -while.Crea un programa que escriba en pantalla los números pares del 26 al 10 (descendiendo), usando "do.while".

/*
int n = 26;
do
{
    Console.WriteLine(n);
    n--;
    n--;
}while(n>=10);
*/

// 3. for. Escribe un programa que me diga si un numero es primo, un numero es primo cuando solamente es divisible por 1 y por el mismo. Implementar mediante un bucle for.

/*
Console.WriteLine("Introduce un número entero");
int n = Convert.ToInt32(Console.ReadLine());
int divisores = 0;
for (int i = 1; i <= n; i++)
{
    if (n % i == 0)
    {
        divisores++;
    }
}
if (divisores == 2)
{
    Console.WriteLine("El número "+n+" es primo");
}
else
{
    Console.WriteLine("El número "+n+" no es primo");
}
*/

/* 4. Crear un programa que devuelva el cambio de una compra, utilizando monedas (o billetes) del mayor valor posible. Supondremos que tenemos una cantidad ilimitada de monedas (o billetes) de 100, 50, 20, 10, 5, 2 y 1, y que no hay decimales. La ejecución podría ser algo como:

Precio ? 44

Pagado ? 100

Su cambio es de 56: 50 5 1

Precio ? 1

Pagado ? 100

Su cambio es de 99: 50 20 20 5 2 2*/

/*
Console.WriteLine("Introduce el precio");
int precio = Convert.ToInt32(Console.ReadLine());

Console.WriteLine("Introduce el dinero pagado");
int pagado = Convert.ToInt32(Console.ReadLine());

int cambio = pagado - precio;

string mensaje = "Su cambio es de "+cambio;


*/

// 5.Escribe un programa que solicite al usuario una cadena de texto y cuente cuántas vocales hay en esa cadena. Deberás mostrar el número de vocales totales.

/*
Console.WriteLine("Introduce una cadena de texto");
string cadena = Console.ReadLine();

int vocales = 0;

for (int i = 0; i < cadena.Length; i++)
{
    if (cadena[i] == 'a' || cadena[i] == 'e' || cadena[i] == 'i' || cadena[i] == 'o' || cadena[i] == 'u')
    {
        vocales++;
    }
}

Console.WriteLine("El número de vocales en la cadena es de "+vocales);
*/

// 6. Crea un programa que verifique si un número entero es capicúa (si se lee igual de izquierda a derecha que de derecha a izquierda). El programa deberá solicitar un número y devolver un mensaje que indique si es capicúa o no.

/*
Console.WriteLine("Introduce un número entero");
int n = Convert.ToInt32(Console.ReadLine());
if (n > 10)
{
    String num = n.ToString();
    int[] ints = new int[n.ToString().Length];
    int j = 1;
    for (int i = 0; i < ints.Length; i++)
    {
        ints[i] = Convert.ToInt32(num.Substring(i, 1));
        j++;
    }
    for (int i = 0; i < ints.Length; i++)
    {
        if (ints[i] != ints[ints.Length - 1 - i])
        {
            Console.WriteLine("El número no es capicúa");
            break;
        }
        else
        {
            Console.WriteLine("El número es capicúa");
            break;
        }
    }
}
else
{
    Console.WriteLine("El número solo tiene un digito");
}
*/

// 7. Escribe un programa que convierta una temperatura dada en grados Celsius a grados Fahrenheit. El programa debe solicitar la temperatura en Celsius, realizar la conversión utilizando la fórmula F = (C*9/5)+32, y mostrar el resultado en Fahrenheit.

/*
Console.WriteLine("Introduce la temperatura en grados Celsius");
int celsius = Convert.ToInt32(Console.ReadLine());
double fahrenheit = (celsius * 9 / 5) + 32;
Console.WriteLine("La temperatura en grados Fahrenheit es de "+fahrenheit);
*/

// 8. Escribe un programa que solicite al usuario una lista de 5 números enteros, los almacene en un array unidimensional y luego muestre la suma de esos números.

/*
Console.WriteLine("Introduce 5 números enteros");
int[] nums = new int[5];
int suma = 0;
for (int i = 0; i < nums.Length; i++)
{
    nums[i] = Convert.ToInt32(Console.ReadLine());
    suma += nums[i];
}
Console.WriteLine("La suma de los números es de "+suma);
*/

// 9. Escribe un programa que reciba 10 números enteros en un array y determine el valor máximo entre ellos.

/*
int[] nums = new int[10];
int max = 0;
for (int i = 0; i < nums.Length; i++)
{
    Console.WriteLine("Introduce un número entero "+(i+1)+"/10");
    nums[i] = Convert.ToInt32(Console.ReadLine());
    if (nums[i] > max)
    {
        max = nums[i];
    }
}
Console.WriteLine("El número máximo es "+max);
*/

// 11. Escribe un programa que permita el usuario escribir 5 números en un array y luego los muestre en orden inverso.

/*
int[] nums = new int[5];
for (int i = 0; i < nums.Length; i++)
{
    Console.WriteLine("Introduce un número entero " + (i + 1) + "/"+nums.Length);
    nums[i] = Convert.ToInt32(Console.ReadLine());    
}
for (int i = nums.Length-1; i >= 0; i--)
{
    Console.WriteLine(nums[i]);
}
*/

/* 12. Crea un programa que almacene las notas de varios estudiantes en diferentes asignaturas utilizando un array multidimensional. El programa deberá realizar lo siguiente:

a.Definir un array de tamaño 3x2, donde las filas representen a 3 estudiantes y las columnas las notas de dos asignaturas

b. Solicitar al usuario que escriba las notas de cada estudiante para ambas asignaturas

c. Calcular y mostrar el promedio de notas para cada estudiante

d. Calcular y mostrar el promedio total de todas las notas escritas.*/

/*
int[,] notas = new int[3,2];
for (int i = 0; i < notas.GetLength(0); i++)
{
    for (int j = 0; j < notas.GetLength(1); j++)
    {
        Console.WriteLine("Introduce la nota del estudiante nº"+(i+1)+" en la asignatura nº"+(j+1));
        notas[i,j] = Convert.ToInt32(Console.ReadLine());
    }
}
float[] promedios = new float[3];
for (int i = 0; i < notas.GetLength(0); i++)
{
    float suma = 0;
    for (int j = 0; j < notas.GetLength(1); j++)
    {
        suma += notas[i, j];
    }
    promedios[i] = suma / notas.GetLength(1);
    Console.WriteLine("El promedio del estudiante nº"+(i+1)+" es de "+promedios[i]);
}
*/

// 13. Crea un programa que solicite al usuario llenar una matriz de 3x3 con números enteros y luego calcule la suma de todos los elementos de la matriz.

/*
Console.WriteLine("Introduce los números de la matriz 3x3");
int[,] matriz = new int[3,3];
int suma = 0;
for (int i = 0; i < matriz.GetLength(0); i++)
{
    for (int j = 0; j < matriz.GetLength(1); j++)
    {
        Console.WriteLine("Introduce el número de la fila " + (i + 1) + " y columna " + (j + 1));
        matriz[i, j] = Convert.ToInt32(Console.ReadLine());
        suma += matriz[i, j];
    }
}
Console.WriteLine("La suma de los elementos de la matriz es de "+suma);
*/

// 14. Escribe una matriz de 2x3 (2 filas y 3 columnas) y calcule la suma de cada fila y de cada columna.

int[,] matriz = new int[2, 3];
int[] sumaFilas = new int[2];
int[] sumaColumnas = new int[3];
for (int i = 0; i < matriz.GetLength(0); i++)
{
    for (int j = 0; j < matriz.GetLength(i); j++)
    {
        Console.WriteLine("Introduce el número de la fila " + (i + 1) + " y columna " + (j + 1));
        matriz[i, j] = Convert.ToInt32(Console.ReadLine());
        sumaFilas[i] += matriz[i, j];
        sumaColumnas[j] += matriz[i, j];
    }
}

