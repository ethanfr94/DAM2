using System;
using System.Text.RegularExpressions;
using System.Windows.Forms;

namespace ProjectStore
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        // Evento que se dispara al hacer clic en el botón de iniciar sesión
        private async void OnClickLogin(object sender, EventArgs e)
        {
            // Obtiene los datos de correo y la contraseña ingresados
            string email = txtEmail.Text;
            string password = txtPassword.Text;

            // Patrón para validar un correo electrónico con expresión regular
            string emailPattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$";

            // Validar que los campos no estén vacíos
            if (string.IsNullOrEmpty(email) || string.IsNullOrEmpty(password))
            {
                MessageBox.Show("Hay campos sin rellenar.\nPor favor, complete todos los campos.",
                                "Campos Incompletos",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
                return;
            }

            // Validar el formato del correo electrónico
            if (!Regex.IsMatch(email, emailPattern))
            {
                MessageBox.Show("El formato del correo electrónico es incorrecto.\nPor favor, ingrese un correo válido.",
                                "Formato Incorrecto",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
                return;
            }

            // Realizar la consulta a la API de forma asíncrona
            var profesor = await new ConexionApi().ProfesorporCorreoPassword(email, password);

            if (profesor == null)
            {
                // Mostrar un mensaje si las credenciales son incorrectas
                MessageBox.Show("Las credenciales no son válidas.\nPor favor, revise su correo o contraseña.",
                                "Credenciales Incorrectas",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);

                // Limpiar los campos de entrada para un nuevo intento
                txtPassword.Clear();
            }
            else
            {
                // Abre el formulario principal en un hilo separado para evitar bloquear la UI
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
        }

        // Evento que se dispara al hacer clic en el enlace de contacto
        private void OnClickLink(object sender, LinkLabelLinkClickedEventArgs e)
        {
            try
            {
                // Abrir el cliente de correo predeterminado con la dirección del enlace
                System.Diagnostics.Process.Start("mailto:" + llbContact.Text);
            }
            catch (System.ComponentModel.Win32Exception)
            {
                // Mostrar un mensaje si no se puede abrir el cliente de correo
                MessageBox.Show("No se pudo abrir el cliente de correo. Asegúrese de tener un cliente de correo predeterminado configurado.",
                                "Error",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
            }
        }
    }
}
