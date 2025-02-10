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

namespace Ud4Hoja2EJ2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnPago_Click(object sender, RoutedEventArgs e)
        {
            if(!int.TryParse(tbCantidad.Text, out int cantidad) || cantidad <= 0) {
                MessageBox.Show("Introduce una cantidad válida");
                return;
            }
            if(cbPlazo.SelectedIndex == null) {
                MessageBox.Show("Selecciona un plazo");
                return;
            }
            if(rdoBaja.IsChecked == false && rdoMedia.IsChecked == false && rdoAlta.IsChecked == false) {
                MessageBox.Show("Selecciona un tipo de interés");
                return;
            }

            double plazo = cbPlazo.SelectedIndex;
            double interes = -1;

            if(rdoBaja.IsChecked == true) {
                interes = 0.03/12;
            } else if(rdoMedia.IsChecked == true) {
                interes = 0.05/12;
            } else if(rdoAlta.IsChecked == true) {
                interes = 0.07/12;
            }
             double pago = (cantidad*interes)/(1-Math.Pow(1+interes,-(plazo*12)));

            tbMensualidad.Text = pago.ToString("0.00");
        }

        private void btnReset_Click(object sender, RoutedEventArgs e)
        {
            tbCantidad.Text = "";
            cbPlazo.SelectedIndex = -1;
            rdoBaja.IsChecked = false;
            rdoMedia.IsChecked = false;
            rdoAlta.IsChecked = false;
            tbMensualidad.Text = "";            
        }

        private void btnSalir_Click(object sender, RoutedEventArgs e)
        {
            App.Current.Shutdown();
        }
    }
}
