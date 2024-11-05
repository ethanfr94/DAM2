namespace EjemploListas
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnadd_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(txtnombre.Text) || String.IsNullOrEmpty(txtedad.Text))
            {
                MessageBox.Show("Debe rellenar los campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Hand);
                return;
            }
            else
            {
                ListViewItem item = new ListViewItem(new[] { txtnombre.Text, txtedad.Text });
                listView1.Items.Add(item);

                txtnombre.Clear();
                txtedad.Clear();
                txtnombre.Focus();

            }
        }

        private void btndel_Click(object sender, EventArgs e)
        {
            //elimina utilizando el checkbox
            foreach (ListViewItem item in listView1.CheckedItems)
            {
                listView1.Items.Remove(item);
            }
            /*
            //elimina utilizando los elementos seleccionados
            foreach (ListViewItem item in listView1.SelectedItems)
            {
                listView1.Items.Remove(item);
            }
            */
        }

        private void eliminarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(listView1.SelectedItems.Count > 0)
            {
                foreach (ListViewItem item in listView1.SelectedItems)
                {
                    listView1.Items.Remove(item);
                }                
            }else
            {
                MessageBox.Show("Debe seleccionar un elemento", "Error", MessageBoxButtons.OK, MessageBoxIcon.Hand);
            }
        }
    }
}
