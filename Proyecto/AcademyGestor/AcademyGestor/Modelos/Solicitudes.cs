using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    class Solicitudes
    {
        private int id;
        private DateTime fecha;
        private Curso curso;
        private string nombre;
        private string apellido1;
        private string apellido2;
        private string dni;
        private DateTime fecha_nac;
        private string direccion;
        private string localidad;
        private string email;
        private string telefono;
        private Tutor tutor;
        private bool prot_datos;
        private bool aut_fotos;
        private bool whatsapp;
        private bool com_comerciales;
        private bool beca;

        public int Id { get => id; set => id = value; }
        public DateTime Fecha { get => fecha; set => fecha = value; }
        public Curso Curso { get => curso; set => curso = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Apellido1 { get => apellido1; set => apellido1 = value; }
        public string Apellido2 { get => apellido2; set => apellido2 = value; }
        public string Dni { get => dni; set => dni = value; }
        public DateTime Fecha_nac { get => fecha_nac; set => fecha_nac = value; }
        public string Direccion { get => direccion; set => direccion = value; }
        public string Localidad { get => localidad; set => localidad = value; }
        public string Email { get => email; set => email = value; }
        public string Telefono { get => telefono; set => telefono = value; }
        public Tutor Tutor { get => tutor; set => tutor = value; }
        public bool Prot_datos { get => prot_datos; set => prot_datos = value; }
        public bool Aut_fotos { get => aut_fotos; set => aut_fotos = value; }
        public bool Whatsapp { get => whatsapp; set => whatsapp = value; }
        public bool Com_comerciales { get => com_comerciales; set => com_comerciales = value; }
        public bool Beca { get => beca; set => beca = value; }

    }
}
