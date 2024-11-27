namespace ProjectStore
{
    partial class ModProfesor
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
            label12 = new Label();
            txtEspecialidad = new TextBox();
            label10 = new Label();
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
            label9 = new Label();
            chkActivo = new CheckBox();
            SuspendLayout();
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Location = new Point(12, 300);
            label12.Name = "label12";
            label12.Size = new Size(118, 15);
            label12.TabIndex = 113;
            label12.Text = "* Campos requeridos";
            // 
            // txtEspecialidad
            // 
            txtEspecialidad.Enabled = false;
            txtEspecialidad.Location = new Point(147, 242);
            txtEspecialidad.Name = "txtEspecialidad";
            txtEspecialidad.Size = new Size(199, 23);
            txtEspecialidad.TabIndex = 112;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(12, 245);
            label10.Name = "label10";
            label10.Size = new Size(72, 15);
            label10.TabIndex = 111;
            label10.Text = "Especialidad";
            // 
            // btnCancelar
            // 
            btnCancelar.Location = new Point(256, 296);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(90, 23);
            btnCancelar.TabIndex = 110;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = true;
            btnCancelar.Click += btnCancelar_Click;
            // 
            // btnMod
            // 
            btnMod.Location = new Point(160, 296);
            btnMod.Name = "btnMod";
            btnMod.Size = new Size(90, 23);
            btnMod.TabIndex = 109;
            btnMod.Text = "Modificar";
            btnMod.UseVisualStyleBackColor = true;
            btnMod.Click += btnMod_Click;
            // 
            // dtpFechaNac
            // 
            dtpFechaNac.Enabled = false;
            dtpFechaNac.Format = DateTimePickerFormat.Short;
            dtpFechaNac.Location = new Point(147, 213);
            dtpFechaNac.Name = "dtpFechaNac";
            dtpFechaNac.Size = new Size(199, 23);
            dtpFechaNac.TabIndex = 108;
            // 
            // cmbGenero
            // 
            cmbGenero.Enabled = false;
            cmbGenero.FormattingEnabled = true;
            cmbGenero.Location = new Point(147, 184);
            cmbGenero.Name = "cmbGenero";
            cmbGenero.Size = new Size(199, 23);
            cmbGenero.TabIndex = 107;
            // 
            // txtTelefono
            // 
            txtTelefono.Location = new Point(147, 155);
            txtTelefono.Name = "txtTelefono";
            txtTelefono.Size = new Size(199, 23);
            txtTelefono.TabIndex = 106;
            // 
            // txtContraseña
            // 
            txtContraseña.Location = new Point(147, 126);
            txtContraseña.Name = "txtContraseña";
            txtContraseña.Size = new Size(199, 23);
            txtContraseña.TabIndex = 105;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(147, 97);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(199, 23);
            txtEmail.TabIndex = 104;
            // 
            // txtDni
            // 
            txtDni.Enabled = false;
            txtDni.Location = new Point(147, 68);
            txtDni.Name = "txtDni";
            txtDni.Size = new Size(199, 23);
            txtDni.TabIndex = 103;
            // 
            // txtApellidos
            // 
            txtApellidos.Enabled = false;
            txtApellidos.Location = new Point(147, 39);
            txtApellidos.Name = "txtApellidos";
            txtApellidos.Size = new Size(199, 23);
            txtApellidos.TabIndex = 102;
            // 
            // txtNombre
            // 
            txtNombre.Enabled = false;
            txtNombre.Location = new Point(147, 9);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(199, 23);
            txtNombre.TabIndex = 101;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(12, 219);
            label8.Name = "label8";
            label8.Size = new Size(103, 15);
            label8.TabIndex = 100;
            label8.Text = "Fecha Nacimiento";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(12, 187);
            label7.Name = "label7";
            label7.Size = new Size(53, 15);
            label7.TabIndex = 99;
            label7.Text = "Género *";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(12, 158);
            label6.Name = "label6";
            label6.Size = new Size(52, 15);
            label6.TabIndex = 98;
            label6.Text = "Teléfono";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(11, 129);
            label5.Name = "label5";
            label5.Size = new Size(75, 15);
            label5.TabIndex = 97;
            label5.Text = "Contraseña *";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(11, 100);
            label4.Name = "label4";
            label4.Size = new Size(49, 15);
            label4.TabIndex = 96;
            label4.Text = "E-Mail *";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 71);
            label3.Name = "label3";
            label3.Size = new Size(35, 15);
            label3.TabIndex = 95;
            label3.Text = "DNI *";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 42);
            label2.Name = "label2";
            label2.Size = new Size(64, 15);
            label2.TabIndex = 94;
            label2.Text = "Apellidos *";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(11, 12);
            label1.Name = "label1";
            label1.Size = new Size(59, 15);
            label1.TabIndex = 93;
            label1.Text = "Nombre *";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(12, 272);
            label9.Name = "label9";
            label9.Size = new Size(42, 15);
            label9.TabIndex = 115;
            label9.Text = "Estado";
            // 
            // chkActivo
            // 
            chkActivo.AutoSize = true;
            chkActivo.Location = new Point(147, 271);
            chkActivo.Name = "chkActivo";
            chkActivo.Size = new Size(76, 19);
            chkActivo.TabIndex = 114;
            chkActivo.Text = "En Activo";
            chkActivo.UseVisualStyleBackColor = true;
            // 
            // ModProfesor
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(359, 329);
            Controls.Add(label9);
            Controls.Add(chkActivo);
            Controls.Add(label12);
            Controls.Add(txtEspecialidad);
            Controls.Add(label10);
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
            Name = "ModProfesor";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "ModProfesor";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label12;
        private TextBox txtEspecialidad;
        private Label label10;
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
        private Label label9;
        private CheckBox chkActivo;
    }
}