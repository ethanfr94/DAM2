using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Ud4Hoja5.ej2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        List<Usuario> usuarios = new List<Usuario>();

        public MainWindow()
        {
            InitializeComponent();
            carga();
        }


        private void carga()
        {
            usuarios.Add(new Usuario("Pepe", 20, "Madrid"));
            usuarios.Add(new Usuario("Juan", 30, "Barcelona"));
            usuarios.Add(new Usuario("Luis", 40, "Valencia"));

            listviewusuario.ItemsSource = usuarios;
        }

        private void btnAdd_Click(object sender, RoutedEventArgs e)
        {
            if(txtNombre.Text == "" || txtEdad.Text == "" || txtCiudad.Text == "")
            {
                MessageBox.Show("Rellene todos los campos");
                return;
            }
            else
            {
                usuarios.Add(new Usuario(txtNombre.Text, Convert.ToInt32(txtEdad.Text), txtCiudad.Text));
                txtCiudad.Text = "";
                txtEdad.Text = "";
                txtNombre.Text = "";

                listviewusuario.ItemsSource = null;
                listviewusuario.ItemsSource = usuarios;
            }

            listviewusuario.ItemsSource = usuarios;
        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            if(tbFiltro.Text == "")
            {
                listviewusuario.ItemsSource = usuarios;
            }
            else
            {
                listviewusuario.ItemsSource = usuarios.Where(x => x.Nombre.ToLower().Contains(tbFiltro.Text.ToLower()));
            }

        }
    }

    public class Usuario
    {
        public string Nombre { get; set; }
        public int Edad { get; set; }
        public string Ciudad { get; set; }

        public Usuario(string nombre, int edad, string ciudad)
        {
            Nombre = nombre;
            Edad = edad;
            Ciudad = ciudad;
        }
    }
}
