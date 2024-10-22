namespace Ud2Hoja10
{
    partial class FormAyuda
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lblAyuda = new Label();
            label1 = new Label();
            SuspendLayout();
            // 
            // lblAyuda
            // 
            lblAyuda.AutoSize = true;
            lblAyuda.Font = new Font("Segoe UI", 15.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblAyuda.Location = new Point(61, 79);
            lblAyuda.Name = "lblAyuda";
            lblAyuda.Size = new Size(228, 30);
            lblAyuda.TabIndex = 0;
            lblAyuda.Text = "Bloc de notas de clase";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(61, 136);
            label1.Name = "label1";
            label1.Size = new Size(160, 15);
            label1.TabIndex = 1;
            label1.Text = "Desarrollado por: Izan Franco";
            // 
            // FormAyuda
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(387, 236);
            Controls.Add(label1);
            Controls.Add(lblAyuda);
            Name = "FormAyuda";
            Text = "Ayuda";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblAyuda;
        private Label label1;
    }
}