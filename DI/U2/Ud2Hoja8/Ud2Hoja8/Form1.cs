
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
            Button boton = (Button)sender;//casting de sender a Button para poder acceder a las propiedades del boton

            if (reiniciarVisor)
            {
                if(txtvisor.Text == "0")
                {
                    if (boton.Text == "0")
                    {
                        txtvisor.Text = "0";
                        reiniciarVisor = true;
                    }
                    if (boton.Text == ",")
                    {
                        txtvisor.Text = "0,";
                        reiniciarVisor = false;
                    }
                    else
                    {
                        txtvisor.Text = boton.Text;
                        reiniciarVisor = false;
                    }
                }
                else
                {
                    txtvisor.Text = boton.Text;
                    reiniciarVisor = false;
                }
                
            }
            else{
                txtvisor.Text += boton.Text;
            }
        }

        private void operacion_click(object sender, EventArgs e)
        {
            Button boton = (Button)sender;

            switch (boton.Text)
            {
                case "+":
                    _calculadora.Operacion = OperacionEnum.Suma;
                    calculadora.Cache = float.Parse(txtvisor.Text);
                    break;
                case "-":
                    _calculadora.Operacion = OperacionEnum.Resta;
                    calculadora.Cache = float.Parse(txtvisor.Text);
                    break;
                case "*":
                    _calculadora.Operacion = OperacionEnum.Multiplicacion;
                    calculadora.Cache = float.Parse(txtvisor.Text);
                    break;
                case "/":
                    _calculadora.Operacion = OperacionEnum.Division;
                    calculadora.Cache = float.Parse(txtvisor.Text);
                    break;
                case "=":
                    _calculadora.Calcular();
                    break;
            }
        }

        private void btnMR_Click(object sender, EventArgs e)
        {
            txtvisor.Text = _calculadora.memoria.ToString();
        }

        private void btnclear_Click(object sender, EventArgs e)
        {
            _calculadora.Borrar();
            txtvisor.Text = "0";
        }

        private void btnMS_Click(object sender, EventArgs e)
        {
            _calculadora.memoria = float.Parse(txtvisor.Text);
        }

        private void btncoma_Click(object sender, EventArgs e)
        {
            if(!txtvisor.Text.Contains(","))
            {
                txtvisor.Text += ",";
            }
        }
    }
}
