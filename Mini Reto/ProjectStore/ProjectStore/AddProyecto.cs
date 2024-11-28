using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class AddProyecto : Form
    {
        // Expresiones regulares y constantes reutilizables
        private const int MinNombreLength = 1;

        public AddProyecto()
        {
            InitializeComponent();
            cargaComboCiclo();
            cargaComboTipo();
            cargaComboProfesor();
        }

        // Carga los ciclos disponibles en el combo de ciclos
        private void cargaComboCiclo()
        {
            foreach (Ciclo ciclo in Principal.ciclos)
            {
                cmbCiclo.Items.Add(ciclo.Nombre);
            }
        }

        // Carga los tipos de proyecto disponibles en el combo
        private void cargaComboTipo()
        {
            foreach (Tipo tipo in Enum.GetValues(typeof(Tipo)))
            {
                cmbTipo.Items.Add(tipo);
            }
        }

        // Carga los profesores disponibles en el combo de tutores
        private void cargaComboProfesor()
        {
            foreach (Profesor profesor in Principal.profesores)
            {
                cmbTutor.Items.Add(profesor.Nombre);
            }
        }

        // Valida los campos requeridos
        private bool ValidarCamposRequeridos()
        {
            List<Control> controls = new List<Control>
            {
                txtNombre,
                cmbTipo,
                cmbCiclo,
                cmbTutor
            };

            foreach (var control in controls)
            {
                if (string.IsNullOrWhiteSpace(control.Text))
                {
                    MessageBox.Show("Faltan campos por rellenar",
                                    "Error",
                                    MessageBoxButtons.OK,
                                    MessageBoxIcon.Error);
                    return false;
                }
            }

            return true;
        }

        // Valida el nombre del proyecto
        private bool ValidarNombre(string nombre)
        {
            if (nombre.Length >= MinNombreLength) return true;
            MessageBox.Show("El nombre del proyecto no puede estar vacío",
                            "Error",
                            MessageBoxButtons.OK,
                            MessageBoxIcon.Error);
            return false;
        }

        // Guarda los datos del proyecto y lo añade a la lista
        private void btnAdd_Click(object sender, EventArgs e)
        {
            // Validamos si todos los campos requeridos están completos
            if (!ValidarCamposRequeridos()) return;

            // Validamos el nombre del proyecto
            if (!ValidarNombre(txtNombre.Text)) return;

            Proyecto p = new Proyecto
            {
                Nombre = txtNombre.Text,
                Tipo = (Tipo) cmbTipo.SelectedItem,
                Resumen = txtResumen.Text,
                AnioAcademico = (int)nudAnioAcademico.Value,
                FechaPresentacion = dtpFechaPres.Value,
                Logo = txtLogo.Text,
                Memoria = txtMemoria.Text,
                Archivos = txtArchivos.Text,
                Comentarios = txtComentarios.Text,
                Ciclo = Principal.ciclos[cmbCiclo.SelectedIndex],
                Tutor = Principal.profesores[cmbTutor.SelectedIndex]
            };

            // Cerrar formulario con éxito
            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        // Cierra el formulario sin guardar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            this.Close();
        }
    }
}
