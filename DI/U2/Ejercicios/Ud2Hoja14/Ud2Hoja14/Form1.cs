namespace Ud2Hoja14
{
    public partial class Contenedor : Form
    {
        public Contenedor()
        {
            InitializeComponent();
        }

        private void sAlirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void libroToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ListaLibroForm listaLibroForm = new ListaLibroForm();
            listaLibroForm.MdiParent = this;
            listaLibroForm.Show();
        }

        private void cascadaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.Cascade);
        }

        private void verticalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileVertical);
        }

        private void horizontalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void peliculaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
            ListaPeliculaForm listaPeliculaForm = new ListaPeliculaForm();
            listaPeliculaForm.MdiParent = this;
            listaPeliculaForm.Show();

        }
    }
}
