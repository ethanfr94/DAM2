namespace Ud2Hoja12
{
    public partial class Form1 : Form
    {
        private List<int> list = new List<int>();
        private int n;
        private int elementos = 0;
        private int sumatorio = 0;
        private double media = 0;
        private int max = 0;
        private int min = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            //validar que el campo no esté vacío y es numerico
            if (String.IsNullOrEmpty(txtNuevo.Text))
            {
                MessageBox.Show("Introduce un número");
                return;
            }
            else
            {
                try
                {
                    n = Convert.ToInt32(txtNuevo.Text);
                    list.Add(n);
                    listView1.Items.Add(txtNuevo.Text);
                    elementos++;
                    lblElementos.Text = elementos.ToString();
                    sumatorio += n;
                    lblSumatorio.Text = sumatorio.ToString();
                    max = list.Max();
                    lblMax.Text = max.ToString();
                    min = list.Min();
                    lblMin.Text = min.ToString();
                    media = (double)sumatorio / elementos;
                    lblMedia.Text = media.ToString();
                    txtNuevo.Text = "";
                    txtNuevo.Focus();

                }
                catch (Exception ex)
                {
                    MessageBox.Show("Introduce un número");
                    txtNuevo.Text = "";
                    txtNuevo.Focus();
                    return;
                }


            }
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count == 1)
            {
                int n = Convert.ToInt32(listView1.SelectedItems[0].Text);
                listView1.Items.Remove(listView1.SelectedItems[0]);
                list.Remove(n);
                elementos--;
                lblElementos.Text = elementos.ToString();
                sumatorio -= n;
                lblSumatorio.Text = sumatorio.ToString();
                if(n==max)max = list.Max();
                lblMax.Text = max.ToString();
                if(n==min)min = list.Min();
                lblMin.Text = min.ToString();
                media = (double)sumatorio / elementos;
                lblMedia.Text = media.ToString();
            }
            else if (listView1.SelectedItems.Count == 0)
            {
                MessageBox.Show("Selecciona un elemento");
            }
            else
            {
                MessageBox.Show("Selecciona un solo elemento");
            }
        }

        private void btnOrdenar_Click(object sender, EventArgs e)
        {
            list.Sort();
            listView1.Items.Clear();
            foreach (int num in list)
            {
                listView1.Items.Add(num.ToString());
            }
        }
       
    }
}
