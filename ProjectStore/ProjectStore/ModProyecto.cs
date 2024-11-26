using ProjectStore.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectStore
{
    public partial class ModProyecto : Form
    {
        Proyecto proyecto;
        public ModProyecto(Proyecto p)
        {
            InitializeComponent();
            proyecto = p;
            txtNombre.Text = p.Nombre;
            cmbTipo.Text = p.Tipo.ToString();
            txtResumen.Text = p.Resumen;
            nudAnioAcademico.Value = p.Anio_academico;
            dtpFechaPres.Value = p.Fecha_presentacion;
            txtLogo.Text = p.Logo;
            txtMemoria.Text = p.Memoria;
            txtArchivos.Text = p.Archivos;
            txtComentarios.Text = p.Comentarios;
            cmbCiclo.Text = p.Ciclo.ToString();
            cmbTutor.Text = p.Tutor.ToString();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
        }

        private async void btnMod_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Esta seguro de modificar los datos", "Atencion", MessageBoxButtons.OKCancel, MessageBoxIcon.Exclamation);
            if (DialogResult == DialogResult.OK)
            {
                if (new[] { dtpFechaPres.Text }.Any(c => string.IsNullOrWhiteSpace(c)))
                {
                    MessageBox.Show("Faltan campos por rellenar", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                {
                    if(proyecto.Resumen != txtResumen.Text)
                    {
                        proyecto.Resumen = txtResumen.Text;
                    }
                    if (proyecto.Fecha_presentacion != dtpFechaPres.Value)
                    {
                        proyecto.Fecha_presentacion = dtpFechaPres.Value;
                    }
                    if (proyecto.Comentarios != txtComentarios.Text)
                    {
                        proyecto.Comentarios = txtComentarios.Text;
                    }
                    if (proyecto.Tutor.ToString() != cmbTutor.Text)
                    {
                        proyecto.Tutor = Principal.profesores[cmbTutor.SelectedIndex];
                    }
                    
                    ConexionApi conexion = new ConexionApi();
                    if (await conexion.ActualizarProyecto(proyecto.Id, proyecto))
                    {
                        MessageBox.Show("Proyecto modificado correctamente", "Exito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    }
                    else
                    {
                        MessageBox.Show("Error al modificar el proyecto", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }

                }

                DialogResult = DialogResult.OK;
            }
        }
    }
}
