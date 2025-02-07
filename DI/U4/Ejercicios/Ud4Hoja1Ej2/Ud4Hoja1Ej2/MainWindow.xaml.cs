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

namespace Ud4Hoja1Ej2
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

        private void btnSalir_Click(object sender, RoutedEventArgs e)
        {
            App.Current.Shutdown();
        }

        private void btnConfirmar_Click(object sender, RoutedEventArgs e)
        {
            String nombre = txtNombre.Text;
            String fecha = dtpFecha.SelectedDate.ToString();
            float total = 0;
            // Obtener el elemento seleccionado en el ComboBox
            var selectedItem = cmbNoches.SelectedItem as ComboBoxItem;
            if (selectedItem == null)
            {
                MessageBox.Show("Seleccione una operación válida.");
                return;
            }
            string noches = selectedItem.Tag.ToString();

            String tipoHabitacion = "";
            if(rdoEstandar.IsChecked == true)
            {
                tipoHabitacion = "Estándar";
                total = 50 * float.Parse(noches);
            }
            else if(rdoSuite.IsChecked == true)
            {
                tipoHabitacion = "Superior";
                total = 80 * float.Parse(noches);
            }
            else if(rdoPremium.IsChecked == true)
            {
                tipoHabitacion = "Suite";
                total = 120 * float.Parse(noches);
            }

            String adicionales = "";
            if(chkDesayuno.IsChecked == true)
            {
                total += (10 * float.Parse(noches));
                adicionales += "Desayuno\n";
            }
            if(chkSpa.IsChecked == true)
            {
                total += (20 * float.Parse(noches));
                adicionales += "Spa\n";
            }
            if(chkAparcamiento.IsChecked == true)
            {
                total += (5 * float.Parse(noches));
                adicionales += "Aparcamiento\n";
            }

            tbResumen.Inlines.Clear();

            Run infoEntrada = new Run("Nombre del cliente: "+nombre+
                "\n Fecha de reserva: "+fecha+
                "\n Noches contratadas: "+noches+
                "\n Tipo de habitacion: "+tipoHabitacion+
                "\n Servicios adicionales: \n"+adicionales);

            Span info = new Span();
            info.Inlines.Add(infoEntrada);
            info.Inlines.Add(new LineBreak());
            
            Run infoSalida = new Run("Total a pagar: "+total+"€");

            infoSalida.Foreground = new SolidColorBrush(Colors.Red);
            info.Inlines.Add(infoSalida);

            tbResumen.Inlines.Add(info);

        }

        

    }
}
