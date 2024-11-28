using System;
using System.Linq;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class ModProfesor : Form
    {
        private Profesor profesor;
        private readonly APIConnection apiConnection = new APIConnection();

        public ModProfesor(Profesor p)
        {
            InitializeComponent();
            profesor = p;
            InicializarCampos();
        }

        // Inicializa los campos con los datos del profesor
        private void InicializarCampos()
        {
            txtNombre.Text = profesor.Nombre;
            txtApellidos.Text = profesor.Apellidos;
            txtDni.Text = profesor.Dni;
            txtEmail.Text = profesor.Email;
            txtContraseña.Text = profesor.Contraseña;
            txtTelefono.Text = profesor.Telefono;
            cmbGenero.Text = profesor.Genero.ToString();
            dtpFechaNac.Value = profesor.FechaNacimiento;
            txtEspecialidad.Text = profesor.Especialidad;
            chkActivo.Checked = profesor.Activo;
        }

        // Validar los campos requeridos antes de modificar
        private bool ValidarCampos()
        {
            var campos = new[] { txtEmail.Text, txtContraseña.Text, cmbGenero.Text };

            if (campos.Any(c => string.IsNullOrWhiteSpace(c)))
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }

            return true;
        }

        // Método para aplicar la modificación al profesor
        private async void ModificarProfesor()
        {
            if (profesor.Email != txtEmail.Text) profesor.Email = txtEmail.Text;
            if (profesor.Contraseña != txtContraseña.Text) profesor.Contraseña = txtContraseña.Text;
            if (profesor.Telefono != txtTelefono.Text) profesor.Telefono = txtTelefono.Text;
            if (profesor.Activo != chkActivo.Checked) profesor.Activo = chkActivo.Checked;

            bool res = await apiConnection.UpdateProfesor(profesor.Id, profesor);

            if (res)
            {
                MessageBox.Show("Profesor modificado correctamente",
                                "Exito",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Error al modificar el profesor",
                                "Error",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
            }
        }

        // Botón de cancelar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        // Botón de modificar
        private void btnMod_Click(object sender, EventArgs e)
        {
            // Confirmación de modificación
            var confirmResult = MessageBox.Show("¿Está seguro de modificar los datos?", "Atención", MessageBoxButtons.OKCancel, MessageBoxIcon.Exclamation);

            if (confirmResult == DialogResult.OK)
            {
                if (ValidarCampos())
                {
                    ModificarProfesor();
                    this.DialogResult = DialogResult.OK;
                    this.Close();
                }
            }
        }
    }
}
