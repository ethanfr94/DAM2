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

        /*-	Eliminar un autor o libro: la aplicación debe permitir eliminar un libro o un autor.
         * Si el usuario selecciona un libro en el DataGridView y confirma la acción, el libro debe ser eliminado de la base de datos.
         * Si el autor está asociado a otros libros, el autor no debe eliminarse automáticamente hasta que se confirme que no hay más libros asociados. */

        private void Eliminar_Click(object sender, EventArgs e)
        {
            if(dgvBiblio.SelectedRows.Count == 0)
            {
                MessageBox.Show("Por favor, seleccione un libro.");
                return;
            }
            DialogResult res = MessageBox.Show("¿Estás seguro de que quieres eliminar el libro?", "Eliminar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (res == DialogResult.Yes)
            {
                Libro libro1;

                if (dgvBiblio.SelectedRows.Count > 0)
                {
                    DataGridViewRow row = dgvBiblio.SelectedRows[0];

                    Autore autor = new Autore
                    {
                        Nombre = row.Cells[2].Value.ToString(),
                        Apellidos = row.Cells[3].Value.ToString(),
                        Nacionalidad = row.Cells[4].Value.ToString()
                    };
                    libro1 = new Libro
                    {
                        Titulo = row.Cells[0].Value.ToString(),
                        Categoria = new Categoria { Categoria1 = row.Cells[1].Value.ToString() },
                        Autor = autor
                    };

                    using (var context = new BibliotecaContext())
                    {
                        var libro = context.Libros.Include(l => l.Autor).FirstOrDefault(l => l.Titulo == libro1.Titulo && l.Categoria.Categoria1 == libro1.Categoria.Categoria1 && l.Autor.Nombre == libro1.Autor.Nombre && l.Autor.Apellidos == libro1.Autor.Apellidos && l.Autor.Nacionalidad == libro1.Autor.Nacionalidad);
                        // la linea anterior es para que no se elimine un libro que tenga el mismo nombre que otro, pero que sea de otro autor
                        context.Libros.Remove(libro);
                        // la linea a continuación es para que si el autor no tiene más libros asociados, se elimine
                        var libro2 = context.Libros.Include(l => l.Autor).FirstOrDefault(l => l.Autor.Nombre == autor.Nombre && l.Autor.Apellidos == autor.Apellidos && l.Autor.Nacionalidad == autor.Nacionalidad);
                        if (libro2 == null)
                        {
                            var autor2 = context.Autores.FirstOrDefault(a => a.Nombre == autor.Nombre && a.Apellidos == autor.Apellidos && a.Nacionalidad == autor.Nacionalidad);
                            context.Autores.Remove(autor2);
                        }
                        context.SaveChanges();
                        cargaDatos();
                    }
                }     

                
            }            
        }
    }
}
