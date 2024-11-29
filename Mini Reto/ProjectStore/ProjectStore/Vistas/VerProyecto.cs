using ProjectStore;

namespace minireto
{
    public partial class VerProyecto : Form
    {
        private readonly APIConnection apiConnection = new APIConnection();
        private List<Realizan> realiza;
        private List<Evaluan> evalua;
        private List<Alumno> alumnos;
        private List<Profesor> profesores;
        private Proyecto proyecto;
        List<Alumno> als = new List<Alumno>();
        List<Profesor> prs = new List<Profesor>();
        Realizan r;
        Evaluan e;

        public VerProyecto(int id)
        {
            this.alumnos = alumnos;
            this.profesores = profesores;
            InitializeComponent();
            carga(id);
            
        }

        private async void carga(int id)
        {
            realiza = await apiConnection.GetRealizan();
            evalua = await apiConnection.GetEvaluan();
            proyecto = await apiConnection.GetProyectoById(id);
            alumnos = await apiConnection.GetAllAlumnos();
            profesores = await apiConnection.GetAllProfesores();

            lblNombre.Text = proyecto.Nombre;

            lbl_ano.Text += " "+proyecto.AnioAcademico.ToString();

            lbl_curso.Text = proyecto.Ciclo.Nombre.ToString();

            txt_profesor.Text = proyecto.Tutor.Nombre + " " + proyecto.Tutor.Apellidos;

            txtResumen.Text = proyecto.Resumen;

            txtAutor.Text = "Autores del proyecto";

            txtEvaluan.Text = "Profesores que evaluan";


            /*foreach (var re in realiza)
            {
                if (re.IdProyecto == proyecto.Id)
                {
                    r = re;
                    break;
                }
            }

            foreach (var ev in evalua)
            {
                if (ev.IdProyecto == proyecto.Id)
                {
                    e = ev;
                    break;
                }
            }

            foreach (var alumno in alumnos)
            {
              if(alumno.Id == r.IdAlumno)
                {
                    als.Add(alumno);
                }
            }

            foreach (Alumno al in als){
                txtAutor.Text += al.Nombre + " " + al.Apellidos + "\n";
            }

            foreach (var profesor in profesores)
            {
               if(profesor.Id == e.IdProfesor)
                {
                    prs.Add(profesor);
                }
            }

            foreach (Profesor pr in prs)
            {
                txtEvaluan.Text += pr.Nombre + " " + pr.Apellidos + "\n";
            }*/






        }

        
    }
}
