namespace Ud2Hoja15
{
    public partial class Principal : Form
    {
        public static List<Empleado> empleados = new List<Empleado>();




        public Principal()
        {
            InitializeComponent();
            tsmiEdit.Enabled = false;
            tsmiBorrar.Enabled = false;
        }

        private void tsmiAdd_Click(object sender, EventArgs e)
        {
            AgregarEmpleado ae = new AgregarEmpleado();
            ae.MdiParent = this;
            ae.ShowDialog();
        }

        private void tsmiVer_Click(object sender, EventArgs e)
        {
            Ver ver = new Ver();
            ver.MdiParent = this;
            ver.ShowDialog();
        }

        private void tsmiEdit_Click(object sender, EventArgs e)
        {
            Editar ed = new Editar();
            ed.MdiParent = this;
            ed.ShowDialog();
        }

        private void tsmiBuscar_Click(object sender, EventArgs e)
        {
            Buscar bs = new Buscar();
            bs.MdiParent = this;
            bs.ShowDialog();
        }

        private void tsmiBorrar_Click(object sender, EventArgs e)
        {
            Eliminar el = new Eliminar();
            el.MdiParent = this;
            el.ShowDialog();
        }
    }
}
