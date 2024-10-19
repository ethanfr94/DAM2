namespace Ud2Hoja5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void btnConf_Click(object sender, EventArgs e)
        {
            if (txtNombre.Text == "")
            {
                MessageBox.Show("Debes introducir un nombre");
            }
            else
            {
                if (rdoMasculino.Checked)
                {
                    MessageBox.Show("Bienvenido " + txtNombre.Text);
                }
                else if (rdoFemenino.Checked)
                {
                    MessageBox.Show("Bienvenida " + txtNombre.Text);
                }
                else
                {
                    MessageBox.Show("Hola " + txtNombre.Text);
                }
            }
            
        }
    }
}
