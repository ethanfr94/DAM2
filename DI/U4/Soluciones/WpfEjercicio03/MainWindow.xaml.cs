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
using System.Diagnostics;

namespace WpfEjercicio03
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private TipoEventoEnum _tipoEventoActual;

        public MainWindow()
        {
            InitializeComponent();
            //Evento cosa = new Evento() { Nombre = "Fiesta pueblo", Hora = default(DateTime).AddHours(10).AddMinutes(20) };
            //this.txtHora.DataContext = cosa;
            //this.DataContext = cosa;           
        }

        private void btnMostrar_Click(object sender, RoutedEventArgs e)
        {
            if (this.ValidarEntrada() == false)
            {
                return;
            }

            Evento evento = new Evento();
            evento.Nombre = this.txtNombre.Text;
            evento.Fecha = this.dpFecha.SelectedDate.Value;
            evento.Hora = Convert.ToDateTime(this.txtHora.Text);
            evento.Aforo = Convert.ToInt32(this.txtAforo.Text);
            evento.Tipo = _tipoEventoActual;
            evento.Promotor = (this.cmbPromotor.SelectedItem as ComboBoxItem).Content.ToString();
            evento.Seguridad = this.chkSeguridad.IsChecked.HasValue ? this.chkSeguridad.IsChecked.Value : false;
            evento.Bar = this.chkBar.IsChecked.HasValue ? this.chkBar.IsChecked.Value : false;
            evento.Montaje = this.chkMontaje.IsChecked.HasValue ? this.chkMontaje.IsChecked.Value : false;
            evento.Sanitarios = this.chkSanitarios.IsChecked.HasValue ? this.chkSanitarios.IsChecked.Value : false;
            evento.Descripcion = this.txtDescripcion.Text;

            ResumenFrm ventana = new ResumenFrm(evento);
            bool? resultado = ventana.ShowDialog();
            if (resultado.HasValue)
            {
                if (resultado == true)
                {
                    MessageBox.Show("Datos correctos", "Información", MessageBoxButton.OK, MessageBoxImage.Information);
                }
                else
                {
                    MessageBox.Show("Datos incorrectos", "Información", MessageBoxButton.OK, MessageBoxImage.Information);
                }
            }
        }

        private bool ValidarEntrada()
        {
            if (this.dpFecha.SelectedDate == null)
            {
                MessageBox.Show("La fecha es obligatoria", "Información", MessageBoxButton.OK, MessageBoxImage.Information);
                this.dpFecha.Focus();
                return false;
            }

            if (string.IsNullOrEmpty(this.txtHora.Text))
            {
                MessageBox.Show("La hora es obligatoria", "Información", MessageBoxButton.OK, MessageBoxImage.Information);
                this.txtHora.Focus();
                return false;
            }

            if (string.IsNullOrEmpty(this.txtAforo.Text))
            {
                MessageBox.Show("El aforo es obligatorio", "Información", MessageBoxButton.OK, MessageBoxImage.Information);
                this.txtAforo.Focus();
                return false;
            }

            return true;
        }

        private void txtHora_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            //detallito, no hace falta pulsar los dos puntos
            if (this.txtHora.Text.Length == 2 && e.Text != ":")
            {
                this.txtHora.Text += ":";
                this.txtHora.CaretIndex = 3;
            }
        }

        private void txtHora_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            //Debug.WriteLine("Ha pulsado: " + e.Key);

            if (e.Key == Key.Back || e.Key == Key.Tab)
            {
                return;
            }

            if (this.txtHora.Text.Length == 5)
            {
                e.Handled = true;
                return;
            }

            if (this.txtHora.Text.Length == 2 &&
                e.Key == Key.OemPeriod &&
                e.KeyboardDevice.IsKeyDown(Key.RightShift)
                ) //haria falta lo mismo con el shiftleft
            {
                return;
            }

            // Key pulsada = e.Key;
            if (e.Key >= Key.NumPad0 && e.Key <= Key.NumPad9
                ||
                e.Key >= Key.D0 && e.Key <= Key.D9
                )
            {
                return;
            }
            e.Handled = true;
        }

        private void txtHora_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (this.txtHora.Text.Length == 5)
            {
                DateTime fecha;
                if (DateTime.TryParse(this.txtHora.Text, out fecha) == false)
                {
                    this.txtHora.Text = string.Empty;
                }
            }
        }

        private void RadioButton_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton origen = sender as RadioButton;
            switch (origen.Content.ToString())
            {
                case "Todos":
                    _tipoEventoActual = TipoEventoEnum.Todos;
                    break;
                case "<10":
                    _tipoEventoActual = TipoEventoEnum.Menor10;
                    break;
                case ">16":
                    _tipoEventoActual = TipoEventoEnum.Mayor16;
                    break;
                case ">18":
                    _tipoEventoActual = TipoEventoEnum.Mayor18;
                    break;
                default:
                    break;
            }
        }

        private void txtAforo_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Back || e.Key == Key.Tab)
            {
                return;
            }

            if (e.Key >= Key.NumPad0 && e.Key <= Key.NumPad9 
                ||
                e.Key >= Key.D0 && e.Key <= Key.D9)
            {
                return;
            }
            e.Handled = true;
        }
    }
}
