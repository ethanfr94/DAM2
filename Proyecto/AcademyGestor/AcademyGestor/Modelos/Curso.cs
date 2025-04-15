using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    class Curso
    {
        private int id;
        private string codCurso;
        private string nombre;
        private string descripcion;
        private string horario;
        private Tipo tipo;
        private bool activo;

        public int Id { get => id; set => id = value; }
        public string CodCurso { get => codCurso; set => codCurso = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public string Horario { get => horario; set => horario = value; }
        public Tipo Tipo { get => tipo; set => tipo = value; }
        public bool Activo { get => activo; set => activo = value; }


    }
}
