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
    public partial class Principal : Form
    {

        public static List<Alumno> alumnos;
        public static List<Profesore> profesores;
        public static List<Ciclo> ciclos;
        EscuelaContext EscuelaContext;
            public Principal()
        {
            InitializeComponent();
            EscuelaContext = new EscuelaContext();
            cargaDatos();
        }

        public void cargaDatos()
        {
            alumnos = EscuelaContext.Alumnos.ToList();
            profesores = EscuelaContext.Profesores.ToList();
            ciclos = EscuelaContext.Ciclos.ToList();
        }

        private void btnContacto_Click(object sender, EventArgs e)
        {
            Contacto contacto = new Contacto();
            contacto.Show();
        }

        private void btnCiclos_Click(object sender, EventArgs e)
        {
            lblInicio.Visible = false;
            dgvDatos.Visible = true;
            lblTabla.Text = "Ciclos";
            cargaDatos();
            dgvDatos.DataSource = ciclos;
        }

        private void btnProfesores_Click(object sender, EventArgs e)
        {
            lblInicio.Visible = false;
            dgvDatos.Visible = true;
            lblTabla.Text = "Profesores";
            cargaDatos();
            dgvDatos.DataSource = profesores;
        }

        private void btnAlumnos_Click(object sender, EventArgs e)
        {
            lblInicio.Visible = false;
            dgvDatos.Visible = true;
            lblTabla.Text = "Alumnos";
            cargaDatos();
            dgvDatos.DataSource = alumnos;  
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            int al = alumnos.Count;
            int pr = profesores.Count;
            int ci = ciclos.Count;

            Agregar agregar = new Agregar();
            agregar.Show();

            if(agregar.DialogResult == DialogResult.OK)
            {                
                cargaDatos();

                if(alumnos.Count > al)
                {
                    dgvDatos.DataSource = alumnos;
                }
                else if(profesores.Count > pr)
                {
                    dgvDatos.DataSource = profesores;   
                }
                else if(ciclos.Count > ci)
                {
                    dgvDatos.DataSource = ciclos;
                }
                
            }
        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Estás seguro de que quieres borrar este registro?", "Borrar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if(res == DialogResult.Yes) {
                if(dgvDatos.DataSource == alumnos)
                {
                    Alumno a = (Alumno)dgvDatos.CurrentRow.DataBoundItem;
                    EscuelaContext.Alumnos.Remove(a);
                    EscuelaContext.SaveChanges();
                    cargaDatos();
                    dgvDatos.DataSource = alumnos;
                }
                else if(dgvDatos.DataSource == profesores)
                {
                    Profesore p = (Profesore)dgvDatos.CurrentRow.DataBoundItem;
                    EscuelaContext.Profesores.Remove(p);
                    EscuelaContext.SaveChanges();
                    cargaDatos();
                    dgvDatos.DataSource = profesores;
                }
                else if(dgvDatos.DataSource == ciclos)
                {
                    Ciclo c = (Ciclo)dgvDatos.CurrentRow.DataBoundItem;
                    EscuelaContext.Ciclos.Remove(c);
                    EscuelaContext.SaveChanges();
                    cargaDatos();
                    dgvDatos.DataSource = ciclos;
                }
            }
        }

        private void editarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(dgvDatos.DataSource == alumnos)
            {
                Alumno a = (Alumno)dgvDatos.CurrentRow.DataBoundItem;
                Agregar agregaral = new Agregar(a);
                agregaral.Show();
                if (agregaral.DialogResult == DialogResult.OK)
                {
                    cargaDatos();
                    dgvDatos.DataSource = alumnos;
                }
            }
            else if (dgvDatos.DataSource == profesores)
            {
                Profesore p = (Profesore)dgvDatos.CurrentRow.DataBoundItem;
                Agregar agregarpr = new Agregar(p);
                agregarpr.Show();
                if (agregarpr.DialogResult == DialogResult.OK)
                {
                    cargaDatos();
                    dgvDatos.DataSource = profesores;
                }
            }
            else if (dgvDatos.DataSource == ciclos)
            {
                Ciclo c = (Ciclo)dgvDatos.CurrentRow.DataBoundItem;
                Agregar agregarcl = new Agregar(c);
                agregarcl.Show();
                if (agregarcl.DialogResult == DialogResult.OK)
                {
                    cargaDatos();
                    dgvDatos.DataSource = ciclos;
                }
            }
            

        }

        
        private void btnDeshacer_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Estás seguro de que quieres deshacer los cambios?", "Deshacer", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if(res == DialogResult.Yes)
            {
                if (lblTabla.Text == "Alumnos")
                {
                    dgvDatos.DataSource = alumnos;
                }
                else if (lblTabla.Text == "Profesores")
                {
                    dgvDatos.DataSource = profesores;
                }
                else if (lblTabla.Text == "Ciclos")
                {
                    dgvDatos.DataSource = ciclos;
                }
            }
            
        }
    }
}
