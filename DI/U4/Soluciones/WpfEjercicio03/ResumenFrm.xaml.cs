using System.Windows;
using System.Windows.Documents;
using System.Windows.Media;

namespace WpfEjercicio03
{
    /// <summary>
    /// Lógica de interacción para ResumenFrm.xaml
    /// </summary>
    public partial class ResumenFrm : Window
    {
        private ResumenFrm()
        {
            InitializeComponent();
        }

        public ResumenFrm(Evento evento) : this()
        {
            //casca
            //this.DialogResult = false;
            this.txtNombre.Text = evento.Nombre;
            this.dpFecha.SelectedDate = evento.Fecha;
            this.txtHora.Text = evento.Hora.ToShortTimeString();
            this.txtAforo.Text = evento.Aforo.ToString();
            this.txtPromotor.Text = evento.Promotor;
            this.txtTipo.Text = evento.Tipo.ToString();

            bool par = false;
            Brush brocha;
            Brush brochaPar = new SolidColorBrush(Colors.Aqua);
            Brush brochaImpar = new SolidColorBrush(Colors.LightGreen);
            if (evento.Seguridad)
            {
                if (par)
                {
                    brocha = brochaPar;
                }
                else
                {
                    brocha = brochaImpar;
                }
                par = !par;
                this.tbRequisitos.Inlines.Add(new Run("Seguridad") { Background = brocha });
            }
            if (evento.Bar)
            {
                if (this.tbRequisitos.Inlines.Count > 0)
                {
                    this.tbRequisitos.Inlines.Add(new LineBreak());
                }

                if (par)
                {
                    brocha = brochaPar;
                }
                else
                {
                    brocha = brochaImpar;
                }
                par = !par;
                this.tbRequisitos.Inlines.Add(new Run("Bar") { Background = brocha });
            }
            if (evento.Montaje)
            {
                if (this.tbRequisitos.Inlines.Count > 0)
                {
                    this.tbRequisitos.Inlines.Add(new LineBreak());
                }

                if (par)
                {
                    brocha = brochaPar;
                }
                else
                {
                    brocha = brochaImpar;
                }
                par = !par;
                this.tbRequisitos.Inlines.Add(new Run("Montaje") { Background = brocha });
            }
            if (evento.Sanitarios)
            {
                if (this.tbRequisitos.Inlines.Count > 0)
                {
                    this.tbRequisitos.Inlines.Add(new LineBreak());
                }
                if (par)
                {
                    brocha = brochaPar;
                }
                else
                {
                    brocha = brochaImpar;
                }
                par = !par;
                this.tbRequisitos.Inlines.Add(new Run("Sanitarios") { Background = brocha });
            }

            this.txtDescripcion.Text = evento.Descripcion;
        }

        private void btnCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.DialogResult = true;
        }

        private void btnAceptar_Click(object sender, RoutedEventArgs e)
        {
            this.DialogResult = false;
        }
    }
}
