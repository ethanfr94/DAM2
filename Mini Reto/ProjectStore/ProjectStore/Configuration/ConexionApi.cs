using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectStore
{
    internal class ConexionApi
    {
        private readonly HttpClient client;

        public ConexionApi()
        {
            client = new HttpClient();
        }

        // Obtiene un profesor basado en su correo y contraseña.
        public async Task<Profesor> ProfesorporCorreoPassword(string correo, string password)
        {
            try
            {
                string url = $"http://localhost:4000/profesores/email/{correo}?contraseña={password}";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Profesor>(responseJson) ?? null;
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene una lista de todos los profesores.
        public async Task<List<Profesor>> ObtenerProfesor()
        {
            try
            {
                string url = "http://localhost:4000/profesores";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Profesor>>(responseJson) ?? new List<Profesor>();
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene un profesor específico por su ID.
        public async Task<Profesor> ObtenerProfesorIndividual(int id)
        {
            try
            {
                string url = $"http://localhost:4000/profesores/{id}";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Profesor>(responseJson) ?? null;
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene un proyecto específico por su ID.
        public async Task<Proyecto> ObtenerProyectoIndividual(int id)
        {
            try
            {
                string url = $"http://localhost:4000/proyectos/idproyecto/{id}";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Proyecto>(responseJson) ?? null;
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene una lista de todos los proyectos.
        public async Task<List<Proyecto>> ObtenerProyectos()
        {
            try
            {
                string url = "http://localhost:4000/proyectos";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Proyecto>>(responseJson) ?? new List<Proyecto>();
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene un alumno específico por su ID.
        public async Task<Alumno> ObtenerAlumnoIndividual(int id)
        {
            try
            {
                string url = $"http://localhost:4000/alumnos/{id}";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Alumno>(responseJson) ?? null;
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene una lista de todos los alumnos.
        public async Task<List<Alumno>> ObtenerAlumnos()
        {
            try
            {
                string url = "http://localhost:4000/alumnos";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Alumno>>(responseJson) ?? new List<Alumno>();
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene un ciclo específico por su ID.
        public async Task<Ciclo> ObtenerCicloIndividual(int id)
        {
            try
            {
                string url = $"http://localhost:4000/ciclos/codciclos/{id}";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<Ciclo>(responseJson) ?? null;
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Obtiene una lista de todos los ciclos.
        public async Task<List<Ciclo>> ObtenerCiclos()
        {
            try
            {
                string url = "http://localhost:4000/ciclos";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();

                string responseJson = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<List<Ciclo>>(responseJson) ?? new List<Ciclo>();
            }
            catch (Exception)
            {
                return null;
            }
        }

        // Actualiza un proyecto con un ID específico.
        public async Task<bool> ActualizarProyecto(int id, Proyecto proyecto)
        {
            return await ActualizarEntidad($"http://localhost:4000/actualizarProyecto{id}", proyecto);
        }

        // Actualiza un alumno con un ID específico.
        public async Task<bool> ActualizarAlumno(int id, Alumno alumno)
        {
            return await ActualizarEntidad($"http://localhost:4000/actualizarAlumno{id}", alumno);
        }

        // Actualiza un profesor con un ID específico.
        public async Task<bool> ActualizarProfesor(int id, Profesor profesor)
        {
            return await ActualizarEntidad($"http://localhost:4000/actualizarProfesor{id}", profesor);
        }

        // Inserta un nuevo proyecto.
        public async Task<bool> InsertarProyecto(Proyecto proyecto)
        {
            return await InsertarEntidad("http://localhost:4000/proyectos", proyecto);
        }

        // Inserta un nuevo alumno.
        public async Task<bool> InsertarAlumno(Alumno alumno)
        {
            return await InsertarEntidad("http://localhost:4000/alumnos", alumno);
        }

        // Inserta un nuevo profesor.
        public async Task<bool> InsertarProfesor(Profesor profesor)
        {
            return await InsertarEntidad("http://localhost:4000/profesores", profesor);
        }

        // Método genérico para actualizar una entidad.
        private async Task<bool> ActualizarEntidad<T>(string url, T entidad)
        {
            try
            {
                string jsonData = JsonConvert.SerializeObject(entidad);
                StringContent content = new StringContent(jsonData, Encoding.UTF8, "application/json");
                HttpResponseMessage response = await client.PutAsync(url, content);
                response.EnsureSuccessStatusCode();
                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }

        // Método genérico para insertar una entidad.
        private async Task<bool> InsertarEntidad<T>(string url, T entidad)
        {
            try
            {
                string jsonData = JsonConvert.SerializeObject(entidad);
                StringContent content = new StringContent(jsonData, Encoding.UTF8, "application/json");
                HttpResponseMessage response = await client.PostAsync(url, content);
                response.EnsureSuccessStatusCode();
                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }
    }
}
