using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ud2Hoja10
{
    public partial class FormBuscar : Form
    {
        public FormBuscar()
        {
            InitializeComponent();
        }

        private String busqueda = "";

        public String Busqueda
        {
            get { return busqueda; }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            if(txtBuscar.Text == "")
            {
                MessageBox.Show("Introduce un texto a buscar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else {
                busqueda = txtBuscar.Text;
                this.DialogResult = DialogResult.OK;
                this.Close();
                
            }
        }
    }
}
