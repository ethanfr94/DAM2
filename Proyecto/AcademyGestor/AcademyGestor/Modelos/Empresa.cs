using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    class Empresa
    {
        private int id;
        private string nombre;
        private string razon_fiscal;
        private string cif;
        private string email;
        private string telefono;
        private string direccion;
        private string localidad;
        private string provincia;
        private string cp;

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Razon_fiscal { get => razon_fiscal; set => razon_fiscal = value; }
        public string Cif { get => cif; set => cif = value; }
        public string Email { get => email; set => email = value; }
        public string Telefono { get => telefono; set => telefono = value; }
        public string Direccion { get => direccion; set => direccion = value; }
        public string Localidad { get => localidad; set => localidad = value; }
        public string Provincia { get => provincia; set => provincia = value; }
        public string Cp { get => cp; set => cp = value; }

    }
}
