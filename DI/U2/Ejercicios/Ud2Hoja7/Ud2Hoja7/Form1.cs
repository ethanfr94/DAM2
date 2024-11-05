namespace Ud2Hoja7
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void chkOtro_CheckedChanged(object sender, EventArgs e)
        {
            if (chkOtro.Checked)
            {
                txtOtros.Enabled = true;
            }
            else
            {
                txtOtros.Text = "";
                txtOtros.Enabled = false;
            }
        }

        private void btnReiniciar_Click(object sender, EventArgs e)
        {
            txtNombre.Clear();

            dtpFecha.Value = DateTime.Now;

            rdoMasculino.Checked = true;
            rdoFemenino.Checked = false;
            rdoOtros.Checked = false;

            chkDeporte.Checked = false;
            chkLectura.Checked = false;
            chkMusica.Checked = false;
            chkOtro.Checked = false;

            txtOtros.Clear();
            txtOtros.Enabled = false;

            cmbSituacion.SelectedIndex = 0;
        }

        private void btnAceptar_Click(object sender, EventArgs e)
        {
            String nombre = txtNombre.Text;
            DateTime fecha = dtpFecha.Value;
            String sexo = rdoMasculino.Checked ? "Masculino" : rdoFemenino.Checked ? "Femenino" : "Otro";
            String aficiones = "";
            if (chkDeporte.Checked)
            {
                aficiones += "Deporte ";
            }
            if (chkLectura.Checked)
            {
                aficiones += "Lectura ";
            }
            if (chkMusica.Checked)
            {
                aficiones += "Música ";
            }
            String otro = txtOtros.Text;
            String situacion = cmbSituacion.SelectedItem.ToString();

            Form1.ActiveForm.Visible = false;
            Form2 form2 = new Form2(nombre, fecha, sexo, aficiones, otro, situacion);
            form2.Visible = true;
            this.Close();//cierra la ventana
            
            

            
        }
    }
}
