using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MiniReto_interfaz_principal
{
    public partial class AddProyecto : Form
    {
        public AddProyecto()
        {
            InitializeComponent();
            cargaComboCiclo();
            cargaComboTipo();
            cargaComboProfesor();

        }

        private void cargaComboCiclo()
        {
            foreach (Ciclo ciclo in Principal.ciclos)
            {
                cmbCiclo.Items.Add(ciclo.Nombre);
            }
        }

        private void cargaComboTipo()
        {
            foreach (Tipo tipo in Enum.GetValues(typeof(Tipo)))
            {
                cmbTipo.Items.Add(tipo);
            }
        }

        private void cargaComboProfesor()
        {
            foreach (Profesor profesor in Principal.profesores)
            {
                cmbTutor.Items.Add(profesor.Nombre);
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if(txtNombre.Text == "" || cmbTipo.SelectedIndex < 0 || cmbCiclo.SelectedIndex < 0)
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                Proyecto proyecto = new Proyecto();
                proyecto.Nombre = txtNombre.Text;
                proyecto.Tipo = (Tipo)cmbTipo.SelectedIndex;
                proyecto.Resumen = txtResumen.Text;
                proyecto.Anio_academico = (int)nudAnioAcademico.Value;
                proyecto.Fecha_presentacion = dtpFechaPres.Value;
                proyecto.Logo = txtLogo.Text;
                proyecto.Memoria = txtMemoria.Text;
                proyecto.Archivos = txtArchivos.Text;
                proyecto.Comentarios = txtComentarios.Text;
                proyecto.Ciclo = Principal.ciclos[cmbCiclo.SelectedIndex];
                proyecto.Tutor = Principal.profesores[cmbTutor.SelectedIndex];
                Principal.proyectos.Add(proyecto);
                DialogResult = DialogResult.OK;
            }
        }
    }
}
