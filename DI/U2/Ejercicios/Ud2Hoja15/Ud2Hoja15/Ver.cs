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
    public partial class Ver : Form
    {
        public Ver()
        {
            InitializeComponent();
            cargaLista();
        }

        private void cargaLista()
        {
            lstEmpleados.Items.Clear();
            foreach (Empleado emp in Principal.empleados)
            {
                lstEmpleados.Items.Add(emp.Nombre + " " + emp.Apellidos);
            }
        }

        private void lstEmpleados_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }
    }
}
