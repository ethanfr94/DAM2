namespace minireto
{
    partial class Proyectoindividual
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
            btn_borrar = new Button();
            btn_editar = new Button();
            btn_subir = new Button();
            textBox1 = new TextBox();
            pictureBox1 = new PictureBox();
            lbl_resumen = new Label();
            lbl_logo = new Label();
            lbl_autor = new Label();
            lbl_profesor = new Label();
            txt_autor = new TextBox();
            txt_profesor = new TextBox();
            lbl_curso = new Label();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            lbl_evaluado = new Label();
            lbl_ano = new Label();
            txt_ano = new TextBox();
            menuStrip1 = new MenuStrip();
            proyectoToolStripMenuItem = new ToolStripMenuItem();
            descargarToolStripMenuItem = new ToolStripMenuItem();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // btn_borrar
            // 
            btn_borrar.Location = new Point(601, 377);
            btn_borrar.Name = "btn_borrar";
            btn_borrar.Size = new Size(75, 23);
            btn_borrar.TabIndex = 0;
            btn_borrar.Text = "Borrar";
            btn_borrar.UseVisualStyleBackColor = true;
            // 
            // btn_editar
            // 
            btn_editar.Location = new Point(495, 377);
            btn_editar.Name = "btn_editar";
            btn_editar.Size = new Size(75, 23);
            btn_editar.TabIndex = 1;
            btn_editar.Text = "Editar";
            btn_editar.UseVisualStyleBackColor = true;
            // 
            // btn_subir
            // 
            btn_subir.Location = new Point(390, 377);
            btn_subir.Name = "btn_subir";
            btn_subir.Size = new Size(75, 23);
            btn_subir.TabIndex = 2;
            btn_subir.Text = "Subir";
            btn_subir.UseVisualStyleBackColor = true;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(12, 185);
            textBox1.Multiline = true;
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(335, 215);
            textBox1.TabIndex = 3;
            // 
            // pictureBox1
            // 
            pictureBox1.Location = new Point(27, 51);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(140, 78);
            pictureBox1.TabIndex = 5;
            pictureBox1.TabStop = false;
            // 
            // lbl_resumen
            // 
            lbl_resumen.AutoSize = true;
            lbl_resumen.Location = new Point(12, 156);
            lbl_resumen.Name = "lbl_resumen";
            lbl_resumen.Size = new Size(125, 15);
            lbl_resumen.TabIndex = 6;
            lbl_resumen.Text = "Resumen del proyecto";
            // 
            // lbl_logo
            // 
            lbl_logo.AutoSize = true;
            lbl_logo.Location = new Point(12, 24);
            lbl_logo.Name = "lbl_logo";
            lbl_logo.Size = new Size(136, 15);
            lbl_logo.TabIndex = 7;
            lbl_logo.Text = "Logo del proyecto/titulo";
            // 
            // lbl_autor
            // 
            lbl_autor.AutoSize = true;
            lbl_autor.Location = new Point(386, 67);
            lbl_autor.Name = "lbl_autor";
            lbl_autor.Size = new Size(109, 15);
            lbl_autor.TabIndex = 8;
            lbl_autor.Text = "Autor del proyecto:";
            // 
            // lbl_profesor
            // 
            lbl_profesor.AutoSize = true;
            lbl_profesor.Location = new Point(386, 121);
            lbl_profesor.Name = "lbl_profesor";
            lbl_profesor.Size = new Size(96, 15);
            lbl_profesor.TabIndex = 9;
            lbl_profesor.Text = "Profesor a cargo:";
            // 
            // txt_autor
            // 
            txt_autor.Location = new Point(533, 64);
            txt_autor.Name = "txt_autor";
            txt_autor.Size = new Size(155, 23);
            txt_autor.TabIndex = 10;
            // 
            // txt_profesor
            // 
            txt_profesor.Location = new Point(533, 118);
            txt_profesor.Name = "txt_profesor";
            txt_profesor.Size = new Size(155, 23);
            txt_profesor.TabIndex = 11;
            // 
            // lbl_curso
            // 
            lbl_curso.AutoSize = true;
            lbl_curso.Location = new Point(390, 168);
            lbl_curso.Name = "lbl_curso";
            lbl_curso.Size = new Size(41, 15);
            lbl_curso.TabIndex = 12;
            lbl_curso.Text = "Curso:";
            // 
            // textBox2
            // 
            textBox2.Location = new Point(533, 165);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(155, 23);
            textBox2.TabIndex = 13;
            // 
            // textBox3
            // 
            textBox3.Location = new Point(533, 261);
            textBox3.Multiline = true;
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(155, 52);
            textBox3.TabIndex = 14;
            // 
            // lbl_evaluado
            // 
            lbl_evaluado.AutoSize = true;
            lbl_evaluado.Location = new Point(386, 261);
            lbl_evaluado.Name = "lbl_evaluado";
            lbl_evaluado.Size = new Size(79, 15);
            lbl_evaluado.TabIndex = 15;
            lbl_evaluado.Text = "Evaluado por:";
            // 
            // lbl_ano
            // 
            lbl_ano.AutoSize = true;
            lbl_ano.Location = new Point(386, 215);
            lbl_ano.Name = "lbl_ano";
            lbl_ano.Size = new Size(90, 15);
            lbl_ano.TabIndex = 16;
            lbl_ano.Text = "Año academico";
            // 
            // txt_ano
            // 
            txt_ano.Location = new Point(533, 212);
            txt_ano.Name = "txt_ano";
            txt_ano.Size = new Size(155, 23);
            txt_ano.TabIndex = 17;
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { proyectoToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(712, 24);
            menuStrip1.TabIndex = 18;
            menuStrip1.Text = "menuStrip1";
            // 
            // proyectoToolStripMenuItem
            // 
            proyectoToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { descargarToolStripMenuItem });
            proyectoToolStripMenuItem.Name = "proyectoToolStripMenuItem";
            proyectoToolStripMenuItem.Size = new Size(66, 20);
            proyectoToolStripMenuItem.Text = "Proyecto";
            // 
            // descargarToolStripMenuItem
            // 
            descargarToolStripMenuItem.Name = "descargarToolStripMenuItem";
            descargarToolStripMenuItem.Size = new Size(180, 22);
            descargarToolStripMenuItem.Text = "Descargar";
            // 
            // Proyectoindividual
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(712, 430);
            Controls.Add(txt_ano);
            Controls.Add(lbl_ano);
            Controls.Add(lbl_evaluado);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(lbl_curso);
            Controls.Add(txt_profesor);
            Controls.Add(txt_autor);
            Controls.Add(lbl_profesor);
            Controls.Add(lbl_autor);
            Controls.Add(lbl_logo);
            Controls.Add(lbl_resumen);
            Controls.Add(pictureBox1);
            Controls.Add(textBox1);
            Controls.Add(btn_subir);
            Controls.Add(btn_editar);
            Controls.Add(btn_borrar);
            Controls.Add(menuStrip1);
            MainMenuStrip = menuStrip1;
            Name = "Proyectoindividual";
            Text = "Proyecto individual";

            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btn_borrar;
        private Button btn_editar;
        private Button btn_subir;
        private TextBox textBox1;
        private PictureBox pictureBox1;
        private Label lbl_resumen;
        private Label lbl_logo;
        private Label lbl_autor;
        private Label lbl_profesor;
        private TextBox txt_autor;
        private TextBox txt_profesor;
        private Label lbl_curso;
        private TextBox textBox2;
        private TextBox textBox3;
        private Label lbl_evaluado;
        private Label lbl_ano;
        private TextBox txt_ano;
        private MenuStrip menuStrip1;
        private ToolStripMenuItem proyectoToolStripMenuItem;
        private ToolStripMenuItem descargarToolStripMenuItem;
    }
}
