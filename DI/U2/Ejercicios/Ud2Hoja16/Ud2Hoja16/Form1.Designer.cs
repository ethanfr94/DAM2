namespace Ud2Hoja16
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
            dgvBiblio = new DataGridView();
            Column1 = new DataGridViewTextBoxColumn();
            Column2 = new DataGridViewTextBoxColumn();
            Column3 = new DataGridViewTextBoxColumn();
            Column5 = new DataGridViewTextBoxColumn();
            Column4 = new DataGridViewTextBoxColumn();
            btnAddLibro = new Button();
            btnActualizar = new Button();
            ((System.ComponentModel.ISupportInitialize)dgvBiblio).BeginInit();
            SuspendLayout();
            // 
            // dgvBiblio
            // 
            dgvBiblio.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvBiblio.Columns.AddRange(new DataGridViewColumn[] { Column1, Column2, Column3, Column5, Column4 });
            dgvBiblio.Location = new Point(12, 12);
            dgvBiblio.MultiSelect = false;
            dgvBiblio.Name = "dgvBiblio";
            dgvBiblio.Size = new Size(541, 157);
            dgvBiblio.TabIndex = 0;
            // 
            // Column1
            // 
            Column1.HeaderText = "Titulo";
            Column1.Name = "Column1";
            // 
            // Column2
            // 
            Column2.HeaderText = "Categoria";
            Column2.Name = "Column2";
            // 
            // Column3
            // 
            Column3.HeaderText = "Autor";
            Column3.Name = "Column3";
            // 
            // Column5
            // 
            Column5.HeaderText = "Apellidos";
            Column5.Name = "Column5";
            // 
            // Column4
            // 
            Column4.HeaderText = "Nacionalidad";
            Column4.Name = "Column4";
            // 
            // btnAddLibro
            // 
            btnAddLibro.Location = new Point(12, 175);
            btnAddLibro.Name = "btnAddLibro";
            btnAddLibro.Size = new Size(103, 23);
            btnAddLibro.TabIndex = 1;
            btnAddLibro.Text = "Agregar Libro";
            btnAddLibro.UseVisualStyleBackColor = true;
            btnAddLibro.Click += btnAddLibro_Click;
            // 
            // btnActualizar
            // 
            btnActualizar.Location = new Point(121, 175);
            btnActualizar.Name = "btnActualizar";
            btnActualizar.Size = new Size(103, 23);
            btnActualizar.TabIndex = 2;
            btnActualizar.Text = "Actualizar Datos";
            btnActualizar.UseVisualStyleBackColor = true;
            btnActualizar.Click += btnActualizar_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(565, 210);
            Controls.Add(btnActualizar);
            Controls.Add(btnAddLibro);
            Controls.Add(dgvBiblio);
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)dgvBiblio).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private DataGridView dgvBiblio;
        private DataGridViewTextBoxColumn Column1;
        private DataGridViewTextBoxColumn Column2;
        private DataGridViewTextBoxColumn Column3;
        private DataGridViewTextBoxColumn Column5;
        private DataGridViewTextBoxColumn Column4;
        private Button btnAddLibro;
        private Button btnActualizar;
    }
}
