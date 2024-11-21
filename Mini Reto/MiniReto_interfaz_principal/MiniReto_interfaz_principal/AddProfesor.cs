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
    public partial class AddProfesor : Form
    {
        public AddProfesor()
        {
            InitializeComponent();
            cargaComboGenero();
        }

        private void cargaComboGenero()
        {
            foreach (Genero genero in Enum.GetValues(typeof(Genero)))
            {
                cmbGenero.Items.Add(genero);
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if(txtNombre.Text == "" || txtApellidos.Text == "" || txtDni.Text == "" || txtEmail.Text == "" || txtContraseña.Text == "" || cmbGenero.Text == "")
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                Profesor profesor = new Profesor();
                profesor.Nombre = txtNombre.Text;
                profesor.Apellidos = txtApellidos.Text;
                profesor.Dni = txtDni.Text;
                profesor.Email = txtEmail.Text;
                profesor.Contraseña = txtContraseña.Text;
                profesor.Telefono = txtTelefono.Text;
                profesor.Genero = (Genero)cmbGenero.SelectedItem;
                profesor.FechaNacimiento = dtpFechaNac.Value;
                profesor.Especialidad = txtEspecialidad.Text;
                profesor.Activo = true;
                Principal.profesores.Add(profesor);
                DialogResult = DialogResult.OK;
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }
    }
}
