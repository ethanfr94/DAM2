namespace Ud2Hoja14
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void librosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ListaPeliculaForm listaLibroForm = new ListaLibroForm();
            listaLibroForm.MdiParent = this;
            listaLibroForm.Show();

        }
    }
}
