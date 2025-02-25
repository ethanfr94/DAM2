using System;
using System.Collections.Generic;
using System.Linq;

namespace WpfEjercicio04
{
    public class Negocio
    {
        private int _reservaId = 0;
        private List<Reserva> reservas;

        public Negocio()
        {
            this.reservas = new List<Reserva>();
        }

        private int SiguienteReservaId()
        {
            return ++_reservaId;
        }

        public Reserva[] ObtenerReservas()
        {
            return this.reservas.ToArray();
        }

        public Reserva ObtenerReserva(int reservaId)
        {
            return reservas.FirstOrDefault(x => x.ReservaId == reservaId);
        }

        public void CrearReserva(Reserva reserva)
        {
            reserva.ReservaId = SiguienteReservaId();
            reservas.Add(reserva);
        }

        //public void ActualizarReserva(Reserva reserva)
        //{
        //    Reserva 
        //}

        public void BorrarReserva(int reservaId)
        {
            Reserva borrar = this.ObtenerReserva(reservaId);
            if(borrar != null)
            {
                this.reservas.Remove(borrar);
            }
        }
    }
}
