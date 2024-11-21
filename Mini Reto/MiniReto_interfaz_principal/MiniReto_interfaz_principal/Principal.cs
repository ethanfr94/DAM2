namespace MiniReto_interfaz_principal
{
    public partial class Principal : Form
    {
        public static List<Alumno> alumnos = new List<Alumno>();
        public static List<Profesor> profesores = new List<Profesor>();
        public static List<Proyecto> proyectos = new List<Proyecto>();
        public static List<Ciclo> ciclos = new List<Ciclo>();

        public Principal()
        {
            InitializeComponent();
        }


        private void tsmiVerCiclos_Click(object sender, EventArgs e)
        {
            ltvListaPrincipal.Items.Clear();
            ltvListaPrincipal.Columns.Clear();
            ltvListaPrincipal.Columns.Add("Codigo", 35);
            ltvListaPrincipal.Columns.Add("Ciclo", 100);
            ltvListaPrincipal.Columns.Add("Etapa", 50);
            ltvListaPrincipal.Columns.Add("Titulo", 100);
            ltvListaPrincipal.Columns.Add("Curriculo", 100);
            ltvListaPrincipal.Columns.Add("Familia", 100);
            cargaCiclo();
        }

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

        private void tsmiVerProfesores_Click(object sender, EventArgs e)
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
            ltvListaPrincipal.Columns.Add("Genero", 25);
            ltvListaPrincipal.Columns.Add("Fecha de Nacimiento", 100);
            ltvListaPrincipal.Columns.Add("Especialidad", 100);
            ltvListaPrincipal.Columns.Add("Activo", 25);
            ltvListaPrincipal.Columns.Add("Admin", 25);
            cargaProfesores();
        }

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

        private void tsmiVerAlumnos_Click(object sender, EventArgs e)
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
            ltvListaPrincipal.Columns.Add("Genero", 35);
            ltvListaPrincipal.Columns.Add("Fecha de Nacimiento", 100);
            ltvListaPrincipal.Columns.Add("Activo", 25);
            ltvListaPrincipal.Columns.Add("Admin", 25);
            cargaAlumnos();
        }

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

        private void verProyectosToolStripMenuItem_Click(object sender, EventArgs e)
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
            cargaProyectos();
        }

        public void cargaProyectos()
        {
            ltvListaPrincipal.Items.Clear();
            foreach (Proyecto proyecto in proyectos)
            {
                ListViewItem item = new ListViewItem(proyecto.Id);
                item.SubItems.Add(proyecto.Nombre);
                item.SubItems.Add(proyecto.Tipo.ToString());
                item.SubItems.Add(proyecto.Resumen);
                item.SubItems.Add(proyecto.Anio_academico.ToString());
                item.SubItems.Add(proyecto.Fecha_presentacion.ToString());
                item.SubItems.Add(proyecto.Logo);
                item.SubItems.Add(proyecto.Memoria);
                item.SubItems.Add(proyecto.Archivos);
                item.SubItems.Add(proyecto.Comentarios);
                item.SubItems.Add(proyecto.Ciclo.ToString());
                item.SubItems.Add(proyecto.Tutor.ToString());
                ltvListaPrincipal.Items.Add(item);
            }
        }

        public static void refresh()
        {
            Principal principal = new Principal();
            principal.cargaAlumnos();
            principal.cargaProfesores();
            principal.cargaProyectos();
            principal.cargaCiclo();
        }

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
    }
}
