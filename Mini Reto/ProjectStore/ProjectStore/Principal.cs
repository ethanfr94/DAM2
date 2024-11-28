using System;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class Principal : Form
    {
        private Profesor profesor = null;
        private readonly APIConnection apiConnection = new APIConnection();

        public static List<Alumno> alumnos;
        public static List<Profesor> profesores;
        public static List<Proyecto> proyectos;
        public static List<Ciclo> ciclos;

        public Principal(Profesor p)
        {
            InitializeComponent();

            profesor = p;
            this.Text = $"{profesor.Nombre} {profesor.Apellidos}";
            esAdmin(p);
        }

        // Verifica si el profesor tiene permisos de administrador
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

            ciclos = await apiConnection.GetAllCiclos();
            cargaCiclos();
        }

        // Método para cargar los ciclos en el ListView
        public void cargaCiclos()
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

            ltvListaPrincipal.Columns.Add("Id", 50);
            ltvListaPrincipal.Columns.Add("Nombre", 100);
            ltvListaPrincipal.Columns.Add("Apellidos", 100);
            ltvListaPrincipal.Columns.Add("Dni", 100);
            ltvListaPrincipal.Columns.Add("Email", 100);
            ltvListaPrincipal.Columns.Add("Contraseña", 100);
            ltvListaPrincipal.Columns.Add("Telefono", 100);
            ltvListaPrincipal.Columns.Add("Genero", 50);
            ltvListaPrincipal.Columns.Add("Fecha de Nacimiento", 100);
            ltvListaPrincipal.Columns.Add("Especialidad", 100);
            ltvListaPrincipal.Columns.Add("Activo", 50);
            ltvListaPrincipal.Columns.Add("Admin", 50);

            profesores = await apiConnection.GetAllProfesores();
            cargaProfesores();
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

            ltvListaPrincipal.Columns.Add("Id", 50);
            ltvListaPrincipal.Columns.Add("Nombre", 100);
            ltvListaPrincipal.Columns.Add("Apellidos", 100);
            ltvListaPrincipal.Columns.Add("Dni", 100);
            ltvListaPrincipal.Columns.Add("Email", 100);
            ltvListaPrincipal.Columns.Add("Contraseña", 100);
            ltvListaPrincipal.Columns.Add("Telefono", 100);
            ltvListaPrincipal.Columns.Add("Genero", 50);
            ltvListaPrincipal.Columns.Add("Fecha de Nacimiento", 100);
            ltvListaPrincipal.Columns.Add("Activo", 50);

            alumnos = await apiConnection.GetAllAlumnos();
            cargaAlumnos();
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
            ltvListaPrincipal.Columns.Add("Ciclo", 100);
            ltvListaPrincipal.Columns.Add("Tutor", 50);

            proyectos = await apiConnection.GetAllProyectos();


            cargaProyectos();
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
                item.SubItems.Add(proyecto.Resumen);
                item.SubItems.Add(proyecto.AnioAcademico.ToString());
                item.SubItems.Add(proyecto.FechaPresentacion.ToString());
                item.SubItems.Add(proyecto.Logo);
                item.SubItems.Add(proyecto.Memoria);
                item.SubItems.Add(proyecto.Archivos);
                item.SubItems.Add(proyecto.Comentarios);
                item.SubItems.Add(proyecto.Ciclo.ToString());
                item.SubItems.Add(proyecto.Tutor.ToString());

                ltvListaPrincipal.Items.Add(item);
            }
        }

        // Evento para cerrar sesión
        private void OnClickLogout(object sender, EventArgs e)
        {
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

        // Método para abrir formulario de alumno
        private void añadirAlumnoToolStripMenuItem_Click(object sender, EventArgs e)
        {

            AddAlumno addAlumno = new AddAlumno();
            addAlumno.ShowDialog();
            if (addAlumno.DialogResult == DialogResult.OK)
            {
                alumnos = apiConnection.GetAllAlumnos().Result;
                cargaAlumnos();
            }
        }

        // Método para abrir formulario de profesor
        private void añadirProfesorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AddProfesor addProfesor = new AddProfesor();
            addProfesor.ShowDialog();
            if (addProfesor.DialogResult == DialogResult.OK)
            {
                profesores = apiConnection.GetAllProfesores().Result;
                cargaProfesores();
            }
        }

        // Método para abrir formulario de proyecto
        private void añadirProyectosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AddProyecto addProyecto = new AddProyecto();
            addProyecto.ShowDialog();
            if (addProyecto.DialogResult == DialogResult.OK)
            {
                proyectos = apiConnection.GetAllProyectos().Result;
                cargaProyectos();
            }
        }
        /*
        // Método genérico para modificar un elemento (Profesor, Alumno o Proyecto)
        private async Task ModificarElementoToolStripMenuItem_Click<T>(List<T> lista, string idElemento, Func<T, bool> buscarElemento, Func<T, Form> crearFormulario, Func<Task> recargarDatos) where T : class
        {
            T elemento = lista.FirstOrDefault(item => buscarElemento(item));

            if (elemento != null)
            {
                Form formulario = crearFormulario(elemento);
                formulario.ShowDialog();

                if (DialogResult == DialogResult.OK)
                {
                    await recargarDatos();
                }
            }
        }
        */

        // Método específico para modificar un Profesor
        private async void modificarProfesorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (ltvListaPrincipal.SelectedItems.Count > 0)
            {
                var id = ltvListaPrincipal.SelectedItems[0].SubItems[0].Text;
                Profesor profesor = profesores.Find(p => p.Id == id);

                ModProfesor modProfesor = new ModProfesor(profesor);
                modProfesor.ShowDialog();
                if (modProfesor.DialogResult == DialogResult.OK)
                {
                    profesores = await apiConnection.GetAllProfesores();
                    cargaProfesores();
                }
            }


            /*
            // Verificar si hay un elemento seleccionado
            if (ltvListaPrincipal.SelectedItems.Count > 0)
            {
                var idSeleccionado = ltvListaPrincipal.SelectedItems[0].SubItems[0].Text;

                await ModificarElementoToolStripMenuItem_Click<Profesor>(
                    profesores,
                    idSeleccionado,
                    (Profesor p) => p.Id == idSeleccionado,
                    (Profesor p) => new ModProfesor(p),
                    async () =>
                    {
                        profesores = await apiConnection.GetAllProfesores();
                        cargaProfesores();
                    });
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un profesor para modificar.",
                                "Atención",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Warning);
            }
            */
        }

        // Método específico para modificar un Alumno
        private async void modificarAlumnoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (ltvListaPrincipal.SelectedItems.Count > 0)
            {
                var id = ltvListaPrincipal.SelectedItems[0].SubItems[0].Text;
                Alumno alumno = alumnos.Find(a => a.Id == id);

                ModAlumno modAlumno = new ModAlumno(alumno);
                modAlumno.ShowDialog();
                if (modAlumno.DialogResult == DialogResult.OK)
                {
                    alumnos = await apiConnection.GetAllAlumnos();
                    cargaAlumnos();
                }
            }

            /*
            // Verificar si hay un elemento seleccionado
            if (ltvListaPrincipal.SelectedItems.Count > 0)
            {
                var idSeleccionado = ltvListaPrincipal.SelectedItems[0].SubItems[0].Text;

                await ModificarElementoToolStripMenuItem_Click<Alumno>(
                    alumnos,
                    idSeleccionado,
                    (Alumno al) => al.Id == idSeleccionado,
                    (Alumno al) => new ModAlumno(al),
                    async () =>
                    {
                        alumnos = await apiConnection.GetAllAlumnos();
                        cargaAlumnos();
                    });
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un alumno para modificar.",
                                "Atención",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Warning);
            }
            */
        }

        // Método específico para modificar un Proyecto
        private async void modificarProyectosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (ltvListaPrincipal.SelectedItems.Count > 0)
            {
                var id = ltvListaPrincipal.SelectedItems[0].SubItems[0].Text;
                Proyecto proyecto = proyectos.Find(p => p.Id == id);

                ModProyecto modProyecto = new ModProyecto(proyecto);
                modProyecto.ShowDialog();
                if (modProyecto.DialogResult == DialogResult.OK)
                {
                    proyectos = await apiConnection.GetAllProyectos();
                    cargaProyectos();
                }
            }

            /*
            // Verificar si hay un elemento seleccionado
            if (ltvListaPrincipal.SelectedItems.Count > 0)
            {
                var idSeleccionado = ltvListaPrincipal.SelectedItems[0].SubItems[0].Text;

                await ModificarElementoToolStripMenuItem_Click<Proyecto>(
                    proyectos,
                    idSeleccionado,
                    (Proyecto p) => p.Id == idSeleccionado,
                    (Proyecto p) => new ModProyecto(p),
                    async () =>
                    {
                        proyectos = await apiConnection.GetAllProyectos();
                        cargaProyectos();
                    });
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un profesor para modificar.",
                                "Atención",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Warning);
            }
            */
        }
/*
        // Evento que habilita los botones de modificación al seleccionar un elemento de la lista
        private void ltvListaPrincipal_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {

                String id2 = ltvListaPrincipal.SelectedIndexChanged
                string id = ltvListaPrincipal.SelectedItems[0].Text;

                if (ltvListaPrincipal.SelectedItems.Count > 0)
                {
                    if (profesor.Admin)
                    {
                        modificarAlumnoToolStripMenuItem.Enabled = true;
                        modificarProfesorToolStripMenuItem.Enabled = true;
                        modificarProyectosToolStripMenuItem.Enabled = true;
                    }
                    else
                    {
                        Proyecto proyecto = proyectos.Find(p => p.Id == id);
                        if (proyecto != null && proyecto.Tutor.Id == profesor.Id)
                        {
                            modificarProyectosToolStripMenuItem.Enabled = true;
                        }
                    }
                }
            }
            catch (Exception)
            {
                MessageBox.Show("Error al seleccionar un elemento",
                                "Error",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
            }
        }
*/
        private void ltvListaPrincipal_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            try
            {

                string id = ltvListaPrincipal.SelectedItems[0].Text;

                if (ltvListaPrincipal.SelectedItems.Count > 0)
                {
                    if (profesor.Admin)
                    {
                        modificarAlumnoToolStripMenuItem.Enabled = true;
                        modificarProfesorToolStripMenuItem.Enabled = true;
                        modificarProyectosToolStripMenuItem.Enabled = true;
                    }
                    else
                    {
                        Proyecto proyecto = proyectos.Find(p => p.Id == id);
                        if (proyecto != null && proyecto.Tutor.Id == profesor.Id)
                        {
                            modificarProyectosToolStripMenuItem.Enabled = true;
                        }
                    }
                }
            }
            catch (Exception)
            {
                
            }

        }
    }
}
