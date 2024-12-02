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
            
        }

        private void tsmiAdd_Click(object sender, EventArgs e)
        {
            AgregarEmpleado ae = new AgregarEmpleado();
            ae.MdiParent = this;
            ae.Show();
        }
                

        private void tsmiVer_Click(object sender, EventArgs e)
        {
            ver = new Ver();
            ver.MdiParent = this;
            ver.Show();
            if(ver.emp != null)
            {
                emp = ver.emp;
            }
        }

        private void tsmiBuscar_Click(object sender, EventArgs e)
        {
            Buscar bs = new Buscar();
            bs.MdiParent = this;
            bs.Show();            
        }

        

        public static bool eliminar(Empleado emp)
        {
            return empleados.Remove(emp);
        }
    }
}
