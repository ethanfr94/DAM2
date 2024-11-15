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
        public String nombre { get; set; }
        public String departamento { get; set; }

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

        private void button1_Click(object sender, EventArgs e)
        {
            nombre = txtNombre.Text;
            departamento = txtDepartamento.Text;
            DialogResult = DialogResult.OK;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }
    }
}
