namespace Ud2Hoja13
{
    public partial class Form1 : Form
    {

        DirectoryInfo nodoRaiz;
        DirectoryInfo[] directorios;
        FileInfo[] ficheros;
        ImageList listaImagenes = new ImageList();

        public Form1()
        {
            InitializeComponent();
            CargarArbol();
            
        }

        

        private void CargarArbol()
        {
            nodoRaiz = new DirectoryInfo(@"C:\");
        }

        
    }
}
