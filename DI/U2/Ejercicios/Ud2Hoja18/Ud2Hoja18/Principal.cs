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
        EscuelaContext escuelaContext;
            public Principal()
        {
            InitializeComponent();
            escuelaContext = new EscuelaContext();
            cargaDatos();
        }

        public void cargaDatos()
        {
            
            alumnos = escuelaContext.Alumnos.ToList();
            profesores = escuelaContext.Profesores.ToList();
            ciclos = escuelaContext.Ciclos.ToList();
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
            int id;
            DialogResult res = MessageBox.Show("¿Estás seguro de que quieres borrar este registro?", "Borrar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (res == DialogResult.Yes)
            {
                if (dgvDatos.DataSource == alumnos)
                {
                    id = (int)dgvDatos.CurrentRow.Cells[0].Value;
                    Alumno a = escuelaContext.Alumnos.FirstOrDefault(x => x.id == id);
                    if (a != null)
                    {
                        escuelaContext.Alumnos.Remove(a);
                        escuelaContext.SaveChanges();
                        cargaDatos();
                        dgvDatos.DataSource = alumnos;
                    }
                    else
                    {
                        MessageBox.Show("No se ha podido borrar el alumno", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
                else if (dgvDatos.DataSource == profesores)
                {
                    id = (int)dgvDatos.CurrentRow.Cells[0].Value;
                    Profesore p = escuelaContext.Profesores.FirstOrDefault(x => x.id == id);
                    if (p != null)
                    {
                        escuelaContext.Profesores.Remove(p);
                        escuelaContext.SaveChanges();
                        cargaDatos();
                        dgvDatos.DataSource = profesores;
                    }
                    else
                    {
                        MessageBox.Show("No se ha podido borrar el profesor", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
                else if (dgvDatos.DataSource == ciclos)
                {
                    id = (int)dgvDatos.CurrentRow.Cells[0].Value;
                    Ciclo c = escuelaContext.Ciclos.FirstOrDefault(x => x.id == id);
                    if (c != null)
                    {
                        escuelaContext.Ciclos.Remove(c);
                        escuelaContext.SaveChanges();
                        cargaDatos();
                        dgvDatos.DataSource = ciclos;
                    }
                    else
                    {
                        MessageBox.Show("No se ha podido borrar el ciclo", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
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
                    MessageBox.Show("Alumno editado correctamente", "Editar", MessageBoxButtons.OK, MessageBoxIcon.Information);
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
                    MessageBox.Show("Profesor editado correctamente", "Editar", MessageBoxButtons.OK, MessageBoxIcon.Information);
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
                    MessageBox.Show("Ciclo editado correctamente", "Editar", MessageBoxButtons.OK, MessageBoxIcon.Information);
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
