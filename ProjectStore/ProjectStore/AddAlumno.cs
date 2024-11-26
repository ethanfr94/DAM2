using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class AddAlumno : Form
    {
        public AddAlumno()
        {
            InitializeComponent();
            cargaComboGenero();    // Carga los géneros en el combo
            cargaComboCiclo();     // Carga los ciclos en el combo
        }

        // Carga los géneros del enum al combo
        private void cargaComboGenero()
        {
            foreach (Genero genero in Enum.GetValues(typeof(Genero)))
            {
                cmbGenero.Items.Add(genero);
            }
        }

        // Carga los ciclos disponibles al combo
        private void cargaComboCiclo()
        {
            foreach (Ciclo ciclo in Principal.ciclos)
            {
                cmbCiclo.Items.Add(ciclo.Nombre);
            }
        }

        // Cierra el formulario sin guardar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        // Guarda los datos del alumno y lo añade a la lista
        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (new[] { txtNombre.Text, txtApellidos.Text, txtDni.Text, txtEmail.Text, txtContraseña.Text, cmbGenero.Text, cmbCiclo.Text }.Any(c => string.IsNullOrWhiteSpace(c)))
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                string emailPattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$";
                string patron = @"^\d{8}[A-Za-z]$";
                Alumno a = new Alumno();

                a.Nombre = txtNombre.Text;
                a.Apellidos = txtApellidos.Text;
                if (Regex.IsMatch(txtDni.Text, patron)) a.Dni = txtDni.Text;
                else
                {
                    MessageBox.Show("Formato de DNI no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                if (Regex.IsMatch(txtEmail.Text, emailPattern)) a.Email = txtEmail.Text;
                else{
                    MessageBox.Show("Formato de Email no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                a.Contraseña = txtContraseña.Text;
                if(txtTelefono.Text.Length == 9) a.Telefono = txtTelefono.Text;
                else
                {
                    MessageBox.Show("Formato de Teléfono no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                a.Genero = (Genero)cmbGenero.SelectedItem;
                a.FechaNacimiento = dtpFechaNac.Value;
                a.Activo = true;
                a.Ciclo = Principal.ciclos[cmbCiclo.SelectedIndex];
                
                //funcion insert alumno
                Principal.alumnos.Add(a);
                DialogResult = DialogResult.OK;
            }
        }
    }
}
