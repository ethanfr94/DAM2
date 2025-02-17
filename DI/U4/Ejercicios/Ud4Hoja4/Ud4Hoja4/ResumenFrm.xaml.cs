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
using System.Windows.Shapes;

namespace Ud4Hoja4
{
    /// <summary>
    /// Lógica de interacción para ResumenFrm.xaml
    /// </summary>
    public partial class ResumenFrm : Window
    {
        public ResumenFrm(Evento evento)
        {
            InitializeComponent();
            txtNombre.Text = evento.Nombre;
            dpFecha.Text = evento.Fecha.ToShortDateString();
            txtHora.Text = evento.Hora.ToShortTimeString();
            txtAforo.Text = evento.Aforo.ToString();
            txtPromotor.Text = evento.Promotor.ToString();
            txtTipo.Text = evento.Tipo.ToString();
            txtDescripcion.Text = evento.Descripcion;

            bool par = false;
            Brush pincel;

            Brush pincelPar = new SolidColorBrush(Colors.Aqua);
            Brush pincelImpar = new SolidColorBrush(Colors.LightGreen);
             


            Span salida = new Span();

            if(evento.Seguridad)
            {
                if (par)
                {
                    pincel = pincelPar;
                }
                else
                {
                    pincel = pincelImpar;
                }
                Run run = new Run("Seguridad ");
                run.Background = pincel;
                salida.Inlines.Add(run);
                salida.Inlines.Add(new LineBreak());
                par = !par;
            }
            if(evento.Bar)
            {
                if (par)
                {
                    pincel = pincelPar;
                }
                else
                {
                    pincel = pincelImpar;
                }
                Run run = new Run("Bar ");
                run.Background = pincel;
                salida.Inlines.Add(run);
                salida.Inlines.Add(new LineBreak());
                par = !par;
            }
            if(evento.Montaje)
            {
                if (par)
                {
                    pincel = pincelPar;
                }
                else
                {
                    pincel = pincelImpar;
                }
                Run run = new Run("Montaje ");
                run.Background = pincel;
                salida.Inlines.Add(run);
                salida.Inlines.Add(new LineBreak());
                par = !par;
            }
            if(evento.Sanitarios)
            {
                if (par)
                {
                    pincel = pincelPar;
                }
                else
                {
                    pincel = pincelImpar;
                }
                Run run = new Run("Sanitarios ");
                run.Background = pincel;
                salida.Inlines.Add(run);
                salida.Inlines.Add(new LineBreak());
                par = !par;
            }

            tbRequisitos.Inlines.Add(salida);



            
        }

        private void btnAceptar_Click(object sender, RoutedEventArgs e)
        {
            DialogResult = true;
        }

        private void btnCancelar_Click(object sender, RoutedEventArgs e)
        {
            DialogResult = false;
        }
    }
}
