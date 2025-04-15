using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AcademyGestor.Modelos
{

    public enum Rol
    {
        Admin, User
    }

    class Usuario
    {
        private int id;
        private string user;
        private string pass;
        private Rol rol;

        public int Id { get => id; set => id = value; }
        public string User { get => user; set => user = value; }
        public string Pass { get => pass; set => pass = value; }
        public Rol Rol { get => rol; set => rol = value; }

    }
}
