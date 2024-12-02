namespace Ud2Hoja15
{
    public partial class Principal : Form
    {
        public static List<Empleado> empleados;
        Ver ver;
        Empleado emp;
        int criterio;
        string busqueda;


        public Principal()
        {
            InitializeComponent();
            empleados = new List<Empleado>();
            tsmiEdit.Enabled = false;
        }

        private void tsmiAdd_Click(object sender, EventArgs e)
        {
            AgregarEmpleado ae = new AgregarEmpleado();
            ae.MdiParent = this;
            ae.Show();
        }
        
        private void tsmiEdit_Click(object sender, EventArgs e)
        {
            Editar ed = new Editar(emp);
            ed.MdiParent = this;
            ed.Show();
            // no deja seleccionar en la lista
            
        }

        private void tsmiVer_Click(object sender, EventArgs e)
        {
            tsmiEdit.Enabled = true;
            ver = new Ver();
            ver.MdiParent = this;
            ver.Show();
            if(ver.emp != null)
            {
                emp = ver.emp;
                tsmiEdit.Enabled = true;
                tsmiBorrar.Enabled = true;
            }
        }

        private void tsmiBuscar_Click(object sender, EventArgs e)
        {
            Buscar bs = new Buscar();
            bs.MdiParent = this;
            bs.Show();            
        }

        private void tsmiBorrar_Click(object sender, EventArgs e)
        {
            Eliminar el = new Eliminar();
            el.MdiParent = this;
            el.Show();
            // no deja seleleccionar el empleado a borrar en la lista
        }
    }
}
