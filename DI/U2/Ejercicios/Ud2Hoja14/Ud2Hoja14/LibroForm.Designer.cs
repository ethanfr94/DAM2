namespace Ud2Hoja14
{
    partial class LibroForm
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
            btnCancel = new Button();
            btnAceptarLibro = new Button();
            txtTituloLibro = new TextBox();
            txtAutorLibro = new TextBox();
            txtAnioLibro = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            SuspendLayout();
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(294, 99);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(75, 23);
            btnCancel.TabIndex = 0;
            btnCancel.Text = "Cancelar";
            btnCancel.UseVisualStyleBackColor = true;
            btnCancel.Click += btnCancel_Click;
            // 
            // btnAceptarLibro
            // 
            btnAceptarLibro.Location = new Point(207, 99);
            btnAceptarLibro.Name = "btnAceptarLibro";
            btnAceptarLibro.Size = new Size(75, 23);
            btnAceptarLibro.TabIndex = 1;
            btnAceptarLibro.Text = "Aceptar";
            btnAceptarLibro.UseVisualStyleBackColor = true;
            btnAceptarLibro.Click += btnAceptar_Click;
            // 
            // txtTituloLibro
            // 
            txtTituloLibro.Location = new Point(55, 12);
            txtTituloLibro.Name = "txtTituloLibro";
            txtTituloLibro.Size = new Size(314, 23);
            txtTituloLibro.TabIndex = 2;
            // 
            // txtAutorLibro
            // 
            txtAutorLibro.Location = new Point(55, 70);
            txtAutorLibro.Name = "txtAutorLibro";
            txtAutorLibro.Size = new Size(314, 23);
            txtAutorLibro.TabIndex = 5;
            // 
            // txtAnioLibro
            // 
            txtAnioLibro.Location = new Point(55, 41);
            txtAnioLibro.Name = "txtAnioLibro";
            txtAnioLibro.Size = new Size(314, 23);
            txtAnioLibro.TabIndex = 6;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 15);
            label1.Name = "label1";
            label1.Size = new Size(37, 15);
            label1.TabIndex = 7;
            label1.Text = "Titulo";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 73);
            label2.Name = "label2";
            label2.Size = new Size(37, 15);
            label2.TabIndex = 8;
            label2.Text = "Autor";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 44);
            label3.Name = "label3";
            label3.Size = new Size(29, 15);
            label3.TabIndex = 9;
            label3.Text = "Año";
            // 
            // LibroForm
            // 
            AcceptButton = btnAceptarLibro;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            CancelButton = btnCancel;
            ClientSize = new Size(378, 129);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(txtAnioLibro);
            Controls.Add(txtAutorLibro);
            Controls.Add(txtTituloLibro);
            Controls.Add(btnAceptarLibro);
            Controls.Add(btnCancel);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "LibroForm";
            Text = "Libro";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnCancel;
        private Button btnAceptarLibro;
        private TextBox txtTituloLibro;
        private TextBox txtAutorLibro;
        private TextBox txtAnioLibro;
        private Label label1;
        private Label label2;
        private Label label3;
    }
}