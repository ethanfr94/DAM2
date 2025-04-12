using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tienda
{
    public partial class FormVideojuego : Form
    {
        TiendaVideojuegosEntities db = new TiendaVideojuegosEntities();
        List<Videojuego> videojuegos;
        public FormVideojuego()
        {
            InitializeComponent();

            // Cargar ensamblados nativos para evitar errores en ReportViewer
            SqlServerTypes.Utilities.LoadNativeAssemblies(AppDomain.CurrentDomain.BaseDirectory);

            cargarDatos();

        }

        private void cargarDatos()
        {
            // cargamos los videojuegos de la base de datos en la lista y los mostramos en el datagridview

            videojuegos = db.Videojuegos.ToList();
            dgVideojuegos.Rows.Clear();
            foreach (Videojuego videojuego in videojuegos)
            {
                DateTime fechaLanzamiento = videojuego.fecha_lanzamiento.Value;
                string nombreEstudio = db.Estudios.Where(v => v.id == videojuego.estudio).Select(v => v.nombre).FirstOrDefault();
                dgVideojuegos.Rows.Add(videojuego.id, videojuego.titulo, fechaLanzamiento.ToShortDateString(), videojuego.precio, nombreEstudio);
            }
            dgVideojuegos.Columns["id"].Visible = false;
            dgVideojuegos.ClearSelection();
            

        }

        public void limpiarCampos()
        {
            // metodo para limpiar los campos de texto

            txtTitulo.Text = "";
            txtEstudio.Text = "";
            dtpFecha.Value = DateTime.Now;
            txtPrecio.Text = "";
        }

        public void cargarCampos(Videojuego videojuego)
        {
            // metodo para cargar los campos de texto con los datos del videojuego

            txtTitulo.Text = videojuego.titulo;
            dtpFecha.Value = videojuego.fecha_lanzamiento.Value;
            txtPrecio.Text = videojuego.precio.ToString();

            // buscamos el estudio del videojuego en la base de datos y mostramos su nombre

            Estudio estudio = db.Estudios.Where(v => v.id == videojuego.estudio).FirstOrDefault();
            if(estudio != null)
            {
                txtEstudio.Text = estudio.nombre;
            }
            else
            {
                txtEstudio.Text = "";
            }            
        }

        // Evento de click en el botón agregar para agregar un videojuego a la base de datos
        private void btnAgregar_Click(object sender, EventArgs e)
        {
            
                Videojuego videojuego = new Videojuego();

                if (txtTitulo.Text == "")
                {
                    MessageBox.Show("Por favor llena los campos requeridos");
                    return;
                }
                else
                {
                    videojuego.titulo = txtTitulo.Text;
                    videojuego.fecha_lanzamiento = dtpFecha.Value;
                }

                // buscamos el estudio en la base de datos y lo asignamos al videojuego si existe

                if(!string.IsNullOrEmpty(txtEstudio.Text))
                {
                    string nombreEstudio = txtEstudio.Text;
                    Estudio estudio = db.Estudios.Where(v => v.nombre == nombreEstudio).FirstOrDefault();

                    if (estudio != null)
                    {
                        videojuego.estudio = estudio.id;
                    }
                    else
                    {
                        MessageBox.Show("El estudio no existe");
                        return;
                    }
                }

                if(!string.IsNullOrEmpty(txtPrecio.Text))
                {
                    videojuego.precio = Convert.ToDecimal(txtPrecio.Text);
                }

                db.Videojuegos.Add(videojuego);
                db.SaveChanges();

                // limpiamos los campos y actualizamos los datos en el datagridview

                limpiarCampos();
                cargarDatos();            
        }

        // Evento de click en el botón eliminar para eliminar un videojuego de la base de datos
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (dgVideojuegos.SelectedRows.Count > 0)
            {
                DialogResult result = MessageBox.Show("¿Estás seguro de eliminar este videojuego?", "Eliminar", MessageBoxButtons.YesNo);
                if (result == DialogResult.Yes)
                {
                    // buscamos el videojuego en la base de datos y si existe lo eliminamos

                    int id = Convert.ToInt32(dgVideojuegos.SelectedRows[0].Cells[0].Value);
                    Videojuego videojuego = db.Videojuegos.Where(v => v.id == id).FirstOrDefault();
                    if (videojuego != null)
                    {
                        db.Videojuegos.Remove(videojuego);
                        db.SaveChanges();
                        cargarDatos();
                    }
                    else
                    {
                        MessageBox.Show("El videojuego no existe");
                        return;
                    }
                }
            }
            else
            {
                MessageBox.Show("Por favor selecciona un videojuego");
            };
        }

        // Evento de click en el botón editar para editar un videojuego de la base de datos
        private void btnEditar_Click(object sender, EventArgs e)
        {

            if (dgVideojuegos.SelectedRows.Count > 0)
            {
                DialogResult result = MessageBox.Show("¿Estás seguro de editar este videojuego?", "Editar", MessageBoxButtons.YesNo);
                if (result == DialogResult.Yes)
                {
                    // buscamos el videojuego en la base de datos y si existe lo editamos

                    int id = Convert.ToInt32(dgVideojuegos.SelectedRows[0].Cells[0].Value);
                    Videojuego videojuego = db.Videojuegos.Where(v => v.id == id).FirstOrDefault();

                    if (videojuego != null)
                    {
                        videojuego.titulo = txtTitulo.Text;
                        videojuego.fecha_lanzamiento = dtpFecha.Value;

                        if (!string.IsNullOrEmpty(txtEstudio.Text))
                        {
                            // buscamos el estudio en la base de datos y lo asignamos al videojuego si existe

                            string nombreEstudio = txtEstudio.Text;
                            Estudio estudio = db.Estudios.Where(v => v.nombre == nombreEstudio).FirstOrDefault();

                            if (estudio != null)
                            {
                                videojuego.estudio = estudio.id;
                            }
                            else
                            {
                                MessageBox.Show("El estudio no existe");
                                return;
                            }
                        }

                        if (!string.IsNullOrEmpty(txtPrecio.Text))
                        {
                            videojuego.precio = Convert.ToDecimal(txtPrecio.Text);
                        }

                        db.SaveChanges();
                    }                   

                    limpiarCampos();
                    cargarDatos();
                }
            }
            else
            {
                MessageBox.Show("Por favor selecciona un videojuego");
            }
        }

        // Evento de click en el botón Estudios para abrir el formulario de estudios
        private void tsmEstudios_Click(object sender, EventArgs e)
        {
                // metodo para abrir el formulario de estudios
                FormEstudio formEstudio = new FormEstudio();
        
                formEstudio.Show();
        }

        // Logica para obtener el videojuego seleccionado y cargar los campos de texto
        private void dgVideojuegos_SelectionChanged(object sender, EventArgs e)
        {
            if (dgVideojuegos.SelectedRows.Count > 0)
            {
                // habilitamos los botones de editar y eliminar y cargamos los campos de texto con los datos del videojuego seleccionado
                btnEditar.Enabled = true;
                btnEliminar.Enabled = true;
                int index = dgVideojuegos.SelectedRows[0].Index;
                if (index >= 0 && index < videojuegos.Count)
                {
                    Videojuego videojuego = videojuegos[index];
                    cargarCampos(videojuego);
                }
                else
                {
                    btnEditar.Enabled = false;
                    btnEliminar.Enabled = false;
                    limpiarCampos();
                    dgVideojuegos.ClearSelection();
                }
            }
            else
            {
                btnEditar.Enabled = false;
                btnEliminar.Enabled = false;
                limpiarCampos();
                dgVideojuegos.ClearSelection();
            }
        }

        // Evento de click en el botón Informes para abrir el formulario de informes
        private void tsmInformes_Click(object sender, EventArgs e)
        {
            FormInformes formInformes = new FormInformes();
            formInformes.Show();
        }
    }
}