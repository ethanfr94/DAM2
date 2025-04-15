using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    public enum TipoPublicacion
    {
        Texto, Foto, Video
    }

    class Publicacion
    {
        private int id;
        private DateTime timeStamp;
        private TipoPublicacion tipo;
        private string url;
        private string titulo;
        private string descripcion;
        private Profesor profesor;

        public int Id { get => id; set => id = value; }
        public DateTime TimeStamp { get => timeStamp; set => timeStamp = value; }
        public TipoPublicacion Tipo { get => tipo; set => tipo = value; }
        public string Url { get => url; set => url = value; }
        public string Titulo { get => titulo; set => titulo = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public Profesor Profesor { get => profesor; set => profesor = value; }

    }
}
