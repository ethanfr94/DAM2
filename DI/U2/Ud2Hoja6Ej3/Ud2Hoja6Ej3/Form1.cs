namespace Ud2Hoja6Ej3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void btnConvertir_Click(object sender, EventArgs e)
        {
            
            if (cmbOrigen.SelectedItem.ToString() == "Euro")
            {
                if (cmbDestino.SelectedItem.ToString() == "Euro")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text);
                    lblConversion.Text = $"{cantidad.ToString():F2} Euros";
                }
                else if (cmbDestino.SelectedItem.ToString() == "Dolar")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text) * (1.09);
                    lblConversion.Text = $"{cantidad.ToString():2f} Dolares";
                }
                else if (cmbDestino.SelectedItem.ToString() == "Libra")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text) * (0.84);
                    lblConversion.Text = $"{cantidad.ToString():F2} Libras";
                }
            }
            else if (cmbOrigen.SelectedItem.ToString() == "Dolar")
            {
                if (cmbDestino.SelectedItem.ToString() == "Euro")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text) * (0.92);
                    lblConversion.Text = $"{cantidad.ToString():F2} Euros";
                }
                else if (cmbDestino.SelectedItem.ToString() == "Dolar")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text);
                    lblConversion.Text = $"{cantidad.ToString():F2} Dolares";
                }
                else if (cmbDestino.SelectedItem.ToString() == "Libra")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text) + (0.77);
                    lblConversion.Text = $"{cantidad.ToString():F2} Libras";
                }
            }
            else if (cmbOrigen.SelectedItem.ToString() == "Libra")
            {
                if (cmbDestino.SelectedItem.ToString() == "Euro")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text) * (1.2);
                    lblConversion.Text = $"{cantidad.ToString():F2} Euros";
                }
                else if (cmbDestino.SelectedItem.ToString() == "Dolar")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text) * (1.31);
                    lblConversion.Text = $"{cantidad.ToString():F2} Dolares";
                }
                else if (cmbDestino.SelectedItem.ToString() == "Libra")
                {
                    double cantidad = Convert.ToDouble(txtCantidad.Text);
                    lblConversion.Text = $"{cantidad.ToString():F2} Libras";
                }
            }
        }

        
    }
}
