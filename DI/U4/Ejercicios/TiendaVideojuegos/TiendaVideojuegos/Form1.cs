using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TiendaVideojuegos
{
    public partial class Form1 : Form
    {
        List<Videojuego> videojuegos;
        public Form1()
        {
            InitializeComponent();
            cargarDatos();
        }

        private void cargarDatos()
        {
            // Cargar datos de la base de datos
            using (TiendaVideojuegosEntities db = new TiendaVideojuegosEntities())
            {
                videojuegos = db.Videojuegos.ToList();
            }

            // Mostrar datos en el DataGridView
            dgVideojuegos.DataSource = videojuegos;
        }

        public void limpiarCampos()
        {
            txtTitulo.Text = "";
            txtEstudio.Text = "";
            dtpFecha.Value = DateTime.Now;
            txtPrecio.Text = "";
        }

        public void cargarCampos(Videojuego videojuego)
        {
            txtTitulo.Text = videojuego.titulo;
            txtEstudio.Text = videojuego.estudio.ToString();
            dtpFecha.Value = videojuego.fecha_lanzamiento.Value;
            txtPrecio.Text = videojuego.precio.ToString();
        }

        

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            using (TiendaVideojuegosEntities db = new TiendaVideojuegosEntities())
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
                    db.Videojuegos.Add(videojuego);
                    db.SaveChanges();
                

                limpiarCampos();
                cargarDatos();

            }
        }

        private void eliminarDatos()
        {
            using (TiendaVideojuegosEntities db = new TiendaVideojuegosEntities())
            {
                if (dgVideojuegos.SelectedRows.Count > 0)
                {
                    DialogResult result = MessageBox.Show("¿Estás seguro de eliminar este videojuego?", "Eliminar", MessageBoxButtons.YesNo);
                    if (result == DialogResult.Yes)
                    {
                        string titulo = dgVideojuegos.SelectedRows[0].Cells[0].Value.ToString();
                        Videojuego videojuego = db.Videojuegos.Where(v => v.titulo == titulo).FirstOrDefault();
                        db.Videojuegos.Remove(videojuego);
                        db.SaveChanges();
                        cargarDatos();
                    }
                    
                }
                else
                {
                    MessageBox.Show("Por favor selecciona un videojuego");
                }
            }
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            eliminarDatos();
        }

        private void dgVideojuegos_SelectionChanged(object sender, EventArgs e)
        {
            if(dgVideojuegos.SelectedRows.Count > 0)
            {
                btnEditar.Enabled = true;
                btnEliminar.Enabled = true;

                Videojuego videojuego = videojuegos[dgVideojuegos.SelectedRows[0].Index];
                txtTitulo.Text = videojuego.titulo;
                dtpFecha.Value = videojuego.fecha_lanzamiento.Value;

            }
        }

        private void btnEditar_Click(object sender, EventArgs e)
        {

            if (dgVideojuegos.SelectedRows.Count > 0)
        {
            DialogResult result = MessageBox.Show("¿Estás seguro de editar este videojuego?", "Editar", MessageBoxButtons.YesNo);
            if (result == DialogResult.Yes)
            {
                using (TiendaVideojuegosEntities db = new TiendaVideojuegosEntities())
                {
                        string titulo = dgVideojuegos.SelectedRows[0].Cells[0].Value.ToString();
                        Videojuego videojuego = db.Videojuegos.Where(v => v.titulo == titulo).FirstOrDefault();

                        if (videojuego != null)
                        {
                        videojuego.titulo = txtTitulo.Text;
                        videojuego.estudio = txtEstudio.Text;
                        videojuego.fecha_lanzamiento = dtpFecha.Value;
                        videojuego.precio = Convert.ToDouble(txtPrecio.Text);

                        db.SaveChanges();
                        }
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
        }
}
