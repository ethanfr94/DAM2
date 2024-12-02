namespace Ud2Hoja14
{
    partial class PeliculaForm
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
            btnAceptar = new Button();
            btnCancelar = new Button();
            label1 = new Label();
            txtTituloPelicula = new TextBox();
            txtGeneroPelicula = new TextBox();
            label2 = new Label();
            txtAnioPelicula = new TextBox();
            label3 = new Label();
            SuspendLayout();
            // 
            // btnAceptar
            // 
            btnAceptar.Location = new Point(215, 100);
            btnAceptar.Name = "btnAceptar";
            btnAceptar.Size = new Size(75, 23);
            btnAceptar.TabIndex = 0;
            btnAceptar.Text = "Aceptar";
            btnAceptar.UseVisualStyleBackColor = true;
            btnAceptar.Click += btnAceptar_Click;
            // 
            // btnCancelar
            // 
            btnCancelar.Location = new Point(296, 100);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(75, 23);
            btnCancelar.TabIndex = 1;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = true;
            btnCancelar.Click += btnCancelar_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(37, 15);
            label1.TabIndex = 2;
            label1.Text = "Titulo";
            // 
            // txtTituloPelicula
            // 
            txtTituloPelicula.Location = new Point(70, 6);
            txtTituloPelicula.Name = "txtTituloPelicula";
            txtTituloPelicula.Size = new Size(301, 23);
            txtTituloPelicula.TabIndex = 3;
            // 
            // txtGeneroPelicula
            // 
            txtGeneroPelicula.Location = new Point(70, 64);
            txtGeneroPelicula.Name = "txtGeneroPelicula";
            txtGeneroPelicula.Size = new Size(301, 23);
            txtGeneroPelicula.TabIndex = 5;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 67);
            label2.Name = "label2";
            label2.Size = new Size(45, 15);
            label2.TabIndex = 4;
            label2.Text = "Genero";
            // 
            // txtAnioPelicula
            // 
            txtAnioPelicula.Location = new Point(70, 35);
            txtAnioPelicula.Name = "txtAnioPelicula";
            txtAnioPelicula.Size = new Size(301, 23);
            txtAnioPelicula.TabIndex = 7;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 38);
            label3.Name = "label3";
            label3.Size = new Size(29, 15);
            label3.TabIndex = 6;
            label3.Text = "Año";
            // 
            // PeliculaForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(383, 135);
            Controls.Add(txtAnioPelicula);
            Controls.Add(label3);
            Controls.Add(txtGeneroPelicula);
            Controls.Add(label2);
            Controls.Add(txtTituloPelicula);
            Controls.Add(label1);
            Controls.Add(btnCancelar);
            Controls.Add(btnAceptar);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "PeliculaForm";
            Text = "Pelicula";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnAceptar;
        private Button btnCancelar;
        private Label label1;
        private TextBox txtTituloPelicula;
        private TextBox txtGeneroPelicula;
        private Label label2;
        private TextBox txtAnioPelicula;
        private Label label3;
    }
}