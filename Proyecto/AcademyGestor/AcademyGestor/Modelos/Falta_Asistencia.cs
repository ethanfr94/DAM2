using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    class Falta_Asistencia
    {
        private int id;
        private Alumno alumno;
        private Curso curso;
        private DateTime fecha;

        public int Id { get => id; set => id = value; }
        public Alumno Alumno { get => alumno; set => alumno = value; }
        public Curso Curso { get => curso; set => curso = value; }
        public DateTime Fecha { get => fecha; set => fecha = value; }


    }
}
