namespace Ud2Hoja10
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            menuStrip1 = new MenuStrip();
            archivoToolStripMenuItem = new ToolStripMenuItem();
            tsmiNuevo = new ToolStripMenuItem();
            tsmiAbrir = new ToolStripMenuItem();
            tsmiGuardar = new ToolStripMenuItem();
            tsmiGuardarComo = new ToolStripMenuItem();
            toolStripSeparator1 = new ToolStripSeparator();
            tsmiSalir = new ToolStripMenuItem();
            edicionToolStripMenuItem = new ToolStripMenuItem();
            tsmiDeshacer = new ToolStripMenuItem();
            toolStripSeparator2 = new ToolStripSeparator();
            tsmiCortar = new ToolStripMenuItem();
            tsmiCopiar = new ToolStripMenuItem();
            tsmiPegar = new ToolStripMenuItem();
            tsmiEliminar = new ToolStripMenuItem();
            toolStripSeparator3 = new ToolStripSeparator();
            tsmiBuscar = new ToolStripMenuItem();
            btnBuscarSiguiente = new ToolStripMenuItem();
            toolStripSeparator4 = new ToolStripSeparator();
            seleccionarTodoToolStripMenuItem = new ToolStripMenuItem();
            formatoToolStripMenuItem = new ToolStripMenuItem();
            ajusteDeTexToolStripMenuItem = new ToolStripMenuItem();
            fuenteToolStripMenuItem = new ToolStripMenuItem();
            ayudaToolStripMenuItem = new ToolStripMenuItem();
            acercaDeToolStripMenuItem = new ToolStripMenuItem();
            txtContenido = new TextBox();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { archivoToolStripMenuItem, edicionToolStripMenuItem, formatoToolStripMenuItem, ayudaToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(405, 24);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // archivoToolStripMenuItem
            // 
            archivoToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { tsmiNuevo, tsmiAbrir, tsmiGuardar, tsmiGuardarComo, toolStripSeparator1, tsmiSalir });
            archivoToolStripMenuItem.Name = "archivoToolStripMenuItem";
            archivoToolStripMenuItem.Size = new Size(60, 20);
            archivoToolStripMenuItem.Text = "Archivo";
            // 
            // tsmiNuevo
            // 
            tsmiNuevo.Name = "tsmiNuevo";
            tsmiNuevo.ShortcutKeys = Keys.Control | Keys.N;
            tsmiNuevo.Size = new Size(158, 22);
            tsmiNuevo.Text = "Nuevo";
            tsmiNuevo.Click += tsmiNuevo_Click;
            // 
            // tsmiAbrir
            // 
            tsmiAbrir.Name = "tsmiAbrir";
            tsmiAbrir.ShortcutKeys = Keys.Control | Keys.A;
            tsmiAbrir.Size = new Size(158, 22);
            tsmiAbrir.Text = "Abrir";
            tsmiAbrir.Click += tsmiAbrir_Click;
            // 
            // tsmiGuardar
            // 
            tsmiGuardar.Image = (Image)resources.GetObject("tsmiGuardar.Image");
            tsmiGuardar.Name = "tsmiGuardar";
            tsmiGuardar.ShortcutKeys = Keys.Control | Keys.G;
            tsmiGuardar.Size = new Size(158, 22);
            tsmiGuardar.Text = "Guardar";
            tsmiGuardar.Click += tsmiGuardar_Click;
            // 
            // tsmiGuardarComo
            // 
            tsmiGuardarComo.Name = "tsmiGuardarComo";
            tsmiGuardarComo.Size = new Size(158, 22);
            tsmiGuardarComo.Text = "Guardar Como";
            tsmiGuardarComo.Click += tsmiGuardarComo_Click;
            // 
            // toolStripSeparator1
            // 
            toolStripSeparator1.Name = "toolStripSeparator1";
            toolStripSeparator1.Size = new Size(155, 6);
            // 
            // tsmiSalir
            // 
            tsmiSalir.Name = "tsmiSalir";
            tsmiSalir.Size = new Size(158, 22);
            tsmiSalir.Text = "Salir";
            tsmiSalir.Click += tsmiSalir_Click;
            // 
            // edicionToolStripMenuItem
            // 
            edicionToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { tsmiDeshacer, toolStripSeparator2, tsmiCortar, tsmiCopiar, tsmiPegar, tsmiEliminar, toolStripSeparator3, tsmiBuscar, btnBuscarSiguiente, toolStripSeparator4, seleccionarTodoToolStripMenuItem });
            edicionToolStripMenuItem.Name = "edicionToolStripMenuItem";
            edicionToolStripMenuItem.Size = new Size(58, 20);
            edicionToolStripMenuItem.Text = "Edicion";
            // 
            // tsmiDeshacer
            // 
            tsmiDeshacer.Image = (Image)resources.GetObject("tsmiDeshacer.Image");
            tsmiDeshacer.Name = "tsmiDeshacer";
            tsmiDeshacer.ShortcutKeys = Keys.Control | Keys.Z;
            tsmiDeshacer.Size = new Size(180, 22);
            tsmiDeshacer.Text = "Deshacer";
            tsmiDeshacer.Click += tsmiDeshacer_Click;
            // 
            // toolStripSeparator2
            // 
            toolStripSeparator2.Name = "toolStripSeparator2";
            toolStripSeparator2.Size = new Size(177, 6);
            // 
            // tsmiCortar
            // 
            tsmiCortar.Image = (Image)resources.GetObject("tsmiCortar.Image");
            tsmiCortar.Name = "tsmiCortar";
            tsmiCortar.ShortcutKeys = Keys.Control | Keys.X;
            tsmiCortar.Size = new Size(180, 22);
            tsmiCortar.Text = "Cortar";
            tsmiCortar.Click += tsmiCortar_Click;
            // 
            // tsmiCopiar
            // 
            tsmiCopiar.Image = (Image)resources.GetObject("tsmiCopiar.Image");
            tsmiCopiar.Name = "tsmiCopiar";
            tsmiCopiar.ShortcutKeys = Keys.Control | Keys.C;
            tsmiCopiar.Size = new Size(180, 22);
            tsmiCopiar.Text = "Copiar";
            tsmiCopiar.Click += tsmiCopiar_Click;
            // 
            // tsmiPegar
            // 
            tsmiPegar.Image = (Image)resources.GetObject("tsmiPegar.Image");
            tsmiPegar.Name = "tsmiPegar";
            tsmiPegar.ShortcutKeys = Keys.Control | Keys.V;
            tsmiPegar.Size = new Size(180, 22);
            tsmiPegar.Text = "Pegar";
            tsmiPegar.Click += tsmiPegar_Click;
            // 
            // tsmiEliminar
            // 
            tsmiEliminar.Name = "tsmiEliminar";
            tsmiEliminar.ShortcutKeys = Keys.Delete;
            tsmiEliminar.Size = new Size(180, 22);
            tsmiEliminar.Text = "Eliminar";
            tsmiEliminar.Click += tsmiEliminar_Click;
            // 
            // toolStripSeparator3
            // 
            toolStripSeparator3.Name = "toolStripSeparator3";
            toolStripSeparator3.Size = new Size(177, 6);
            // 
            // tsmiBuscar
            // 
            tsmiBuscar.Name = "tsmiBuscar";
            tsmiBuscar.Size = new Size(180, 22);
            tsmiBuscar.Text = "Buscar";
            tsmiBuscar.Click += tsmiBuscar_Click;
            // 
            // btnBuscarSiguiente
            // 
            btnBuscarSiguiente.Name = "btnBuscarSiguiente";
            btnBuscarSiguiente.Size = new Size(180, 22);
            btnBuscarSiguiente.Text = "Buscar Siguiente";
            btnBuscarSiguiente.Click += btnBuscarSiguiente_Click;
            // 
            // toolStripSeparator4
            // 
            toolStripSeparator4.Name = "toolStripSeparator4";
            toolStripSeparator4.Size = new Size(177, 6);
            // 
            // seleccionarTodoToolStripMenuItem
            // 
            seleccionarTodoToolStripMenuItem.Name = "seleccionarTodoToolStripMenuItem";
            seleccionarTodoToolStripMenuItem.Size = new Size(180, 22);
            seleccionarTodoToolStripMenuItem.Text = "Seleccionar Todo";
            // 
            // formatoToolStripMenuItem
            // 
            formatoToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { ajusteDeTexToolStripMenuItem, fuenteToolStripMenuItem });
            formatoToolStripMenuItem.Name = "formatoToolStripMenuItem";
            formatoToolStripMenuItem.Size = new Size(64, 20);
            formatoToolStripMenuItem.Text = "Formato";
            // 
            // ajusteDeTexToolStripMenuItem
            // 
            ajusteDeTexToolStripMenuItem.Checked = true;
            ajusteDeTexToolStripMenuItem.CheckState = CheckState.Checked;
            ajusteDeTexToolStripMenuItem.Name = "ajusteDeTexToolStripMenuItem";
            ajusteDeTexToolStripMenuItem.Size = new Size(153, 22);
            ajusteDeTexToolStripMenuItem.Text = "Ajuste de texto";
            ajusteDeTexToolStripMenuItem.Click += ajusteDeTexToolStripMenuItem_Click;
            // 
            // fuenteToolStripMenuItem
            // 
            fuenteToolStripMenuItem.Name = "fuenteToolStripMenuItem";
            fuenteToolStripMenuItem.Size = new Size(153, 22);
            fuenteToolStripMenuItem.Text = "Fuente";
            fuenteToolStripMenuItem.Click += fuenteToolStripMenuItem_Click;
            // 
            // ayudaToolStripMenuItem
            // 
            ayudaToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { acercaDeToolStripMenuItem });
            ayudaToolStripMenuItem.Name = "ayudaToolStripMenuItem";
            ayudaToolStripMenuItem.Size = new Size(53, 20);
            ayudaToolStripMenuItem.Text = "Ayuda";
            // 
            // acercaDeToolStripMenuItem
            // 
            acercaDeToolStripMenuItem.Name = "acercaDeToolStripMenuItem";
            acercaDeToolStripMenuItem.Size = new Size(135, 22);
            acercaDeToolStripMenuItem.Text = "Acerca de...";
            acercaDeToolStripMenuItem.Click += acercaDeToolStripMenuItem_Click;
            // 
            // txtContenido
            // 
            txtContenido.Dock = DockStyle.Fill;
            txtContenido.Location = new Point(0, 24);
            txtContenido.Multiline = true;
            txtContenido.Name = "txtContenido";
            txtContenido.Size = new Size(405, 405);
            txtContenido.TabIndex = 1;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(405, 429);
            Controls.Add(txtContenido);
            Controls.Add(menuStrip1);
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Bloc de Notas";
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem archivoToolStripMenuItem;
        private ToolStripMenuItem tsmiNuevo;
        private ToolStripMenuItem tsmiAbrir;
        private ToolStripMenuItem tsmiGuardar;
        private ToolStripMenuItem tsmiGuardarComo;
        private ToolStripSeparator toolStripSeparator1;
        private ToolStripMenuItem tsmiSalir;
        private ToolStripMenuItem edicionToolStripMenuItem;
        private ToolStripMenuItem formatoToolStripMenuItem;
        private ToolStripMenuItem ayudaToolStripMenuItem;
        private ToolStripMenuItem tsmiDeshacer;
        private ToolStripSeparator toolStripSeparator2;
        private ToolStripMenuItem tsmiCortar;
        private ToolStripMenuItem tsmiCopiar;
        private ToolStripMenuItem tsmiPegar;
        private ToolStripMenuItem tsmiEliminar;
        private ToolStripSeparator toolStripSeparator3;
        private ToolStripMenuItem tsmiBuscar;
        private ToolStripMenuItem btnBuscarSiguiente;
        private ToolStripSeparator toolStripSeparator4;
        private ToolStripMenuItem seleccionarTodoToolStripMenuItem;
        private ToolStripMenuItem ajusteDeTexToolStripMenuItem;
        private ToolStripMenuItem fuenteToolStripMenuItem;
        private ToolStripMenuItem acercaDeToolStripMenuItem;
        private TextBox txtContenido;
    }
}
