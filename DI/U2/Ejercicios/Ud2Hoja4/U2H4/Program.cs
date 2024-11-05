//1.INDIZADORES.Implementa la clase autobús, la clase autobús dispondrá de un array de booleanos para indicar si una plaza está ocupada,
//el número de plazas será necesario indicarlo a la hora de instanciar un autobús.
//Se podrá saber si una plaza está ocupada a través de un indizador que reciba como parámetro el número de plaza y devuelva verdadero o falso
//en función de si el asiento está ocupado o no.
//Implementar una propiedad Ocupadas que me indique el número de plazas reservadas,
//otra propiedad Plazas que me indique el número de plazas totales del autobús.
//Una función PlazasLibres que me devuelva los números de plaza libres y otra función ReservarPlaza que reciba el número de plaza y trate de reservarla,
//si la plaza ya está ocupada devolverá false y se notificara al usuario.
//Crear el código necesario para poder probar toda la funcionalidad requerida ofertándola al usuario a través de un menú de selección.

class autobus
{
    private bool[] plazas;
    private int ocupadas;
    private int plazasTotales;

    public autobus(int numPlazas)
    {
        plazas = new bool[numPlazas];
        plazasTotales = numPlazas;
        ocupadas = 0;
    }

    public void ReservarPlaza()
    {
        for (int i = 0; i < plazas.Length; i++)
        {
            int plaza = new Random().Next(0, 2);
            plazas[i] = plaza == 0 ? false : true;
            if (plazas[i])
            {
                ocupadas++;
            }            
        }
    }

    public string this[int i]
    {
        
        get
        {
            string plaza = "";
            if (i < 0 || i >= plazas.Length)
            {
                plaza = "fuera de rango";
            }
            plaza = plazas[i] ? "ocupada" : "libre";
            return plaza;
        }
    }

    public String PlazasLibres()
    {
       String plazasLibres = "las siguientes plazas estan libres: ";
        for (int i = 0; i < plazas.Length; i++)
        {
            if (!plazas[i])
            {
                plazasLibres += i + " ";
            }
        }
        return plazasLibres;
    }

    public void ReservarPlaza(int plaza)
    {
        string reservada = "";
        if (plazas[plaza] == false)
        {
            plazas[plaza] = true;
            ocupadas++;
            Console.WriteLine("plaza reservada correctamente");
        }else 
        {
            Console.WriteLine("la plaza esta ocupada");
        }
    }    
}

/*class program
{
    static void Main()
    {
        autobus bus = new autobus(10);
        bus.ReservarPlaza();
        Console.WriteLine(bus.PlazasLibres());
        Console.WriteLine("estado plaza 5? "+bus[5]);
        Console.WriteLine("intentamos reservar la plaza 5");         
        bus.ReservarPlaza(5);
    }
}*/

// 2.Crea una interfaz llamada IDispositivoElectronico que tenga los métodos Encender y Apagar.
// Luego crea las clases Televisión y Radio, las cuales implementará esta interfaz.
// Ambas clases deben tener una propiedad Estado que indique si el dispositivo está encendido
// o apagado Escribe un programa que instancie objetos de ambas clases, los encienda,
// y luego imprima el estado actual del dispositivo

interface IDispositivoElectronico
{
    void Encender();
    void Apagar();
}

public class Television : IDispositivoElectronico
{
    public bool Estado { get; set; }

    public void Encender()
    {
        Estado = true;
    }

    public void Apagar()
    {
        Estado = false;
    }
}

public class Radio : IDispositivoElectronico
{
    public bool Estado { get; set; }

    public void Encender()
    {
        Estado = true;
    }

    public void Apagar()
    {
        Estado = false;
    }
}

/*class Program
{
    static void Main()
    {
        Television tv = new Television();
        Console.WriteLine("La televisión está encendida: " + (tv.Estado ? "si" : "no"));
        Console.WriteLine("Encendiendo la televisión...");
        tv.Encender();
        Console.WriteLine("La televisión está encendida: " + (tv.Estado? "si" : "no"));

        Radio radio = new Radio();
        Console.WriteLine("La radio está encendida: " + (radio.Estado ? "si" : "no"));
        Console.WriteLine("Encendiendo la radio...");
        radio.Encender();
        Console.WriteLine("La radio está encendida: " + (radio.Estado? "si" : "no"));
    }
}*/

// 3. Crea una interfaz IPago que tenga un método RealizarPago(). Luego, crea dos clases PagoTarjeta y
// PagoPaypal que implementen esta interfaz. Cada una debe imprimir un mensaje distinto cuando se realice el pago.
// Escribe un programa que simule el pago con tarjeta y el pago con Paypal.

interface IPago
{
    void RealizarPago();
}

public class PagoTarjeta : IPago
{
    public void RealizarPago()
    {
        Console.WriteLine("Pago con tarjeta realizado");
    }
}

public class PagoPaypal : IPago
{
    public void RealizarPago()
    {
        Console.WriteLine("Pago con Paypal realizado");
    }
}

/*class Program
{
    static void Main()
    {
        PagoTarjeta pagoTarjeta = new PagoTarjeta();
        pagoTarjeta.RealizarPago();

        PagoPaypal pagoPaypal = new PagoPaypal();
        pagoPaypal.RealizarPago();
    }
}*/

// 4. Crea una interfaz ITransporte con los métodos Arrancar() y Detener(). Luego, crea una clase base Vehiculo
// que tenga una propiedad Marca y un método MostrarInformacion() que muestre la marca del vehículo.A partir de Vehiculo,
// crea dos clases derivadas: Coche y Moto, que implementen la interfaz ITransporte. Ambas clases deben proporcionar
// una implementación para los métodos de la interfaz, además de heredar el método MostrarInformacion() de la clase base.
// Escribe un programa que cree un objeto de tipo Coche y otro de tipo Moto, llame a sus métodos de la
// interfaz y muestre la información de cada vehículo.

interface ITransporte
{
    void Arrancar();
    void Detener();
}

public class Vehiculo
{
    public string Marca { get; set; }

    public void MostrarInformacion()
    {
        Console.WriteLine("Marca: " + Marca);
    }
}

public class Coche : Vehiculo, ITransporte
{
    public void Arrancar()
    {
        Console.WriteLine("Coche arrancado");
    }

    public void Detener()
    {
        Console.WriteLine("Coche detenido");
    }
}

public class Moto : Vehiculo, ITransporte
{
    public void Arrancar()
    {
        Console.WriteLine("Moto arrancada");
    }

    public void Detener()
    {
        Console.WriteLine("Moto detenida");
    }
}

/*class Program
{
    static void Main()
    {
        Coche coche = new Coche();
        coche.Marca = "Ford";
        coche.MostrarInformacion();
        coche.Arrancar();
        coche.Detener();

        Moto moto = new Moto();
        moto.Marca = "Yamaha";
        moto.MostrarInformacion();
        moto.Arrancar();
        moto.Detener();
    }
}*/

// 5. Crea una interfaz ITrabajador que tenga los métodos Trabajar() y CobrarSalario().
// Luego, crea una clase base Persona que tenga las propiedades Nombre y Edad, y un método MostrarInformacion()
// que muestre el nombre y la edad de la persona.A partir de la clase Persona, crea dos clases derivadas:
// Empleado y Freelancer, que implementen la interfaz ITrabajador. El método Trabajar() debe mostrar mensajes
// diferentes para un empleado y un freelancer, y el método CobrarSalario() debe reflejar sus diferencias, por ejemplo,
// un empleado cobra un salario fijo y un freelancer cobra por proyecto.Escribe un programa que cree un objeto de tipo Empleado
// y otro de tipo Freelancer, muestre su información y haga que trabajen y cobren su salario.

interface ITrabajador
{
    void Trabajar();
    void CobrarSalario();
}

public class Persona
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    public void MostrarInformacion()
    {
        Console.WriteLine("Nombre: " + Nombre);
        Console.WriteLine("Edad: " + Edad);
    }
}

public class Empleado : Persona, ITrabajador
{
    public void Trabajar()
    {
        Console.WriteLine("Empleado trabajando");
    }

    public void CobrarSalario()
    {
        Console.WriteLine("Sueldo cobrado 1250 Eur");
    }
}

public class Freelancer : Persona, ITrabajador
{
    public void Trabajar()
    {
        Console.WriteLine("Freelancer trabajando");
    }

    public void CobrarSalario()
    {
        int sueldo = new Random().Next(100, 1000);
        Console.WriteLine("sueldo cobrado "+sueldo+" Eur");
    }
}

/*class Program
{
    static void Main()
    {
        Empleado empleado = new Empleado();
        empleado.Nombre = "Juan";
        empleado.Edad = 30;
        empleado.MostrarInformacion();
        empleado.Trabajar();
        empleado.CobrarSalario();

        Freelancer freelancer = new Freelancer();
        freelancer.Nombre = "Ana";
        freelancer.Edad = 25;
        freelancer.MostrarInformacion();
        freelancer.Trabajar();
        freelancer.CobrarSalario();
    }
}*/

// 6. Crea una interfaz llamada IVolador que tenga un método Volar(). Luego, crea dos clases, Ave y Avion,
// que implementen esta interfaz. Escribe un programa que haga volar tanto a un ave como a un avión.

interface IVolador
{
    void volar();
}

public class  ave : IVolador
{
    public void volar()
    {
           Console.WriteLine("el ave vuela");
    }
}

public class avion : IVolador
{
    public void volar()
    {
        Console.WriteLine("el avion vuela");
    }
}

/*class Program
{
    static void Main()
    {
        ave ave = new ave();
        ave.volar();

        avion avion = new avion();
        avion.volar();
    }
}*/

// 7. Interfaces, ordenación, IComparable Crea una clase Mascota que disponga de las propiedades nombre y edad,
// la clase implementara la interfaz IComparable la cual permite comparar dos objetos. Después se pedirá al usuario
// los datos de 5 mascotas y el programa mostrará sus nombres ordenados por edad usando el método CompareTo de la interfaz.

class Mascota : IComparable
{
    public string Nombre { get; set; }
    public int Edad { get; set; }

    public int CompareTo(object o)
    {
        Mascota mascota = (Mascota)o;
        return Edad.CompareTo(mascota.Edad);
    }
}

/*class Program
{
    static void Main()
    {
        Mascota[] mascotas = new Mascota[5];
        for (int i = 0; i < mascotas.Length; i++)
        {
            mascotas[i] = new Mascota();
            Console.WriteLine("Introduce el nombre de la mascota " + (i + 1));
            mascotas[i].Nombre = Console.ReadLine();
            Console.WriteLine("Introduce la edad de la mascota " + (i + 1));
            mascotas[i].Edad = int.Parse(Console.ReadLine());
        }

        Array.Sort(mascotas);
        Console.WriteLine("Mascotas ordenadas por edad:");
        foreach (Mascota mascota in mascotas)
        {
            Console.WriteLine(mascota.Nombre);
        }
    }
}*/

// 8. Interfaces, ordenación, IComparer. Crea una clase Cliente con las propiedades nombre, importe facturación,
// fecha de alta, fecha de ultima venta. Los campos de tipo fecha serán del tipo DateTime y solo se tendrán en cuenta el día,
// mes y año. Implementar mediante IComparer un comparador para cada una de las propiedades. Crear una aplicación que mediante
// un menú me permita dar de alta hasta 10 clientes y mostrarlos ordenados según la propiedad que indique el usuario.

class Cliente
{
    public string Nombre { get; set; }
    public double ImporteFacturacion { get; set; }
    public DateTime FechaAlta { get; set; }
    public DateTime FechaUltimaVenta { get; set; }
}

class PorNombre : IComparer<Cliente>
{
    public int Compare(Cliente x, Cliente y)
    {
        return String.Compare(x.Nombre, y.Nombre);
    }
}

class porImporteFacturacion : IComparer<Cliente>
{
    public int Compare(Cliente x, Cliente y)
    {
        return x.ImporteFacturacion.CompareTo(y.ImporteFacturacion);
    }
}

class porFechaAlta : IComparer<Cliente>
{
    public int Compare(Cliente x, Cliente y)
    {
        return x.FechaAlta.CompareTo(y.FechaAlta);
    }
}

class porFechaUltimaVenta : IComparer<Cliente>
{
    public int Compare(Cliente x, Cliente y)
    {
        return x.FechaUltimaVenta.CompareTo(y.FechaUltimaVenta);
    }
}

/*class Program
{
    static void Main()
    {
        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < clientes.Length; i++)
        {
            clientes[i] = new Cliente();
            Console.WriteLine("Introduce el nombre del cliente " + (i + 1));
            clientes[i].Nombre = Console.ReadLine();
            Console.WriteLine("Introduce el importe de facturación del cliente " + (i + 1));
            clientes[i].ImporteFacturacion = double.Parse(Console.ReadLine());
            Console.WriteLine("Introduce la fecha de alta del cliente " + (i + 1));
            clientes[i].FechaAlta = DateTime.Parse(Console.ReadLine());
            Console.WriteLine("Introduce la fecha de la última venta del cliente " + (i + 1));
            clientes[i].FechaUltimaVenta = DateTime.Parse(Console.ReadLine());
        }

        Console.WriteLine("Selecciona la propiedad por la que quieres ordenar los clientes:");
        Console.WriteLine("1. Nombre");
        Console.WriteLine("2. Importe de facturación");
        Console.WriteLine("3. Fecha de alta");
        Console.WriteLine("4. Fecha de última venta");
        int opcion = int.Parse(Console.ReadLine());

        switch (opcion)
        {
            case 1:
                Array.Sort(clientes, new PorNombre());
                break;
            case 2:
                Array.Sort(clientes, new porImporteFacturacion());
                break;
            case 3:
                Array.Sort(clientes, new porFechaAlta());
                break;
            case 4:
                Array.Sort(clientes, new porFechaUltimaVenta());
                break;
        }

        Console.WriteLine("Clientes ordenados:");
        foreach (Cliente cliente in clientes)
        {
            Console.WriteLine(cliente.Nombre);
        }
    }
}*/

//9. Crea una clase llamada Aula que represente un aula con un número determinado de alumnos.
//La clase debe tener un indizador que permita acceder a los alumnos por su índice

class Aula
{
    private string[] alumnos;

    public Aula(int numAlumnos)
    {
        alumnos = new string[numAlumnos];
    }

    public string this[int i]
    {
        get
        {
            return alumnos[i];
        }
    }
}

//10. Crea una clase llamada Libro que contenga una colección de capítulos.
//Implementa un indizador que permita acceder a los capítulos por su índice.

class Libro
{
    private string[] capitulos;

    public Libro(int numCapitulos)
    {
        capitulos = new string[numCapitulos];
    }

    public string this[int i]
    {
        get
        {
            return capitulos[i];
        }
    }
}

//11. Crea una clase llamada Producto que tenga propiedades para Nombre y Precio.
//Luego implementa un comparador que ordene los productos por precio

class Producto : IComparable<Producto>
{
    public string Nombre { get; set; }
    public double Precio { get; set; }

    public int CompareTo(Producto o)
    {
        return Precio.CompareTo(o.Precio);
    }
}

//12. Crea una clase llamada Libro con propiedades para Titulo y Autor.
//Luego, implementa un comparador que ordene los libros alfabéticamente por título.

class Libro1 : IComparable<Libro1>
{
    public string Titulo { get; set; }
    public string Autor { get; set; }

    public int CompareTo(Libro1 o)
    {
        return Titulo.CompareTo(o.Titulo);
    }
}