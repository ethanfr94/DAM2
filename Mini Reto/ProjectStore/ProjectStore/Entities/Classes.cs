using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace ProjectStore
{
    public enum Genero
    {
        M,
        F,
        NB
    }

    public enum Familia
    {
        ADG,
        FME,
        IFC,
        TMA
    }

    public enum Tipo
    {
        Final,
        Intermodular
    }

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

        [JsonProperty("idAlumno")]
        public string Id { get => id; set => id = value; }

        [JsonProperty("nombre")]
        public string Nombre { get => nombre; set => nombre = value; }

        [JsonProperty("apellidos")]
        public string Apellidos { get => apellidos; set => apellidos = value; }

        [JsonProperty("dni")]
        public string Dni { get => dni; set => dni = value; }

        [JsonProperty("email")]
        public string Email { get => email; set => email = value; }

        [JsonProperty("password")]
        public string Contraseña { get => contraseña; set => contraseña = value; }

        [JsonProperty("telefono")]
        public string Telefono { get => telefono; set => telefono = value; }

        [JsonProperty("genero")]
        public Genero Genero { get => genero; set => genero = value; }

        [JsonProperty("fechaNac")]
        public DateTime FechaNacimiento { get => fechaNacimiento; set => fechaNacimiento = value; }

        [JsonProperty("activo")]
        public bool Activo { get => activo; set => activo = value; }

        [JsonProperty("cicloActual")]
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

        [JsonProperty("idProfesor")]
        public string Id { get => id; set => id = value; }

        [JsonProperty("nombre")]
        public string Nombre { get => nombre; set => nombre = value; }

        [JsonProperty("apellidos")]
        public string Apellidos { get => apellidos; set => apellidos = value; }

        [JsonProperty("dni")]
        public string Dni { get => dni; set => dni = value; }

        [JsonProperty("email")]
        public string Email { get => email; set => email = value; }

        [JsonProperty("password")]
        public string Contraseña { get => contraseña; set => contraseña = value; }

        [JsonProperty("telefono")]
        public string Telefono { get => telefono; set => telefono = value; }

        [JsonProperty("genero")]
        public Genero Genero { get => genero; set => genero = value; }

        [JsonProperty("fechaNac")]
        public DateTime FechaNacimiento { get => fechaNacimiento; set => fechaNacimiento = value; }

        [JsonProperty("especialidad")]
        public string Especialidad { get => especialidad; set => especialidad = value; }

        [JsonProperty("activo")]
        public bool Activo { get => activo; set => activo = value; }

        [JsonProperty("admin")]
        public bool Admin { get => admin; set => admin = value; }
    }

    public class Ciclo
    {
        private string codigo;
        private string nombre;
        private string etapa;
        private string titulo;
        private string curriculo;
        private string familia;

        [JsonProperty("codCiclo")]
        public string Codigo { get => codigo; set => codigo = value; }

        [JsonProperty("nombre")]
        public string Nombre { get => nombre; set => nombre = value; }

        [JsonProperty("etapa")]
        public string Etapa { get => etapa; set => etapa = value; }

        [JsonProperty("titulo")]
        public string Titulo { get => titulo; set => titulo = value; }

        [JsonProperty("curriculo")]
        public string Curriculo { get => curriculo; set => curriculo = value; }

        [JsonProperty("familia")]
        public string Familia { get => familia; set => familia = value; }
    }

    public class Proyecto
    {
        private string id;
        private string nombre;
        private Tipo tipo;
        private string resumen;
        private int? anioAcademico;
        private DateTime? fechaPresentacion;
        private string logo;
        private string memoria;
        private string archivos;
        private string comentarios;
        private Ciclo ciclo;
        private Profesor? tutor;

        [JsonProperty("id")]
        public string Id { get => id; set => id = value; }

        [JsonProperty("nombre")]
        public string Nombre { get => nombre; set => nombre = value; }

        [JsonProperty("tipo")]
        public Tipo Tipo { get => tipo; set => tipo = value; }

        [JsonProperty("resumen")]
        public string Resumen { get => resumen; set => resumen = value; }

        [JsonProperty("anio_academico")]
        public int? AnioAcademico { get => anioAcademico; set => anioAcademico = value; }

        [JsonProperty("fecha_presentacion")]
        public DateTime? FechaPresentacion { get => fechaPresentacion; set => fechaPresentacion = value; }

        [JsonProperty("logo")]
        public string Logo { get => logo; set => logo = value; }

        [JsonProperty("memoria")]
        public string Memoria { get => memoria; set => memoria = value; }

        [JsonProperty("archivos")]
        public string Archivos { get => archivos; set => archivos = value; }

        [JsonProperty("comentarios")]
        public string Comentarios { get => comentarios; set => comentarios = value; }

        [JsonProperty("ciclo")]
        public Ciclo Ciclo { get => ciclo; set => ciclo = value; }

        [JsonProperty("tutor")]
        public Profesor? Tutor { get => tutor; set => tutor = value; }
    }
}
