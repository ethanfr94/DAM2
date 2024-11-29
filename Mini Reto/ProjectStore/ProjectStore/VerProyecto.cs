using ProjectStore;

namespace minireto
{
    public partial class VerProyecto : Form
    {
        private readonly APIConnection apiConnection = new APIConnection();
        private List<Realizan> realiza;
        private List<Evaluan> evalua;
        private List<string> alumnos;
        private List<string> profesores;
        private Proyecto proyecto;
        List<Alumno> als;
        List<Profesor> prs;

        public VerProyecto(int id)
        {
            this.alumnos = alumnos;
            this.profesores = profesores;
            InitializeComponent();
            carga(id);
            
        }

        private async void carga(int id)
        {
            realiza = await apiConnection.GetRealizanId(id);
            evalua = await apiConnection.GetEvaluanId(id);
            proyecto = await apiConnection.GetProyectoById(id);
            alumnos = await apiConnection.GetAutores(id);
            profesores = await apiConnection.GetEvaluadores(id);

            lblNombre.Text = proyecto.Nombre;

            lbl_ano.Text += " "+proyecto.AnioAcademico.ToString();

            lbl_curso.Text = proyecto.Ciclo.Nombre.ToString();

            txt_profesor.Text = proyecto.Tutor.Nombre + " " + proyecto.Tutor.Apellidos;

            txtResumen.Text = proyecto.Resumen;

            foreach (var alumno in alumnos)
            {
                als = new List<Alumno>();
                Alumno al = await apiConnection.GetAlumnoById(alumno);
                als.Add(al);
            }

            foreach (Alumno al in als){
                txtAutor.Text += al.Nombre + " " + al.Apellidos + "\n";
            }

            foreach (var profesor in profesores)
            {
                prs = new List<Profesor>();
                Profesor pr = await apiConnection.GetProfesorById(profesor);
                prs.Add(pr);
            }

            foreach (Profesor pr in prs)
            {
                txtEvaluan.Text += pr.Nombre + " " + pr.Apellidos + "\n";
            }






        }

        
    }
}
