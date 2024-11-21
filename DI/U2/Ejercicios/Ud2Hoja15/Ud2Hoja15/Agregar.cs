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
    public partial class AgregarEmpleado : Form
    {
        public AgregarEmpleado()
        {
            InitializeComponent();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            Empleado emp = new Empleado();
            emp.Nombre = txtNombre.Text;
            emp.Apellidos = txtApellidos.Text;
            emp.edad = int.Parse(txtEdad.Text);
            emp.departamento = txtDept.Text;
            Principal.empleados.Add(emp);
        }
    }
}
