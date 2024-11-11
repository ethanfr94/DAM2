using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ud2Hoja14
{
    public class Pelicula
    {
        public int peliculaId { get; set; }
        public string titulo { get; set; }
        public int anio { get; set; }
        public string genero { get; set; }
    }

    public class Libro
    {
        public int libroId { get; set; }
        public string titulo { get; set; }
        public int anio { get; set; }
        public string autor { get; set; }
    }

    public class Negocio
    {
        private static List<Pelicula> _peliculas;
        private static List<Libro> _libros;

        static Negocio()
        {
            _peliculas = new List<Pelicula>();
            _libros = new List<Libro>();
        }

        public static List<Pelicula> ObtenerPeliculas()
        {
            return _peliculas;
        }

        public static void CrearPelicula(Pelicula nuevaPelicula)
        {
            if (_peliculas.Count > 0)
            {
                nuevaPelicula.peliculaId = _peliculas.Max(x => x.peliculaId) + 1;
            }
            else
            {
                nuevaPelicula.peliculaId = 1;
            }
            _peliculas.Add(nuevaPelicula);
        }

        public static Pelicula ObtenerPelicula(int peliculaId)
        {
            return _peliculas.FirstOrDefault(x => x.peliculaId == peliculaId);
        }

        public static void BorrarPelicula(int peliculaId)
        {
            var borrar = ObtenerPelicula(peliculaId);
            _peliculas.Remove(borrar);
        }

        public static List<Libro> ObtenerLibros()
        {
            return _libros;
        }

        public static void CrearLibro(Libro nuevoLibro)
        {
            if (_libros.Count > 0)
            {
                nuevoLibro.libroId = _libros.Max(x => x.libroId) + 1;
            }
            else
            {
                nuevoLibro.libroId = 1;
            }
            _libros.Add(nuevoLibro);
        }

        public static Libro ObtenerLibro(int libroId)
        {
            return _libros.FirstOrDefault(x => x.libroId == libroId);
        }

        public static void BorrarLibro(int libroId)
        {
            var borrar = ObtenerLibro(libroId);
            _libros.Remove(borrar);
        }
    }

}
