using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ud4Hoja6
{
    internal class Reserva
    {
        public int ReservaId { get; set; }

        public string Nombre { get; set; }

        public DateTime Fecha { get; set; }

        public string Telefono { get; set; }

        public int Comensales { get; set; }

        public bool Asiste { get; set; }

        public string Observaciones { get; set; }
    }
}
