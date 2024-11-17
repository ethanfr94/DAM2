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
    public partial class ListaLibroForm : Form
    {

        public static List<Libro> libros = new List<Libro>();

        public ListaLibroForm()
        {
            InitializeComponent();
        }

        private void crearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Libro libro = new Libro();
            LibroForm libroForm = new LibroForm(libro, 0);
            libroForm.ShowDialog();
            if (libroForm.DialogResult == DialogResult.OK)
            {
                refresca();
            }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                ListViewItem item = listView1.SelectedItems[0];
                DialogResult result = MessageBox.Show("¿Estás seguro de que quieres borrar el libro?", "Borrar", MessageBoxButtons.YesNo);
                if (result == DialogResult.Yes)
                {
                    Libro libro = (Libro)item.Tag;
                    libros.Remove(libro);
                    refresca();
                }
            }
        }

        private void verToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                ListViewItem item = listView1.SelectedItems[0];
                Libro libro = (Libro)item.Tag;
                LibroForm libroForm = new LibroForm(libro, 1);
                libroForm.ShowDialog();
            }
        }

        private void listView1_DoubleClick(object sender, EventArgs e)
        {
            verToolStripMenuItem_Click(sender, e);
        }

        private void refresca()
        {
            listView1.Items.Clear();
            foreach (Libro libro in libros)
            {
                if (libro != null)
                {
                    ListViewItem item = new ListViewItem(libro.Titulo);
                    item.SubItems.Add(libro.Autor);
                    item.SubItems.Add(libro.Anio.ToString());
                    item.Tag = libro;
                    listView1.Items.Add(item);
                }
            }
        }

        private void ContextMenu_Opening(object sender, System.ComponentModel.CancelEventArgs e)
        {
            ContextMenuStrip menu = sender as ContextMenuStrip;
            bool itemSelected = listView1.SelectedItems.Count > 0;
            menu.Items[0].Enabled = !itemSelected; // Crear
            menu.Items[1].Enabled = itemSelected;  // Ver
            menu.Items[2].Enabled = itemSelected;  // Borrar
        }

    }
}
