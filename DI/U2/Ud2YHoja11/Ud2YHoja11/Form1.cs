namespace Ud2YHoja11
{
    public partial class Form1 : Form
    {
        private String nombre;
        private String Telefono;
        private String Email;

        public Form1()
        {
            InitializeComponent();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if(txtNombre.Text == "" || txtTlfn.Text == "" || txtEmail.Text == "")
            {
                MessageBox.Show("Rellene todos los campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                nombre = txtNombre.Text;
                Telefono = txtTlfn.Text;
                Email = txtEmail.Text;
                MessageBox.Show("Datos guardados", "Guardar", MessageBoxButtons.OK);
            }
            nombre = txtNombre.Text;
            Telefono = txtTlfn.Text;
            Email = txtEmail.Text;
        }

        private void btnMostrar_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Nombre: " + nombre + "\nTelefono: " + Telefono + "\nEmail: " + Email);
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Datos eliminados", "Eliminar", MessageBoxButtons.OK);
            txtNombre.Text = "";
            txtTlfn.Text = "";
            txtEmail.Text = "";
        }

        private void tsmiNuevo_Click(object sender, EventArgs e)
        {
            txtNombre.Text = "";
            txtTlfn.Text = "";
            txtEmail.Text = "";
        }

        private void tsmiSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
