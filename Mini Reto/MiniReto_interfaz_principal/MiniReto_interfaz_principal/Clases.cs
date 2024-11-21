using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiniReto_interfaz_principal
{
    public enum Genero { M, F, NB }
    public enum Familia { ADG, FME, IFC, TMA }
    public enum Tipo { Final, Intermodular }


    public class Alumno
    {
        private string id;
        private string nombre;
        private string apellidos;
        private string dni;
        private string email;
        private string contraseña;
        private string telefono;
        private Genero genero;
        private DateTime fechaNacimiento;
        private bool activo;
        private Ciclo ciclo;

        public String Id { get => id; set => id = value; }
        public String Nombre { get => nombre; set => nombre = value; }
        public String Apellidos { get => apellidos; set => apellidos = value; }
        public String Dni { get => dni; set => dni = value; }
        public String Email { get => email; set => email = value; }
        public String Contraseña { get => contraseña; set => contraseña = value; }
        public String Telefono { get => telefono; set => telefono = value; }
        public Genero Genero { get => genero; set => genero = value; }
        public DateTime FechaNacimiento { get => fechaNacimiento; set => fechaNacimiento = value; }
        public bool Activo { get => activo; set => activo = value; }
        public Ciclo Ciclo { get => ciclo; set => ciclo = value; }

    }

    public class Profesor
    {
        private string id;
        private string nombre;
        private string apellidos;
        private string dni;
        private string email;
        private string contraseña;
        private string telefono;
        private Genero genero;
        private DateTime fechaNacimiento;
        private string especialidad;
        private bool activo;
        private bool admin;

        public String Id { get => id; set => id = value; }
        public String Nombre { get => nombre; set => nombre = value; }
        public String Apellidos { get => apellidos; set => apellidos = value; }
        public String Dni { get => dni; set => dni = value; }
        public String Email { get => email; set => email = value; }
        public String Contraseña { get => contraseña; set => contraseña = value; }
        public String Telefono { get => telefono; set => telefono = value; }
        public Genero Genero { get => genero; set => genero = value; }
        public DateTime FechaNacimiento { get => fechaNacimiento; set => fechaNacimiento = value; }
        public String Especialidad { get => especialidad; set => especialidad = value; }
        public bool Activo { get => activo; set => activo = value; }
        public bool Admin { get => admin; set => admin = value; }

    }

    public class Ciclo
    {
        private string codigo;
        private string nombre;
        private string etapa;
        private string titulo;
        private string curriculo;
        private Familia familia;

        public String Codigo { get => codigo; set => codigo = value; }
        public String Nombre { get => nombre; set => nombre = value; }
        public String Etapa { get => etapa; set => etapa = value; }
        public String Titulo { get => titulo; set => titulo = value; }
        public String Curriculo { get => curriculo; set => curriculo = value; }
        public Familia Familia { get => familia; set => familia = value; }

    }

    public class Proyecto
    {
        private string id;
        private string nombre;
        private Tipo tipo;
        private string resumen;
        private int anio_academico;
        private DateTime fecha_presentacion;
        private string logo;
        private string memoria;
        private string archivos;
        private string comentarios;
        private Ciclo ciclo;
        private Profesor tutor;

        public String Id { get => id; set => id = value; }
        public String Nombre { get => nombre; set => nombre = value; }
        public Tipo Tipo { get => tipo; set => tipo = value; }
        public String Resumen { get => resumen; set => resumen = value; }
        public int Anio_academico { get => anio_academico; set => anio_academico = value; }
        public DateTime Fecha_presentacion { get => fecha_presentacion; set => fecha_presentacion = value; }
        public String Logo { get => logo; set => logo = value; }
        public String Memoria { get => memoria; set => memoria = value; }
        public String Archivos { get => archivos; set => archivos = value; }
        public String Comentarios { get => comentarios; set => comentarios = value; }
        public Ciclo Ciclo { get => ciclo; set => ciclo = value; }
        public Profesor Tutor { get => tutor; set => tutor = value; }

    }
}
