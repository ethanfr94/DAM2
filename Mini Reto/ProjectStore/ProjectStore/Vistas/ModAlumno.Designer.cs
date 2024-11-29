namespace ProjectStore
{
    partial class ModAlumno
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
            label9 = new Label();
            chkActivo = new CheckBox();
            label12 = new Label();
            btnCancelar = new Button();
            btnMod = new Button();
            dtpFechaNac = new DateTimePicker();
            cmbGenero = new ComboBox();
            txtTelefono = new TextBox();
            txtContraseña = new TextBox();
            txtEmail = new TextBox();
            txtDni = new TextBox();
            txtApellidos = new TextBox();
            txtNombre = new TextBox();
            label8 = new Label();
            label7 = new Label();
            label6 = new Label();
            label5 = new Label();
            label4 = new Label();
            label3 = new Label();
            label2 = new Label();
            label1 = new Label();
            cmbCiclo = new ComboBox();
            label10 = new Label();
            SuspendLayout();
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(13, 275);
            label9.Name = "label9";
            label9.Size = new Size(42, 15);
            label9.TabIndex = 138;
            label9.Text = "Estado";
            // 
            // chkActivo
            // 
            chkActivo.AutoSize = true;
            chkActivo.Location = new Point(148, 274);
            chkActivo.Name = "chkActivo";
            chkActivo.Size = new Size(76, 19);
            chkActivo.TabIndex = 137;
            chkActivo.Text = "En Activo";
            chkActivo.UseVisualStyleBackColor = true;
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Location = new Point(13, 303);
            label12.Name = "label12";
            label12.Size = new Size(118, 15);
            label12.TabIndex = 136;
            label12.Text = "* Campos requeridos";
            // 
            // btnCancelar
            // 
            btnCancelar.Location = new Point(257, 299);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(90, 23);
            btnCancelar.TabIndex = 133;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = true;
            btnCancelar.Click += btnCancelar_Click;
            // 
            // btnMod
            // 
            btnMod.Location = new Point(161, 299);
            btnMod.Name = "btnMod";
            btnMod.Size = new Size(90, 23);
            btnMod.TabIndex = 132;
            btnMod.Text = "Modificar";
            btnMod.UseVisualStyleBackColor = true;
            btnMod.Click += btnMod_Click;
            // 
            // dtpFechaNac
            // 
            dtpFechaNac.Enabled = false;
            dtpFechaNac.Format = DateTimePickerFormat.Short;
            dtpFechaNac.Location = new Point(148, 216);
            dtpFechaNac.Name = "dtpFechaNac";
            dtpFechaNac.Size = new Size(199, 23);
            dtpFechaNac.TabIndex = 131;
            // 
            // cmbGenero
            // 
            cmbGenero.Enabled = false;
            cmbGenero.FormattingEnabled = true;
            cmbGenero.Location = new Point(148, 187);
            cmbGenero.Name = "cmbGenero";
            cmbGenero.Size = new Size(199, 23);
            cmbGenero.TabIndex = 130;
            // 
            // txtTelefono
            // 
            txtTelefono.Location = new Point(148, 158);
            txtTelefono.Name = "txtTelefono";
            txtTelefono.Size = new Size(199, 23);
            txtTelefono.TabIndex = 129;
            // 
            // txtContraseña
            // 
            txtContraseña.Location = new Point(148, 129);
            txtContraseña.Name = "txtContraseña";
            txtContraseña.Size = new Size(199, 23);
            txtContraseña.TabIndex = 128;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(148, 100);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(199, 23);
            txtEmail.TabIndex = 127;
            // 
            // txtDni
            // 
            txtDni.Enabled = false;
            txtDni.Location = new Point(148, 71);
            txtDni.Name = "txtDni";
            txtDni.Size = new Size(199, 23);
            txtDni.TabIndex = 126;
            // 
            // txtApellidos
            // 
            txtApellidos.Enabled = false;
            txtApellidos.Location = new Point(148, 42);
            txtApellidos.Name = "txtApellidos";
            txtApellidos.Size = new Size(199, 23);
            txtApellidos.TabIndex = 125;
            // 
            // txtNombre
            // 
            txtNombre.Enabled = false;
            txtNombre.Location = new Point(148, 12);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(199, 23);
            txtNombre.TabIndex = 124;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(13, 222);
            label8.Name = "label8";
            label8.Size = new Size(103, 15);
            label8.TabIndex = 123;
            label8.Text = "Fecha Nacimiento";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(13, 190);
            label7.Name = "label7";
            label7.Size = new Size(53, 15);
            label7.TabIndex = 122;
            label7.Text = "Género *";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(13, 161);
            label6.Name = "label6";
            label6.Size = new Size(52, 15);
            label6.TabIndex = 121;
            label6.Text = "Teléfono";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(12, 132);
            label5.Name = "label5";
            label5.Size = new Size(75, 15);
            label5.TabIndex = 120;
            label5.Text = "Contraseña *";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(12, 103);
            label4.Name = "label4";
            label4.Size = new Size(49, 15);
            label4.TabIndex = 119;
            label4.Text = "E-Mail *";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(13, 74);
            label3.Name = "label3";
            label3.Size = new Size(35, 15);
            label3.TabIndex = 118;
            label3.Text = "DNI *";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(13, 45);
            label2.Name = "label2";
            label2.Size = new Size(64, 15);
            label2.TabIndex = 117;
            label2.Text = "Apellidos *";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 15);
            label1.Name = "label1";
            label1.Size = new Size(59, 15);
            label1.TabIndex = 116;
            label1.Text = "Nombre *";
            // 
            // cmbCiclo
            // 
            cmbCiclo.Enabled = false;
            cmbCiclo.FormattingEnabled = true;
            cmbCiclo.Location = new Point(148, 245);
            cmbCiclo.Name = "cmbCiclo";
            cmbCiclo.Size = new Size(200, 23);
            cmbCiclo.TabIndex = 140;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(13, 248);
            label10.Name = "label10";
            label10.Size = new Size(42, 15);
            label10.TabIndex = 139;
            label10.Text = "Ciclo *";
            // 
            // ModAlumno
            // 
            AcceptButton = btnMod;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            CancelButton = btnCancelar;
            ClientSize = new Size(356, 330);
            Controls.Add(cmbCiclo);
            Controls.Add(label10);
            Controls.Add(label9);
            Controls.Add(chkActivo);
            Controls.Add(label12);
            Controls.Add(btnCancelar);
            Controls.Add(btnMod);
            Controls.Add(dtpFechaNac);
            Controls.Add(cmbGenero);
            Controls.Add(txtTelefono);
            Controls.Add(txtContraseña);
            Controls.Add(txtEmail);
            Controls.Add(txtDni);
            Controls.Add(txtApellidos);
            Controls.Add(txtNombre);
            Controls.Add(label8);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "ModAlumno";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "ModAlumno";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label9;
        private CheckBox chkActivo;
        private Label label12;
        private Button btnCancelar;
        private Button btnMod;
        private DateTimePicker dtpFechaNac;
        private ComboBox cmbGenero;
        private TextBox txtTelefono;
        private TextBox txtContraseña;
        private TextBox txtEmail;
        private TextBox txtDni;
        private TextBox txtApellidos;
        private TextBox txtNombre;
        private Label label8;
        private Label label7;
        private Label label6;
        private Label label5;
        private Label label4;
        private Label label3;
        private Label label2;
        private Label label1;
        private ComboBox cmbCiclo;
        private Label label10;
    }
}