using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectStore
{
    public partial class ModProfesor : Form
    {
        Profesor profesor;
        public ModProfesor(Profesor p)
        {
            InitializeComponent();
            profesor = p;
            txtNombre.Text = p.Nombre;
            txtApellidos.Text = p.Apellidos;
            txtDni.Text = p.Dni;
            txtEmail.Text = p.Email;
            txtContraseña.Text = p.Contraseña;
            txtTelefono.Text = p.Telefono;
            cmbGenero.Text = p.Genero.ToString();
            dtpFechaNac.Value = p.FechaNacimiento;
            txtEspecialidad.Text = p.Especialidad;
            chkActivo.Checked = p.Activo;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        private async void btnMod_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Esta seguro de modificar los datos", "Atencion", MessageBoxButtons.OKCancel, MessageBoxIcon.Exclamation);
            if (DialogResult == DialogResult.OK)
            {
                if (new[] { txtEmail.Text, txtContraseña.Text, cmbGenero.Text }.Any(c => string.IsNullOrWhiteSpace(c)))
                {
                    MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                {
                    if (profesor.Email != txtEmail.Text)
                    {
                        profesor.Email = txtEmail.Text;
                    }
                    if (profesor.Contraseña != txtContraseña.Text)
                    {
                        profesor.Contraseña = txtContraseña.Text;
                    }
                    if (profesor.Telefono != txtTelefono.Text)
                    {
                        profesor.Telefono = txtTelefono.Text;
                    }
                    if (profesor.Activo != chkActivo.Checked)
                    {
                        profesor.Activo = chkActivo.Checked;
                    }

                    ConexionApi conexion = new ConexionApi();
                    if (await conexion.ActualizarProfesor(profesor.Id, profesor))
                    {
                        MessageBox.Show("Profesor modificado correctamente", "Exito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                    else
                    {
                        MessageBox.Show("Error al modificar el profesor", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }

                }
                DialogResult = DialogResult.OK;
            }
        }
    }
}
