using ProjectStore.Entities;
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
    public partial class ModAlumno : Form
    {
        Alumno alumno;
        public ModAlumno(Alumno a)
        {
            InitializeComponent();
            alumno = a;
            txtNombre.Text = a.Nombre;
            txtApellidos.Text = a.Apellidos;
            txtDni.Text = a.Dni;
            txtEmail.Text = a.Email;
            txtContraseña.Text = a.Contraseña;
            txtTelefono.Text = a.Telefono;
            cmbGenero.Text = a.Genero.ToString();
            dtpFechaNac.Value = a.FechaNacimiento;
            cmbCiclo.Text = a.Ciclo.Nombre;
            chkActivo.Checked = a.Activo;
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
                    if (alumno.Email != txtEmail.Text)
                    {
                        alumno.Email = txtEmail.Text;
                    }
                    if (alumno.Contraseña != txtContraseña.Text)
                    {
                        alumno.Contraseña = txtContraseña.Text;
                    }
                    if (alumno.Telefono != txtTelefono.Text)
                    {
                        alumno.Telefono = txtTelefono.Text;
                    }
                    if (alumno.Activo != chkActivo.Checked)
                    {
                        alumno.Activo = chkActivo.Checked;
                    }

                    ConexionApi conexion = new ConexionApi();
                    if (await conexion.ActualizarAlumno(alumno.Id, alumno))
                    {
                        MessageBox.Show("Alumno modificado correctamente", "Exito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                    else
                    {
                        MessageBox.Show("Error al modificar el alumno", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }

                    
                }
                DialogResult = DialogResult.OK;
            }
        }
    }
}

