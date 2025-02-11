using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace Ud4Hoja3
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<TabItem> Tabs { get; set; }
        private BitmapImage biCancelar = new BitmapImage(new Uri("Imagenes/cancelar.png", UriKind.Relative));

        private Stretch AjusteSeleccionado;

        private Dictionary<string, string> rutasImagenes = new Dictionary<string, string>();
        private int indice = 0;

        private int nextIndice()
        {
            indice++;
            return indice;
        }

        public MainWindow()
        {
            InitializeComponent();
            Tabs = new ObservableCollection<TabItem>();
            tcImagenes.ItemsSource = Tabs;
        }

        private void CloseTab_Click(object sender, RoutedEventArgs e)
        {
            if (sender is Button button && button.DataContext is TabItem tabItem)
            {
                Tabs.Remove(tabItem);
            }
        }

        private void AddImagen(string imagePath)
        {
            Uri uri = new Uri(imagePath);
            BitmapImage bitmap = new BitmapImage(uri);

            TabItem newTab = new TabItem();
            
            StackPanel spCabecera = new StackPanel{ Orientation = Orientation.Horizontal };
            TextBlock tbTitulo = new TextBlock(new Run(System.IO.Path.GetFileName(imagePath)));
            Image iCabecera = new Image { Source = biCancelar};
            iCabecera.MouseUp += ICabecera_MouseUp;
            spCabecera.Children.Add(tbTitulo);
            spCabecera.Children.Add(iCabecera);
            newTab.Header = spCabecera;

            Grid gContenedor = new Grid();
            ScrollViewer svContenedor = new ScrollViewer();
            svContenedor.VerticalScrollBarVisibility = ScrollBarVisibility.Auto;
            svContenedor.HorizontalScrollBarVisibility = ScrollBarVisibility.Auto;
            Image iContenedor = new Image();
            iContenedor.Source = bitmap;
            iContenedor.Stretch = this.AjusteSeleccionado;

            string nombreVisor = "visor" + nextIndice();
            newTab.Tag = nombreVisor;
            iContenedor.Name = nombreVisor;

            this.rutasImagenes.Add(nombreVisor, imagePath);

            RegisterName(nombreVisor, iContenedor);

            newTab.Content = gContenedor;
            gContenedor.Children.Add(svContenedor);
            svContenedor.Content = iContenedor;

            Tabs.Add(newTab);
            this.tcImagenes.SelectedItem = newTab;

            MenuItem entradaMenu = new MenuItem();
            entradaMenu.Header = System.IO.Path.GetFileName(imagePath);
            entradaMenu.Tag = newTab;
            entradaMenu.Click += EntradaMenu_Click;
            this.mnImagenes.Items.Add(entradaMenu);

        }

        private void EntradaMenu_Click(object sender, RoutedEventArgs e)
        {
            TabItem tab = (TabItem)(sender as MenuItem).Tag;
            this.tcImagenes.SelectedItem = tab;
        }

        private void ICabecera_MouseUp(object sender, MouseButtonEventArgs e)
        {
           

        }

        private void mnArchivoSalir_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }

        private void mnArchivoAbrir_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog
            {
                Filter = "Image files (*.png;*.jpg;*.jpeg;*.bmp;*.gif)|*.png;*.jpg;*.jpeg;*.bmp;*.gif|All files (*.*)|*.*"
            };

            if (openFileDialog.ShowDialog() == true)
            {
                AddImagen(openFileDialog.FileName);
            }
        }

        private void cbi_DataContextChanged(object sender, DependencyPropertyChangedEventArgs e)
        {
           if(cbiNone.IsSelected)
            {
                this.AjusteSeleccionado = Stretch.None;
            }
            else if(cbiFill.IsSelected)
            {
                this.AjusteSeleccionado = Stretch.Fill;
            }
            else if(cbiUniform.IsSelected)
            {
                this.AjusteSeleccionado = Stretch.Uniform;
            }
            else if(cbiUniformToFill.IsSelected)
            {
                this.AjusteSeleccionado = Stretch.UniformToFill;
            }
        }

    }
}
