using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tienda
{
    public partial class FormInformes : Form
    {
        public FormInformes()
        {
            InitializeComponent();
        }

        // Evento click del botón de videojuegos que muestra el informe de videojuegos
        private void btnVideojuegos_Click(object sender, EventArgs e)
        {
            InformeVideojuegos formInforme = new InformeVideojuegos();
            formInforme.Show();
        }

        // Evento click del botón de estudios que muestra el informe de estudios
        private void btnEstudios_Click(object sender, EventArgs e)
        {
            InformeEstudios formInforme = new InformeEstudios();
            formInforme.Show();
        }
    }
}
