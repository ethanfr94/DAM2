using System.Text.RegularExpressions;

namespace Ud2Hoja6Ej4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void btnRegistro_Click(object sender, EventArgs e)
        {
            if(txtNombre.Text == "" || txtPass.Text == "" || txtEmail.Text == "")
            {
                MessageBox.Show("Rellene todos los campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                string nombre = txtNombre.Text;
                string pass = txtPass.Text;
                string email = txtEmail.Text;
                if(nombre != "" && pass != "" && Regex.IsMatch(email, @"^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$"))
                {
                    MessageBox.Show("Usuario registrado correctamente", "Correcto", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    txtNombre.Text = "";
                    txtPass.Text = "";
                    txtEmail.Text = "";
                }
                else if (Regex.IsMatch(email, @"^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$") == false)
                {
                    MessageBox.Show("Email no válido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else if (nombre == "" || pass == "")
                {
                    MessageBox.Show("Rellene todos los campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }
    }
}
