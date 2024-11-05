// See https://aka.ms/new-console-template for more information
// declarar int
using System.Numerics;

int num;
num = 10;
Console.WriteLine(num);

// un decimal puede ser entero
num = (int)4.5;
Console.WriteLine(num);

// cadena de caracteres
// esto no es posible -- num = (int)"4";
// num = Convert.ToInt32("cuatro"); // error
num = Convert.ToInt32("4");
