using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ud3Hoja2
{
    public partial class VisorInforme : Form
    {
        public VisorInforme()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            this.rpvVisorInforme.RefreshReport();
        }
    }
}
