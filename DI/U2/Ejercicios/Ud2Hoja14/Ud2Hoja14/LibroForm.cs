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
        private LibroForm()
        {
            InitializeComponent();
        }

        public LibroForm(Libro libro)
        {
            InitializeComponent();
            txtTituloLibro.Text = libro.Titulo;
            txtAnioLibro.Text = libro.Anio.ToString();
            txtAutorLibro.Text = libro.Autor;
            DialogResult = DialogResult.Cancel;
        }

        private void btnBorrar_Click(object sender, EventArgs e)
        {
            txtTituloLibro.Text = "";
            txtAnioLibro.Text = "";
            txtAutorLibro.Text = "";

        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            Libro libro = new Libro();
            libro.Titulo = txtTituloLibro.Text;
            libro.Anio = int.Parse(txtAnioLibro.Text);
            libro.Autor = txtAutorLibro.Text;
            DialogResult = DialogResult.OK;

        }
    }
}
