namespace ProjectStore
{
    partial class AddProfesor
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
            btnCancelar = new Button();
            btnAdd = new Button();
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
            label10 = new Label();
            txtEspecialidad = new TextBox();
            label12 = new Label();
            SuspendLayout();
            // 
            // btnCancelar
            // 
            btnCancelar.Location = new Point(263, 283);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(90, 23);
            btnCancelar.TabIndex = 58;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = true;
            btnCancelar.Click += btnCancelar_Click;
            // 
            // btnAdd
            // 
            btnAdd.Location = new Point(154, 283);
            btnAdd.Name = "btnAdd";
            btnAdd.Size = new Size(90, 23);
            btnAdd.TabIndex = 57;
            btnAdd.Text = "Añadir";
            btnAdd.UseVisualStyleBackColor = true;
            btnAdd.Click += btnAdd_Click;
            // 
            // dtpFechaNac
            // 
            dtpFechaNac.Format = DateTimePickerFormat.Short;
            dtpFechaNac.Location = new Point(154, 216);
            dtpFechaNac.Name = "dtpFechaNac";
            dtpFechaNac.Size = new Size(199, 23);
            dtpFechaNac.TabIndex = 55;
            // 
            // cmbGenero
            // 
            cmbGenero.DropDownStyle = ComboBoxStyle.DropDownList;
            cmbGenero.FormattingEnabled = true;
            cmbGenero.Location = new Point(154, 187);
            cmbGenero.Name = "cmbGenero";
            cmbGenero.Size = new Size(199, 23);
            cmbGenero.TabIndex = 54;
            // 
            // txtTelefono
            // 
            txtTelefono.Location = new Point(154, 158);
            txtTelefono.Name = "txtTelefono";
            txtTelefono.Size = new Size(199, 23);
            txtTelefono.TabIndex = 53;
            // 
            // txtContraseña
            // 
            txtContraseña.Location = new Point(154, 129);
            txtContraseña.Name = "txtContraseña";
            txtContraseña.Size = new Size(199, 23);
            txtContraseña.TabIndex = 52;
            txtContraseña.UseSystemPasswordChar = true;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(154, 100);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(199, 23);
            txtEmail.TabIndex = 51;
            // 
            // txtDni
            // 
            txtDni.Location = new Point(154, 71);
            txtDni.Name = "txtDni";
            txtDni.Size = new Size(199, 23);
            txtDni.TabIndex = 50;
            // 
            // txtApellidos
            // 
            txtApellidos.Location = new Point(154, 42);
            txtApellidos.Name = "txtApellidos";
            txtApellidos.Size = new Size(199, 23);
            txtApellidos.TabIndex = 49;
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(154, 12);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(199, 23);
            txtNombre.TabIndex = 48;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(19, 222);
            label8.Name = "label8";
            label8.Size = new Size(103, 15);
            label8.TabIndex = 46;
            label8.Text = "Fecha Nacimiento";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(19, 190);
            label7.Name = "label7";
            label7.Size = new Size(53, 15);
            label7.TabIndex = 45;
            label7.Text = "Género *";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(19, 161);
            label6.Name = "label6";
            label6.Size = new Size(52, 15);
            label6.TabIndex = 44;
            label6.Text = "Teléfono";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(18, 132);
            label5.Name = "label5";
            label5.Size = new Size(75, 15);
            label5.TabIndex = 43;
            label5.Text = "Contraseña *";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(18, 103);
            label4.Name = "label4";
            label4.Size = new Size(49, 15);
            label4.TabIndex = 42;
            label4.Text = "E-Mail *";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(19, 74);
            label3.Name = "label3";
            label3.Size = new Size(35, 15);
            label3.TabIndex = 41;
            label3.Text = "DNI *";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(19, 45);
            label2.Name = "label2";
            label2.Size = new Size(64, 15);
            label2.TabIndex = 40;
            label2.Text = "Apellidos *";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(18, 15);
            label1.Name = "label1";
            label1.Size = new Size(59, 15);
            label1.TabIndex = 39;
            label1.Text = "Nombre *";
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(19, 248);
            label10.Name = "label10";
            label10.Size = new Size(72, 15);
            label10.TabIndex = 59;
            label10.Text = "Especialidad";
            // 
            // txtEspecialidad
            // 
            txtEspecialidad.Location = new Point(154, 245);
            txtEspecialidad.Name = "txtEspecialidad";
            txtEspecialidad.Size = new Size(199, 23);
            txtEspecialidad.TabIndex = 60;
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Location = new Point(18, 287);
            label12.Name = "label12";
            label12.Size = new Size(118, 15);
            label12.TabIndex = 92;
            label12.Text = "* Campos requeridos";
            // 
            // AddProfesor
            // 
            AcceptButton = btnAdd;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            CancelButton = btnCancelar;
            ClientSize = new Size(378, 321);
            Controls.Add(label12);
            Controls.Add(txtEspecialidad);
            Controls.Add(label10);
            Controls.Add(btnCancelar);
            Controls.Add(btnAdd);
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
            MaximizeBox = false;
            Name = "AddProfesor";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Añadir Profesor";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnCancelar;
        private Button btnAdd;
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
        private Label label10;
        private TextBox txtEspecialidad;
        private Label label12;
    }
}