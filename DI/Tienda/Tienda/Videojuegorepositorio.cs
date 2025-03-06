using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda
{
    public class Videojuegorepositorio
    {
        public static List<Videojuego> ObtenerVideojuegos()
        {
            using (TiendaVideojuegosEntities db = new TiendaVideojuegosEntities())
            {
                return db.Videojuegos.ToList();
            }
        }
    }
}
