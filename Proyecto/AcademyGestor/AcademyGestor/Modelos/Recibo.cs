using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    class Recibo
    {
        private int id;
        private Matricula matricula;
        private string detalle;
        private DateTime fecha;
        private double importe;
        private bool descuento;
        private bool pagado;
        public int Id { get => id; set => id = value; }
        public Matricula Matricula { get => matricula; set => matricula = value; }
        public string Detalle { get => detalle; set => detalle = value; }
        public DateTime Fecha { get => fecha; set => fecha = value; }
        public double Importe { get => importe; set => importe = value; }
        public bool Descuento { get => descuento; set => descuento = value; }
        public bool Pagado { get => pagado; set => pagado = value; }
    }
}
