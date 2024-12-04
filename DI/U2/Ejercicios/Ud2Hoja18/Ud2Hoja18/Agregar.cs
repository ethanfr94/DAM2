using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ud2Hoja18
{
    public partial class Agregar : Form
    {
        EscuelaContext escuelaContext;
        public Agregar()
        {
            InitializeComponent();
            escuelaContext = new EscuelaContext();
            cargaCiclos();
            cargaProfesores();
        }

        public Agregar(Profesore p)
        {
            InitializeComponent();
            rdoProfesor.Checked = true;
            escuelaContext = new EscuelaContext();
            cargaCiclos();
            cargaProfesores();
            txtNombre.Text = p.nombre;
            txtApellidos.Text = p.apellidos;
            cmbCiclo.Text = "";
            cmbTutor.Text = "";
            
        }

        public Agregar(Alumno a)
        {
            InitializeComponent();
            rdoAlumno.Checked = true;
            escuelaContext = new EscuelaContext();
            cargaCiclos();
            cargaProfesores();
            txtNombre.Text = a.nombre;
            txtApellidos.Text = a.apellidos;
            cmbCiclo.SelectedItem = a.ciclo;
            cmbTutor.Text = "";
        }

        public Agregar(Ciclo c)
        {
            InitializeComponent();
            rdoCiclo.Checked = true;
            escuelaContext = new EscuelaContext();
            cargaCiclos();
            cargaProfesores();
            txtNombre.Text = c.nombre;
            cmbTutor.SelectedItem = c.tutor;
            txtApellidos.Text = "";
            cmbTutor.Text = "";

        }

        private void cargaCiclos()
        {
           cmbCiclo.DataSource = escuelaContext.Ciclos.ToList();
            cmbCiclo.DisplayMember = "nombre";
        }

        private void cargaProfesores()
        {
            cmbTutor.DataSource = escuelaContext.Profesores.ToList();
            cmbTutor.DisplayMember = "nombre";
        }

        private void rdoProfesor_CheckedChanged(object sender, EventArgs e)
        {

            txtApellidos.Enabled = true;
            txtNombre.Enabled = true;
            cmbCiclo.Enabled = false;
            cmbTutor.Enabled = false;
        }

        private void rdoCiclo_CheckedChanged(object sender, EventArgs e)
        {

            txtApellidos.Enabled = false;
            txtNombre.Enabled = true;
            cmbCiclo.Enabled = false;
            cmbTutor.Enabled = true;
        }

        private void rdoAlumno_CheckedChanged(object sender, EventArgs e)
        {

            txtApellidos.Enabled = true;
            txtNombre.Enabled = true;
            cmbCiclo.Enabled = true;
            cmbTutor.Enabled = false;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
            this.Close();
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            if(rdoAlumno.Checked)
            {
                Alumno alumno = new Alumno();
                alumno.nombre = txtNombre.Text;
                alumno.apellidos = txtApellidos.Text;
                Ciclo ciclo = (Ciclo)cmbCiclo.SelectedItem;
                alumno.ciclo = ciclo.id;
                escuelaContext.Alumnos.Add(alumno);
                Principal.alumnos.Add(alumno);
                escuelaContext.SaveChanges();
            }
            else if(rdoProfesor.Checked)
            {
                Profesore profesor = new Profesore();
                profesor.nombre = txtNombre.Text;
                profesor.apellidos = txtApellidos.Text;
                escuelaContext.Profesores.Add(profesor);
                Principal.profesores.Add(profesor);
                escuelaContext.SaveChanges();   
            }
            else if(rdoCiclo.Checked)
            {
                Ciclo ciclo = new Ciclo();
                ciclo.nombre = txtNombre.Text;
                Profesore profesor = (Profesore)cmbTutor.SelectedItem;
                ciclo.tutor = profesor.id;
                escuelaContext.Ciclos.Add(ciclo);
                Principal.ciclos.Add(ciclo);
                escuelaContext.SaveChanges();
            }

            DialogResult = DialogResult.OK;
            this.Close();
        }

        
    }
}
