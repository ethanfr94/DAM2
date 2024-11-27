using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class AddAlumno : Form
    {
        // Expresiones regulares reutilizables para validación
        private const string EmailPattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$";
        private const string DniPattern = @"^\d{8}[A-Za-z]$";
        private const int PhoneLength = 9;
        APIConnection apiConnection = new APIConnection();
        List<Ciclo> ciclos;

        public AddAlumno()
        {
            InitializeComponent();
            cargaComboGenero();
            cargaComboCiclo();
        }

        // Carga los géneros del enum al combo, convertidos a string
        private void cargaComboGenero()
        {
            foreach (Genero genero in Enum.GetValues(typeof(Genero)))
            {
                cmbGenero.Items.Add(genero.ToString());
            }
        }

        // Carga los ciclos disponibles al combo
        private async void cargaComboCiclo()
        {
            
            ciclos = await apiConnection.GetAllCiclos();
            foreach (Ciclo ciclo in ciclos)
            {
                cmbCiclo.Items.Add(ciclo.Nombre);
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
                cmbCiclo,
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

        // Guarda los datos del alumno y lo añade a la lista
        private async void btnAdd_Click(object sender, EventArgs e)
        {
            // Validamos si todos los campos requeridos están completos
            if (!ValidarCamposRequeridos()) return;

            // Validamos los campos específicos
            if (!ValidarDni(txtDni.Text)) return;
            if (!ValidarEmail(txtEmail.Text)) return;
            if (!ValidarTelefono(txtTelefono.Text)) return;

            Alumno a = new Alumno
            {
                Nombre = txtNombre.Text,
                Apellidos = txtApellidos.Text,
                Dni = txtDni.Text,
                Email = txtEmail.Text,
                Contraseña = txtContraseña.Text,
                Telefono = txtTelefono.Text,
                FechaNacimiento = dtpFechaNac.Value,
                Activo = true
            };

            // Asignación segura del género
            if (Enum.TryParse(cmbGenero.SelectedItem?.ToString(), out Genero genero))
            {
                a.Genero = genero;
            }
            else
            {
                MessageBox.Show("Selección de género no válida", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // Asignación del ciclo
            a.Ciclo = ciclos[cmbCiclo.SelectedIndex];

            bool result = await apiConnection.PostAlumno(a);

            if (result)
            {
                MessageBox.Show("Alumno añadido correctamente", "Exito", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Error al añadir el alumno", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            // Cerrar formulario con éxito
            DialogResult = DialogResult.OK;
        }

        // Cierra el formulario sin guardar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }
    }
}
