namespace ProjectStore
{
    partial class AddProyecto
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
            txtComentarios = new TextBox();
            label10 = new Label();
            btnCancelar = new Button();
            btnAdd = new Button();
            dtpFechaPres = new DateTimePicker();
            txtLogo = new TextBox();
            txtNombre = new TextBox();
            label8 = new Label();
            label7 = new Label();
            label6 = new Label();
            label5 = new Label();
            label4 = new Label();
            label3 = new Label();
            label1 = new Label();
            cmbTipo = new ComboBox();
            label2 = new Label();
            txtMemoria = new TextBox();
            txtArchivos = new TextBox();
            label9 = new Label();
            cmbCiclo = new ComboBox();
            label11 = new Label();
            cmbTutor = new ComboBox();
            txtResumen = new TextBox();
            label12 = new Label();
            nudAnioAcademico = new NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)nudAnioAcademico).BeginInit();
            SuspendLayout();
            // 
            // txtComentarios
            // 
            txtComentarios.Location = new Point(154, 244);
            txtComentarios.Name = "txtComentarios";
            txtComentarios.Size = new Size(200, 23);
            txtComentarios.TabIndex = 80;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(18, 247);
            label10.Name = "label10";
            label10.Size = new Size(75, 15);
            label10.TabIndex = 79;
            label10.Text = "Comentarios";
            // 
            // btnCancelar
            // 
            btnCancelar.Location = new Point(264, 344);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(90, 23);
            btnCancelar.TabIndex = 78;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = true;
            btnCancelar.Click += btnCancelar_Click;
            // 
            // btnAdd
            // 
            btnAdd.Location = new Point(154, 344);
            btnAdd.Name = "btnAdd";
            btnAdd.Size = new Size(90, 23);
            btnAdd.TabIndex = 77;
            btnAdd.Text = "Añadir";
            btnAdd.UseVisualStyleBackColor = true;
            btnAdd.Click += btnAdd_Click;
            // 
            // dtpFechaPres
            // 
            dtpFechaPres.Format = DateTimePickerFormat.Short;
            dtpFechaPres.Location = new Point(154, 128);
            dtpFechaPres.Name = "dtpFechaPres";
            dtpFechaPres.Size = new Size(200, 23);
            dtpFechaPres.TabIndex = 76;
            // 
            // txtLogo
            // 
            txtLogo.Location = new Point(154, 157);
            txtLogo.Name = "txtLogo";
            txtLogo.Size = new Size(200, 23);
            txtLogo.TabIndex = 74;
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(154, 12);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(200, 23);
            txtNombre.TabIndex = 69;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(18, 134);
            label8.Name = "label8";
            label8.Size = new Size(117, 15);
            label8.TabIndex = 68;
            label8.Text = "Fecha Presentación *";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(18, 189);
            label7.Name = "label7";
            label7.Size = new Size(55, 15);
            label7.TabIndex = 67;
            label7.Text = "Memoria";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(18, 160);
            label6.Name = "label6";
            label6.Size = new Size(34, 15);
            label6.TabIndex = 66;
            label6.Text = "Logo";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(18, 276);
            label5.Name = "label5";
            label5.Size = new Size(42, 15);
            label5.TabIndex = 65;
            label5.Text = "Ciclo *";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(18, 101);
            label4.Name = "label4";
            label4.Size = new Size(100, 15);
            label4.TabIndex = 64;
            label4.Text = "Año Académico *";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(18, 73);
            label3.Name = "label3";
            label3.Size = new Size(56, 15);
            label3.TabIndex = 63;
            label3.Text = "Resumen";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(18, 15);
            label1.Name = "label1";
            label1.Size = new Size(59, 15);
            label1.TabIndex = 61;
            label1.Text = "Nombre *";
            // 
            // cmbTipo
            // 
            cmbTipo.FormattingEnabled = true;
            cmbTipo.Location = new Point(154, 41);
            cmbTipo.Name = "cmbTipo";
            cmbTipo.Size = new Size(200, 23);
            cmbTipo.TabIndex = 82;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(18, 44);
            label2.Name = "label2";
            label2.Size = new Size(38, 15);
            label2.TabIndex = 81;
            label2.Text = "Tipo *";
            // 
            // txtMemoria
            // 
            txtMemoria.Location = new Point(154, 186);
            txtMemoria.Name = "txtMemoria";
            txtMemoria.Size = new Size(200, 23);
            txtMemoria.TabIndex = 83;
            // 
            // txtArchivos
            // 
            txtArchivos.Location = new Point(154, 215);
            txtArchivos.Name = "txtArchivos";
            txtArchivos.Size = new Size(200, 23);
            txtArchivos.TabIndex = 86;
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(18, 218);
            label9.Name = "label9";
            label9.Size = new Size(53, 15);
            label9.TabIndex = 85;
            label9.Text = "Archivos";
            // 
            // cmbCiclo
            // 
            cmbCiclo.DropDownStyle = ComboBoxStyle.DropDownList;
            cmbCiclo.FormattingEnabled = true;
            cmbCiclo.Location = new Point(154, 273);
            cmbCiclo.Name = "cmbCiclo";
            cmbCiclo.Size = new Size(200, 23);
            cmbCiclo.TabIndex = 87;
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Location = new Point(18, 306);
            label11.Name = "label11";
            label11.Size = new Size(35, 15);
            label11.TabIndex = 88;
            label11.Text = "Tutor";
            // 
            // cmbTutor
            // 
            cmbTutor.DropDownStyle = ComboBoxStyle.DropDownList;
            cmbTutor.FormattingEnabled = true;
            cmbTutor.Location = new Point(154, 303);
            cmbTutor.Name = "cmbTutor";
            cmbTutor.Size = new Size(200, 23);
            cmbTutor.TabIndex = 89;
            // 
            // txtResumen
            // 
            txtResumen.Location = new Point(154, 70);
            txtResumen.Name = "txtResumen";
            txtResumen.Size = new Size(200, 23);
            txtResumen.TabIndex = 90;
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Location = new Point(18, 348);
            label12.Name = "label12";
            label12.Size = new Size(118, 15);
            label12.TabIndex = 91;
            label12.Text = "* Campos requeridos";
            // 
            // nudAnioAcademico
            // 
            nudAnioAcademico.Location = new Point(154, 99);
            nudAnioAcademico.Maximum = new decimal(new int[] { 9999, 0, 0, 0 });
            nudAnioAcademico.Minimum = new decimal(new int[] { 2023, 0, 0, 0 });
            nudAnioAcademico.Name = "nudAnioAcademico";
            nudAnioAcademico.Size = new Size(200, 23);
            nudAnioAcademico.TabIndex = 84;
            nudAnioAcademico.Value = new decimal(new int[] { 2024, 0, 0, 0 });
            // 
            // AddProyecto
            // 
            AcceptButton = btnAdd;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            CancelButton = btnCancelar;
            ClientSize = new Size(378, 383);
            Controls.Add(label12);
            Controls.Add(txtResumen);
            Controls.Add(cmbTutor);
            Controls.Add(label11);
            Controls.Add(cmbCiclo);
            Controls.Add(txtArchivos);
            Controls.Add(label9);
            Controls.Add(nudAnioAcademico);
            Controls.Add(txtMemoria);
            Controls.Add(cmbTipo);
            Controls.Add(label2);
            Controls.Add(txtComentarios);
            Controls.Add(label10);
            Controls.Add(btnCancelar);
            Controls.Add(btnAdd);
            Controls.Add(dtpFechaPres);
            Controls.Add(txtLogo);
            Controls.Add(txtNombre);
            Controls.Add(label8);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            Name = "AddProyecto";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Añadir Proyecto";
            ((System.ComponentModel.ISupportInitialize)nudAnioAcademico).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtComentarios;
        private Label label10;
        private Button btnCancelar;
        private Button btnAdd;
        private DateTimePicker dtpFechaPres;
        private TextBox txtLogo;
        private TextBox txtEmail;
        private TextBox txtDni;
        private TextBox txtNombre;
        private Label label8;
        private Label label7;
        private Label label6;
        private Label label5;
        private Label label4;
        private Label label3;
        private Label label1;
        private ComboBox cmbTipo;
        private Label label2;
        private TextBox txtMemoria;
        private TextBox txtArchivos;
        private Label label9;
        private ComboBox cmbCiclo;
        private Label label11;
        private ComboBox cmbTutor;
        private TextBox txtResumen;
        private Label label12;
        private NumericUpDown nudAnioAcademico;
    }
}