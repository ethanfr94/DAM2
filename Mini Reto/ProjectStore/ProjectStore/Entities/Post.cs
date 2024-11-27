using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectStore.Entities
{
    public class Post
    {
        // ID único del post
        public int id { get; set; }

        // ID del usuario al que pertenece el post
        public int userId { get; set; }

        // Título del post
        public string title { get; set; }

        // Cuerpo o contenido del post
        public string body { get; set; }
    }
}
