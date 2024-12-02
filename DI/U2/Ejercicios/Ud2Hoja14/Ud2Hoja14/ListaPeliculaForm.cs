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
    // no funciona correctamente aunque parece esrtar bien
    
    public partial class ListaPeliculaForm : Form
    {
        public static List<Pelicula> peliculas = new List<Pelicula>();
        public ListaPeliculaForm()
        {
            InitializeComponent();
        }

        private void crearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Pelicula pelic = new Pelicula();
            PeliculaForm form = new PeliculaForm(pelic, 0);
            form.ShowDialog();
            if (form.DialogResult == DialogResult.OK)
            {
                refresca();
            }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                ListViewItem item = listView1.SelectedItems[0]; 
                DialogResult result = MessageBox.Show("¿Estás seguro de que quieres borrar la película?", "Borrar", MessageBoxButtons.YesNo);
                if (result == DialogResult.Yes)
                {
                    Pelicula pelic = (Pelicula)item.Tag;
                    peliculas.Remove(pelic);
                    refresca();
                }
            }
        }

        private void verToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                ListViewItem item = listView1.SelectedItems[0]; // Obtiene el item seleccionado
                Pelicula pelic = (Pelicula)item.Tag; // Obtiene la pelicula asociada al item
                PeliculaForm form = new PeliculaForm(pelic, 1); // Crea un formulario de pelicula con la pelicula seleccionada
                form.ShowDialog();
            }
        }

        private void listView1_DoubleClick(object sender, EventArgs e)
        {
            verToolStripMenuItem_Click(sender, e);
        }

        private void refresca()
        {
            listView1.Items.Clear();
            foreach (Pelicula pelic in peliculas)
            {
                if (pelic != null)
                {
                    ListViewItem item = new ListViewItem(pelic.Titulo);     //Añadimos el titulo de la pelicula a la lista
                    item.SubItems.Add(pelic.Anio.ToString());//Añadimos el año de la pelicula a la lista
                    item.SubItems.Add(pelic.Genero);    //Añadimos el genero de la pelicula a la lista
                    item.Tag = pelic;
                    listView1.Items.Add(item);
                }
            }
        }

        private void ContextMenu_Opening(object sender, System.ComponentModel.CancelEventArgs e)
        {
            ContextMenuStrip menu = sender as ContextMenuStrip;
            bool itemSelected = listView1.SelectedItems.Count > 0; // Comprueba si hay un item seleccionado
            menu.Items[0].Enabled = !itemSelected; // Crear
            menu.Items[1].Enabled = itemSelected;  // Ver
            menu.Items[2].Enabled = itemSelected;  // Borrar
        }
    }
}
