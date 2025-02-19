namespace Ud3Hoja2
{
    partial class VisorInforme
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.rpvVisorInforme = new Microsoft.Reporting.WinForms.ReportViewer();
            this.SuspendLayout();
            // 
            // rpvVisorInforme
            // 
            this.rpvVisorInforme.Dock = System.Windows.Forms.DockStyle.Fill;
            this.rpvVisorInforme.LocalReport.ReportEmbeddedResource = "Ud3Hoja2.rptFabricantes.rdlc";
            this.rpvVisorInforme.Location = new System.Drawing.Point(0, 0);
            this.rpvVisorInforme.Name = "rpvVisorInforme";
            this.rpvVisorInforme.ServerReport.BearerToken = null;
            this.rpvVisorInforme.Size = new System.Drawing.Size(800, 450);
            this.rpvVisorInforme.TabIndex = 0;
            // 
            // VisorInforme
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.rpvVisorInforme);
            this.Name = "VisorInforme";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        public Microsoft.Reporting.WinForms.ReportViewer rpvVisorInforme;
    }
}

