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
        private readonly APIConnection apiConnection = new APIConnection();

        public AddProyecto()
        {
            InitializeComponent();
            cargaComboCiclo();
            cargaComboProfesor();
            cargaComboTipo();
        }

        private void cargaComboTipo()
        {
            cmbTipo.Items.Add(Tipo.Final);
            cmbTipo.Items.Add(Tipo.Intermodular);
        }

        // Carga los ciclos disponibles en el combo de ciclos
        private void cargaComboCiclo()
        {
            foreach (Ciclo ciclo in Principal.ciclos)
            {
                cmbCiclo.Items.Add(ciclo.Codigo);
            }
        }

        // Carga los profesores disponibles en el combo de tutores
        private void cargaComboProfesor()
        {
            foreach (Profesor profesor in Principal.profesores)
            {
                cmbTutor.Items.Add(profesor.Nombre + " " + profesor.Apellidos);
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
        private async void btnAdd_Click(object sender, EventArgs e)
        {
            // Validamos si todos los campos requeridos están completos
            if (!ValidarCamposRequeridos()) return;

            // Validamos el nombre del proyecto
            if (!ValidarNombre(txtNombre.Text)) return;

            Proyecto p = new Proyecto
            {
                Nombre = txtNombre.Text,
                Tipo = cmbTipo.SelectedText.ToString() == Tipo.Final.ToString() ? "fin de ciclo" : "intermodular",
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
            await apiConnection.PostProyecto(p);

            this.Dispose();
        }

        // Cierra el formulario sin guardar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
    }
}
