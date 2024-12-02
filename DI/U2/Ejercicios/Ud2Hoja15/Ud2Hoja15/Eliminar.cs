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
    public partial class Eliminar : Form
    {
        Empleado emp;
        public Eliminar()
        {
            InitializeComponent();
            cargaLista();
        }

        public void cargaLista()
        {
            lstEmpleados.Items.Clear();
            foreach (Empleado emp in Principal.empleados)
            {
                ListViewItem item = new ListViewItem(emp.Nombre);
                item.SubItems.Add(emp.Apellidos);
                item.SubItems.Add(emp.edad.ToString());
                item.SubItems.Add(emp.departamento);
                item.Tag = emp;
                lstEmpleados.Items.Add(item);
            }
        }

        private void lstEmpleados_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            if (lstEmpleados.SelectedItems.Count < 0)
            {
                ListViewItem item = lstEmpleados.SelectedItems[0];
                emp = (Empleado)item.Tag;
            }
        }

        private void lstEmpleados_DoubleClick(object sender, EventArgs e)
        {
            MessageBox.Show("¿Está seguro de que desea eliminar el empleado?", "Atencion", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
            if (DialogResult == DialogResult.Yes)
            {
                Principal.empleados.Remove(emp);
                DialogResult = DialogResult.OK;
            }
        }
    }
}
