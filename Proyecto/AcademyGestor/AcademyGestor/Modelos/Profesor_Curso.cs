using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{
    class Profesor_Curso
    {
        private int id;
        private Profesor profesor;
        private Curso curso;
        private bool coordinador;

        public int Id { get => id; set => id = value; }
        public Profesor Profesor { get => profesor; set => profesor = value; }
        public Curso Curso { get => curso; set => curso = value; }
        public bool Coordinador { get => coordinador; set => coordinador = value; }
    }
}
