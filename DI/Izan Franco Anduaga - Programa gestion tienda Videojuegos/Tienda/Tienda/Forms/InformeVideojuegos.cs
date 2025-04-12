using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.Reporting.WinForms;

namespace Tienda
{
    public partial class InformeVideojuegos : Form
    {
        public InformeVideojuegos()
        {
            InitializeComponent();
        }

        // Evento de carga de los datos del informe
        private void InformeVideojuegos_Load(object sender, EventArgs e)
        {
            try
            {
                List<Videojuego> videojuegos = Videojuegorepositorio.ObtenerVideojuegos();
                ReportDataSource rds = new ReportDataSource("DataSetVideojuegos", videojuegos);
                rpvVideojuegos.LocalReport.DataSources.Clear();
                rpvVideojuegos.LocalReport.DataSources.Add(rds);

                rpvVideojuegos.RefreshReport();

            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar el informe: " + ex.Message);
            }
        }
    }
}
