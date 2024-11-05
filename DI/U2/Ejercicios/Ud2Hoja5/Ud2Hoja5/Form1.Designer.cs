namespace Ud2Hoja5
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
            txtNombre = new TextBox();
            txtDireccion = new TextBox();
            txtEmail = new TextBox();
            txtTlfn = new TextBox();
            rdoMasculino = new RadioButton();
            rdoFemenino = new RadioButton();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            btnConf = new Button();
            SuspendLayout();
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(86, 16);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(224, 23);
            txtNombre.TabIndex = 0;
            // 
            // txtDireccion
            // 
            txtDireccion.Location = new Point(86, 128);
            txtDireccion.Name = "txtDireccion";
            txtDireccion.Size = new Size(224, 23);
            txtDireccion.TabIndex = 1;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(86, 99);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(224, 23);
            txtEmail.TabIndex = 2;
            // 
            // txtTlfn
            // 
            txtTlfn.Location = new Point(86, 70);
            txtTlfn.Name = "txtTlfn";
            txtTlfn.Size = new Size(224, 23);
            txtTlfn.TabIndex = 3;
            // 
            // rdoMasculino
            // 
            rdoMasculino.AutoSize = true;
            rdoMasculino.Location = new Point(130, 45);
            rdoMasculino.Name = "rdoMasculino";
            rdoMasculino.Size = new Size(80, 19);
            rdoMasculino.TabIndex = 4;
            rdoMasculino.TabStop = true;
            rdoMasculino.Text = "Masculino";
            rdoMasculino.UseVisualStyleBackColor = true;
            // 
            // rdoFemenino
            // 
            rdoFemenino.AutoSize = true;
            rdoFemenino.Location = new Point(232, 45);
            rdoFemenino.Name = "rdoFemenino";
            rdoFemenino.Size = new Size(78, 19);
            rdoFemenino.TabIndex = 5;
            rdoFemenino.TabStop = true;
            rdoFemenino.Text = "Femenino";
            rdoFemenino.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(16, 19);
            label1.Name = "label1";
            label1.Size = new Size(51, 15);
            label1.TabIndex = 6;
            label1.Text = "Nombre";
            label1.Click += label1_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(16, 102);
            label2.Name = "label2";
            label2.Size = new Size(36, 15);
            label2.TabIndex = 7;
            label2.Text = "Email";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(16, 73);
            label3.Name = "label3";
            label3.Size = new Size(52, 15);
            label3.TabIndex = 8;
            label3.Text = "Telefono";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(16, 47);
            label4.Name = "label4";
            label4.Size = new Size(45, 15);
            label4.TabIndex = 9;
            label4.Text = "Genero";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(16, 131);
            label5.Name = "label5";
            label5.Size = new Size(57, 15);
            label5.TabIndex = 10;
            label5.Text = "Direccion";
            // 
            // btnConf
            // 
            btnConf.Location = new Point(16, 157);
            btnConf.Name = "btnConf";
            btnConf.Size = new Size(294, 23);
            btnConf.TabIndex = 11;
            btnConf.Text = "Confirmar";
            btnConf.UseVisualStyleBackColor = true;
            btnConf.Click += btnConf_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(326, 190);
            Controls.Add(btnConf);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(rdoFemenino);
            Controls.Add(rdoMasculino);
            Controls.Add(txtTlfn);
            Controls.Add(txtEmail);
            Controls.Add(txtDireccion);
            Controls.Add(txtNombre);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtNombre;
        private TextBox txtDireccion;
        private TextBox txtEmail;
        private TextBox txtTlfn;
        private RadioButton rdoMasculino;
        private RadioButton rdoFemenino;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Button btnConf;
    }
}
