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
using System.Windows.Media.Converters;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Ud4Hoja4
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private TipoEventoEnum tipoEvento;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnMostrar_Click(object sender, RoutedEventArgs e)
        {
            if (validarEntrada())
            {
                Evento evento = new Evento();

                evento.Nombre = this.txtNombre.Text;
                evento.Fecha = this.dpFecha.SelectedDate.Value;
                evento.Hora = Convert.ToDateTime(this.txtHora.Text);
                evento.Aforo = Convert.ToInt32(this.txtAforo.Text);
                evento.Promotor = (cbPromotor.SelectedItem as ComboBoxItem).Content.ToString();
                evento.Tipo = this.tipoEvento;
                evento.Descripcion = this.txtDescripcion.Text;
                evento.Seguridad = this.chkSeguridad.IsChecked.HasValue?chkBar.IsChecked.Value:false;   
                evento.Bar = this.chkBar.IsChecked.HasValue?chkBar.IsChecked.Value:false;
                evento.Montaje = this.chkMontaje.IsChecked.HasValue?chkMontaje.IsChecked.Value:false;
                evento.Sanitarios = this.chkSanitarios.IsChecked.HasValue?chkSanitarios.IsChecked.Value:false;

                ResumenFrm frm = new ResumenFrm(evento);
                bool? res = frm.ShowDialog();

                if (res.HasValue)
                {
                    if (res == true)
                    {
                        MessageBox.Show("Evento guardado correctamente", "Informacion", MessageBoxButton.OK, MessageBoxImage.Information);
                    }
                    else
                    {
                        MessageBox.Show("Evento no guardado", "Informacion", MessageBoxButton.OK, MessageBoxImage.Information);
                    }
                }       
            }
            else
            {
                return;
            }
        }

        public bool validarEntrada()
        {
            if(this.dpFecha.SelectedDate == null)
            {
                MessageBox.Show("Debe seleccionar una fecha","Informacion",MessageBoxButton.OK, MessageBoxImage.Information);
                this.dpFecha.Focus();
                return false;
            }
            if (string.IsNullOrEmpty(this.txtAforo.Text))
            {
                MessageBox.Show("Debe introducir un aforo", "Informacion", MessageBoxButton.OK, MessageBoxImage.Information);
                this.txtAforo.Focus();
                return false;
            }
            if (string.IsNullOrEmpty(this.txtHora.Text))
            {

               MessageBox.Show("Debe introducir una hora", "Informacion", MessageBoxButton.OK, MessageBoxImage.Information);
                this.txtHora.Focus();
                return false;
            }
            
            return true;
        }

        private void txtHora_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            if(txtHora.Text.Length == 2 && e.Text != ":")
            {
                txtHora.Text += ":";
                txtHora.CaretIndex = 3;
            }
        }

        private void RadioButton_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton rb = sender as RadioButton;
            switch (rb.Content.ToString())
            {
                case "Todos":
                    tipoEvento = TipoEventoEnum.Todos;
                    break;
                case "<10>":
                    tipoEvento = TipoEventoEnum.Menor10;
                    break;
                case ">16":
                    tipoEvento = TipoEventoEnum.Mayor16;
                    break;
                case ">18":
                    tipoEvento = TipoEventoEnum.Mayor18;
                    break;
                default:
                    break;
            }
        }
    }
}
