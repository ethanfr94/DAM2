using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class Principal : Form
    {
        // Listas estáticas que almacenan los objetos de alumnos, profesores, proyectos y ciclos
        public static List<Alumno> alumnos;
        public static List<Profesor> profesores;
        public static List<Proyecto> proyectos;
        public static List<Ciclo> ciclos;

        // Variable para almacenar el correo del usuario que inició sesión        
        Profesor prof = null;

        public Principal(Profesor p)
        {
            InitializeComponent();
            prof = p;
            this.Text = prof.Nombre + " " + prof.Apellidos;
            esAdmin(p);            
            
        }

        private void esAdmin(Profesor p)
        {
            if (p.Admin)
            {
                 addAlumnoToolStripMenuItem.Visible = true;
                addProfesorToolStripMenuItem.Visible = true;
                addProyectosToolStripMenuItem.Visible = true;
                modificarAlumnoToolStripMenuItem.Visible = true;
                modificarProfesorToolStripMenuItem.Visible = true;
                modificarProyectosToolStripMenuItem.Visible = true;          
            }
            
        }

        // Evento para visualizar los ciclos
        private async void tsmiVerCiclos_Click(object sender, EventArgs e)
        {
            ltvListaPrincipal.Items.Clear();
            ltvListaPrincipal.Columns.Clear();

            ltvListaPrincipal.Columns.Add("Codigo", 65);
            ltvListaPrincipal.Columns.Add("Ciclo", 100);
            ltvListaPrincipal.Columns.Add("Etapa", 50);
            ltvListaPrincipal.Columns.Add("Titulo", 100);
            ltvListaPrincipal.Columns.Add("Curriculo", 100);
            ltvListaPrincipal.Columns.Add("Familia", 100);
            ciclos = await new ConexionApi().ObtenerCiclos();
            cargaCiclo();
        }

        // Método para cargar los ciclos en el ListView
        public void cargaCiclo()
        {
            ltvListaPrincipal.Items.Clear();
            foreach (Ciclo ciclo in ciclos)
            {
                ListViewItem item = new ListViewItem(ciclo.Codigo);

                item.SubItems.Add(ciclo.Nombre);
                item.SubItems.Add(ciclo.Etapa);
                item.SubItems.Add(ciclo.Titulo);
                item.SubItems.Add(ciclo.Curriculo);
                item.SubItems.Add(ciclo.Familia.ToString());
                ltvListaPrincipal.Items.Add(item);
            }
        }

        // Evento para visualizar los profesores
        private async void tsmiVerProfesores_Click(object sender, EventArgs e)
        {
            ltvListaPrincipal.Items.Clear();
            ltvListaPrincipal.Columns.Clear();

            ltvListaPrincipal.Columns.Add("Id", 25);
            ltvListaPrincipal.Columns.Add("Nombre", 100);
            ltvListaPrincipal.Columns.Add("Apellidos", 100);
            ltvListaPrincipal.Columns.Add("Dni", 100);
            ltvListaPrincipal.Columns.Add("Email", 100);
            ltvListaPrincipal.Columns.Add("Contraseña", 100);
            ltvListaPrincipal.Columns.Add("Telefono", 100);
            ltvListaPrincipal.Columns.Add("Genero", 50);
            ltvListaPrincipal.Columns.Add("Fecha de Nacimiento", 100);
            ltvListaPrincipal.Columns.Add("Especialidad", 100);
            ltvListaPrincipal.Columns.Add("Activo", 25);
            ltvListaPrincipal.Columns.Add("Admin", 25);
            profesores = await new ConexionApi().ObtenerProfesor();
            if (profesores != null)
            {
                cargaProfesores();
            }
            
        }

        // Método para cargar los profesores en el ListView
        public void cargaProfesores()
        {
            ltvListaPrincipal.Items.Clear();
            foreach (Profesor profesor in profesores)
            {
                ListViewItem item = new ListViewItem(profesor.Id);
                item.SubItems.Add(profesor.Nombre);
                item.SubItems.Add(profesor.Apellidos);
                item.SubItems.Add(profesor.Dni);
                item.SubItems.Add(profesor.Email);
                item.SubItems.Add(profesor.Contraseña);
                item.SubItems.Add(profesor.Telefono);
                item.SubItems.Add(profesor.Genero.ToString());
                item.SubItems.Add(profesor.FechaNacimiento.ToString());
                item.SubItems.Add(profesor.Especialidad);
                item.SubItems.Add(profesor.Activo.ToString());
                item.SubItems.Add(profesor.Admin.ToString());
                ltvListaPrincipal.Items.Add(item);
            }
        }

        // Evento para visualizar los alumnos
        private async void tsmiVerAlumnos_Click(object sender, EventArgs e)
        {
            ltvListaPrincipal.Items.Clear();
            ltvListaPrincipal.Columns.Clear();

            ltvListaPrincipal.Columns.Add("Id", 25);
            ltvListaPrincipal.Columns.Add("Nombre", 100);
            ltvListaPrincipal.Columns.Add("Apellidos", 100);
            ltvListaPrincipal.Columns.Add("Dni", 100);
            ltvListaPrincipal.Columns.Add("Email", 100);
            ltvListaPrincipal.Columns.Add("Contraseña", 100);
            ltvListaPrincipal.Columns.Add("Telefono", 100);
            ltvListaPrincipal.Columns.Add("Genero", 50);
            ltvListaPrincipal.Columns.Add("Fecha de Nacimiento", 100);
            ltvListaPrincipal.Columns.Add("Activo", 25);
            ltvListaPrincipal.Columns.Add("Admin", 25);
            alumnos = await new ConexionApi().ObtenerAlumnos();
            if (alumnos != null)
            {
                cargaAlumnos();
            }
        }

        // Método para cargar los alumnos en el ListView
        public void cargaAlumnos()
        {
            ltvListaPrincipal.Items.Clear();
            foreach (Alumno alumno in alumnos)
            {
                ListViewItem item = new ListViewItem(alumno.Id);

                item.SubItems.Add(alumno.Nombre);
                item.SubItems.Add(alumno.Apellidos);
                item.SubItems.Add(alumno.Dni);
                item.SubItems.Add(alumno.Email);
                item.SubItems.Add(alumno.Contraseña);
                item.SubItems.Add(alumno.Telefono);
                item.SubItems.Add(alumno.Genero.ToString());
                item.SubItems.Add(alumno.FechaNacimiento.ToString());
                item.SubItems.Add(alumno.Activo.ToString());
                ltvListaPrincipal.Items.Add(item);
            }
        }

        // Evento para visualizar los proyectos
        private async void verProyectosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ltvListaPrincipal.Items.Clear();
            ltvListaPrincipal.Columns.Clear();

            ltvListaPrincipal.Columns.Add("Id", 35);
            ltvListaPrincipal.Columns.Add("Nombre", 100);
            ltvListaPrincipal.Columns.Add("Tipo", 100);
            ltvListaPrincipal.Columns.Add("Resumen", 100);
            ltvListaPrincipal.Columns.Add("Año Academico", 100);
            ltvListaPrincipal.Columns.Add("Fecha Presentacion", 100);
            ltvListaPrincipal.Columns.Add("Logo", 100);
            ltvListaPrincipal.Columns.Add("Memoria", 100);
            ltvListaPrincipal.Columns.Add("Archivos", 100);
            ltvListaPrincipal.Columns.Add("Comentarios", 100);
            ltvListaPrincipal.Columns.Add("Ciclo", 35);
            ltvListaPrincipal.Columns.Add("Tutor", 35);
            proyectos = await new ConexionApi().ObtenerProyectos();
            
            if (proyectos != null)
            {
                cargaProyectos();
            }
        }

        // Método para cargar los proyectos en el ListView
        public void cargaProyectos()
        {
            ltvListaPrincipal.Items.Clear();
            foreach (Proyecto proyecto in proyectos)
            {
                ListViewItem item = new ListViewItem(proyecto.Id);
                item.SubItems.Add(proyecto.Nombre);
                item.SubItems.Add(proyecto.Tipo.ToString());
                item.SubItems.Add("");
                item.SubItems.Add(proyecto.Anio_academico.ToString());
                item.SubItems.Add("proyecto.Fecha_presentacion.ToString()");
                item.SubItems.Add("proyecto.Logo");
                item.SubItems.Add("proyecto.Memoria");
                item.SubItems.Add("proyecto.Archivos");
                item.SubItems.Add("proyecto.Comentarios");
                item.SubItems.Add(proyecto.Ciclo.Codigo);
                item.SubItems.Add(proyecto.Tutor.Id);

                ltvListaPrincipal.Items.Add(item);
            }
        }

        // Evento para cerrar sesión
        private void OnClickLogout(object sender, EventArgs e)
        {
            // Abre el formulario principal en un hilo separado para evitar bloquear la UI
            Thread thread = new Thread(() =>
            {
                Application.SetCompatibleTextRenderingDefault(false);
                Application.EnableVisualStyles();

                Login login = new Login();
                Application.Run(login);
            });

            thread.SetApartmentState(ApartmentState.STA);
            thread.Start();
            this.Close();
        }

        // Método para actualizar los objetos de alumnos, profesores, proyectos y ciclos
        //public static void refresh()
        //{
        //    Principal principal = new Principal();
        //    principal.cargaAlumnos();
        //    principal.cargaProfesores();
        //    principal.cargaProyectos();
        //    principal.cargaCiclo();
        //}

        // Métodos para abrir formularios de adición de alumnos, profesores y proyectos
        private void añadirAlumnoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AddAlumno addAlumno = new AddAlumno();
            addAlumno.ShowDialog();
        }

        private void añadirProfesorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AddProfesor addProfesor = new AddProfesor();
            addProfesor.ShowDialog();
        }

        private void añadirProyectosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AddProyecto addProyecto = new AddProyecto();
            addProyecto.ShowDialog();
        }

        private async void modificarProfesorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Profesor profesor;
            foreach (Profesor p in profesores)
            {
                if (p.Id == ltvListaPrincipal.SelectedItems[0].SubItems[0].Text)
                {
                    profesor = p;
                    ModProfesor modProf = new ModProfesor(p);
                    modProf.ShowDialog();
                }
            }
            if (DialogResult == DialogResult.OK)
            {
               
                profesores = await new ConexionApi().ObtenerProfesor();
                cargaProfesores();
            }
        }

        private async void modificarAlumnoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            foreach (Alumno al in alumnos)
            {
                if (al.Id == ltvListaPrincipal.SelectedItems[0].SubItems[0].Text)
                {
                    ModAlumno modAlumno = new ModAlumno(al);
                    modAlumno.ShowDialog();
                }
            }
            if (DialogResult == DialogResult.OK)
            {
                alumnos = await new ConexionApi().ObtenerAlumnos();
                cargaAlumnos();
            }
        }
        private async void modificarProyectosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            foreach (Proyecto p in proyectos)
            {
                if (p.Id == ltvListaPrincipal.SelectedItems[0].SubItems[0].Text)
                {
                    ModProyecto modProyecto = new ModProyecto(p);
                    modProyecto.ShowDialog();
                }
            }
            if (DialogResult == DialogResult.OK)
            {
                proyectos = await new ConexionApi().ObtenerProyectos();
                cargaProyectos();
            }
        }

        // evento que habilita los botones de modificacion al seleccionar un elemento de la lista
        private void ltvListaPrincipal_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (ltvListaPrincipal.SelectedItems.Count > 0 && ltvListaPrincipal.SelectedItems[0].SubItems[11].Text == prof.Id || prof.Admin)
            {                       
                modificarAlumnoToolStripMenuItem.Enabled = true;
                modificarProfesorToolStripMenuItem.Enabled = true;
                modificarProyectosToolStripMenuItem.Enabled = true;
            }

        }

        
    }
}
