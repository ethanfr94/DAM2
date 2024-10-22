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
            if (HaSidoModificado())
            {
                DialogResult result = MessageBox.Show("¿Desea guardar los cambios?", "Guardar", MessageBoxButtons.YesNoCancel);
                if (result == DialogResult.Yes)
                {
                    guardarComo();
                }
                else if (result == DialogResult.Cancel)
                {
                    return;
                }
                OpenFileDialog ofd = new OpenFileDialog();
                txtContenido.Clear();
                contenidoInicial = "";
                ruta = "";

            }
        }

        private void guardarComo()
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.Filter = "Text files (*.txt)|*.txt";//Filtro para que solo se puedan seleccionar archivos de texto
            sfd.Title = "Guardar archivo de texto";//Titulo de la ventana
            if (sfd.ShowDialog() == DialogResult.OK)// Si se ha seleccionado un archivo
            {
                ruta = sfd.FileName;
                System.IO.File.WriteAllText(ruta, contenidoInicial);//Guardamos el contenido del archivo en el fichero seleccionado si no existe el fichero lo crea
                contenidoInicial = txtContenido.Text;
            }
        }

        private void tsmiAbrir_Click(object sender, EventArgs e)
        {
            if (HaSidoModificado())
            {
                DialogResult result = MessageBox.Show("¿Desea guardar los cambios?", "Guardar", MessageBoxButtons.YesNoCancel);

                if (result == DialogResult.Yes)
                {
                    guardarComo();
                }
                else if (result == DialogResult.Cancel)
                {
                    return;
                }

                OpenFileDialog ofd = new OpenFileDialog();

                ofd.Filter = "Text files (*.txt)|*.txt";//Filtro para que solo se puedan seleccionar archivos de texto
                ofd.Title = "Abrir archivo de texto";//Titulo de la ventana

                if (ofd.ShowDialog() == DialogResult.OK)// Si se ha seleccionado un archivo
                {
                    ruta = ofd.FileName;
                    txtContenido.Text = System.IO.File.ReadAllText(ruta);//Guardamos el contenido del archivo en la variable contenidoInicial
                    contenidoInicial = txtContenido.Text;//Guardamos el contenido del archivo en la variable contenidoInicial
                }
            }
        }

        private void guardar()
        {
            if (string.IsNullOrEmpty(ruta))
            {
                guardarComo();
            }
            else
            {
                System.IO.File.WriteAllText(ruta, contenidoInicial);//Guardamos el contenido del archivo en el fichero seleccionado si no existe el fichero lo crea
                contenidoInicial = txtContenido.Text;
            }
        }

        private void tsmiGuardar_Click(object sender, EventArgs e)
        {
            guardar();
        }

        private void tsmiGuardarComo_Click(object sender, EventArgs e)
        {
            guardarComo();
        }

        private void tsmiSalir_Click(object sender, EventArgs e)
        {
            if (HaSidoModificado())
            {
                DialogResult result = MessageBox.Show("¿Desea guardar los cambios?", "Guardar", MessageBoxButtons.YesNoCancel);

                if (result == DialogResult.Yes)
                {
                    guardarComo();
                }
                else if (result == DialogResult.Cancel)
                {
                    return;
                }
                else
                {
                    Application.Exit();
                }
            }
            else
            {
                Application.Exit();
            }

        }

        private void acercaDeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FormAyuda f2 = new FormAyuda();
            f2.Show();
        }

        private void fuenteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FontDialog fd = new FontDialog();
            fd.Font = txtContenido.Font;
            if (fd.ShowDialog() == DialogResult.OK)
            {
                txtContenido.Font = fd.Font;
            }

        }

        private void ajusteDeTexToolStripMenuItem_Click(object sender, EventArgs e)
        {
            txtContenido.WordWrap = !txtContenido.WordWrap;
            ajusteDeTexToolStripMenuItem.Checked = txtContenido.WordWrap;
            if (ajusteDeTexToolStripMenuItem.Checked)
            {
                ajusteDeTexToolStripMenuItem.Checked = false;
            }
            else
            {
                ajusteDeTexToolStripMenuItem.Checked = true;
            }
        }

        private void tsmiDeshacer_Click(object sender, EventArgs e)
        {
            if(txtContenido.CanUndo) txtContenido.Undo();
        }

        private void tsmiCortar_Click(object sender, EventArgs e)
        {
            if(txtContenido.SelectedText.Length>0) txtContenido.Cut();//Corta el texto seleccionado
        }

        private void tsmiCopiar_Click(object sender, EventArgs e)
        {
            if (txtContenido.SelectedText.Length > 0) txtContenido.Copy();//Copia el texto seleccionado
        }

        private void tsmiPegar_Click(object sender, EventArgs e)
        {
            if(Clipboard.ContainsText()) txtContenido.Paste();//Pega el texto seleccionado
        }

        private void tsmiEliminar_Click(object sender, EventArgs e)
        {
            if (txtContenido.SelectedText.Length > 0) txtContenido.SelectedText = "";//Elimina el texto seleccionado
        }

        private void tsmiBuscar_Click(object sender, EventArgs e)
        {
            FormBuscar f3 = new FormBuscar();
            f3.Show();
            if(txtContenido.Text.Contains(f3.Busqueda))//Si el texto contiene la busqueda realizada se selecciona el texto
            {
                txtContenido.Select(txtContenido.Text.IndexOf(f3.Busqueda), f3.Busqueda.Length);// el primer parametro es la posicion del texto a seleccionar y el segundo la longitud del texto a seleccionar
            }
            else
            {
                MessageBox.Show("Texto no encontrado");
            }

        }
    }
}
