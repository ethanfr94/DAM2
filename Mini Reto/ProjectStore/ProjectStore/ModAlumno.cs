using System;
using System.Linq;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class ModAlumno : Form
    {
        private Alumno alumno;

        public ModAlumno(Alumno a)
        {
            InitializeComponent();
            alumno = a;
            InicializarCampos();
        }

        // Inicializa los campos con los datos del alumno
        private void InicializarCampos()
        {
            txtNombre.Text = alumno.Nombre;
            txtApellidos.Text = alumno.Apellidos;
            txtDni.Text = alumno.Dni;
            txtEmail.Text = alumno.Email;
            txtContraseña.Text = alumno.Contraseña;
            txtTelefono.Text = alumno.Telefono;
            cmbGenero.Text = alumno.Genero.ToString();
            dtpFechaNac.Value = alumno.FechaNacimiento;
            cmbCiclo.Text = alumno.Ciclo.Nombre;
            chkActivo.Checked = alumno.Activo;
        }

        // Valida los campos requeridos antes de modificar
        private bool ValidarCampos()
        {
            var campos = new[] { txtEmail.Text, txtContraseña.Text, cmbGenero.Text };

            if (campos.Any(c => string.IsNullOrWhiteSpace(c)))
            {
                MessageBox.Show("Faltan campos por rellenar",
                                "Error",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
                return false;
            }

            return true;
        }

        // Método para aplicar la modificación al alumno
        private void ModificarAlumno()
        {
            if (alumno.Email != txtEmail.Text) alumno.Email = txtEmail.Text;
            if (alumno.Contraseña != txtContraseña.Text) alumno.Contraseña = txtContraseña.Text;
            if (alumno.Telefono != txtTelefono.Text) alumno.Telefono = txtTelefono.Text;
            if (alumno.Activo != chkActivo.Checked) alumno.Activo = chkActivo.Checked;

            //
            // API
            //
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
            var confirmResult = MessageBox.Show("¿Está seguro de modificar los datos?",
                                "Atención",
                                MessageBoxButtons.OKCancel,
                                MessageBoxIcon.Exclamation);

            if (confirmResult == DialogResult.OK)
            {
                if (ValidarCampos())
                {
                    ModificarAlumno();
                    DialogResult = DialogResult.OK;
                }
            }
        }
    }
}
