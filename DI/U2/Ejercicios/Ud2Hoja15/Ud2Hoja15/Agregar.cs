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
        Empleado emp;
        public AgregarEmpleado()
        {
            InitializeComponent();
            emp = new Empleado();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            emp.Nombre = txtNombre.Text;
            emp.Apellidos = txtApellidos.Text;
            emp.edad = int.Parse(txtEdad.Text);
            emp.departamento = txtDept.Text;
            Principal.empleados.Add(emp);
            this.Close();
        }
    }
}
