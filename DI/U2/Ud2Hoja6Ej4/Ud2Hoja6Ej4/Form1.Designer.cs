namespace Ud2Hoja6Ej4
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
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            txtNombre = new TextBox();
            txtEmail = new TextBox();
            txtPass = new TextBox();
            btnRegistro = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(14, 40);
            label1.Name = "label1";
            label1.Size = new Size(51, 15);
            label1.TabIndex = 0;
            label1.Text = "Nombre";
            label1.Click += label1_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(14, 78);
            label2.Name = "label2";
            label2.Size = new Size(67, 15);
            label2.TabIndex = 1;
            label2.Text = "Contraseña";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(14, 116);
            label3.Name = "label3";
            label3.Size = new Size(36, 15);
            label3.TabIndex = 2;
            label3.Text = "Email";
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(108, 37);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(126, 23);
            txtNombre.TabIndex = 3;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(108, 113);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(126, 23);
            txtEmail.TabIndex = 4;
            // 
            // txtPass
            // 
            txtPass.Location = new Point(108, 75);
            txtPass.Name = "txtPass";
            txtPass.Size = new Size(126, 23);
            txtPass.TabIndex = 5;
            txtPass.UseSystemPasswordChar = true;
            // 
            // btnRegistro
            // 
            btnRegistro.Location = new Point(108, 153);
            btnRegistro.Name = "btnRegistro";
            btnRegistro.Size = new Size(126, 23);
            btnRegistro.TabIndex = 6;
            btnRegistro.Text = "Registrar";
            btnRegistro.UseVisualStyleBackColor = true;
            btnRegistro.Click += btnRegistro_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(246, 204);
            Controls.Add(btnRegistro);
            Controls.Add(txtPass);
            Controls.Add(txtEmail);
            Controls.Add(txtNombre);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private TextBox txtNombre;
        private TextBox txtEmail;
        private TextBox txtPass;
        private Button btnRegistro;
    }
}
