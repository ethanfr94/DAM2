using System;

namespace WpfEjercicio04
{
    public class Reserva
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
