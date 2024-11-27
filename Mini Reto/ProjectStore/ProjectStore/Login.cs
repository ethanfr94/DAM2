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

        // Maneja el evento de clic en el botón de inicio de sesión
        private async void OnClickLogin(object sender, EventArgs e)
        {
            string email = txtEmail.Text;
            string password = txtPassword.Text;

            // Valida los campos de correo y contraseña
            if (!ValidateFields(email, password))
                return;

            // Consulta la API para obtener el profesor por correo y contraseña
            var profesor = await apiConnection.GetProfesorByCredentials(email, password);

            // Muestra un mensaje de error si las credenciales son incorrectas
            if (profesor == null)
            {
                MessageBox.Show("Las credenciales no son válidas.\nPor favor, revise su correo o contraseña.",
                                "Credenciales Incorrectas",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
                txtPassword.Clear();
            }
            else
            {
                OpenPrincipalForm(profesor);
            }
        }

        // Valida los campos de correo electrónico y contraseña
        private bool ValidateFields(string email, string password)
        {
            // Muestra un mensaje si los campos están vacíos
            if (string.IsNullOrEmpty(email) || string.IsNullOrEmpty(password))
            {
                MessageBox.Show("Hay campos sin rellenar.\nPor favor, complete todos los campos.",
                                "Campos Incompletos",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
                return false;
            }

            // Valida el formato del correo electrónico
            string emailPattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$";
            if (!Regex.IsMatch(email, emailPattern))
            {
                MessageBox.Show("El formato del correo electrónico es incorrecto.\nPor favor, ingrese un correo válido.",
                                "Formato Incorrecto",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
                return false;
            }

            return true;
        }

        // Abre el formulario principal con la información del profesor
        private void OpenPrincipalForm(Profesor profesor)
        {
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

        // Maneja el evento de clic en el enlace de contacto
        private void OnClickLink(object sender, LinkLabelLinkClickedEventArgs e)
        {
            try
            {
                // Abre el cliente de correo predeterminado para enviar un correo al contacto
                System.Diagnostics.Process.Start("mailto:" + llbContact.Text);
            }
            catch (System.ComponentModel.Win32Exception)
            {
                MessageBox.Show("No se pudo abrir el cliente de correo. Asegúrese de tener un cliente de correo predeterminado configurado.",
                                "Error",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
            }
        }
    }
}
