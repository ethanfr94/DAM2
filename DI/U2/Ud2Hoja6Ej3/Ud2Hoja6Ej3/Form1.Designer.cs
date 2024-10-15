namespace Ud2Hoja6Ej3
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            txtCantidad = new TextBox();
            lblCantidad = new Label();
            lblOrigen = new Label();
            lblDestino = new Label();
            btnConvertir = new Button();
            cmbOrigen = new ComboBox();
            cmbDestino = new ComboBox();
            lblConversion = new Label();
            SuspendLayout();
            // 
            // txtCantidad
            // 
            txtCantidad.Location = new Point(119, 37);
            txtCantidad.Name = "txtCantidad";
            txtCantidad.Size = new Size(121, 23);
            txtCantidad.TabIndex = 0;
            // 
            // lblCantidad
            // 
            lblCantidad.AutoSize = true;
            lblCantidad.Location = new Point(12, 40);
            lblCantidad.Name = "lblCantidad";
            lblCantidad.Size = new Size(55, 15);
            lblCantidad.TabIndex = 1;
            lblCantidad.Text = "Cantidad";
            // 
            // lblOrigen
            // 
            lblOrigen.AutoSize = true;
            lblOrigen.Location = new Point(12, 82);
            lblOrigen.Name = "lblOrigen";
            lblOrigen.Size = new Size(90, 15);
            lblOrigen.TabIndex = 2;
            lblOrigen.Text = "Moneda Origen";
            // 
            // lblDestino
            // 
            lblDestino.AutoSize = true;
            lblDestino.Location = new Point(12, 126);
            lblDestino.Name = "lblDestino";
            lblDestino.Size = new Size(94, 15);
            lblDestino.TabIndex = 3;
            lblDestino.Text = "Moneda Destino";
            // 
            // btnConvertir
            // 
            btnConvertir.Location = new Point(119, 162);
            btnConvertir.Name = "btnConvertir";
            btnConvertir.Size = new Size(121, 23);
            btnConvertir.TabIndex = 4;
            btnConvertir.Text = "Convertir";
            btnConvertir.UseVisualStyleBackColor = true;
            btnConvertir.Click += btnConvertir_Click;
            // 
            // cmbOrigen
            // 
            cmbOrigen.FormattingEnabled = true;
            cmbOrigen.Items.AddRange(new object[] { "Euro", "Dolar", "Libra" });
            cmbOrigen.Location = new Point(119, 79);
            cmbOrigen.Name = "cmbOrigen";
            cmbOrigen.Size = new Size(121, 23);
            cmbOrigen.TabIndex = 5;
            // 
            // cmbDestino
            // 
            cmbDestino.FormattingEnabled = true;
            cmbDestino.Items.AddRange(new object[] { "Euro", "Dolar", "Libra" });
            cmbDestino.Location = new Point(119, 123);
            cmbDestino.Name = "cmbDestino";
            cmbDestino.Size = new Size(121, 23);
            cmbDestino.TabIndex = 6;
            // 
            // lblConversion
            // 
            lblConversion.AutoSize = true;
            lblConversion.Location = new Point(29, 207);
            lblConversion.Name = "lblConversion";
            lblConversion.Size = new Size(38, 15);
            lblConversion.TabIndex = 7;
            lblConversion.Text = "label1";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(252, 248);
            Controls.Add(lblConversion);
            Controls.Add(cmbDestino);
            Controls.Add(cmbOrigen);
            Controls.Add(btnConvertir);
            Controls.Add(lblDestino);
            Controls.Add(lblOrigen);
            Controls.Add(lblCantidad);
            Controls.Add(txtCantidad);
            Name = "Form1";
            Text = "Conversor";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtCantidad;
        private Label lblCantidad;
        private Label lblOrigen;
        private Label lblDestino;
        private Button button1;
        private ComboBox cmbOrigen;
        private ComboBox cmbDestino;
        private Button btnConvertir;
        private Label lblConversion;
    }
}
