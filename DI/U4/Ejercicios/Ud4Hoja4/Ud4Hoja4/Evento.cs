using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ud4Hoja4
{
    public enum TipoEventoEnum
    {
        Todos,
        Menor10,
        Mayor16,
        Mayor18
    }
    public class Evento
    {
        public string Nombre { get; set; }
        public DateTime Fecha { get; set; }
        public DateTime Hora { get; set; }
        public int Aforo { get; set; }
        public TipoEventoEnum Tipo { get; set; }
        public string Descripcion { get; set; }
        public bool Seguridad { get; set; }
        public bool Bar { get; set; }
        public bool Montaje { get; set; }
        public bool Sanitarios { get; set; }
        public string Promotor { get; set; }

        

    }
}
