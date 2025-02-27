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

namespace Ud4Hoja5
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

        private void treeview_SelectedItemChanged(object sender, RoutedPropertyChangedEventArgs<object> e)
        {
            if (treeview.SelectedItem != null)
            {
                if(treeview.SelectedItem is TreeViewItem selectedItem)
                {
                    tbDetalles.Text = "Categoria seleccionada: " + selectedItem.Header;
                }
                else
                {
                    tbDetalles.Text = "Seleccione una categoría para ver los detalles.";
                }
            }
        }
    }
}
