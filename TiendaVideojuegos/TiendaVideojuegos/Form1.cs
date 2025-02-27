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
        TiendaVideojuegosEntities db = new TiendaVideojuegosEntities();
        List<Videojuego> videojuegos;
        public Form1()
        {
            InitializeComponent();
            cargarDatos();
        }

        private void cargarDatos()
        {
            // Cargar datos de la base de datos
            
                videojuegos = db.Videojuegos.ToList();
            

            // Mostrar datos en el DataGridView
            dgVideojuegos.DataSource = videojuegos;
        }

        public void limpiarCampos()
        {
            txtTitulo.Text = "";
            txtEstudio.Text = "";
            txtPrecio.Text = "";
        }

        public void cargarCampos(Videojuego videojuego)
        {
            txtTitulo.Text = videojuego.titulo;
            txtEstudio.Text = videojuego.estudio.ToString();
            txtPrecio.Text = videojuego.precio.ToString();
        }



        private void btnAgregar_Click(object sender, EventArgs e)
        {
            
                Videojuego videojuego = new Videojuego();

                if (string.IsNullOrEmpty(txtTitulo.Text)||string.IsNullOrEmpty(txtEstudio.Text))
                {
                    MessageBox.Show("Por favor llena los campos requeridos");
                    return;
                }
                else
                {
                    videojuego.titulo = txtTitulo.Text;
                    if(txtEstudio.Text != "")
                    {
                        Estudio estudio = db.Estudios.Where(est => est.nombre == txtEstudio.Text).FirstOrDefault();
                        if(estudio == null)
                        {
                            DialogResult result = MessageBox.Show("El estudio no existe, ¿deseas agregarlo?", "Estudio no encontrado", MessageBoxButtons.YesNo);
                            if (result == DialogResult.Yes)
                            {
                                Estudio nuevoEstudio = new Estudio();
                                nuevoEstudio.nombre = txtEstudio.Text;
                                db.Estudios.Add(nuevoEstudio);
                                db.SaveChanges();
                                videojuego.estudio = nuevoEstudio.id;
                            }
                            else
                            {
                                return;
                            }
                        }
                        else
                        {
                            videojuego.estudio = estudio.id;
                        }
                    }                    
                }
                db.Videojuegos.Add(videojuego);
                db.SaveChanges();


                limpiarCampos();
                cargarDatos();

            
        }

        private void eliminarDatos()
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

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            eliminarDatos();
        }

        private void dgVideojuegos_SelectionChanged(object sender, EventArgs e)
        {
            if (dgVideojuegos.SelectedRows.Count > 0)
            {
                Videojuego videojuego = videojuegos[dgVideojuegos.SelectedRows[0].Index];
                txtTitulo.Text = videojuego.titulo;
                txtEstudio.Text = db.Estudios.Where(est => est.id == videojuego.estudio).FirstOrDefault().nombre;


            }
        }

        private void btnEditar_Click(object sender, EventArgs e)
        {

            if (dgVideojuegos.SelectedRows.Count > 0)
            {
                DialogResult result = MessageBox.Show("¿Estás seguro de editar este videojuego?", "Editar", MessageBoxButtons.YesNo);
                if (result == DialogResult.Yes)
                {
                    
                        string titulo = dgVideojuegos.SelectedRows[0].Cells[0].Value.ToString();
                        Videojuego videojuego = db.Videojuegos.Where(v => v.titulo == titulo).FirstOrDefault();

                        if (videojuego != null)
                        {
                            videojuego.titulo = txtTitulo.Text;

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
    }
}

