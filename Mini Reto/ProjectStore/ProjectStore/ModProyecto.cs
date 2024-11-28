using System;
using System.Linq;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class ModProyecto : Form
    {
        private Proyecto proyecto;

        private readonly APIConnection apiConnection = new APIConnection();

        public ModProyecto(Proyecto p)
        {
            InitializeComponent();
            proyecto = p;
            InicializarCampos();
        }

        // Inicializa los campos con los datos del proyecto
        private void InicializarCampos()
        {
            txtNombre.Text = proyecto.Nombre;
            cmbTipo.Text = proyecto.Tipo.ToString();
            txtResumen.Text = proyecto.Resumen;
            int anno = int.TryParse(nudAnioAcademico.Value.ToString(), out anno) ? anno : 0;
            nudAnioAcademico.Value = anno;
            //dtpFechaPres.Value = proyecto.FechaPresentacion;
            txtLogo.Text = proyecto.Logo;
            txtMemoria.Text = proyecto.Memoria;
            txtArchivos.Text = proyecto.Archivos;
            txtComentarios.Text = proyecto.Comentarios;
            cmbCiclo.Text = proyecto.Ciclo.ToString();
            cmbTutor.Text = proyecto.Tutor.ToString();
        }

        // Validar los campos requeridos antes de modificar
        private bool ValidarCampos()
        {
            var camposRequeridos = new[] { txtResumen.Text, txtComentarios.Text };

            if (camposRequeridos.Any(c => string.IsNullOrWhiteSpace(c)))
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }

            return true;
        }

        // Método para aplicar la modificación al proyecto
        private async void ModificarProyecto()
        {
            if (proyecto.Resumen != txtResumen.Text)
                proyecto.Resumen = txtResumen.Text;

            if (proyecto.FechaPresentacion != dtpFechaPres.Value)
                proyecto.FechaPresentacion = dtpFechaPres.Value;

            if (proyecto.Comentarios != txtComentarios.Text)
                proyecto.Comentarios = txtComentarios.Text;

            if (proyecto.Tutor.ToString() != cmbTutor.Text)
                proyecto.Tutor = Principal.profesores[cmbTutor.SelectedIndex];

           bool res = await apiConnection.UpdateProyecto(proyecto.Id, proyecto);
            if (res)
            {
                MessageBox.Show("Proyecto modificado correctamente", "Exito", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Error al modificar el proyecto", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        // Confirmar si el usuario realmente quiere modificar los datos
        private bool ConfirmarModificacion()
        {
            var result = MessageBox.Show("¿Está seguro de modificar los datos?", "Atención", MessageBoxButtons.OKCancel, MessageBoxIcon.Exclamation);
            return result == DialogResult.OK;
        }

        // Botón de cancelar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            this.Close();
        }

        // Botón de modificar
        private void btnMod_Click(object sender, EventArgs e)
        {
            if (ConfirmarModificacion())
            {
                if (ValidarCampos())
                {
                    ModificarProyecto();
                    this.DialogResult = DialogResult.OK;
                    this.Close();
                }
            }
        }
    }
}
