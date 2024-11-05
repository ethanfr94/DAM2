namespace Ud2Hoja6Ej2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            String tarea = txtTarea.Text;
            if (tarea != "")
            {
                lstTareas.Items.Add(tarea);
                txtTarea.Text = "";
            }
            else
            {
                MessageBox.Show("Introduce una tarea");
            }
        }

        private void btnDel_Click(object sender, EventArgs e)
        {
            lstTareas.Items.Remove(lstTareas.SelectedItem);
        }
    }
}
