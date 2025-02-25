using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;

namespace WpfEjercicio04
{
    /// <summary>
    /// Lógica de interacción para ReservaFrm.xaml
    /// </summary>
    public partial class ReservaFrm : Window
    {
        private Reserva reserva;

        private ReservaFrm()
        {
            InitializeComponent();
        }

        public ReservaFrm(Reserva reserva) : this()
        {
            this.reserva = reserva;
            //nombre, fecha, telefono, comensales, asiste, observaciones
            this.txtNombre.Text = reserva.Nombre;
            if (reserva.ReservaId == 0)
            {
                this.dpFecha.SelectedDate = DateTime.Today;
            }
            else
            {
                this.dpFecha.SelectedDate = reserva.Fecha;
            }
            this.txtTelefono.Text = reserva.Telefono;
            this.txtComensales.Text = reserva.Comensales.ToString();
            this.chkAsiste.IsChecked = reserva.Asiste;
            this.txtObeservaciones.Text = reserva.Observaciones;
        }

        private void btnAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (this.ValidarDatos() == false)
            {
                e.Handled = true;
                return;
            }

            this.DialogResult = true;
            this.reserva.Nombre = this.txtNombre.Text;
            this.reserva.Fecha = this.dpFecha.SelectedDate.Value;
            this.reserva.Telefono = this.txtTelefono.Text;
            this.reserva.Comensales = Convert.ToInt32(this.txtComensales.Text);
            this.reserva.Asiste = this.chkAsiste.IsChecked.Value;
            this.reserva.Observaciones = this.txtObeservaciones.Text;

            this.Close();
        }

        private bool ValidarDatos()
        {
            if (string.IsNullOrEmpty(this.txtNombre.Text))
            {
                MessageBox.Show("El campo nombre no puede estar vacío", "Atención", MessageBoxButton.OK, MessageBoxImage.Warning);
                this.txtNombre.Focus();
                return false;
            }

            if (this.dpFecha.SelectedDate == null)
            {
                MessageBox.Show("El campo fecha no puede estar vacío", "Atención", MessageBoxButton.OK, MessageBoxImage.Warning);
                this.dpFecha.Focus();
                return false;
            }

            if (string.IsNullOrEmpty(this.txtTelefono.Text))
            {
                MessageBox.Show("El campo teléfono no puede estar vacío", "Atención", MessageBoxButton.OK, MessageBoxImage.Warning);
                this.txtTelefono.Focus();
                return false;
            }

            if (string.IsNullOrEmpty(this.txtComensales.Text))
            {
                MessageBox.Show("El campo comensales no puede estar vacío", "Atención", MessageBoxButton.OK, MessageBoxImage.Warning);
                this.txtComensales.Focus();
                return false;
            }

            return true;
        }

        private void btnCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.DialogResult = false;
        }

        private void txtComensales_PreviewKeyDown(object sender, System.Windows.Input.KeyEventArgs e)
        {
            if(e.Key == Key.Back || e.Key == Key.Tab)
            {
                return;
            }

            if(e.Key >= Key.NumPad0 && e.Key <= Key.NumPad9)
            {
                return;
            }

            e.Handled = true;
        }

        private void txtTelefono_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Back || e.Key == Key.Tab)
            {
                return;
            }

            if (e.Key >= Key.NumPad0 && e.Key <= Key.NumPad9)
            {
                return;
            }

            e.Handled = true;
        }
    }
}
