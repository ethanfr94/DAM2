using System.Windows.Forms;
using Ud2Hoja16.Models;
using Microsoft.EntityFrameworkCore; //se deben meter a mano

namespace Ud2Hoja16
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            cargaDatos();
        }

        private void cargaDatos()
        {
            using (var context = new BibliotecaContext())
            {
                var libros = context.Libros.Include(l => l.Autor).Include(l => l.Categoria).ToList();
                dgvBiblio.Rows.Clear();
                foreach (var libro in libros)
                {
                    dgvBiblio.Rows.Add(libro.Titulo, libro.Categoria.Categoria1, libro.Autor.Nombre, libro.Autor.Apellidos, libro.Autor.Nacionalidad);
                }
            }
        }

        private void btnAddLibro_Click(object sender, EventArgs e)
        {
            AgregarLibro agregarLibro = new AgregarLibro();
            agregarLibro.ShowDialog();
            if (agregarLibro.DialogResult == DialogResult.OK)
            {
                cargaDatos();
            }
        }

        private void btnActualizar_Click(object sender, EventArgs e)
        {
            Libro libro1 = new Libro();

            if (dgvBiblio.SelectedRows.Count > 0)
            {
                DataGridViewRow row = dgvBiblio.SelectedRows[0];

                libro1.Titulo = row.Cells[0].Value.ToString();
                libro1.Categoria = new Categoria { Categoria1 = row.Cells[1].Value.ToString() };
                libro1.Autor = new Autore
                {
                    Nombre = row.Cells[2].Value.ToString(),
                    Apellidos = row.Cells[3].Value.ToString(),
                    Nacionalidad = row.Cells[4].Value.ToString()
                };
            }
            AgregarLibro agregarLibro = new AgregarLibro(libro1);            
            agregarLibro.ShowDialog();            
            if (agregarLibro.DialogResult == DialogResult.OK)
            {
                cargaDatos();
            }
        }
    }


}
