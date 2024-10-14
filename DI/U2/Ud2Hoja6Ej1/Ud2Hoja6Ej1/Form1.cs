namespace Ud2Hoja6Ej1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void btnRestar_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(txtOp1.Text);
            int num2 = Convert.ToInt32(txtOp2.Text);
            int resultado = num1 - num2;
            txtResult.Text = resultado.ToString();
        }

        private void btnMultip_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(txtOp1.Text);
            int num2 = Convert.ToInt32(txtOp2.Text);
            int resultado = num1 * num2;
            txtResult.Text = resultado.ToString();
        }

        private void btnDiv_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(txtOp1.Text);
            int num2 = Convert.ToInt32(txtOp2.Text);
            int resultado = 0;
            if (num2 != 0){
                resultado = num1 / num2;
            }
            else {
                MessageBox.Show("No se puede dividir por 0");                
            }
            txtResult.Text = resultado.ToString();
        }

        private void btnSumar_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(txtOp1.Text);
            int num2 = Convert.ToInt32(txtOp2.Text);
            int resultado = num1 + num2;
            txtResult.Text = resultado.ToString();
        }
    }
}
