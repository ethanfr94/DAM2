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
        private Pelicula _pelicula;
        private int estado;

        private PeliculaForm()
        {
            InitializeComponent();
        }

        public PeliculaForm(Pelicula pelicula, int estado) : this()
        {
            this.estado = estado;
            if (estado > 0)
            {
                txtTituloPelicula.Enabled = false;
                txtAnioPelicula.Enabled = false;
                txtGeneroPelicula.Enabled = false;
            }
            this._pelicula = pelicula;
            txtTituloPelicula.Text = pelicula.Titulo;
            txtAnioPelicula.Text = pelicula.Anio.ToString();
            txtGeneroPelicula.Text = pelicula.Genero;
            DialogResult = DialogResult.Cancel;
        }


        public void btnAceptar_Click(object sender, EventArgs e)
        {
            if(estado > 0)
            {
                DialogResult = DialogResult.Cancel;
                return;
            }
            else
            {
                _pelicula = new Pelicula();
                _pelicula.Titulo = txtTituloPelicula.Text;
                _pelicula.Anio = Convert.ToInt32(txtAnioPelicula.Text);
                _pelicula.Genero = txtGeneroPelicula.Text;
                ListaPeliculaForm.peliculas.Add(_pelicula);
                DialogResult = DialogResult.OK;
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }
    }
}
