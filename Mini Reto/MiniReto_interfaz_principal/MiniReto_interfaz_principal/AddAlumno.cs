using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MiniReto_interfaz_principal
{
    public partial class AddAlumno : Form
    {
        public AddAlumno()
        {
            InitializeComponent();
            cargaComboGenero();
            cargaComboCiclo();
        }

        private void cargaComboGenero()
        {
            foreach (Genero genero in Enum.GetValues(typeof(Genero)))
            {
                cmbGenero.Items.Add(genero);
            }
        }

        private void cargaComboCiclo()
        {
            foreach (Ciclo ciclo in Principal.ciclos)
            {
                cmbCiclo.Items.Add(ciclo.Nombre);
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if(txtNombre.Text == "" || txtApellidos.Text == "" || txtDni.Text == "" || txtEmail.Text == "" || txtContraseña.Text == "" ||  cmbGenero.Text == "" || cmbCiclo.Text == "")
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                Alumno alumno = new Alumno();
                alumno.Nombre = txtNombre.Text;
                alumno.Apellidos = txtApellidos.Text;
                alumno.Dni = txtDni.Text;
                alumno.Email = txtEmail.Text;
                alumno.Contraseña = txtContraseña.Text;
                alumno.Telefono = txtTelefono.Text;
                alumno.Genero = (Genero)cmbGenero.SelectedItem;
                alumno.FechaNacimiento = dtpFechaNac.Value;
                alumno.Activo = true;
                alumno.Ciclo = Principal.ciclos[cmbCiclo.SelectedIndex];
                Principal.alumnos.Add(alumno);
                DialogResult = DialogResult.OK;
            }
        }
    }
}
