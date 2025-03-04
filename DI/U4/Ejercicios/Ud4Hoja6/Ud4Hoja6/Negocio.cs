using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Ud4Hoja6
{
    internal class Negocio
    {

        public int _reservaId { get; set; }
        public List<Reserva> _reservas { get; set; }


        public Negocio()
        {
            _reservas = new List<Reserva>();
            _reservaId = 0;
        }

        public void BorrarReserva(int reservaId)
        {
            Reserva reserva = _reservas.Find(r => r.ReservaId == reservaId);
            _reservas.Remove(reserva);
        }

        public void CrearReserva(Reserva reserva)
        {
            reserva.ReservaId = SiguienteReservaId();
            _reservas.Add(reserva);
        }

        public Reserva ObtenerReserva(int reservaId)
        {
            return _reservas.Find(r => r.ReservaId == reservaId);
        }

        public List<Reserva> ObtenerReservas()
        {
            return _reservas;
        }

        private int SiguienteReservaId()
        {
            return ++_reservaId;
        }
    }
}
