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
        public ListaLibroForm()
        {
            InitializeComponent();
        }

        private void crearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Libro libro = new Libro();
            LibroForm libroForm = new LibroForm(libro);
            libroForm.ShowDialog();
            if (libroForm.DialogResult == DialogResult.OK)
            {
                libro.Titulo = libroForm.Titulo;
                libro.Autor = libroForm.Autor;
                libro.Anio = libroForm.Anio;
                ListViewItem item = new ListViewItem(libro.Titulo);
                item.SubItems.Add(libro.Anio.ToString());
                item.SubItems.Add(libro.Autor);
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
            Libro libro = new Libro();
            LibroForm libroForm = new LibroForm(libro);
            libroForm.ShowDialog();
        }
    }
}
