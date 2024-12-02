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
        public Empleado emp;
        public Ver()
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

        public void cargaBusqueda(int criterio, string busqueda)
        {

            lstEmpleados.Items.Clear();
            foreach (Empleado emp in Principal.empleados)
            {
                if(criterio == 0)
                {
                    if(emp.Nombre.Contains(busqueda))
                    {
                        ListViewItem item = new ListViewItem(emp.Nombre);
                        item.SubItems.Add(emp.Apellidos);
                        item.SubItems.Add(emp.edad.ToString());
                        item.SubItems.Add(emp.departamento);
                        item.Tag = emp;
                        lstEmpleados.Items.Add(item);
                    }
                }
                else
                {
                    if(emp.departamento.Contains(busqueda))
                    {
                        ListViewItem item = new ListViewItem(emp.Nombre);
                        item.SubItems.Add(emp.Apellidos);
                        item.SubItems.Add(emp.edad.ToString());
                        item.SubItems.Add(emp.departamento);
                        item.Tag = emp;
                        lstEmpleados.Items.Add(item);
                    }
                }
            }
        }

        private void lstEmpleados_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstEmpleados.SelectedItems.Count < 0)
            {
                ListViewItem item = lstEmpleados.SelectedItems[0];
                emp = (Empleado)item.Tag;                
            }

        }
    }
}
