using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda
{
    public class EstudioRepositorio
    {
        public static List<Estudio> ObtenerEstudios()
        {
            using (TiendaVideojuegosEntities db = new TiendaVideojuegosEntities())
            {
                return db.Estudios.ToList();
            }
        }
    }
}
