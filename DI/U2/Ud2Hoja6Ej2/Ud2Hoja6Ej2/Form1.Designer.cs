namespace Ud2Hoja6Ej2
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
            txtTarea = new TextBox();
            label1 = new Label();
            btnAdd = new Button();
            btnDel = new Button();
            lstTareas = new ListBox();
            SuspendLayout();
            // 
            // txtTarea
            // 
            txtTarea.Location = new Point(52, 6);
            txtTarea.Name = "txtTarea";
            txtTarea.Size = new Size(191, 23);
            txtTarea.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(34, 15);
            label1.TabIndex = 1;
            label1.Text = "Tarea";
            // 
            // btnAdd
            // 
            btnAdd.Location = new Point(12, 35);
            btnAdd.Name = "btnAdd";
            btnAdd.Size = new Size(109, 23);
            btnAdd.TabIndex = 2;
            btnAdd.Text = "Agregar";
            btnAdd.UseVisualStyleBackColor = true;
            btnAdd.Click += btnAdd_Click;
            // 
            // btnDel
            // 
            btnDel.Location = new Point(134, 35);
            btnDel.Name = "btnDel";
            btnDel.Size = new Size(109, 23);
            btnDel.TabIndex = 3;
            btnDel.Text = "Borrar";
            btnDel.UseVisualStyleBackColor = true;
            btnDel.Click += btnDel_Click;
            // 
            // lstTareas
            // 
            lstTareas.FormattingEnabled = true;
            lstTareas.ItemHeight = 15;
            lstTareas.Location = new Point(12, 73);
            lstTareas.Name = "lstTareas";
            lstTareas.Size = new Size(231, 154);
            lstTareas.TabIndex = 4;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(252, 235);
            Controls.Add(lstTareas);
            Controls.Add(btnDel);
            Controls.Add(btnAdd);
            Controls.Add(label1);
            Controls.Add(txtTarea);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtTarea;
        private Label label1;
        private Button btnAdd;
        private Button btnDel;
        private ListBox lstTareas;
    }
}
