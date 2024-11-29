namespace minireto
{
    partial class VerProyecto
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(VerProyecto));
            txtResumen = new TextBox();
            pictureBox1 = new PictureBox();
            lbl_resumen = new Label();
            lbl_autor = new Label();
            lbl_profesor = new Label();
            lbl_curso = new Label();
            txtEvaluan = new TextBox();
            lbl_evaluado = new Label();
            lbl_ano = new Label();
            txt_profesor = new TextBox();
            txtAutor = new TextBox();
            lblNombre = new Label();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // txtResumen
            // 
            txtResumen.Enabled = false;
            txtResumen.Location = new Point(12, 341);
            txtResumen.Multiline = true;
            txtResumen.Name = "txtResumen";
            txtResumen.Size = new Size(328, 122);
            txtResumen.TabIndex = 3;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(269, 21);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(71, 63);
            pictureBox1.TabIndex = 5;
            pictureBox1.TabStop = false;
            // 
            // lbl_resumen
            // 
            lbl_resumen.AutoSize = true;
            lbl_resumen.Location = new Point(12, 320);
            lbl_resumen.Name = "lbl_resumen";
            lbl_resumen.Size = new Size(125, 15);
            lbl_resumen.TabIndex = 6;
            lbl_resumen.Text = "Resumen del proyecto";
            // 
            // lbl_autor
            // 
            lbl_autor.AutoSize = true;
            lbl_autor.Location = new Point(12, 76);
            lbl_autor.Name = "lbl_autor";
            lbl_autor.Size = new Size(53, 15);
            lbl_autor.TabIndex = 8;
            lbl_autor.Text = "Autor/es";
            // 
            // lbl_profesor
            // 
            lbl_profesor.AutoSize = true;
            lbl_profesor.Location = new Point(12, 172);
            lbl_profesor.Name = "lbl_profesor";
            lbl_profesor.Size = new Size(35, 15);
            lbl_profesor.TabIndex = 9;
            lbl_profesor.Text = "Tutor";
            // 
            // lbl_curso
            // 
            lbl_curso.AutoSize = true;
            lbl_curso.Location = new Point(12, 51);
            lbl_curso.Name = "lbl_curso";
            lbl_curso.Size = new Size(41, 15);
            lbl_curso.TabIndex = 12;
            lbl_curso.Text = "Curso:";
            // 
            // txtEvaluan
            // 
            txtEvaluan.Enabled = false;
            txtEvaluan.Location = new Point(12, 243);
            txtEvaluan.Multiline = true;
            txtEvaluan.Name = "txtEvaluan";
            txtEvaluan.Size = new Size(328, 60);
            txtEvaluan.TabIndex = 14;
            // 
            // lbl_evaluado
            // 
            lbl_evaluado.AutoSize = true;
            lbl_evaluado.Location = new Point(12, 225);
            lbl_evaluado.Name = "lbl_evaluado";
            lbl_evaluado.Size = new Size(79, 15);
            lbl_evaluado.TabIndex = 15;
            lbl_evaluado.Text = "Evaluado por:";
            // 
            // lbl_ano
            // 
            lbl_ano.AutoSize = true;
            lbl_ano.Location = new Point(12, 36);
            lbl_ano.Name = "lbl_ano";
            lbl_ano.Size = new Size(90, 15);
            lbl_ano.TabIndex = 16;
            lbl_ano.Text = "Año academico";
            // 
            // txt_profesor
            // 
            txt_profesor.Enabled = false;
            txt_profesor.Location = new Point(12, 190);
            txt_profesor.Name = "txt_profesor";
            txt_profesor.Size = new Size(328, 23);
            txt_profesor.TabIndex = 11;
            // 
            // txtAutor
            // 
            txtAutor.Enabled = false;
            txtAutor.Location = new Point(12, 102);
            txtAutor.Multiline = true;
            txtAutor.Name = "txtAutor";
            txtAutor.Size = new Size(328, 60);
            txtAutor.TabIndex = 17;
            // 
            // lblNombre
            // 
            lblNombre.AutoSize = true;
            lblNombre.Location = new Point(12, 9);
            lblNombre.Name = "lblNombre";
            lblNombre.Size = new Size(37, 15);
            lblNombre.TabIndex = 18;
            lblNombre.Text = "Titulo";
            // 
            // VerProyecto
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(352, 479);
            Controls.Add(lblNombre);
            Controls.Add(txtAutor);
            Controls.Add(lbl_ano);
            Controls.Add(lbl_evaluado);
            Controls.Add(txtEvaluan);
            Controls.Add(lbl_curso);
            Controls.Add(txt_profesor);
            Controls.Add(lbl_profesor);
            Controls.Add(lbl_autor);
            Controls.Add(lbl_resumen);
            Controls.Add(pictureBox1);
            Controls.Add(txtResumen);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Icon = (Icon)resources.GetObject("$this.Icon");
            MaximizeBox = false;
            Name = "VerProyecto";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Visualizador de proyectos";
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private TextBox txtResumen;
        private PictureBox pictureBox1;
        private Label lbl_resumen;
        private Label lbl_autor;
        private Label lbl_profesor;
        private Label lbl_curso;
        private TextBox txtEvaluan;
        private Label lbl_evaluado;
        private Label lbl_ano;
        private TextBox txt_profesor;
        private TextBox txtAutor;
        private Label lblNombre;
    }
}
