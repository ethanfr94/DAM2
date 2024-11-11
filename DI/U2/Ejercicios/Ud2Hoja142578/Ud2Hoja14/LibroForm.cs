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

        private String _titulo;
        private String _autor;
        private int _anio;

        public String Titulo
        {
            get { return _titulo; }
            set { _titulo = value; }
        }

        public String Autor
        {
            get { return _autor; }
            set { _autor = value; }
        }

        public int Anio
        {
            get { return _anio; }
            set { _anio = value; }
        }

        private LibroForm()
        {
            InitializeComponent();
        }

        public LibroForm(Libro libro)
        {
            txtTitulo.Text = libro.titulo;
            txtAutor.Text = libro.autor;
            txtAnio.Text = libro.anio.ToString();
            InitializeComponent();
        }

        private void btnBorrar_Click(object sender, EventArgs e)
        {
            txtTitulo.Text = "";
            txtAutor.Text = "";
            txtAnio.Text = "";
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            _titulo = txtTitulo.Text;
            _autor = txtAutor.Text;
            _anio = Convert.ToInt32(txtAnio.Text);
        }
    }
}
