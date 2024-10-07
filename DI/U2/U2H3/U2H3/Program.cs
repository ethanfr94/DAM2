
using System.Diagnostics.Contracts;
using static System.Runtime.InteropServices.JavaScript.JSType;

class programa
{
    static void Main(string[] args)
    {
        List<animal> animales = new List<animal>();
        animales.Add(new perro());
        animales.Add(new gato());
        animales.Add(new pato());
        foreach (animal a in animales)
        {
            a.sonidoAnimal();
        }
    }
}

/// <summary>
/// ////////////////////////////////////////////////////////
/// </summary>

//1. Crea una clase Figuras y varias clases derivadas para calcular el área y el perímetro de rectángulo, triángulo, cuadrado, rombo y trapecio. 

abstract class Figuras
{
    protected double b {  get; set; }
    protected double h {  get; set; }

    public Figuras(double b, double h)
    {
        this.b = b;
        this.h = h;
    }
    public abstract double area();

}

class rectangulo : Figuras
{
    public rectangulo(double b, double h) : base(b, h)
    {
    }

    public override double area()
    {
        return b * h;
    }
}

class triangulo : Figuras
{
    public triangulo(double b, double h) : base(b, h)
    {
    }

    public override double area()
    {
        return b * h / 2;
    }
}

class  Rombo : Figuras
{
    public Rombo(double b, double h) : base(b, h)
    {
    }

    public override double area()
    {
        return (b * (h*2))/2;
    }
}

class Cuadrado : Figuras
{
    public Cuadrado(double b, double h) : base(b, h)
    {
    }

    public override double area()
    {
        return b * h;
    }
}

class Trapecio : Figuras
{
    public double b2 { get; set; }
    public Trapecio(double b2, double b, double h) : base(b, h)
    {
        this.b2 = b2;
    }

    public override double area()
        {
            return ((b + b2) / 2) * h;
        }
    
}

/// <summary>
/// ////////////////////////////////////////////////////////
/// </summary>

//2. Crea una clase Animal y dos clases derivadas, Perro y Gato, que implementen un método HacerSonido().
//3. Crea una lista Animal y añade diferentes tipos de animales. Usa polimorfismo para llamar al método HacerSonido().
abstract class animal
{
    public abstract void sonidoAnimal();
}

    class perro : animal
    {
        public override void sonidoAnimal()
        {
            Console.WriteLine("guau guau");
        }
    }

    class gato : animal
    {  
        public override void sonidoAnimal()
        {
            Console.WriteLine("miau miau");
        }
    }

    class pato : animal
    {
        public override void sonidoAnimal()
        {
        Console.WriteLine("cuac cuac");
    }
}

/// <summary>
/// ////////////////////////////////////////////////////////
/// </summary>

//4. Crea una clase Libro que contenga atributos y métodos para gestionar un libro.
class Libro
{
    private string titulo { get; set; }
    private int paginas { get; set; }

    public virtual void leerLibro()
    {
        Console.WriteLine("leyendo libro");
    }
}

/// <summary>
/// ////////////////////////////////////////////////////////
/// </summary>

//5.	Escribe un programa que permita gestionar una agenda, para ello hará falta definir las entidades Agenda, Contacto y Cita.
//La entidad Agenda consta de los siguientes atributos y métodos:
//-Contactos->colección con los contactos de la agenda
//-CrearContacto(nombre, teléfono, correo)-> crea un nuevo contacto asignándole como Id el tamaño de la propiedad Contactos + 1.
//-BuscarContacto(nombre):Contacto
//- BorrarContacto(contacto)
//- VerContactos()
//- VerCitas()

class Agenda
{
    private List<Contacto> contactos = new List<Contacto>();
    private List<Cita> citas = new List<Cita>();

    public void CrearContacto(string nombre, string telefono, string correo)
    {
        contactos.Add(new Contacto(nombre, telefono, correo));
    }

    public Contacto BuscarContacto(string nombre)
    {
        Contacto contacto = null;
        foreach (Contacto c in contactos)
        {
            if (c.nombre == nombre)
            {
                contacto = c;
            }            
        }
        return contacto;
    }

    public void BorrarContacto(Contacto contacto)
    {
        if (contactos.Remove(contacto))
        {
            Console.WriteLine("Contacto borrado");
        }
        else
        {
            Console.WriteLine("Error al borrar contacto");
        }
    }

    public void VerContactos()
    {
        foreach (Contacto c in contactos)
        {
            Console.WriteLine(c.nombre);
        }
    }
}

//La entidad Contacto consta de los siguientes atributos y métodos:
//-Id - Nombre - Teléfono - Correo - Citas->colección con las citas de la agenda
//-CrearCita(fechaCita, lugar) -> crea una nueva Cita asignándole la el IdContacto.
//-BuscarCita(fechaCita):Cita
//- BorrarCita(Cita)
//- VerCitas()

class Contacto
{
    public int id { get; set; }
    public string nombre { get; set; }
    public string telefono { get; set; }
    public string correo { get; set; }

    private List<Cita> citas = new List<Cita>();

    public Contacto(string nombre, string telefono, string correo)
    {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public void CrearCita(DateTime fechaCita, string lugar)
    {
        citas.Add(new Cita(fechaCita, lugar));
    }

    public Cita BuscarCita(DateTime fechaCita)
    {
        Cita cita = null;
        foreach (Cita c in citas)
        {
            if (c.fecha == fechaCita)
            {
                cita = c;
            }
        }
        return cita;
    }

    public void BorrarCita(Cita cita)
    {
        citas.Remove(cita);
    }

    public void VerCitas()
    {
        foreach (Cita c in citas)
        {
            Console.WriteLine(c.fecha);
        }
    }

    public void datosContacto()
    {
        Console.WriteLine("Nombre: " + nombre);
        Console.WriteLine("Telefono: " + telefono);
        Console.WriteLine("Correo: " + correo);
    }
}

//La entidad Cita consta de los siguientes atributos y métodos:
//-IdContacto - Fecha - Lugar

class Cita
{
    public int idContacto { get; set; }
    public DateTime fecha { get; set; }
    public string lugar { get; set; }

    public Cita(DateTime fecha, string lugar)
    {
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public void datosCita()
    {
        Console.WriteLine("Fecha: " + fecha);
        Console.WriteLine("Lugar: " + lugar);
    }
}

//Mediante un menú se podrán realizar las tareas de mantenimiento de la agenda.
//Evidentemente, tras seleccionar un contacto dispondremos de un submenú para gestión de sus Citas correspondientes.

class Program
{
    static void Main(string[] args)
    {
        Agenda agenda = new Agenda();
        int opcion = 0;
        do
        {
            Console.WriteLine("""
                1. Crear contacto
                2. Buscar contacto
                3. Ver contactos
                4. Salir
                """);            
            opcion = Convert.ToInt32(Console.ReadLine());
            switch (opcion)
            {
                case 1:
                    Console.WriteLine("Nombre:");
                    string nombre = Console.ReadLine();
                    Console.WriteLine("Telefono:");
                    string telefono = Console.ReadLine();
                    Console.WriteLine("Correo:");
                    string correo = Console.ReadLine();
                    agenda.CrearContacto(nombre, telefono, correo);
                    break;
                case 2:
                    Console.WriteLine("Nombre:");
                    string nombreBuscar = Console.ReadLine();
                    Contacto contacto = agenda.BuscarContacto(nombreBuscar);
                    if (contacto != null)
                    {
                        contacto.datosContacto();
                        Console.WriteLine("""
                        1. Ver citas
                        2. Crear cita
                        3. Buscar cita por fecha
                        4. Borrar contacto
                        5. Salir
                        """);
                        int opcionContacto = Convert.ToInt32(Console.ReadLine());
                        switch (opcionContacto)
                        {
                            case 1:
                                contacto.VerCitas();
                                break;
                            case 2:
                                Console.WriteLine("Fecha:");
                                DateTime fecha = Convert.ToDateTime(Console.ReadLine());
                                Console.WriteLine("Lugar:");
                                string lugar = Console.ReadLine();
                                contacto.CrearCita(fecha, lugar);
                                break;
                            case 3:
                                Console.WriteLine("Fecha:");
                                DateTime fechaBuscar = Convert.ToDateTime(Console.ReadLine());
                                Cita cita = contacto.BuscarCita(fechaBuscar);
                                if (cita != null)
                                {
                                    cita.datosCita();
                                    Console.WriteLine("borrar cita? (s/n)");
                                    string borrar = Console.ReadLine();
                                    if (borrar == "s")
                                    {
                                        contacto.BorrarCita(cita);
                                    }
                                }
                                else
                                {
                                    Console.WriteLine("Cita no encontrada");
                                }
                                break;
                            case 4:                                
                                agenda.BorrarContacto(contacto);
                                break;
                            case 6:
                                break;
                        }
                    }
                    else
                    {
                        Console.WriteLine("Contacto no encontrado");
                    }
                    break;
                case 3:
                    agenda.VerContactos();
                    break;
                case 4:
                    Console.WriteLine("Cerrando Agenda");
                    break;
            }
        } while (opcion != 6);
    }
}



