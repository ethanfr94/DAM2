
using Ud2Hoja8;

namespace U2Hoja8
{
    public partial class Form1 : Form
    {
        private Calculadora _calculadora = new Calculadora();
        private Boolean reiniciarVisor = true;
        public Form1()
        {
            InitializeComponent();
        }



        private void numero_click(object sender, EventArgs e)
        {
            if (reiniciarVisor)
            {
                txtvisor.Text = "0";
                reiniciarVisor = false;
            }
            Button boton = (Button)sender;//casting de sender a Button para poder acceder a las propiedades del boton
            if (txtvisor.Text.Equals("0"))
            {
                txtvisor.Text = "";
                txtvisor.Text += boton.Text;
                _calculadora.Visor = float.Parse(txtvisor.Text);
                reiniciarVisor = false;
            }            
            else
            {                
                txtvisor.Text += boton.Text;
                _calculadora.Visor = float.Parse(txtvisor.Text);
            }
        }
        private void btncoma_Click(object sender, EventArgs e)
        {
            if (txtvisor.Text.Equals("0"))
            {
                txtvisor.Text = "0,";
                reiniciarVisor = false;
            }
            if (!txtvisor.Text.Contains(","))
            {
                txtvisor.Text += ",";
            }
        }

        private void operacion_click(object sender, EventArgs e)
        {
            Button boton = (Button)sender;

            switch (boton.Text)
            {
                case "+":
                    _calculadora.Visor = float.Parse(txtvisor.Text);
                    _calculadora.Operacion = OperacionEnum.Suma;
                    break;
                case "-":
                    _calculadora.Visor = float.Parse(txtvisor.Text);
                    _calculadora.Operacion = OperacionEnum.Resta;
                    break;
                case "*":
                    _calculadora.Visor = float.Parse(txtvisor.Text);
                    _calculadora.Operacion = OperacionEnum.Multiplicacion;
                    break;
                case "/":
                    _calculadora.Visor = float.Parse(txtvisor.Text);
                    _calculadora.Operacion = OperacionEnum.Division;
                    break;
            }
            _calculadora.Visor = 0;
            reiniciarVisor = true;
        }

        private void btnigual_Click(object sender, EventArgs e)
        {
            _calculadora.Calcular();
            txtvisor.Text = _calculadora.Visor.ToString();
            _calculadora.Visor = 0;
            reiniciarVisor = true;
        }

        private void btnMS_Click(object sender, EventArgs e)
        {
            _calculadora.memoria = float.Parse(txtvisor.Text);
            reiniciarVisor = true;
        }
        private void btnMR_Click(object sender, EventArgs e)
        {
            txtvisor.Text = _calculadora.memoria.ToString();
            _calculadora.Visor = float.Parse(txtvisor.Text);
        }

        private void btnclear_Click(object sender, EventArgs e)
        {
            _calculadora.Borrar();
            txtvisor.Text = "0";

        }

        

       

        
    }
}
