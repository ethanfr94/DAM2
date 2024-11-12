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
    public partial class ListaPeliculaForm : Form
    {
        public ListaPeliculaForm()
        {
            InitializeComponent();
        }

        private void crearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Pelicula pelicula = new Pelicula();
            PeliculaForm peliculaForm = new PeliculaForm(pelicula);
            peliculaForm.ShowDialog();
            if (peliculaForm.DialogResult == DialogResult.OK)
            {
                pelicula.Titulo = peliculaForm.Titulo;
                pelicula.Genero = peliculaForm.Genero;
                pelicula.Anio = peliculaForm.Anio;
                ListViewItem item = new ListViewItem(pelicula.Titulo);
                item.SubItems.Add(pelicula.Anio.ToString());
                item.SubItems.Add(pelicula.Genero);
                listView1.Items.Add(item);

            }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                listView1.Items.Remove(listView1.SelectedItems[0]);
            }
        }

        private void verToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Pelicula pelicula = new Pelicula();
            PeliculaForm peliculaForm = new PeliculaForm(pelicula);
            peliculaForm.ShowDialog();

        }
    }
}
