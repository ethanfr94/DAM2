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
    public partial class AddProfesor : Form
    {
        public AddProfesor()
        {
            InitializeComponent();
            cargaComboGenero();    // Carga los géneros en el combo
        }

        // Carga los géneros del enum al combo
        private void cargaComboGenero()
        {
            foreach (Genero genero in Enum.GetValues(typeof(Genero)))
            {
                cmbGenero.Items.Add(genero);
            }
        }

        // Guarda los datos del profesor y lo añade a la lista
        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (new[] { txtNombre.Text, txtApellidos.Text, txtDni.Text, txtEmail.Text, txtContraseña.Text, cmbGenero.Text }.Any(c => string.IsNullOrWhiteSpace(c)))
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                string emailPattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$";
                string patron = @"^\d{8}[A-Za-z]$";
                Profesor p = new Profesor();

                p.Nombre = txtNombre.Text;
                p.Apellidos = txtApellidos.Text;
                if(Regex.IsMatch(txtDni.Text, patron)) p.Dni = txtDni.Text;
                else
                {
                    MessageBox.Show("Formato de DNI no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                if(Regex.IsMatch(txtEmail.Text, emailPattern)) p.Email = txtEmail.Text; 
                else{
                    MessageBox.Show("Formato de Email no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                p.Contraseña = txtContraseña.Text;
                if (txtTelefono.Text.Length == 9) p.Telefono = txtTelefono.Text;
                else
                {
                    MessageBox.Show("Formato de Teléfono no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                p.Genero = (Genero)cmbGenero.SelectedItem;
                p.FechaNacimiento = dtpFechaNac.Value;
                p.Especialidad = txtEspecialidad.Text;
                p.Activo = true;
                
                //funcion insert profesor
                Principal.profesores.Add(p);
                DialogResult = DialogResult.OK;
            }
        }

        // Cierra el formulario sin guardar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }
    }
}
