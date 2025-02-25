using System;
using System.Collections.Generic;
using System.ComponentModel;
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

namespace WpfEjercicio04
{

    /*
     Falta
    poner el ordenar
    poner el conversor
    al hacer un resize que se ajuste el tamaño de la columna nombre
     */

    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Negocio negocio;
        private GridViewColumnHeader columnaOrden;
        private ListSortDirection sentidoOrden;

        public MainWindow()
        {
            InitializeComponent();
            negocio = new Negocio();

            CargaDatos();
            RefrescarLista();
        }

        private void CargaDatos()
        {
            negocio.CrearReserva(new Reserva() { Nombre = "Pepe", Fecha = new DateTime(2021, 01, 2), Telefono = "942587412", Comensales = 2 });
            negocio.CrearReserva(new Reserva() { Nombre = "Alfredo", Fecha = new DateTime(2021, 03, 4), Telefono = "942753159", Comensales = 4, Asiste = true });
            negocio.CrearReserva(new Reserva() { Nombre = "Francisco", Fecha = new DateTime(2021, 06, 6), Telefono = "942852147", Comensales = 3 });
            negocio.CrearReserva(new Reserva() { Nombre = "Carmen", Fecha = new DateTime(2021, 04, 8), Telefono = "942789123", Comensales = 2 });
            negocio.CrearReserva(new Reserva() { Nombre = "Alberto", Fecha = new DateTime(2021, 02, 15), Telefono = "942654159", Comensales = 11, Asiste = true });
            negocio.CrearReserva(new Reserva() { Nombre = "Miguel", Fecha = new DateTime(2021, 05, 26), Telefono = "942751248", Comensales = 6 });
        }

        private void RefrescarLista()
        {
            Reserva[] reservas = negocio.ObtenerReservas();

            this.lvReservas.Items.Clear();

            foreach (Reserva reserva in reservas)
            {
                this.lvReservas.Items.Add(reserva);
            }

            ActualizarEstado();
        }

        private void btnFiltrar_Click(object sender, RoutedEventArgs e)
        {
            CollectionView vista = (CollectionView)CollectionViewSource.GetDefaultView(this.lvReservas.Items);
            vista.Filter = FiltroVista;

            this.ActualizarEstado();
        }

        private bool FiltroVista(object item)
        {
            if (string.IsNullOrEmpty(this.txtFiltro.Text))
            {
                return true;
            }

            string buscar = this.txtFiltro.Text.Trim();
            Reserva reserva = (Reserva)item;
            if (reserva.Nombre.Contains(buscar) || reserva.Fecha.ToShortDateString().Equals(buscar))
            {
                return true;
            }

            return false;
        }

        private void ActualizarEstado()
        {
            string filtro = this.txtFiltro.Text.Trim();
            string total = this.lvReservas.Items.Count.ToString();

            this.tbFiltro.Inlines.Clear();
            this.tbRegistros.Inlines.Clear();

            if (string.IsNullOrEmpty(filtro))
            {
                this.tbFiltro.Inlines.Add(new Run("Sin filtro"));
            }
            else
            {
                this.tbFiltro.Inlines.Add(new Run("Filtrando por '" + filtro + "'"));
            }

            if(total.Equals("1"))
            {
                this.tbRegistros.Inlines.Add(new Run(total + " registro"));
            }
            else
            {
                this.tbRegistros.Inlines.Add(new Run(total + " registros"));
            }
        }

        private void btnNueva_Click(object sender, RoutedEventArgs e)
        {
            Reserva nueva = new Reserva();
            ReservaFrm ventana = new ReservaFrm(nueva);
            if (ventana.ShowDialog() == true)
            {
                negocio.CrearReserva(nueva);
                this.RefrescarLista();
            }
        }

        private void lvReservas_ContextMenuOpening(object sender, ContextMenuEventArgs e)
        {
            //this.cmiNueva.IsEnabled = true;
            this.cmiVer.IsEnabled = false;
            this.cmiBorrar.IsEnabled = false;
            this.cmiConfirmar.IsEnabled = false;
            if (this.lvReservas.SelectedItem != null)
            {
                this.cmiVer.IsEnabled = true;
                this.cmiBorrar.IsEnabled = true;
                this.cmiConfirmar.IsEnabled = true;
            }
        }

        private void cmiNueva_Click(object sender, RoutedEventArgs e)
        {
            Reserva nueva = new Reserva();
            ReservaFrm ventana = new ReservaFrm(nueva);
            if (ventana.ShowDialog() == true)
            {
                negocio.CrearReserva(nueva);
                this.RefrescarLista();
            }
        }

        private void cmiVer_Click(object sender, RoutedEventArgs e)
        {
            Reserva reserva = (Reserva)this.lvReservas.SelectedItem;
            ReservaFrm ventana = new ReservaFrm(reserva);
            if (ventana.ShowDialog() == true)
            {
                this.RefrescarLista();
            }
        }

        private void cmiBorrar_Click(object sender, RoutedEventArgs e)
        {
            Reserva reserva = (Reserva)this.lvReservas.SelectedItem;
            if (MessageBox.Show("Borrar el elemento seleccionado", "Atención", MessageBoxButton.OKCancel, MessageBoxImage.Information) == MessageBoxResult.OK)
            {
                negocio.BorrarReserva(reserva.ReservaId);
                this.RefrescarLista();
            }
        }

        private void cmiConfirmar_Click(object sender, RoutedEventArgs e)
        {
            Reserva reserva = (Reserva)this.lvReservas.SelectedItem;
            ReservaFrm ventana = new ReservaFrm(reserva);
            if (MessageBox.Show("¿Confirmar la reserva?", "Atención", MessageBoxButton.OKCancel, MessageBoxImage.Information) == MessageBoxResult.OK)
            {
                reserva.Asiste = true;
                this.RefrescarLista();
            }
        }

        private void GridViewColumnHeader_Click(object sender, RoutedEventArgs e)
        {
            GridViewColumnHeader columnaClick = (sender as GridViewColumnHeader);
            string ordenarPor = columnaClick.Tag as string;

            if (columnaOrden == null)
            {
                columnaOrden = columnaClick;
                sentidoOrden = ListSortDirection.Descending;
            }

            this.lvReservas.Items.SortDescriptions.Clear();
            if (columnaOrden == columnaClick)
            {
                if (sentidoOrden == ListSortDirection.Ascending)
                {
                    sentidoOrden = ListSortDirection.Descending;
                }
                else
                {
                    sentidoOrden = ListSortDirection.Ascending;
                }
                this.lvReservas.Items.SortDescriptions.Add(
                    new SortDescription(ordenarPor, sentidoOrden));
            }
            else
            {
                columnaOrden = null;
            }
        }

        private void lvReservas_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            if (this.lvReservas.SelectedItem != null)
            {
                Reserva reserva = (Reserva)this.lvReservas.SelectedItem;
                ReservaFrm ventana = new ReservaFrm(reserva);
                ventana.ShowDialog();
            }
        }

        private void ventanaFrm_SizeChanged(object sender, SizeChangedEventArgs e)
        {
            AjustarAnchoColumnas();
        }

        private void ventanaFrm_StateChanged(object sender, EventArgs e)
        {
            switch (ventanaFrm.WindowState)
            {
                case WindowState.Normal:
                    AjustarAnchoColumnas();
                    break;
                case WindowState.Minimized:
                    break;
                case WindowState.Maximized:
                    AjustarAnchoColumnas();
                    break;
            }            
        }

        private void AjustarAnchoColumnas()
        {
            //800 tamaño original ventana
            //440 tamaño original columna nombre
            double cambio = this.ventanaFrm.RenderSize.Width - 800;
            if (cambio > 0)
            {
                this.gvcNombre.Width = 440 + cambio;
            }
            else
            {
                this.gvcNombre.Width = 440 - Math.Abs(cambio);
            }
        }
    }
}
