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
        int id;

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
            id = p.id;
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
            id = a.id;
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
            id = c.id;
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
                Alumno alumno = escuelaContext.Alumnos.FirstOrDefault(x => x.id == id);
                if(alumno != null)
                {
                    alumno.nombre = txtNombre.Text;
                    alumno.apellidos = txtApellidos.Text;
                    alumno.ciclo = ((Ciclo)cmbCiclo.SelectedItem).id;
                    escuelaContext.SaveChanges();
                }
                else
                {
                    alumno = new Alumno();
                    alumno.nombre = txtNombre.Text;
                    alumno.apellidos = txtApellidos.Text;
                    alumno.ciclo = ((Ciclo)cmbCiclo.SelectedItem).id;
                    escuelaContext.Alumnos.Add(alumno);
                    escuelaContext.SaveChanges();
                }
            }
            else if(rdoProfesor.Checked)
            {
                Profesore profesor = escuelaContext.Profesores.FirstOrDefault(x => x.id == id);
                if (profesor != null)
                {
                    profesor.nombre = txtNombre.Text;
                    profesor.apellidos = txtApellidos.Text;
                    escuelaContext.SaveChanges();
                }
                else
                {
                    profesor = new Profesore();
                    profesor.nombre = txtNombre.Text;
                    profesor.apellidos = txtApellidos.Text;
                    escuelaContext.Profesores.Add(profesor);
                    escuelaContext.SaveChanges();
                }
            }
            else if(rdoCiclo.Checked)
            {
                Ciclo ciclo = escuelaContext.Ciclos.FirstOrDefault(x => x.id == id);
                if (ciclo != null)
                {
                    ciclo.nombre = txtNombre.Text;
                    ciclo.tutor = ((Profesore)cmbTutor.SelectedItem).id;
                    escuelaContext.SaveChanges();
                }
                else
                {
                    ciclo = new Ciclo();
                    ciclo.nombre = txtNombre.Text;
                    ciclo.tutor = ((Profesore)cmbTutor.SelectedItem).id;
                    escuelaContext.Ciclos.Add(ciclo);
                    escuelaContext.SaveChanges();
                }

            }

            DialogResult = DialogResult.OK;
            this.Close();
        }

        
    }
}
