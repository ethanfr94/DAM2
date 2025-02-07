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

namespace Ud4Hoja2Ej1
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private Dictionary<string, int> inventario = new Dictionary<string, int>();

        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnSalirr_Click(object sender, RoutedEventArgs e)
        {
            App.Current.Shutdown();
        }

        private void btnAñadir_Click(object sender, RoutedEventArgs e)
        {
            if (string.IsNullOrEmpty(tbProducto.Text) || cmbCategoria.SelectedItem == null)
            {
                MessageBox.Show("Debe rellenar todos los campos", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (int.TryParse(tbCantidad.Text, out int cantidad) == false || cantidad < 0)
            {
                MessageBox.Show("Introduzca una cantidad valida", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            String producto = tbProducto.Text;
            String categoria = (cmbCategoria.SelectedItem as ComboBoxItem)?.Content.ToString();
            String clave = $"{producto}({categoria})";

            if (!inventario.ContainsKey(clave))
            {
                inventario[clave] = cantidad;
                lstProductos.Items.Add($"{clave} - Stock: {cantidad}");
            }
            else
            {
                MessageBox.Show("El producto ya existe", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }

            tbProducto.Clear();
            tbCantidad.Clear();
        }

        private void btnRegistrar_Click(object sender, RoutedEventArgs e)
        {
            if(lstProductos.SelectedItem == null)
            {
                MessageBox.Show("Debe seleccionar un producto", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }
            if(!int.TryParse(tbCantidad.Text, out int cantidad) || cantidad <= 0)
            {
                MessageBox.Show("Introduzca una cantidad valida", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            String producto = lstProductos.SelectedItem.ToString();
            String clave = producto.Split('-')[0].Trim();

            if (!inventario.ContainsKey(clave))
            {
                if(inventario[clave] <= cantidad)
                {
                    MessageBox.Show("No hay suficiente stock", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                    return;
                }

        }
    }
}
