using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ud2Hoja7
{
    public partial class Form2 : Form
    {


        public Form2(String nombre, DateTime fecha, String sexo, String aficiones, String otro, String situacion)
        {
            InitializeComponent();
            lblNombre.Text = nombre;
            lblFecha.Text = fecha.ToString();
            lblSexo.Text = sexo;
            lblAficiones.Text = aficiones;
            txtAficiones.Text = otro;
            lblSituacion.Text = situacion;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Datos confirmados");
            lblNombre.Text = "";
            lblFecha.Text = "";
            lblSexo.Text = "";
            lblAficiones.Text = "";
            txtAficiones.Text = "";
            lblSituacion.Text = "";
            //System.Windows.Forms.Application.Exit();//cierra la aplicacion
            this.Close(); //  cierra la ventana

        }

        private void button2_Click(object sender, EventArgs e)
        {
            //System.Windows.Forms.Application.Exit();
            this.Close(); //  cierra la ventana

        }
    }
}
