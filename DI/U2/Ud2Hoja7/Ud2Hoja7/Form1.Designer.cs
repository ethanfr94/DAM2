namespace Ud2Hoja7
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
            dtpFecha = new DateTimePicker();
            label3 = new Label();
            rdoMasculino = new RadioButton();
            rdoFemenino = new RadioButton();
            rdoOtros = new RadioButton();
            label4 = new Label();
            cmbSituacion = new ComboBox();
            groupBox1 = new GroupBox();
            txtOtros = new TextBox();
            chkOtro = new CheckBox();
            chkLectura = new CheckBox();
            chkMusica = new CheckBox();
            chkDeporte = new CheckBox();
            btnReiniciar = new Button();
            btnAceptar = new Button();
            txtNombre = new TextBox();
            groupBox1.SuspendLayout();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(24, 43);
            label1.Name = "label1";
            label1.Size = new Size(51, 15);
            label1.TabIndex = 0;
            label1.Text = "Nombre";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(24, 101);
            label2.Name = "label2";
            label2.Size = new Size(69, 15);
            label2.TabIndex = 1;
            label2.Text = "Nacimiento";
            // 
            // dtpFecha
            // 
            dtpFecha.Format = DateTimePickerFormat.Short;
            dtpFecha.Location = new Point(136, 95);
            dtpFecha.Name = "dtpFecha";
            dtpFecha.Size = new Size(278, 23);
            dtpFecha.TabIndex = 2;
            dtpFecha.Value = new DateTime(2006, 12, 31, 0, 0, 0, 0);
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(24, 157);
            label3.Name = "label3";
            label3.Size = new Size(45, 15);
            label3.TabIndex = 3;
            label3.Text = "Genero";
            // 
            // rdoMasculino
            // 
            rdoMasculino.AutoSize = true;
            rdoMasculino.Checked = true;
            rdoMasculino.Location = new Point(136, 158);
            rdoMasculino.Name = "rdoMasculino";
            rdoMasculino.Size = new Size(80, 19);
            rdoMasculino.TabIndex = 4;
            rdoMasculino.TabStop = true;
            rdoMasculino.Text = "Masculino";
            rdoMasculino.UseVisualStyleBackColor = true;
            rdoMasculino.CheckedChanged += radioButton1_CheckedChanged;
            // 
            // rdoFemenino
            // 
            rdoFemenino.AutoSize = true;
            rdoFemenino.Location = new Point(222, 158);
            rdoFemenino.Name = "rdoFemenino";
            rdoFemenino.Size = new Size(78, 19);
            rdoFemenino.TabIndex = 5;
            rdoFemenino.Text = "Femenino";
            rdoFemenino.UseVisualStyleBackColor = true;
            // 
            // rdoOtros
            // 
            rdoOtros.AutoSize = true;
            rdoOtros.Location = new Point(306, 158);
            rdoOtros.Name = "rdoOtros";
            rdoOtros.Size = new Size(54, 19);
            rdoOtros.TabIndex = 6;
            rdoOtros.Text = "Otros";
            rdoOtros.UseVisualStyleBackColor = true;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(24, 424);
            label4.Name = "label4";
            label4.Size = new Size(56, 15);
            label4.TabIndex = 7;
            label4.Text = "Situacion";
            // 
            // cmbSituacion
            // 
            cmbSituacion.FormattingEnabled = true;
            cmbSituacion.Items.AddRange(new object[] { "Becario", "Empleado", "Excedencia", "Jubilado" });
            cmbSituacion.Location = new Point(136, 421);
            cmbSituacion.Name = "cmbSituacion";
            cmbSituacion.Size = new Size(164, 23);
            cmbSituacion.TabIndex = 8;
            // 
            // groupBox1
            // 
            groupBox1.Controls.Add(txtOtros);
            groupBox1.Controls.Add(chkOtro);
            groupBox1.Controls.Add(chkLectura);
            groupBox1.Controls.Add(chkMusica);
            groupBox1.Controls.Add(chkDeporte);
            groupBox1.Location = new Point(12, 207);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(402, 187);
            groupBox1.TabIndex = 9;
            groupBox1.TabStop = false;
            groupBox1.Text = "Aficiones";
            // 
            // txtOtros
            // 
            txtOtros.Enabled = false;
            txtOtros.Location = new Point(6, 72);
            txtOtros.Multiline = true;
            txtOtros.Name = "txtOtros";
            txtOtros.Size = new Size(390, 109);
            txtOtros.TabIndex = 13;
            // 
            // chkOtro
            // 
            chkOtro.AutoSize = true;
            chkOtro.Location = new Point(279, 32);
            chkOtro.Name = "chkOtro";
            chkOtro.Size = new Size(55, 19);
            chkOtro.TabIndex = 3;
            chkOtro.Text = "Otros";
            chkOtro.UseVisualStyleBackColor = true;
            chkOtro.CheckedChanged += chkOtro_CheckedChanged;
            // 
            // chkLectura
            // 
            chkLectura.AutoSize = true;
            chkLectura.Location = new Point(190, 32);
            chkLectura.Name = "chkLectura";
            chkLectura.Size = new Size(65, 19);
            chkLectura.TabIndex = 2;
            chkLectura.Text = "Lectura";
            chkLectura.UseVisualStyleBackColor = true;
            // 
            // chkMusica
            // 
            chkMusica.AutoSize = true;
            chkMusica.Location = new Point(101, 32);
            chkMusica.Name = "chkMusica";
            chkMusica.Size = new Size(64, 19);
            chkMusica.TabIndex = 1;
            chkMusica.Text = "Musica";
            chkMusica.UseVisualStyleBackColor = true;
            // 
            // chkDeporte
            // 
            chkDeporte.AutoSize = true;
            chkDeporte.Location = new Point(12, 32);
            chkDeporte.Name = "chkDeporte";
            chkDeporte.Size = new Size(73, 19);
            chkDeporte.TabIndex = 0;
            chkDeporte.Text = "Deportes";
            chkDeporte.UseVisualStyleBackColor = true;
            // 
            // btnReiniciar
            // 
            btnReiniciar.Location = new Point(237, 472);
            btnReiniciar.Name = "btnReiniciar";
            btnReiniciar.Size = new Size(75, 23);
            btnReiniciar.TabIndex = 10;
            btnReiniciar.Text = "Reiniciar";
            btnReiniciar.UseVisualStyleBackColor = true;
            btnReiniciar.Click += btnReiniciar_Click;
            // 
            // btnAceptar
            // 
            btnAceptar.Location = new Point(339, 472);
            btnAceptar.Name = "btnAceptar";
            btnAceptar.Size = new Size(75, 23);
            btnAceptar.TabIndex = 11;
            btnAceptar.Text = "Aceptar";
            btnAceptar.UseVisualStyleBackColor = true;
            btnAceptar.Click += btnAceptar_Click;
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(136, 40);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(278, 23);
            txtNombre.TabIndex = 12;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(428, 513);
            Controls.Add(txtNombre);
            Controls.Add(btnAceptar);
            Controls.Add(btnReiniciar);
            Controls.Add(groupBox1);
            Controls.Add(cmbSituacion);
            Controls.Add(label4);
            Controls.Add(rdoOtros);
            Controls.Add(rdoFemenino);
            Controls.Add(rdoMasculino);
            Controls.Add(label3);
            Controls.Add(dtpFecha);
            Controls.Add(label2);
            Controls.Add(label1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Ficha Socio";
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private DateTimePicker dtpFecha;
        private Label label3;
        private RadioButton rdoMasculino;
        private RadioButton rdoFemenino;
        private RadioButton rdoOtros;
        private Label label4;
        private ComboBox cmbSituacion;
        private GroupBox groupBox1;
        private CheckBox chkOtro;
        private CheckBox chkLectura;
        private CheckBox chkMusica;
        private CheckBox chkDeporte;
        private Button btnReiniciar;
        private Button btnAceptar;
        private TextBox txtNombre;
        private TextBox txtOtros;
    }
}
