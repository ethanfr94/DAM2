using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ud2Hoja14
{
    public partial class LibroForm : Form
    {

        private Libro _libro;
        private int estado;


        private LibroForm()
        {
            InitializeComponent();
        }

        public LibroForm(Libro libro, int estado) : this()
        {
            this.estado = estado;
            if (estado > 0)
            {
                txtTituloLibro.Enabled = false;
                txtAutorLibro.Enabled = false;
                txtAnioLibro.Enabled = false;
            }
            _libro = libro;
            txtTituloLibro.Text = _libro.Titulo;
            txtAnioLibro.Text = _libro.Anio.ToString();
            txtAutorLibro.Text = _libro.Autor;
            DialogResult = DialogResult.Cancel;
        }



        public void btnAceptar_Click(object sender, EventArgs e)
        {
            if (estado > 0)
            {
                DialogResult = DialogResult.Cancel;
                return;
            }
            else
            {
                _libro = new Libro();
                _libro.Titulo = txtTituloLibro.Text;
                _libro.Autor = txtAutorLibro.Text;
                _libro.Anio = Convert.ToInt32(txtAnioLibro.Text);
                ListaLibroForm.libros.Add(_libro);
                DialogResult = DialogResult.OK;
            }

        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }
    }
}
