using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ProjectStore.Entities;

namespace ProjectStore
{
    public partial class AddProyecto : Form
    {
        public AddProyecto()
        {
            InitializeComponent();
            cargaComboCiclo();     // Carga los ciclos disponibles en el combo
            cargaComboTipo();      // Carga los tipos de proyecto en el combo
            cargaComboProfesor();  // Carga los profesores disponibles en el combo
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

        // Cierra el formulario sin guardar
        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        // Guarda los datos del proyecto y lo añade a la lista
        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (txtNombre.Text == "" || cmbTipo.SelectedIndex < 0 || cmbCiclo.SelectedIndex < 0)
            {
                MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                Proyecto p = new Proyecto();                
                    p.Nombre = txtNombre.Text;
                    p.Tipo = (Tipo)cmbTipo.SelectedIndex;
                    p.Resumen = txtResumen.Text;
                    p.Anio_academico = (int)nudAnioAcademico.Value;
                    p.Fecha_presentacion = dtpFechaPres.Value;
                    p.Logo = txtLogo.Text;
                    p.Memoria = txtMemoria.Text;
                    p.Archivos = txtArchivos.Text;
                    p.Comentarios = txtComentarios.Text;
                    p.Ciclo = Principal.ciclos[cmbCiclo.SelectedIndex];
                    p.Tutor = Principal.profesores[cmbTutor.SelectedIndex];
                

                //funcion insert proyecto
                Principal.proyectos.Add(p);
                DialogResult = DialogResult.OK;
            }
        }
    }
}
