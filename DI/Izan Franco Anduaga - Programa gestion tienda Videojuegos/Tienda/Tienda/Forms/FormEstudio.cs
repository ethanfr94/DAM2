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
    public partial class FormEstudio : Form
    {
        // Contexto de la base de datos y lista de estudios
        TiendaVideojuegosEntities db = new TiendaVideojuegosEntities();
        List<Estudio> estudios;

        // Constructor
        public FormEstudio()
        {
            InitializeComponent();            
            cargaDatos();
        }

        // Metodo para cargar los datos de la base de datos en el DataGridView
        private void cargaDatos()
        {            
            estudios = db.Estudios.ToList();
            dgEstudios.Rows.Clear();

            foreach (Estudio estudio in estudios)
            {
                dgEstudios.Rows.Add(estudio.id, estudio.nombre, estudio.fundacion, estudio.pais, estudio.descripcion);
            }
            dgEstudios.Columns["id"].Visible = false;
            dgEstudios.ClearSelection();
        }

        // Metodo para limpiar los campos de texto
        public void limpiarCampos()
        {
            txtNombre.Text = "";
            txtFundacion.Text = "";
            txtPais.Text = "";
            txtDescripcion.Text = "";
        }

        // Metodo para cargar los campos de texto con los datos de un estudio seleccionado
        public void cargarCampos(Estudio estudio)
        {
            txtNombre.Text = estudio.nombre;
            txtFundacion.Text = estudio.fundacion.ToString();
            txtPais.Text = estudio.pais;
            txtDescripcion.Text = estudio.descripcion;
        }

        // Evento click del boton agregar para agregar un estudio a la base de datos
        private void btnAgregar_Click(object sender, EventArgs e)
        {
            Estudio estudio = new Estudio();

            if (txtNombre.Text == "")
            {
                MessageBox.Show("Por favor llena los campos requeridos");
                return;
            }

            estudio.nombre = txtNombre.Text;

            if (!string.IsNullOrEmpty(txtFundacion.Text)) { 
                int n = Convert.ToInt32(txtFundacion.Text);
                estudio.fundacion = n;
            }

            estudio.pais = txtPais.Text;
            estudio.descripcion = txtDescripcion.Text;

            db.Estudios.Add(estudio);
            db.SaveChanges();

            cargaDatos();
            limpiarCampos();
        }

        // Logica para obtener el estudio seleccionado y cargar los campos de texto
        private void dgEstudios_SelectionChanged(object sender, EventArgs e)
        {
            if (dgEstudios.SelectedRows.Count > 0)
            {
                // habilitamos los botones de editar y eliminar y cargamos los campos de texto con los datos del videojuego seleccionado
                btnEditar.Enabled = true;
                btnEliminar.Enabled = true;
                int index = dgEstudios.SelectedRows[0].Index;
                if (index >= 0 && index < estudios.Count)
                {
                    Estudio es = estudios[index];
                    cargarCampos(es);
                }
                else
                {
                    btnEditar.Enabled = false;
                    btnEliminar.Enabled = false;
                    limpiarCampos();
                    dgEstudios.ClearSelection();
                }
            }
            else
            {
                btnEditar.Enabled = false;
                btnEliminar.Enabled = false;
                limpiarCampos();
                dgEstudios.ClearSelection();
            }
        }

        // Evento click del boton eliminar para eliminar un estudio de la base de datos
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (dgEstudios.SelectedRows.Count > 0)
            {
                DialogResult dialogResult = MessageBox.Show("¿Estás seguro de eliminar este estudio?", "Eliminar", MessageBoxButtons.YesNo);
                if(dialogResult == DialogResult.Yes) {

                    int id = Convert.ToInt32(dgEstudios.SelectedRows[0].Cells[0].Value);

                    Estudio estudio = db.Estudios.Where(v => v.id == id).FirstOrDefault();
                    Videojuego videojuego = db.Videojuegos.Where(v => v.estudio == id).FirstOrDefault();
                    
                    if (videojuego != null)
                    {
                        MessageBox.Show("No puedes eliminar un estudio que tenga videojuegos asociados");
                        return;
                    }
                    if (estudio != null)
                    {
                        db.Estudios.Remove(estudio);
                        db.SaveChanges();
                        cargaDatos();
                    }
                    else
                    {
                        MessageBox.Show("El estudio no existe");
                        return;
                    }
                    
                }
            }
            else
            {
                MessageBox.Show("Por favor selecciona un videojuego");
            }
        }

        // Evento click del boton editar para editar un estudio de la base de datos
        private void btnEditar_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = MessageBox.Show("¿Estás seguro de editar este estudio?", "Editar", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                int id = Convert.ToInt32(dgEstudios.SelectedRows[0].Cells[0].Value);
                Estudio estudio = db.Estudios.Where(v => v.id == id).FirstOrDefault();
                if (estudio != null)
                {
                    if (string.IsNullOrEmpty(txtNombre.Text))
                    {
                        MessageBox.Show("Por favor llena los campos requeridos");
                        return;
                    }

                    estudio.nombre = txtNombre.Text;
                    estudio.fundacion = Convert.ToInt32(txtFundacion.Text);
                    estudio.pais = txtPais.Text;
                    estudio.descripcion = txtDescripcion.Text;

                    db.SaveChanges();
                    cargaDatos();
                    limpiarCampos();
                }
                else
                {
                    MessageBox.Show("El estudio no existe");
                    return;
                }
            }
        }
    }
}
