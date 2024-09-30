// See https://aka.ms/new-console-template for more information
// 1.Escribe un programa que solicite al usuario dos números enteros y muestre la suma, resta, multiplicación y división de los mismos.
/*
Console.WriteLine("Introduce el primer número");
int num1 = Convert.ToInt32(Console.ReadLine());
Console.WriteLine("Introduce el segundo número");
int num2 = Convert.ToInt32(Console.ReadLine());

Console.WriteLine("La suma de los números es: " + (num1 + num2));
Console.WriteLine("La resta de los números es: " + (num1 - num2));
Console.WriteLine("La multiplicación de los números es: " + (num1 * num2));
Console.WriteLine("La división de los números es: " + (num1 / num2));
*/
// 2. Escribe un programa que solicite un número. El programa indicará si el número es par o impar.
/*
Console.WriteLine("Introduce un número");
int num = Convert.ToInt32(Console.ReadLine());

if (num == 0)
{
    Console.WriteLine("El número es cero");
}
else if (num % 2 == 0)
{
    Console.WriteLine("El número es par");
}
{
    Console.WriteLine("El número es impar");
}
*/
// 3. Escribe un programa que muestre la tabla de multiplicar de un número introducido por el usuario.
/*
Console.WriteLine("Introduce un número");
int num = Convert.ToInt32(Console.ReadLine());

for (int i = 1; i <= 10; i++)
{
    Console.WriteLine(num + " x " + i + " = " + (num * i));
}
*/
// 4. Escribe un programa que solicite al usuario 3 números y determine cuál es el mayor de ellos.
/*
Console.WriteLine("Introduce el primer número");
int num1 = Convert.ToInt32(Console.ReadLine());
Console.WriteLine("Introduce el segundo número");
int num2 = Convert.ToInt32(Console.ReadLine());
Console.WriteLine("Introduce el tercer número");
int num3 = Convert.ToInt32(Console.ReadLine());

if (num1 > num2 && num1 > num3)
{
    Console.WriteLine("El número mayor es: " + num1);
}
else if (num2 > num1 && num2 > num3)
{
    Console.WriteLine("El número mayor es: " + num2);
}
else
{
    Console.WriteLine("El número mayor es: " + num3);
}
*/
// 5. Escribe un programa que funcione como una calculadora básica. El usuario debe introducir dos números y seleccionar una operación (suma, resta, multiplicación, división).
/*
Console.WriteLine("Introduce el primer número");
int num1 = Convert.ToInt32(Console.ReadLine());
Console.WriteLine("Introduce el segundo número");
int num2 = Convert.ToInt32(Console.ReadLine());

Console.WriteLine("Selecciona la operación a realizar:\n1.Suma\n2.Resta\n3.Multiplicacion\n4.Division");
int operacion = Convert.ToInt32(Console.ReadLine());
switch (operacion)
{
    case 1:
        Console.WriteLine("La suma de los números es: " + (num1 + num2));
        break;
    case 2:
        Console.WriteLine("La resta de los números es: " + (num1 - num2));
        break;
    case 3:
        Console.WriteLine("La multiplicación de los números es: " + (num1 * num2));
        break;
    case 4:
        Console.WriteLine("La división de los números es: " + (num1 / num2));
        break;
    default:
        Console.WriteLine("Seleccion no válida");
        break;
}
*/
// 6. Escribe un programa que determine si un número que se ha introducido por el usuario es primo o no
/*
Console.WriteLine("Introduce un número");
int num = Convert.ToInt32(Console.ReadLine());

Boolean primo = true;

for (int i = 2; i < num; i++)if (num % i == 0) primo = false;

if (primo) Console.WriteLine("El número es primo");

else Console.WriteLine("El número no es primo");
*/
// 7. Escribe un programa que solicite un número al usuario y calcule su factorial
/*
Console.WriteLine("Introduce un número");
int num = Convert.ToInt32(Console.ReadLine());
int fact = 1;

for (int i = 1; i <= num; i++) fact *= i;

Console.WriteLine("el factorial del número " + num + " es: " + fact);
*/