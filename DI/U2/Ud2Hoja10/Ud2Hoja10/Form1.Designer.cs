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
            deshacerToolStripMenuItem = new ToolStripMenuItem();
            toolStripSeparator2 = new ToolStripSeparator();
            cortarToolStripMenuItem = new ToolStripMenuItem();
            copiarToolStripMenuItem = new ToolStripMenuItem();
            pegarToolStripMenuItem = new ToolStripMenuItem();
            eliminarToolStripMenuItem = new ToolStripMenuItem();
            toolStripSeparator3 = new ToolStripSeparator();
            buscarToolStripMenuItem = new ToolStripMenuItem();
            buscarSiguienteToolStripMenuItem = new ToolStripMenuItem();
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
            tsmiNuevo.Size = new Size(180, 22);
            tsmiNuevo.Text = "Nuevo";
            tsmiNuevo.Click += tsmiNuevo_Click;
            // 
            // tsmiAbrir
            // 
            tsmiAbrir.Name = "tsmiAbrir";
            tsmiAbrir.ShortcutKeys = Keys.Control | Keys.A;
            tsmiAbrir.Size = new Size(180, 22);
            tsmiAbrir.Text = "Abrir";
            // 
            // tsmiGuardar
            // 
            tsmiGuardar.Image = (Image)resources.GetObject("tsmiGuardar.Image");
            tsmiGuardar.Name = "tsmiGuardar";
            tsmiGuardar.ShortcutKeys = Keys.Control | Keys.G;
            tsmiGuardar.Size = new Size(180, 22);
            tsmiGuardar.Text = "Guardar";
            // 
            // tsmiGuardarComo
            // 
            tsmiGuardarComo.Name = "tsmiGuardarComo";
            tsmiGuardarComo.Size = new Size(180, 22);
            tsmiGuardarComo.Text = "Guardar Como";
            // 
            // toolStripSeparator1
            // 
            toolStripSeparator1.Name = "toolStripSeparator1";
            toolStripSeparator1.Size = new Size(177, 6);
            // 
            // tsmiSalir
            // 
            tsmiSalir.Name = "tsmiSalir";
            tsmiSalir.Size = new Size(180, 22);
            tsmiSalir.Text = "Salir";
            // 
            // edicionToolStripMenuItem
            // 
            edicionToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { deshacerToolStripMenuItem, toolStripSeparator2, cortarToolStripMenuItem, copiarToolStripMenuItem, pegarToolStripMenuItem, eliminarToolStripMenuItem, toolStripSeparator3, buscarToolStripMenuItem, buscarSiguienteToolStripMenuItem, toolStripSeparator4, seleccionarTodoToolStripMenuItem });
            edicionToolStripMenuItem.Name = "edicionToolStripMenuItem";
            edicionToolStripMenuItem.Size = new Size(58, 20);
            edicionToolStripMenuItem.Text = "Edicion";
            // 
            // deshacerToolStripMenuItem
            // 
            deshacerToolStripMenuItem.Name = "deshacerToolStripMenuItem";
            deshacerToolStripMenuItem.ShortcutKeys = Keys.Control | Keys.Z;
            deshacerToolStripMenuItem.Size = new Size(169, 22);
            deshacerToolStripMenuItem.Text = "Deshacer";
            // 
            // toolStripSeparator2
            // 
            toolStripSeparator2.Name = "toolStripSeparator2";
            toolStripSeparator2.Size = new Size(166, 6);
            // 
            // cortarToolStripMenuItem
            // 
            cortarToolStripMenuItem.Name = "cortarToolStripMenuItem";
            cortarToolStripMenuItem.ShortcutKeys = Keys.Control | Keys.X;
            cortarToolStripMenuItem.Size = new Size(169, 22);
            cortarToolStripMenuItem.Text = "Cortar";
            // 
            // copiarToolStripMenuItem
            // 
            copiarToolStripMenuItem.Name = "copiarToolStripMenuItem";
            copiarToolStripMenuItem.ShortcutKeys = Keys.Control | Keys.C;
            copiarToolStripMenuItem.Size = new Size(169, 22);
            copiarToolStripMenuItem.Text = "Copiar";
            // 
            // pegarToolStripMenuItem
            // 
            pegarToolStripMenuItem.Name = "pegarToolStripMenuItem";
            pegarToolStripMenuItem.ShortcutKeys = Keys.Control | Keys.V;
            pegarToolStripMenuItem.Size = new Size(169, 22);
            pegarToolStripMenuItem.Text = "Pegar";
            // 
            // eliminarToolStripMenuItem
            // 
            eliminarToolStripMenuItem.Name = "eliminarToolStripMenuItem";
            eliminarToolStripMenuItem.ShortcutKeys = Keys.Delete;
            eliminarToolStripMenuItem.Size = new Size(169, 22);
            eliminarToolStripMenuItem.Text = "Eliminar";
            // 
            // toolStripSeparator3
            // 
            toolStripSeparator3.Name = "toolStripSeparator3";
            toolStripSeparator3.Size = new Size(166, 6);
            // 
            // buscarToolStripMenuItem
            // 
            buscarToolStripMenuItem.Name = "buscarToolStripMenuItem";
            buscarToolStripMenuItem.Size = new Size(169, 22);
            buscarToolStripMenuItem.Text = "Buscar";
            // 
            // buscarSiguienteToolStripMenuItem
            // 
            buscarSiguienteToolStripMenuItem.Name = "buscarSiguienteToolStripMenuItem";
            buscarSiguienteToolStripMenuItem.Size = new Size(169, 22);
            buscarSiguienteToolStripMenuItem.Text = "Buscar Siguiente";
            // 
            // toolStripSeparator4
            // 
            toolStripSeparator4.Name = "toolStripSeparator4";
            toolStripSeparator4.Size = new Size(166, 6);
            // 
            // seleccionarTodoToolStripMenuItem
            // 
            seleccionarTodoToolStripMenuItem.Name = "seleccionarTodoToolStripMenuItem";
            seleccionarTodoToolStripMenuItem.Size = new Size(169, 22);
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
            // 
            // fuenteToolStripMenuItem
            // 
            fuenteToolStripMenuItem.Name = "fuenteToolStripMenuItem";
            fuenteToolStripMenuItem.Size = new Size(153, 22);
            fuenteToolStripMenuItem.Text = "Fuente";
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
        private ToolStripMenuItem deshacerToolStripMenuItem;
        private ToolStripSeparator toolStripSeparator2;
        private ToolStripMenuItem cortarToolStripMenuItem;
        private ToolStripMenuItem copiarToolStripMenuItem;
        private ToolStripMenuItem pegarToolStripMenuItem;
        private ToolStripMenuItem eliminarToolStripMenuItem;
        private ToolStripSeparator toolStripSeparator3;
        private ToolStripMenuItem buscarToolStripMenuItem;
        private ToolStripMenuItem buscarSiguienteToolStripMenuItem;
        private ToolStripSeparator toolStripSeparator4;
        private ToolStripMenuItem seleccionarTodoToolStripMenuItem;
        private ToolStripMenuItem ajusteDeTexToolStripMenuItem;
        private ToolStripMenuItem fuenteToolStripMenuItem;
        private ToolStripMenuItem acercaDeToolStripMenuItem;
        private TextBox txtContenido;
    }
}
