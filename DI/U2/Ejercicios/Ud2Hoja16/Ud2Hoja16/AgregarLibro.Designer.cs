namespace Ud2Hoja16
{
    partial class AgregarLibro
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
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            txtTitulo = new TextBox();
            txtNacionalidad = new TextBox();
            txtApellidos = new TextBox();
            txtAutor = new TextBox();
            btnOk = new Button();
            btnCancel = new Button();
            cmbCateboria = new ComboBox();
            label5 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(37, 15);
            label1.TabIndex = 0;
            label1.Text = "Titulo";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 69);
            label2.Name = "label2";
            label2.Size = new Size(56, 15);
            label2.TabIndex = 1;
            label2.Text = "Apellidos";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 39);
            label3.Name = "label3";
            label3.Size = new Size(37, 15);
            label3.TabIndex = 2;
            label3.Text = "Autor";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(12, 99);
            label4.Name = "label4";
            label4.Size = new Size(77, 15);
            label4.TabIndex = 3;
            label4.Text = "Nacionalidad";
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(108, 6);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(215, 23);
            txtTitulo.TabIndex = 1;
            // 
            // txtNacionalidad
            // 
            txtNacionalidad.Location = new Point(108, 96);
            txtNacionalidad.Name = "txtNacionalidad";
            txtNacionalidad.Size = new Size(215, 23);
            txtNacionalidad.TabIndex = 4;
            // 
            // txtApellidos
            // 
            txtApellidos.Location = new Point(108, 66);
            txtApellidos.Name = "txtApellidos";
            txtApellidos.Size = new Size(215, 23);
            txtApellidos.TabIndex = 3;
            // 
            // txtAutor
            // 
            txtAutor.Location = new Point(108, 36);
            txtAutor.Name = "txtAutor";
            txtAutor.Size = new Size(215, 23);
            txtAutor.TabIndex = 2;
            // 
            // btnOk
            // 
            btnOk.Location = new Point(170, 153);
            btnOk.Name = "btnOk";
            btnOk.Size = new Size(75, 23);
            btnOk.TabIndex = 6;
            btnOk.Text = "Agregar";
            btnOk.UseVisualStyleBackColor = true;
            btnOk.Click += btnOk_Click;
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(251, 153);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(75, 23);
            btnCancel.TabIndex = 7;
            btnCancel.Text = "Cancelar";
            btnCancel.UseVisualStyleBackColor = true;
            btnCancel.Click += btnCancel_Click;
            // 
            // cmbCateboria
            // 
            cmbCateboria.FormattingEnabled = true;
            cmbCateboria.Location = new Point(108, 124);
            cmbCateboria.Name = "cmbCateboria";
            cmbCateboria.Size = new Size(214, 23);
            cmbCateboria.TabIndex = 5;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(12, 127);
            label5.Name = "label5";
            label5.Size = new Size(58, 15);
            label5.TabIndex = 11;
            label5.Text = "Categoria";
            // 
            // AgregarLibro
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(334, 188);
            Controls.Add(label5);
            Controls.Add(cmbCateboria);
            Controls.Add(btnCancel);
            Controls.Add(btnOk);
            Controls.Add(txtAutor);
            Controls.Add(txtApellidos);
            Controls.Add(txtNacionalidad);
            Controls.Add(txtTitulo);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "AgregarLibro";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "AgregarLibro";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox txtTitulo;
        private TextBox txtNacionalidad;
        private TextBox txtApellidos;
        private TextBox txtAutor;
        private Button btnOk;
        private Button btnCancel;
        private ComboBox cmbCateboria;
        private Label label5;
    }
}