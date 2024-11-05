namespace EjemploListas
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
            components = new System.ComponentModel.Container();
            listView1 = new ListView();
            nombre = new ColumnHeader();
            edad = new ColumnHeader();
            contextMenuStrip1 = new ContextMenuStrip(components);
            eliminarToolStripMenuItem = new ToolStripMenuItem();
            btnadd = new Button();
            txtnombre = new TextBox();
            label1 = new Label();
            label2 = new Label();
            txtedad = new TextBox();
            btndel = new Button();
            contextMenuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // listView1
            // 
            listView1.CheckBoxes = true;
            listView1.Columns.AddRange(new ColumnHeader[] { nombre, edad });
            listView1.ContextMenuStrip = contextMenuStrip1;
            listView1.FullRowSelect = true;
            listView1.GridLines = true;
            listView1.Location = new Point(12, 36);
            listView1.Name = "listView1";
            listView1.Size = new Size(152, 402);
            listView1.TabIndex = 0;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.Details;
            // 
            // nombre
            // 
            nombre.Text = "Nombre";
            nombre.Width = 100;
            // 
            // edad
            // 
            edad.Text = "Edad";
            edad.Width = 50;
            // 
            // contextMenuStrip1
            // 
            contextMenuStrip1.Items.AddRange(new ToolStripItem[] { eliminarToolStripMenuItem });
            contextMenuStrip1.Name = "contextMenuStrip1";
            contextMenuStrip1.Size = new Size(181, 48);
            // 
            // eliminarToolStripMenuItem
            // 
            eliminarToolStripMenuItem.Name = "eliminarToolStripMenuItem";
            eliminarToolStripMenuItem.Size = new Size(180, 22);
            eliminarToolStripMenuItem.Text = "Eliminar";
            eliminarToolStripMenuItem.Click += eliminarToolStripMenuItem_Click;
            // 
            // btnadd
            // 
            btnadd.Location = new Point(170, 358);
            btnadd.Name = "btnadd";
            btnadd.Size = new Size(117, 80);
            btnadd.TabIndex = 1;
            btnadd.Text = "Añadir";
            btnadd.UseVisualStyleBackColor = true;
            btnadd.Click += btnadd_Click;
            // 
            // txtnombre
            // 
            txtnombre.Location = new Point(209, 54);
            txtnombre.Name = "txtnombre";
            txtnombre.Size = new Size(167, 23);
            txtnombre.TabIndex = 2;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(210, 36);
            label1.Name = "label1";
            label1.Size = new Size(54, 15);
            label1.TabIndex = 3;
            label1.Text = "Nombre:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(210, 116);
            label2.Name = "label2";
            label2.Size = new Size(36, 15);
            label2.TabIndex = 4;
            label2.Text = "Edad:";
            // 
            // txtedad
            // 
            txtedad.Location = new Point(209, 134);
            txtedad.Name = "txtedad";
            txtedad.Size = new Size(167, 23);
            txtedad.TabIndex = 5;
            // 
            // btndel
            // 
            btndel.Location = new Point(293, 358);
            btndel.Name = "btndel";
            btndel.Size = new Size(117, 80);
            btndel.TabIndex = 6;
            btndel.Text = "Borrar";
            btndel.UseVisualStyleBackColor = true;
            btndel.Click += btndel_Click;
            // 
            // Form1
            // 
            AcceptButton = btnadd;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(417, 450);
            Controls.Add(btndel);
            Controls.Add(txtedad);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(txtnombre);
            Controls.Add(btnadd);
            Controls.Add(listView1);
            Name = "Form1";
            Text = "Form1";
            contextMenuStrip1.ResumeLayout(false);
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ListView listView1;
        private ColumnHeader nombre;
        private ColumnHeader edad;
        private Button btnadd;
        private TextBox txtnombre;
        private Label label1;
        private Label label2;
        private TextBox txtedad;
        private Button btndel;
        private ContextMenuStrip contextMenuStrip1;
        private ToolStripMenuItem eliminarToolStripMenuItem;
    }
}
