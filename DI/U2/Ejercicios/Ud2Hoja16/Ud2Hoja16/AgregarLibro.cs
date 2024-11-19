using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Ud2Hoja16.Models;
using Ud2Hoja16.Models;
using Microsoft.EntityFrameworkCore;

namespace Ud2Hoja16
{
    public partial class AgregarLibro : Form
    {
        public AgregarLibro()
        {
            InitializeComponent();
            cargaCombo();
        }

        public AgregarLibro(Libro libro)
        {
            InitializeComponent();
            txtTitulo.Text = libro.Titulo;
            txtAutor.Text = libro.Autor.Nombre;
            txtApellidos.Text = libro.Autor.Apellidos;
            txtNacionalidad.Text = libro.Autor.Nacionalidad;
            cmbCateboria.SelectedItem = libro.Categoria.Categoria1;
            cargaCombo();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        private void btnOk_Click(object sender, EventArgs e)
        {
            if(string.IsNullOrWhiteSpace(txtTitulo.Text))
            {
                MessageBox.Show("Por favor, ingrese un título.");
                return;
            }

            if (string.IsNullOrWhiteSpace(txtAutor.Text))
            {
                MessageBox.Show("Por favor, ingrese un autor.");
                return;
            }

            if (string.IsNullOrWhiteSpace(txtApellidos.Text))
            {
                MessageBox.Show("Por favor, ingrese los apellidos del autor.");
                return;
            }

            if (string.IsNullOrWhiteSpace(txtNacionalidad.Text))
            {
                MessageBox.Show("Por favor, ingrese la nacionalidad del autor.");
                return;
            }
            
            using (var context = new BibliotecaContext())
            {
                var autor = new Autore
                {
                    Nombre = txtAutor.Text,
                    Apellidos = txtApellidos.Text,
                    Nacionalidad = txtNacionalidad.Text
                };

                var libro = new Libro
                {
                    Titulo = txtTitulo.Text,
                    Categoria = context.Categorias.FirstOrDefault(c => c.Categoria1 == cmbCateboria.SelectedItem.ToString()),
                    Autor = autor
                };
                
                var autores = context.Autores.ToList();
                foreach (var aut  in autores)
                {
                    if (aut.Nombre == autor.Nombre && aut.Apellidos == autor.Apellidos && aut.Nacionalidad == autor.Nacionalidad)
                    {
                        libro.Autor = aut;
                        break;
                    }
                    else
                    {
                       context.Autores.Add(autor);
                        context.SaveChanges();
                        break;
                    }
                }

                var libros = context.Libros.ToList();
                foreach (var lib in libros)
                {
                    if (lib.Titulo == libro.Titulo)
                    {
                        lib.Autor = autor;
                        lib.Titulo = libro.Titulo;
                        lib.Categoria = libro.Categoria;
                        context.SaveChanges();
                        break;
                    }
                    else
                    {
                        context.Libros.Add(libro);
                        context.SaveChanges();
                    }

                }
               
            }
            


            DialogResult = DialogResult.OK;

        }

        public void cargaCombo()
        {
            using (var context = new BibliotecaContext())
            {
                var categorias = context.Categorias.ToList();
                foreach (var categoria in categorias)
                {
                    cmbCateboria.Items.Add(categoria.Categoria1);
                }
            }
        }
    }
}
