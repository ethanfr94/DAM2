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
    public partial class InformeEstudios : Form
    {
        public InformeEstudios()
        {
            InitializeComponent();
        }

        // Evento de carga de los datos del informe
        private void InformeEstudios_Load(object sender, EventArgs e)
        {
            try
            {
                List<Estudio> estudios = EstudioRepositorio.ObtenerEstudios();
                ReportDataSource rds = new ReportDataSource("DataSetEstudios", estudios);
                rpvEstudios.LocalReport.DataSources.Clear();
                rpvEstudios.LocalReport.DataSources.Add(rds);

                rpvEstudios.RefreshReport();

            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al cargar el informe: " + ex.Message);
            }
        }
    }
}
