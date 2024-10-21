namespace Ud2Hoja10
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private String contenidoInicial = "";
        private String ruta = "";

       private bool HaSidoModificado()
        {
            return contenidoInicial != txtContenido.Text;
        }


        private void tsmiNuevo_Click(object sender, EventArgs e)
        {
            if(HaSidoModificado())
            {
                DialogResult result = MessageBox.Show("¿Desea guardar los cambios?", "Guardar", MessageBoxButtons.YesNoCancel);
                if (result == DialogResult.Yes)
                {
                    SaveFileDialog saveFileDialog = new SaveFileDialog();
                }
                else if (result == DialogResult.Cancel)
                {
                    return;
                }
                txtContenido.Clear();
                contenidoInicial = "";
                ruta = "";
            }
        }
    }
}
