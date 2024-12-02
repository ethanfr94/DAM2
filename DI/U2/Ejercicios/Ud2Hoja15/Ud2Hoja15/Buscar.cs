using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ud2Hoja15
{
    public partial class Buscar : Form
    {
        public int criterio;
        public string busqueda;
        public Buscar()
        {
            InitializeComponent();
            txtNombre.Enabled = true;
            txtDepartamento.Enabled = false;
        }

        private void rdoNombre_CheckedChanged(object sender, EventArgs e)
        {
            txtNombre.Enabled = true;
            txtDepartamento.Enabled = false;
        }

        private void rdoDept_CheckedChanged(object sender, EventArgs e)
        {
            txtDepartamento.Enabled = true;
            txtNombre.Enabled = false;
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            if (rdoNombre.Checked)
            {
                criterio = 0;
                busqueda = txtNombre.Text;
                DialogResult = DialogResult.OK;
            }
            else if (rdoDept.Checked)
            {
                criterio = 1;
                busqueda = txtDepartamento.Text;
                DialogResult = DialogResult.OK;
            }
            else
            {
                MessageBox.Show("Debe seleccionar un criterio de busqueda", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                DialogResult = DialogResult.Cancel;
            }
            Ver ver = new Ver();
            ver.cargaBusqueda(criterio, busqueda);
            ver.MdiParent = Principal.ActiveForm;
            ver.Show();
            this.Close();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
