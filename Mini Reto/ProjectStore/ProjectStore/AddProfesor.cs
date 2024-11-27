using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class AddProfesor : Form
    {
        private readonly APIConnection apiConnection = new APIConnection();

        // Expresiones regulares reutilizables para validación
        private const string EmailPattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$";
        private const string DniPattern = @"^\d{8}[A-Za-z]$";
        private const int PhoneLength = 9;

        public AddProfesor()
        {
            InitializeComponent();
            cargaComboGenero();
        }

        // Carga los géneros del enum al combo
        private void cargaComboGenero()
        {
            foreach (Genero genero in Enum.GetValues(typeof(Genero)))
            {
                cmbGenero.Items.Add(genero.ToString());
            }
        }

        // Valida los campos requeridos
        private bool ValidarCamposRequeridos()
        {
            List<Control> controls = new List<Control>
            {
                txtNombre,
                txtApellidos,
                txtDni,
                txtEmail,
                txtContraseña,
                cmbGenero,
                txtTelefono
            };

            foreach (var control in controls)
            {
                if (string.IsNullOrWhiteSpace(control.Text))
                {
                    MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return false;
                }
            }

            return true;
        }

        // Valida el formato del DNI
        private bool ValidarDni(string dni)
        {
            if (Regex.IsMatch(dni, DniPattern)) return true;
            MessageBox.Show("Formato de DNI no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            return false;
        }

        // Valida el formato del Email
        private bool ValidarEmail(string email)
        {
            if (Regex.IsMatch(email, EmailPattern)) return true;
            MessageBox.Show("Formato de Email no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            return false;
        }

        // Valida el formato del Teléfono
        private bool ValidarTelefono(string telefono)
        {
            if (telefono.Length == PhoneLength) return true;
            MessageBox.Show("Formato de Teléfono no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            return false;
        }

        // Guarda los datos del profesor y lo añade a la lista
        private async void btnAdd_Click(object sender, EventArgs e)
        {
            // Validamos si todos los campos requeridos están completos
            if (!ValidarCamposRequeridos()) return;

            // Validamos los campos específicos
            if (!ValidarDni(txtDni.Text)) return;
            if (!ValidarEmail(txtEmail.Text)) return;
            if (!ValidarTelefono(txtTelefono.Text)) return;

            Profesor p = new Profesor
            {
                Nombre = txtNombre.Text,
                Apellidos = txtApellidos.Text,
                Dni = txtDni.Text,
                Email = txtEmail.Text,
                Contraseña = txtContraseña.Text,
                Telefono = txtTelefono.Text,
                FechaNacimiento = dtpFechaNac.Value,
                Especialidad = txtEspecialidad.Text,
                Activo = true
            };

            // Asignación segura del género
            if (Enum.TryParse(cmbGenero.SelectedItem?.ToString(), out Genero genero))
            {
                p.Genero = genero;
            }
            else
            {
                MessageBox.Show("Selección de género no válida", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // Insertar el profesor en la lista
            Principal.profesores.Add(p);
            DialogResult = DialogResult.OK;

            // Insertar el profesor en la API
            bool resultado = await apiConnection.PostProfesor(p);
            if (resultado)
            {
                MessageBox.Show("Profesor añadido con éxito", "Éxito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                DialogResult = DialogResult.OK;
            }
            else
            {
                MessageBox.Show("Error al añadir el profesor", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        // Cierra el formulario sin guardar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }
    }
}
