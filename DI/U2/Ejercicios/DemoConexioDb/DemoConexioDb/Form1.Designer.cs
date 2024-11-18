namespace DemoConexioDb
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
            listBox = new ListBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            txtNombre = new TextBox();
            txtImporte = new TextBox();
            dtpFecha = new DateTimePicker();
            btnCarga = new Button();
            btnAdd = new Button();
            btnActualizar = new Button();
            btnEliminar = new Button();
            SuspendLayout();
            // 
            // listBox
            // 
            listBox.FormattingEnabled = true;
            listBox.ItemHeight = 15;
            listBox.Location = new Point(12, 12);
            listBox.Name = "listBox";
            listBox.Size = new Size(351, 109);
            listBox.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(10, 140);
            label1.Name = "label1";
            label1.Size = new Size(51, 15);
            label1.TabIndex = 1;
            label1.Text = "Nombre";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(10, 172);
            label2.Name = "label2";
            label2.Size = new Size(49, 15);
            label2.TabIndex = 2;
            label2.Text = "Importe";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(10, 208);
            label3.Name = "label3";
            label3.Size = new Size(38, 15);
            label3.TabIndex = 3;
            label3.Text = "Fecha";
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(89, 137);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(272, 23);
            txtNombre.TabIndex = 4;
            // 
            // txtImporte
            // 
            txtImporte.Location = new Point(89, 169);
            txtImporte.Name = "txtImporte";
            txtImporte.Size = new Size(272, 23);
            txtImporte.TabIndex = 5;
            // 
            // dtpFecha
            // 
            dtpFecha.Location = new Point(89, 202);
            dtpFecha.Name = "dtpFecha";
            dtpFecha.Size = new Size(272, 23);
            dtpFecha.TabIndex = 6;
            // 
            // btnCarga
            // 
            btnCarga.Location = new Point(9, 241);
            btnCarga.Name = "btnCarga";
            btnCarga.Size = new Size(111, 23);
            btnCarga.TabIndex = 7;
            btnCarga.Text = "Cargar Datos";
            btnCarga.UseVisualStyleBackColor = true;
            btnCarga.Click += btnCarga_Click;
            // 
            // btnAdd
            // 
            btnAdd.Location = new Point(126, 241);
            btnAdd.Name = "btnAdd";
            btnAdd.Size = new Size(75, 23);
            btnAdd.TabIndex = 8;
            btnAdd.Text = "Agregar";
            btnAdd.UseVisualStyleBackColor = true;
            btnAdd.Click += btnAdd_Click;
            // 
            // btnActualizar
            // 
            btnActualizar.Location = new Point(207, 241);
            btnActualizar.Name = "btnActualizar";
            btnActualizar.Size = new Size(75, 23);
            btnActualizar.TabIndex = 9;
            btnActualizar.Text = "Actualizar";
            btnActualizar.UseVisualStyleBackColor = true;
            btnActualizar.Click += btnActualizar_Click;
            // 
            // btnEliminar
            // 
            btnEliminar.Location = new Point(288, 241);
            btnEliminar.Name = "btnEliminar";
            btnEliminar.Size = new Size(75, 23);
            btnEliminar.TabIndex = 10;
            btnEliminar.Text = "Eliminar";
            btnEliminar.UseVisualStyleBackColor = true;
            btnEliminar.Click += btnEliminar_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(375, 277);
            Controls.Add(btnEliminar);
            Controls.Add(btnActualizar);
            Controls.Add(btnAdd);
            Controls.Add(btnCarga);
            Controls.Add(dtpFecha);
            Controls.Add(txtImporte);
            Controls.Add(txtNombre);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(listBox);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ListBox listBox;
        private Label label1;
        private Label label2;
        private Label label3;
        private TextBox txtNombre;
        private TextBox txtImporte;
        private DateTimePicker dtpFecha;
        private Button btnCarga;
        private Button btnAdd;
        private Button btnActualizar;
        private Button btnEliminar;
    }
}
