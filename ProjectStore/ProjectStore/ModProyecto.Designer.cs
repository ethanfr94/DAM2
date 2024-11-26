namespace ProjectStore
{
    partial class ModProyecto
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
            btnCancelar = new Button();
            btnMod = new Button();
            txtResumen = new TextBox();
            cmbTutor = new ComboBox();
            label11 = new Label();
            cmbCiclo = new ComboBox();
            txtArchivos = new TextBox();
            label9 = new Label();
            nudAnioAcademico = new NumericUpDown();
            txtMemoria = new TextBox();
            cmbTipo = new ComboBox();
            label2 = new Label();
            txtComentarios = new TextBox();
            label10 = new Label();
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
            ((System.ComponentModel.ISupportInitialize)nudAnioAcademico).BeginInit();
            SuspendLayout();
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Location = new Point(15, 338);
            label12.Name = "label12";
            label12.Size = new Size(118, 15);
            label12.TabIndex = 136;
            label12.Text = "* Campos requeridos";
            // 
            // btnCancelar
            // 
            btnCancelar.Location = new Point(259, 334);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(90, 23);
            btnCancelar.TabIndex = 133;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = true;
            btnCancelar.Click += btnCancelar_Click;
            // 
            // btnMod
            // 
            btnMod.Location = new Point(163, 334);
            btnMod.Name = "btnMod";
            btnMod.Size = new Size(90, 23);
            btnMod.TabIndex = 132;
            btnMod.Text = "Modificar";
            btnMod.UseVisualStyleBackColor = true;
            btnMod.Click += btnMod_Click;
            // 
            // txtResumen
            // 
            txtResumen.Location = new Point(151, 70);
            txtResumen.Name = "txtResumen";
            txtResumen.Size = new Size(200, 23);
            txtResumen.TabIndex = 158;
            // 
            // cmbTutor
            // 
            cmbTutor.FormattingEnabled = true;
            cmbTutor.Location = new Point(151, 303);
            cmbTutor.Name = "cmbTutor";
            cmbTutor.Size = new Size(200, 23);
            cmbTutor.TabIndex = 157;
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Location = new Point(15, 306);
            label11.Name = "label11";
            label11.Size = new Size(35, 15);
            label11.TabIndex = 156;
            label11.Text = "Tutor";
            // 
            // cmbCiclo
            // 
            cmbCiclo.Enabled = false;
            cmbCiclo.FormattingEnabled = true;
            cmbCiclo.Location = new Point(151, 273);
            cmbCiclo.Name = "cmbCiclo";
            cmbCiclo.Size = new Size(200, 23);
            cmbCiclo.TabIndex = 155;
            // 
            // txtArchivos
            // 
            txtArchivos.Enabled = false;
            txtArchivos.Location = new Point(151, 215);
            txtArchivos.Name = "txtArchivos";
            txtArchivos.Size = new Size(200, 23);
            txtArchivos.TabIndex = 154;
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(15, 218);
            label9.Name = "label9";
            label9.Size = new Size(53, 15);
            label9.TabIndex = 153;
            label9.Text = "Archivos";
            // 
            // nudAnioAcademico
            // 
            nudAnioAcademico.Enabled = false;
            nudAnioAcademico.Location = new Point(151, 99);
            nudAnioAcademico.Maximum = new decimal(new int[] { 9999, 0, 0, 0 });
            nudAnioAcademico.Minimum = new decimal(new int[] { 2023, 0, 0, 0 });
            nudAnioAcademico.Name = "nudAnioAcademico";
            nudAnioAcademico.Size = new Size(200, 23);
            nudAnioAcademico.TabIndex = 152;
            nudAnioAcademico.Value = new decimal(new int[] { 2024, 0, 0, 0 });
            // 
            // txtMemoria
            // 
            txtMemoria.Enabled = false;
            txtMemoria.Location = new Point(151, 186);
            txtMemoria.Name = "txtMemoria";
            txtMemoria.Size = new Size(200, 23);
            txtMemoria.TabIndex = 151;
            // 
            // cmbTipo
            // 
            cmbTipo.Enabled = false;
            cmbTipo.FormattingEnabled = true;
            cmbTipo.Location = new Point(151, 41);
            cmbTipo.Name = "cmbTipo";
            cmbTipo.Size = new Size(200, 23);
            cmbTipo.TabIndex = 150;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(15, 44);
            label2.Name = "label2";
            label2.Size = new Size(38, 15);
            label2.TabIndex = 149;
            label2.Text = "Tipo *";
            // 
            // txtComentarios
            // 
            txtComentarios.Location = new Point(151, 244);
            txtComentarios.Name = "txtComentarios";
            txtComentarios.Size = new Size(200, 23);
            txtComentarios.TabIndex = 148;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(15, 247);
            label10.Name = "label10";
            label10.Size = new Size(75, 15);
            label10.TabIndex = 147;
            label10.Text = "Comentarios";
            // 
            // dtpFechaPres
            // 
            dtpFechaPres.Format = DateTimePickerFormat.Short;
            dtpFechaPres.Location = new Point(151, 128);
            dtpFechaPres.Name = "dtpFechaPres";
            dtpFechaPres.Size = new Size(200, 23);
            dtpFechaPres.TabIndex = 146;
            // 
            // txtLogo
            // 
            txtLogo.Enabled = false;
            txtLogo.Location = new Point(151, 157);
            txtLogo.Name = "txtLogo";
            txtLogo.Size = new Size(200, 23);
            txtLogo.TabIndex = 145;
            // 
            // txtNombre
            // 
            txtNombre.Enabled = false;
            txtNombre.Location = new Point(151, 12);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(200, 23);
            txtNombre.TabIndex = 144;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(15, 134);
            label8.Name = "label8";
            label8.Size = new Size(117, 15);
            label8.TabIndex = 143;
            label8.Text = "Fecha Presentación *";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(15, 189);
            label7.Name = "label7";
            label7.Size = new Size(55, 15);
            label7.TabIndex = 142;
            label7.Text = "Memoria";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(15, 160);
            label6.Name = "label6";
            label6.Size = new Size(34, 15);
            label6.TabIndex = 141;
            label6.Text = "Logo";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(15, 276);
            label5.Name = "label5";
            label5.Size = new Size(42, 15);
            label5.TabIndex = 140;
            label5.Text = "Ciclo *";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(15, 101);
            label4.Name = "label4";
            label4.Size = new Size(100, 15);
            label4.TabIndex = 139;
            label4.Text = "Año Académico *";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(15, 73);
            label3.Name = "label3";
            label3.Size = new Size(56, 15);
            label3.TabIndex = 138;
            label3.Text = "Resumen";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(15, 15);
            label1.Name = "label1";
            label1.Size = new Size(59, 15);
            label1.TabIndex = 137;
            label1.Text = "Nombre *";
            // 
            // ModProyecto
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(365, 366);
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
            Controls.Add(label12);
            Controls.Add(btnCancelar);
            Controls.Add(btnMod);
            Name = "ModProyecto";
            Text = "ModProyecto";
            ((System.ComponentModel.ISupportInitialize)nudAnioAcademico).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label12;
        private Button btnCancelar;
        private Button btnMod;
        private TextBox txtResumen;
        private ComboBox cmbTutor;
        private Label label11;
        private ComboBox cmbCiclo;
        private TextBox txtArchivos;
        private Label label9;
        private NumericUpDown nudAnioAcademico;
        private TextBox txtMemoria;
        private ComboBox cmbTipo;
        private Label label2;
        private TextBox txtComentarios;
        private Label label10;
        private DateTimePicker dtpFechaPres;
        private TextBox txtLogo;
        private TextBox txtNombre;
        private Label label8;
        private Label label7;
        private Label label6;
        private Label label5;
        private Label label4;
        private Label label3;
        private Label label1;
    }
}