namespace MiniReto_interfaz_principal
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
            menuStrip1 = new MenuStrip();
            tsmiCiclos = new ToolStripMenuItem();
            tsmiVerCiclos = new ToolStripMenuItem();
            txmiProfesores = new ToolStripMenuItem();
            tsmiVerProfesores = new ToolStripMenuItem();
            añadirProfesorToolStripMenuItem = new ToolStripMenuItem();
            modificarProfesorToolStripMenuItem = new ToolStripMenuItem();
            tsmiAlumnos = new ToolStripMenuItem();
            tsmiVerAlumnos = new ToolStripMenuItem();
            añadirAlumnoToolStripMenuItem = new ToolStripMenuItem();
            modificarAlumnoToolStripMenuItem = new ToolStripMenuItem();
            tsmiProyectos = new ToolStripMenuItem();
            verProyectosToolStripMenuItem = new ToolStripMenuItem();
            añadirProyectosToolStripMenuItem = new ToolStripMenuItem();
            modificarProyectosToolStripMenuItem = new ToolStripMenuItem();
            tsmiLogOut = new ToolStripMenuItem();
            ltvListaPrincipal = new ListView();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { tsmiCiclos, txmiProfesores, tsmiAlumnos, tsmiProyectos, tsmiLogOut });
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
            txmiProfesores.DropDownItems.AddRange(new ToolStripItem[] { tsmiVerProfesores, añadirProfesorToolStripMenuItem, modificarProfesorToolStripMenuItem });
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
            // añadirProfesorToolStripMenuItem
            // 
            añadirProfesorToolStripMenuItem.Name = "añadirProfesorToolStripMenuItem";
            añadirProfesorToolStripMenuItem.Size = new Size(172, 22);
            añadirProfesorToolStripMenuItem.Text = "Añadir Profesor";
            añadirProfesorToolStripMenuItem.Click += añadirProfesorToolStripMenuItem_Click;
            // 
            // modificarProfesorToolStripMenuItem
            // 
            modificarProfesorToolStripMenuItem.Name = "modificarProfesorToolStripMenuItem";
            modificarProfesorToolStripMenuItem.Size = new Size(172, 22);
            modificarProfesorToolStripMenuItem.Text = "Modificar Profesor";
            // 
            // tsmiAlumnos
            // 
            tsmiAlumnos.DropDownItems.AddRange(new ToolStripItem[] { tsmiVerAlumnos, añadirAlumnoToolStripMenuItem, modificarAlumnoToolStripMenuItem });
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
            // añadirAlumnoToolStripMenuItem
            // 
            añadirAlumnoToolStripMenuItem.Name = "añadirAlumnoToolStripMenuItem";
            añadirAlumnoToolStripMenuItem.Size = new Size(171, 22);
            añadirAlumnoToolStripMenuItem.Text = "Añadir Alumno";
            añadirAlumnoToolStripMenuItem.Click += añadirAlumnoToolStripMenuItem_Click;
            // 
            // modificarAlumnoToolStripMenuItem
            // 
            modificarAlumnoToolStripMenuItem.Name = "modificarAlumnoToolStripMenuItem";
            modificarAlumnoToolStripMenuItem.Size = new Size(171, 22);
            modificarAlumnoToolStripMenuItem.Text = "Modificar Alumno";
            // 
            // tsmiProyectos
            // 
            tsmiProyectos.DropDownItems.AddRange(new ToolStripItem[] { verProyectosToolStripMenuItem, añadirProyectosToolStripMenuItem, modificarProyectosToolStripMenuItem });
            tsmiProyectos.Name = "tsmiProyectos";
            tsmiProyectos.Size = new Size(71, 20);
            tsmiProyectos.Text = "Proyectos";
            // 
            // verProyectosToolStripMenuItem
            // 
            verProyectosToolStripMenuItem.Name = "verProyectosToolStripMenuItem";
            verProyectosToolStripMenuItem.Size = new Size(180, 22);
            verProyectosToolStripMenuItem.Text = "Ver Proyectos";
            verProyectosToolStripMenuItem.Click += verProyectosToolStripMenuItem_Click;
            // 
            // añadirProyectosToolStripMenuItem
            // 
            añadirProyectosToolStripMenuItem.Name = "añadirProyectosToolStripMenuItem";
            añadirProyectosToolStripMenuItem.Size = new Size(180, 22);
            añadirProyectosToolStripMenuItem.Text = "Añadir Proyecto";
            añadirProyectosToolStripMenuItem.Click += añadirProyectosToolStripMenuItem_Click;
            // 
            // modificarProyectosToolStripMenuItem
            // 
            modificarProyectosToolStripMenuItem.Name = "modificarProyectosToolStripMenuItem";
            modificarProyectosToolStripMenuItem.Size = new Size(180, 22);
            modificarProyectosToolStripMenuItem.Text = "Modificar Proyecto";
            // 
            // tsmiLogOut
            // 
            tsmiLogOut.Name = "tsmiLogOut";
            tsmiLogOut.Size = new Size(88, 20);
            tsmiLogOut.Text = "Cerrar Sesion";
            // 
            // ltvListaPrincipal
            // 
            ltvListaPrincipal.GridLines = true;
            ltvListaPrincipal.Location = new Point(12, 27);
            ltvListaPrincipal.MultiSelect = false;
            ltvListaPrincipal.Name = "ltvListaPrincipal";
            ltvListaPrincipal.Size = new Size(698, 358);
            ltvListaPrincipal.TabIndex = 8;
            ltvListaPrincipal.UseCompatibleStateImageBehavior = false;
            ltvListaPrincipal.View = View.Details;
            // 
            // Principal
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(722, 397);
            Controls.Add(ltvListaPrincipal);
            Controls.Add(menuStrip1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MainMenuStrip = menuStrip1;
            Name = "Principal";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Perfil de Usuario";
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
        private ListView ltvListaPrincipal;
        private ToolStripMenuItem tsmiVerCiclos;
        private ToolStripMenuItem tsmiVerProfesores;
        private ToolStripMenuItem tsmiVerAlumnos;
        private ToolStripMenuItem añadirAlumnoToolStripMenuItem;
        private ToolStripMenuItem modificarAlumnoToolStripMenuItem;
        private ToolStripMenuItem verProyectosToolStripMenuItem;
        private ToolStripMenuItem añadirProyectosToolStripMenuItem;
        private ToolStripMenuItem modificarProyectosToolStripMenuItem;
        private ToolStripMenuItem añadirProfesorToolStripMenuItem;
        private ToolStripMenuItem modificarProfesorToolStripMenuItem;
    }
}
