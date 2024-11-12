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

        private Libro _libro = new Libro();

        public String Titulo
        {
            get { return txtTituloLibro.Text; }
            set { txtTituloLibro.Text = value; }
        }

        public int Anio
        {
            get { return int.Parse(txtAnioLibro.Text); }
            set { txtAnioLibro.Text = value.ToString(); }
        }

        public String Autor
        {
            get { return txtAutorLibro.Text; }
            set { txtAutorLibro.Text = value; }
        }

        private LibroForm()
        {
            InitializeComponent();
        }

        public LibroForm(Libro libro)
        {
            InitializeComponent();
            txtTituloLibro.Text = "";
            txtAnioLibro.Text = "";
            txtAutorLibro.Text = "";
            _libro = libro;
        }

        public void btnBorrar_Click(object sender, EventArgs e)
        {
            txtTituloLibro.Text = "";
            txtAnioLibro.Text = "";
            txtAutorLibro.Text = "";

        }

        public void btnAceptar_Click(object sender, EventArgs e)
        {
            _libro.Titulo = txtTituloLibro.Text;
            _libro.Anio = int.Parse(txtAnioLibro.Text);
            _libro.Autor = txtAutorLibro.Text;
            DialogResult = DialogResult.OK;

        }

        
    }
}
