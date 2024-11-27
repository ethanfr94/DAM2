using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectStore.APIUtilities
{
    public class Reply
    {
        // Cadena para almacenar el código de estado de la respuesta HTTP
        public string StatusCode { get; set; }

        // Objeto genérico con los datos que devuelve la API
        public object Data { get; set; }
    }

    public enum methodHttp
    {
        GET,    // Método HTTP para obtener datos
        POST,   // Método HTTP para crear datos
        PUT,    // Método HTTP para actualizar datos
        DELETE  // Método HTTP para eliminar datos
    }
}
