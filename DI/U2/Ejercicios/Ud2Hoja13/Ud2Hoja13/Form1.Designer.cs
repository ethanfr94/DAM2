namespace Ud2Hoja13
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
            splitContainer1 = new SplitContainer();
            treeView1 = new TreeView();
            listView1 = new ListView();
            clmNombre = new ColumnHeader();
            clmFecha = new ColumnHeader();
            clmTamanio = new ColumnHeader();
            ((System.ComponentModel.ISupportInitialize)splitContainer1).BeginInit();
            splitContainer1.Panel1.SuspendLayout();
            splitContainer1.Panel2.SuspendLayout();
            splitContainer1.SuspendLayout();
            SuspendLayout();
            // 
            // splitContainer1
            // 
            splitContainer1.Dock = DockStyle.Fill;
            splitContainer1.Location = new Point(0, 0);
            splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel1
            // 
            splitContainer1.Panel1.Controls.Add(treeView1);
            // 
            // splitContainer1.Panel2
            // 
            splitContainer1.Panel2.Controls.Add(listView1);
            splitContainer1.Size = new Size(633, 449);
            splitContainer1.SplitterDistance = 173;
            splitContainer1.TabIndex = 0;
            // 
            // treeView1
            // 
            treeView1.Location = new Point(0, -1);
            treeView1.Name = "treeView1";
            treeView1.Size = new Size(170, 451);
            treeView1.TabIndex = 0;
            // 
            // listView1
            // 
            listView1.Columns.AddRange(new ColumnHeader[] { clmNombre, clmFecha, clmTamanio });
            listView1.Location = new Point(-1, 0);
            listView1.Name = "listView1";
            listView1.Size = new Size(457, 449);
            listView1.TabIndex = 0;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.Details;
            // 
            // clmNombre
            // 
            clmNombre.Text = "Nombre";
            clmNombre.Width = 150;
            // 
            // clmFecha
            // 
            clmFecha.Text = "Fecha de modificacion";
            clmFecha.Width = 150;
            // 
            // clmTamanio
            // 
            clmTamanio.Text = "Tamaño";
            clmTamanio.Width = 150;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(633, 449);
            Controls.Add(splitContainer1);
            Name = "Form1";
            Text = "Form1";
            splitContainer1.Panel1.ResumeLayout(false);
            splitContainer1.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)splitContainer1).EndInit();
            splitContainer1.ResumeLayout(false);
            ResumeLayout(false);
        }

        #endregion

        private SplitContainer splitContainer1;
        private TreeView treeView1;
        private ListView listView1;
        private ColumnHeader clmNombre;
        private ColumnHeader clmFecha;
        private ColumnHeader clmTamanio;
    }
}
