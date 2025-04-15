namespace AcademyGestor
{
    partial class Main
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.pTablas = new System.Windows.Forms.Panel();
            this.dgvDatos = new System.Windows.Forms.DataGridView();
            this.btnSolicitudes = new System.Windows.Forms.Button();
            this.btnMatriculas = new System.Windows.Forms.Button();
            this.btnCursos = new System.Windows.Forms.Button();
            this.btnAlumnos = new System.Windows.Forms.Button();
            this.btnRecibos = new System.Windows.Forms.Button();
            this.btnProfesores = new System.Windows.Forms.Button();
            this.btnPublicaciones = new System.Windows.Forms.Button();
            this.pMenu = new System.Windows.Forms.Panel();
            this.pTablas.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvDatos)).BeginInit();
            this.pMenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // pTablas
            // 
            this.pTablas.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.pTablas.Controls.Add(this.dgvDatos);
            this.pTablas.Location = new System.Drawing.Point(182, 223);
            this.pTablas.Name = "pTablas";
            this.pTablas.Size = new System.Drawing.Size(703, 309);
            this.pTablas.TabIndex = 1;
            // 
            // dgvDatos
            // 
            this.dgvDatos.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvDatos.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvDatos.Location = new System.Drawing.Point(0, 0);
            this.dgvDatos.MultiSelect = false;
            this.dgvDatos.Name = "dgvDatos";
            this.dgvDatos.Size = new System.Drawing.Size(703, 309);
            this.dgvDatos.TabIndex = 0;
            // 
            // btnSolicitudes
            // 
            this.btnSolicitudes.Location = new System.Drawing.Point(11, 11);
            this.btnSolicitudes.Name = "btnSolicitudes";
            this.btnSolicitudes.Size = new System.Drawing.Size(147, 57);
            this.btnSolicitudes.TabIndex = 0;
            this.btnSolicitudes.Text = "Solicitudes";
            this.btnSolicitudes.UseVisualStyleBackColor = true;
            // 
            // btnMatriculas
            // 
            this.btnMatriculas.Location = new System.Drawing.Point(11, 74);
            this.btnMatriculas.Name = "btnMatriculas";
            this.btnMatriculas.Size = new System.Drawing.Size(147, 57);
            this.btnMatriculas.TabIndex = 1;
            this.btnMatriculas.Text = "Matriculas";
            this.btnMatriculas.UseVisualStyleBackColor = true;
            // 
            // btnCursos
            // 
            this.btnCursos.Location = new System.Drawing.Point(11, 137);
            this.btnCursos.Name = "btnCursos";
            this.btnCursos.Size = new System.Drawing.Size(147, 57);
            this.btnCursos.TabIndex = 2;
            this.btnCursos.Text = "Cursos";
            this.btnCursos.UseVisualStyleBackColor = true;
            // 
            // btnAlumnos
            // 
            this.btnAlumnos.Location = new System.Drawing.Point(11, 200);
            this.btnAlumnos.Name = "btnAlumnos";
            this.btnAlumnos.Size = new System.Drawing.Size(147, 57);
            this.btnAlumnos.TabIndex = 4;
            this.btnAlumnos.Text = "Alumnos";
            this.btnAlumnos.UseVisualStyleBackColor = true;
            // 
            // btnRecibos
            // 
            this.btnRecibos.Location = new System.Drawing.Point(11, 326);
            this.btnRecibos.Name = "btnRecibos";
            this.btnRecibos.Size = new System.Drawing.Size(147, 57);
            this.btnRecibos.TabIndex = 5;
            this.btnRecibos.Text = "Recibos";
            this.btnRecibos.UseVisualStyleBackColor = true;
            // 
            // btnProfesores
            // 
            this.btnProfesores.Location = new System.Drawing.Point(11, 263);
            this.btnProfesores.Name = "btnProfesores";
            this.btnProfesores.Size = new System.Drawing.Size(147, 57);
            this.btnProfesores.TabIndex = 3;
            this.btnProfesores.Text = "Profesores";
            this.btnProfesores.UseVisualStyleBackColor = true;
            // 
            // btnPublicaciones
            // 
            this.btnPublicaciones.Location = new System.Drawing.Point(11, 389);
            this.btnPublicaciones.Name = "btnPublicaciones";
            this.btnPublicaciones.Size = new System.Drawing.Size(147, 57);
            this.btnPublicaciones.TabIndex = 6;
            this.btnPublicaciones.Text = "Publicaciones";
            this.btnPublicaciones.UseVisualStyleBackColor = true;
            // 
            // pMenu
            // 
            this.pMenu.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pMenu.Controls.Add(this.btnPublicaciones);
            this.pMenu.Controls.Add(this.btnProfesores);
            this.pMenu.Controls.Add(this.btnRecibos);
            this.pMenu.Controls.Add(this.btnAlumnos);
            this.pMenu.Controls.Add(this.btnCursos);
            this.pMenu.Controls.Add(this.btnMatriculas);
            this.pMenu.Controls.Add(this.btnSolicitudes);
            this.pMenu.Location = new System.Drawing.Point(1, 1);
            this.pMenu.Name = "pMenu";
            this.pMenu.Size = new System.Drawing.Size(178, 536);
            this.pMenu.TabIndex = 0;
            // 
            // Main
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(893, 537);
            this.Controls.Add(this.pTablas);
            this.Controls.Add(this.pMenu);
            this.MinimumSize = new System.Drawing.Size(909, 576);
            this.Name = "Main";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "AcademyGestor";
            this.pTablas.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvDatos)).EndInit();
            this.pMenu.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Panel pTablas;
        private System.Windows.Forms.DataGridView dgvDatos;
        private System.Windows.Forms.Button btnSolicitudes;
        private System.Windows.Forms.Button btnMatriculas;
        private System.Windows.Forms.Button btnCursos;
        private System.Windows.Forms.Button btnAlumnos;
        private System.Windows.Forms.Button btnRecibos;
        private System.Windows.Forms.Button btnProfesores;
        private System.Windows.Forms.Button btnPublicaciones;
        private System.Windows.Forms.Panel pMenu;
    }
}

