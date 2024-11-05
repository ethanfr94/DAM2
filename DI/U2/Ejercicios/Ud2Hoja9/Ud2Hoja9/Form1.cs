namespace Ud2Hoja9
{
    public partial class Form1 : Form
    {

        private MessageBoxButtons botones = MessageBoxButtons.OK;
        private MessageBoxIcon iconos = MessageBoxIcon.None;
        private String result = "Ha seleccionado: ";

        public Form1()
        {
            InitializeComponent();
        }

        private void botones_chekedChanged(object sender, EventArgs e)
        {
            RadioButton btn = sender as RadioButton;
            if (btn != null && btn.Checked)
            {
                switch (btn.Name)
                {
                    case "rdoAceptar":
                        botones = MessageBoxButtons.OK;
                        break;
                    case "rdoAcepCanc":
                        botones = MessageBoxButtons.OKCancel;
                        break;
                    case "rdoSiNo":
                        botones = MessageBoxButtons.YesNo;
                        break;
                    case "rdoSiNoCanc":
                        botones = MessageBoxButtons.YesNoCancel;
                        break;
                    case "rdoReintCanc":
                        botones = MessageBoxButtons.RetryCancel;
                        break;
                    case "rdoAbReintIgn":
                        botones = MessageBoxButtons.AbortRetryIgnore;
                        break;
                    
                }
            }
            /*
            if (rdoAceptar.Checked) { botones = MessageBoxButtons.OK; }
            else if (rdoAcepCanc.Checked) { botones = MessageBoxButtons.OKCancel; }
            else if (rdoSiNo.Checked) { botones = MessageBoxButtons.YesNo; }
            else if (rdoSiNoCanc.Checked) { botones = MessageBoxButtons.YesNoCancel; }
            else (rdoReintCanc.Checked) { botones = MessageBoxButtons.RetryCancel; }
            else (rdoAbReintIgn.Checked) { botones = MessageBoxButtons.AbortRetryIgnore; }
            */

        }

        private void Iconos_checkedChange(object sender, EventArgs e)
        {
            RadioButton btn = sender as RadioButton;
            if (btn != null && btn.Checked)
            {
                switch (btn.Name)
                {
                    case "rdoAsterisco":
                        iconos = MessageBoxIcon.Asterisk;
                        break;
                    case "rdoError":
                        iconos = MessageBoxIcon.Error;
                        break;
                    case "rdoExclamacion":
                        iconos = MessageBoxIcon.Exclamation;
                        break;
                    case "rdoInfo":
                        iconos = MessageBoxIcon.Information;
                        break;
                    case "rdoMano":
                        iconos = MessageBoxIcon.Hand;
                        break;
                    case "rdoAviso":
                        iconos = MessageBoxIcon.Warning;
                        break;
                    case "rdoPregunta":
                        iconos = MessageBoxIcon.Question;
                        break;
                    case "rdoAlto":
                        iconos = MessageBoxIcon.Stop;
                        break;


                }
            }
            /*
            if (rdoError.Checked) { iconos = MessageBoxIcon.Error; }
            else if (rdoInfo.Checked) { iconos = MessageBoxIcon.Information; }
            else if (rdoAviso.Checked) { iconos = MessageBoxIcon.Warning; }
            else (rdoPregunta.Checked) { iconos = MessageBoxIcon.Question; }
            else (rdoAsterisco.Checked) { iconos = MessageBoxIcon.Asterisk; }
            else (rdoMano.Checked) { iconos = MessageBoxIcon.Hand; }
            else (rdoAlto.Checked) { iconos = MessageBoxIcon.Stop; }
            else (rdoExclamacion.Checked) { iconos = MessageBoxIcon.Exclamation; }
            */

        }

        private void btnMostrar_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show(txtMsg.Text, txtTitulo.Text, botones, iconos);
            switch (res)
            {
                case DialogResult.OK:
                    result += "OK";
                    break;
                case DialogResult.Cancel:
                    result += "Cancelar";
                    break;
                case DialogResult.Yes:
                    result += "Si";
                    break;
                case DialogResult.No:
                    result += "No";
                    break;
                case DialogResult.Abort:
                    result += "Abortar";
                    break;
                case DialogResult.Retry:
                    result += "Reintentar";
                    break;
                case DialogResult.Ignore:
                    result += "Ignorar";
                    break;
            }       
            lblRes.Text = result;
        }
    }
}
