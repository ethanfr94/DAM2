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

namespace Ud4Hoja1
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

        private void btnCalcular_Click(object sender, RoutedEventArgs e)
        {
            float valor1 = Convert.ToSingle(txtPrimero.Text);
            float valor2 = Convert.ToSingle(txtSegundo.Text);
            float resultado = 0;

            // Obtener el elemento seleccionado en el ComboBox
            var selectedItem = cmbOperacion.SelectedItem as ComboBoxItem;
            if (selectedItem == null)
            {
                MessageBox.Show("Seleccione una operación válida.");
                return;
            }

            string operacion = selectedItem.Tag.ToString();

            Run infoEntrada = new Run(valor1 + " " + operacion + " " + valor2);

            // Realizar la operación correspondiente
            switch (operacion)
            {
                case "+":
                    resultado = valor1 + valor2;
                    break;
                case "-":
                    resultado = valor1 - valor2;
                    break;
                case "*":
                    resultado = valor1 * valor2;
                    break;
                case "/":
                    if (valor2 != 0)
                    {
                        resultado = valor1 / valor2;
                    }
                    else
                    {
                        MessageBox.Show("No se puede dividir por cero.");
                        return;
                    }
                    break;
                default:
                    MessageBox.Show("Seleccione una operación válida.");
                    return;
            }

            // Mostrar el resultado
            // Crear un nuevo elemento de tipo Span para mostrar la información de entrada y salida formateada
            Span formSalida = new Span();
            // formatea la salida con negrita
            formSalida.FontWeight = FontWeights.Bold;
            // añade al  elemento de salida la información de entrada y un salto de linea
            formSalida.Inlines.Add(infoEntrada);
            formSalida.Inlines.Add(new LineBreak());

            // Añadir el resultado al elemento de salida
            Run infoSalida = new Run("Resultado: " + resultado);
            // Cambiar el color de fondo del resultado
            infoSalida.Background = new SolidColorBrush(Colors.Aqua);
            // Añadir el resultado al elemento de salida y un salto de linea
            formSalida.Inlines.Add(infoSalida);
            formSalida.Inlines.Add(new LineBreak());

            tbResultado.Inlines.Add(formSalida);
        }

        private void btnSalir_Click(object sender, RoutedEventArgs e)
        {
           App.Current.Shutdown();
        }
    }
}
