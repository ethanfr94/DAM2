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
    public partial class PeliculaForm : Form
    {
        private Pelicula _pelicula = new Pelicula();

        public String Titulo
        {
            get { return txtTituloPelicula.Text; }
            set { txtTituloPelicula.Text = value; }
        }

        public int Anio
        {
            get { return int.Parse(txtAnioPelicula.Text); }
            set { txtAnioPelicula.Text = value.ToString(); }
        }

        public String Genero
        {
            get { return txtGeneroPelicula.Text; }
            set { txtGeneroPelicula.Text = value; }
        }

        private PeliculaForm()
        {
            InitializeComponent();
        }

        public PeliculaForm(Pelicula pelicula)
        {
            InitializeComponent();
            txtTituloPelicula.Text = pelicula.Titulo;
            txtAnioPelicula.Text = pelicula.Anio.ToString();
            txtGeneroPelicula.Text = pelicula.Genero;
            DialogResult = DialogResult.OK;
        }

        public void btnBorrar_Click(object sender, EventArgs e)
        {
            txtTituloPelicula.Text = "";
            txtAnioPelicula.Text = "";
            txtGeneroPelicula.Text = "";


        }

        public void btnAceptar_Click(object sender, EventArgs e)
        {
            _pelicula.Titulo = txtTituloPelicula.Text;
            _pelicula.Anio = int.Parse(txtAnioPelicula.Text);
            _pelicula.Genero = txtGeneroPelicula.Text;
            DialogResult = DialogResult.OK;
        }
    }
}
