using System;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectStore
{
    public partial class Login : Form
    {
        private readonly APIConnection apiConnection = new APIConnection();

        public Login()
        {
            InitializeComponent();
        }

        private async void OnClickLogin(object sender, EventArgs e)
        {
            string email = txtEmail.Text;
            string password = txtPassword.Text;
            string emailPattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$";

            if (string.IsNullOrEmpty(email) || string.IsNullOrEmpty(password))
            {
                MessageBox.Show("Hay campos sin rellenar.\nPor favor, complete todos los campos.",
                                "Campos Incompletos", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            if (!Regex.IsMatch(email, emailPattern))
            {
                MessageBox.Show("El formato del correo electrónico es incorrecto.\nPor favor, ingrese un correo válido.",
                                "Formato Incorrecto", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            var profesor = await apiConnection.GetProfesorByCredentials(email, password);
            if (profesor == null)
            {
                MessageBox.Show("Las credenciales no son válidas.\nPor favor, revise su correo o contraseña.",
                                "Credenciales Incorrectas", MessageBoxButtons.OK, MessageBoxIcon.Error);
                txtPassword.Clear();
                return;
            }


            Thread thread = new Thread(() =>
            {
                Application.SetCompatibleTextRenderingDefault(false);
                Application.EnableVisualStyles();
                Principal principal = new Principal(profesor);
                Application.Run(principal);
            });

            thread.SetApartmentState(ApartmentState.STA);
            thread.Start();
            this.Close();
        }

        private void OnClickForget(object sender, LinkLabelLinkClickedEventArgs e)
        {
            try
            {
                System.Diagnostics.Process.Start("mailto: support@projectstore.com");
            }
            catch (System.ComponentModel.Win32Exception)
            {
                MessageBox.Show("No se pudo abrir el cliente de correo. Asegúrese de tener un cliente de correo predeterminado configurado.",
                                "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
