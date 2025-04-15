using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    class Matricula
    {
        private int id;
        private Alumno alumno;
        private Curso curso;
        private DateTime fecha_alta;
        private DateTime fecha_baja;
        private bool aut_fotos;
        private bool beca;

        public int Id { get => id; set => id = value; }
        public Alumno Alumno { get => alumno; set => alumno = value; }
        public Curso Curso { get => curso; set => curso = value; }
        public DateTime Fecha_matricula { get => fecha_alta; set => fecha_alta = value; }
        public DateTime Fecha_baja { get => fecha_baja; set => fecha_baja = value; }
        public bool Aut_fotos { get => aut_fotos; set => aut_fotos = value; }
        public bool Beca { get => beca; set => beca = value; }
    }
}
