using Ud2Hoja8;

namespace U2Hoja8
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button15_Click(object sender, EventArgs e)
        {

        }

        private void btndiv_Click(object sender, EventArgs e)
        {
            calculadora.Operacion = OperacionEnum.Division;
        }

        private void btnmulti_Click(object sender, EventArgs e)
        {
            calculadora.Operacion = OperacionEnum.Multiplicacion;
        }

        private void btnresta_Click(object sender, EventArgs e)
        {
            calculadora.Operacion = OperacionEnum.Resta;
        }

        private void btnsuma_Click(object sender, EventArgs e)
        {
            calculadora.Operacion = OperacionEnum.Suma;
        }

        private void btnigual_Click(object sender, EventArgs e)
        {
            calculadora.Calcular();
        }
    }
}
