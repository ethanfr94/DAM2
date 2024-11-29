namespace ProjectStore
{
    partial class Principal
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Principal));
            menuStrip1 = new MenuStrip();
            tsmiCiclos = new ToolStripMenuItem();
            tsmiVerCiclos = new ToolStripMenuItem();
            txmiProfesores = new ToolStripMenuItem();
            tsmiVerProfesores = new ToolStripMenuItem();
            addProfesorToolStripMenuItem = new ToolStripMenuItem();
            modificarProfesorToolStripMenuItem = new ToolStripMenuItem();
            borrarProfesorToolStripMenuItem = new ToolStripMenuItem();
            tsmiAlumnos = new ToolStripMenuItem();
            tsmiVerAlumnos = new ToolStripMenuItem();
            addAlumnoToolStripMenuItem = new ToolStripMenuItem();
            modificarAlumnoToolStripMenuItem = new ToolStripMenuItem();
            borrarAlumnoToolStripMenuItem = new ToolStripMenuItem();
            tsmiProyectos = new ToolStripMenuItem();
            tsmiVerProyectos = new ToolStripMenuItem();
            verProyectoToolStripMenuItem = new ToolStripMenuItem();
            addProyectosToolStripMenuItem = new ToolStripMenuItem();
            modificarProyectosToolStripMenuItem = new ToolStripMenuItem();
            borrarProyectoToolStripMenuItem = new ToolStripMenuItem();
            archivosToolStripMenuItem = new ToolStripMenuItem();
            subirArchivoToolStripMenuItem = new ToolStripMenuItem();
            descargarArchivoToolStripMenuItem = new ToolStripMenuItem();
            tsmiLogOut = new ToolStripMenuItem();
            ltvListaPrincipal = new ListView();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.BackColor = SystemColors.ControlLightLight;
            menuStrip1.Items.AddRange(new ToolStripItem[] { tsmiCiclos, txmiProfesores, tsmiAlumnos, tsmiProyectos, archivosToolStripMenuItem, tsmiLogOut });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(722, 24);
            menuStrip1.TabIndex = 7;
            menuStrip1.Text = "menuStrip1";
            // 
            // tsmiCiclos
            // 
            tsmiCiclos.DropDownItems.AddRange(new ToolStripItem[] { tsmiVerCiclos });
            tsmiCiclos.Name = "tsmiCiclos";
            tsmiCiclos.Size = new Size(51, 20);
            tsmiCiclos.Text = "Ciclos";
            // 
            // tsmiVerCiclos
            // 
            tsmiVerCiclos.Name = "tsmiVerCiclos";
            tsmiVerCiclos.Size = new Size(125, 22);
            tsmiVerCiclos.Text = "Ver Ciclos";
            tsmiVerCiclos.Click += tsmiVerCiclos_Click;
            // 
            // txmiProfesores
            // 
            txmiProfesores.DropDownItems.AddRange(new ToolStripItem[] { tsmiVerProfesores, addProfesorToolStripMenuItem, modificarProfesorToolStripMenuItem, borrarProfesorToolStripMenuItem });
            txmiProfesores.Name = "txmiProfesores";
            txmiProfesores.Size = new Size(74, 20);
            txmiProfesores.Text = "Profesores";
            // 
            // tsmiVerProfesores
            // 
            tsmiVerProfesores.Name = "tsmiVerProfesores";
            tsmiVerProfesores.Size = new Size(172, 22);
            tsmiVerProfesores.Text = "Ver Profesores";
            tsmiVerProfesores.Click += tsmiVerProfesores_Click;
            // 
            // addProfesorToolStripMenuItem
            // 
            addProfesorToolStripMenuItem.Name = "addProfesorToolStripMenuItem";
            addProfesorToolStripMenuItem.Size = new Size(172, 22);
            addProfesorToolStripMenuItem.Text = "Añadir Profesor";
            addProfesorToolStripMenuItem.Visible = false;
            addProfesorToolStripMenuItem.Click += añadirProfesorToolStripMenuItem_Click;
            // 
            // modificarProfesorToolStripMenuItem
            // 
            modificarProfesorToolStripMenuItem.Name = "modificarProfesorToolStripMenuItem";
            modificarProfesorToolStripMenuItem.Size = new Size(172, 22);
            modificarProfesorToolStripMenuItem.Text = "Modificar Profesor";
            modificarProfesorToolStripMenuItem.Visible = false;
            modificarProfesorToolStripMenuItem.Click += modificarProfesorToolStripMenuItem_Click;
            // 
            // borrarProfesorToolStripMenuItem
            // 
            borrarProfesorToolStripMenuItem.Name = "borrarProfesorToolStripMenuItem";
            borrarProfesorToolStripMenuItem.Size = new Size(172, 22);
            borrarProfesorToolStripMenuItem.Text = "Borrar profesor";
            borrarProfesorToolStripMenuItem.Visible = false;
            borrarProfesorToolStripMenuItem.Click += borrarProfesorToolStripMenuItem_Click;
            // 
            // tsmiAlumnos
            // 
            tsmiAlumnos.DropDownItems.AddRange(new ToolStripItem[] { tsmiVerAlumnos, addAlumnoToolStripMenuItem, modificarAlumnoToolStripMenuItem, borrarAlumnoToolStripMenuItem });
            tsmiAlumnos.Name = "tsmiAlumnos";
            tsmiAlumnos.Size = new Size(67, 20);
            tsmiAlumnos.Text = "Alumnos";
            // 
            // tsmiVerAlumnos
            // 
            tsmiVerAlumnos.Name = "tsmiVerAlumnos";
            tsmiVerAlumnos.Size = new Size(171, 22);
            tsmiVerAlumnos.Text = "Ver Alumnos";
            tsmiVerAlumnos.Click += tsmiVerAlumnos_Click;
            // 
            // addAlumnoToolStripMenuItem
            // 
            addAlumnoToolStripMenuItem.Name = "addAlumnoToolStripMenuItem";
            addAlumnoToolStripMenuItem.Size = new Size(171, 22);
            addAlumnoToolStripMenuItem.Text = "Añadir Alumno";
            addAlumnoToolStripMenuItem.Visible = false;
            addAlumnoToolStripMenuItem.Click += añadirAlumnoToolStripMenuItem_Click;
            // 
            // modificarAlumnoToolStripMenuItem
            // 
            modificarAlumnoToolStripMenuItem.Name = "modificarAlumnoToolStripMenuItem";
            modificarAlumnoToolStripMenuItem.Size = new Size(171, 22);
            modificarAlumnoToolStripMenuItem.Text = "Modificar Alumno";
            modificarAlumnoToolStripMenuItem.Visible = false;
            modificarAlumnoToolStripMenuItem.Click += modificarAlumnoToolStripMenuItem_Click;
            // 
            // borrarAlumnoToolStripMenuItem
            // 
            borrarAlumnoToolStripMenuItem.Name = "borrarAlumnoToolStripMenuItem";
            borrarAlumnoToolStripMenuItem.Size = new Size(171, 22);
            borrarAlumnoToolStripMenuItem.Text = "Borrar alumno";
            borrarAlumnoToolStripMenuItem.Visible = false;
            borrarAlumnoToolStripMenuItem.Click += borrarAlumnoToolStripMenuItem1_Click;
            // 
            // tsmiProyectos
            // 
            tsmiProyectos.DropDownItems.AddRange(new ToolStripItem[] { tsmiVerProyectos, verProyectoToolStripMenuItem, addProyectosToolStripMenuItem, modificarProyectosToolStripMenuItem, borrarProyectoToolStripMenuItem });
            tsmiProyectos.Name = "tsmiProyectos";
            tsmiProyectos.Size = new Size(71, 20);
            tsmiProyectos.Text = "Proyectos";
            // 
            // tsmiVerProyectos
            // 
            tsmiVerProyectos.Name = "tsmiVerProyectos";
            tsmiVerProyectos.Size = new Size(180, 22);
            tsmiVerProyectos.Text = "Ver Proyectos";
            tsmiVerProyectos.Click += verProyectosToolStripMenuItem_Click;
            // 
            // verProyectoToolStripMenuItem
            // 
            verProyectoToolStripMenuItem.Name = "verProyectoToolStripMenuItem";
            verProyectoToolStripMenuItem.Size = new Size(180, 22);
            verProyectoToolStripMenuItem.Text = "Ver proyecto";
            verProyectoToolStripMenuItem.Visible = false;
            verProyectoToolStripMenuItem.Click += verProyectoToolStripMenuItem_Click;
            // 
            // addProyectosToolStripMenuItem
            // 
            addProyectosToolStripMenuItem.Name = "addProyectosToolStripMenuItem";
            addProyectosToolStripMenuItem.Size = new Size(180, 22);
            addProyectosToolStripMenuItem.Text = "Añadir Proyecto";
            addProyectosToolStripMenuItem.Visible = false;
            addProyectosToolStripMenuItem.Click += añadirProyectosToolStripMenuItem_Click;
            // 
            // modificarProyectosToolStripMenuItem
            // 
            modificarProyectosToolStripMenuItem.Name = "modificarProyectosToolStripMenuItem";
            modificarProyectosToolStripMenuItem.Size = new Size(180, 22);
            modificarProyectosToolStripMenuItem.Text = "Modificar Proyecto";
            modificarProyectosToolStripMenuItem.Visible = false;
            modificarProyectosToolStripMenuItem.Click += modificarProyectosToolStripMenuItem_Click;
            // 
            // borrarProyectoToolStripMenuItem
            // 
            borrarProyectoToolStripMenuItem.Name = "borrarProyectoToolStripMenuItem";
            borrarProyectoToolStripMenuItem.Size = new Size(180, 22);
            borrarProyectoToolStripMenuItem.Text = "Borrar proyecto";
            borrarProyectoToolStripMenuItem.Visible = false;
            borrarProyectoToolStripMenuItem.Click += borrarProyectoToolStripMenuItem_Click;
            // 
            // archivosToolStripMenuItem
            // 
            archivosToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { subirArchivoToolStripMenuItem, descargarArchivoToolStripMenuItem });
            archivosToolStripMenuItem.Name = "archivosToolStripMenuItem";
            archivosToolStripMenuItem.Size = new Size(65, 20);
            archivosToolStripMenuItem.Text = "Archivos";
            // 
            // subirArchivoToolStripMenuItem
            // 
            subirArchivoToolStripMenuItem.Name = "subirArchivoToolStripMenuItem";
            subirArchivoToolStripMenuItem.Size = new Size(180, 22);
            subirArchivoToolStripMenuItem.Text = "Subir archivo";
            subirArchivoToolStripMenuItem.Visible = false;
            subirArchivoToolStripMenuItem.Click += subirArchivoToolStripMenuItem_Click;
            // 
            // descargarArchivoToolStripMenuItem
            // 
            descargarArchivoToolStripMenuItem.Name = "descargarArchivoToolStripMenuItem";
            descargarArchivoToolStripMenuItem.Size = new Size(180, 22);
            descargarArchivoToolStripMenuItem.Text = "Descargar archivo";
            // 
            // tsmiLogOut
            // 
            tsmiLogOut.Name = "tsmiLogOut";
            tsmiLogOut.Size = new Size(88, 20);
            tsmiLogOut.Text = "Cerrar Sesion";
            tsmiLogOut.Click += OnClickLogout;
            // 
            // ltvListaPrincipal
            // 
            ltvListaPrincipal.BorderStyle = BorderStyle.FixedSingle;
            ltvListaPrincipal.Dock = DockStyle.Fill;
            ltvListaPrincipal.FullRowSelect = true;
            ltvListaPrincipal.GridLines = true;
            ltvListaPrincipal.Location = new Point(0, 24);
            ltvListaPrincipal.Name = "ltvListaPrincipal";
            ltvListaPrincipal.Size = new Size(722, 373);
            ltvListaPrincipal.TabIndex = 8;
            ltvListaPrincipal.UseCompatibleStateImageBehavior = false;
            ltvListaPrincipal.View = View.Details;
            ltvListaPrincipal.ItemSelectionChanged += ltvListaPrincipal_ItemSelectionChanged;
            ltvListaPrincipal.DoubleClick += verProyectoToolStripMenuItem_Click;
            // 
            // Principal
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLightLight;
            ClientSize = new Size(722, 397);
            Controls.Add(ltvListaPrincipal);
            Controls.Add(menuStrip1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Icon = (Icon)resources.GetObject("$this.Icon");
            MainMenuStrip = menuStrip1;
            Name = "Principal";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "ProjectStore | Perfil de Usuario";
            Load += Principal_Load;
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem tsmiCiclos;
        private ToolStripMenuItem txmiProfesores;
        private ToolStripMenuItem tsmiAlumnos;
        private ToolStripMenuItem tsmiProyectos;
        private ToolStripMenuItem tsmiLogOut;
        private ToolStripMenuItem tsmiVerCiclos;
        private ToolStripMenuItem tsmiVerProfesores;
        private ToolStripMenuItem tsmiVerAlumnos;
        private ToolStripMenuItem addAlumnoToolStripMenuItem;
        private ToolStripMenuItem modificarAlumnoToolStripMenuItem;
        private ToolStripMenuItem tsmiVerProyectos;
        private ToolStripMenuItem addProyectosToolStripMenuItem;
        private ToolStripMenuItem modificarProyectosToolStripMenuItem;
        private ToolStripMenuItem addProfesorToolStripMenuItem;
        private ToolStripMenuItem modificarProfesorToolStripMenuItem;
        private ListView ltvListaPrincipal;
        private ToolStripMenuItem archivosToolStripMenuItem;
        private ToolStripMenuItem subirArchivoToolStripMenuItem;
        private ToolStripMenuItem descargarArchivoToolStripMenuItem;
        private ToolStripMenuItem borrarProyectoToolStripMenuItem;
        private ToolStripMenuItem borrarAlumnoToolStripMenuItem;
        private ToolStripMenuItem borrarProfesorToolStripMenuItem;
        private ToolStripMenuItem verProyectoToolStripMenuItem;
    }
}
