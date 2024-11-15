namespace Ud2Hoja15
{
    partial class Buscar
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            label2 = new Label();
            txtNombre = new TextBox();
            txtDepartamento = new TextBox();
            button1 = new Button();
            button2 = new Button();
            rdoNombre = new RadioButton();
            rdoDept = new RadioButton();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(27, 47);
            label1.Name = "label1";
            label1.Size = new Size(51, 15);
            label1.TabIndex = 0;
            label1.Text = "Nombre";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(27, 86);
            label2.Name = "label2";
            label2.Size = new Size(83, 15);
            label2.TabIndex = 1;
            label2.Text = "Departamento";
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(120, 44);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(200, 23);
            txtNombre.TabIndex = 4;
            // 
            // txtDepartamento
            // 
            txtDepartamento.Location = new Point(120, 83);
            txtDepartamento.Name = "txtDepartamento";
            txtDepartamento.Size = new Size(200, 23);
            txtDepartamento.TabIndex = 5;
            // 
            // button1
            // 
            button1.Location = new Point(157, 112);
            button1.Name = "button1";
            button1.Size = new Size(75, 23);
            button1.TabIndex = 6;
            button1.Text = "Buscar";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(245, 112);
            button2.Name = "button2";
            button2.Size = new Size(75, 23);
            button2.TabIndex = 7;
            button2.Text = "Cancelar";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // rdoNombre
            // 
            rdoNombre.AutoSize = true;
            rdoNombre.Checked = true;
            rdoNombre.Location = new Point(27, 12);
            rdoNombre.Name = "rdoNombre";
            rdoNombre.Size = new Size(69, 19);
            rdoNombre.TabIndex = 8;
            rdoNombre.TabStop = true;
            rdoNombre.Text = "Nombre";
            rdoNombre.UseVisualStyleBackColor = true;
            rdoNombre.CheckedChanged += rdoNombre_CheckedChanged;
            // 
            // rdoDept
            // 
            rdoDept.AutoSize = true;
            rdoDept.Location = new Point(138, 12);
            rdoDept.Name = "rdoDept";
            rdoDept.Size = new Size(101, 19);
            rdoDept.TabIndex = 9;
            rdoDept.Text = "Departamento";
            rdoDept.UseVisualStyleBackColor = true;
            rdoDept.CheckedChanged += rdoDept_CheckedChanged;
            // 
            // Buscar
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(332, 147);
            Controls.Add(rdoDept);
            Controls.Add(rdoNombre);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(txtDepartamento);
            Controls.Add(txtNombre);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Buscar";
            Text = "Buscar";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private TextBox txtNombre;
        private TextBox txtDepartamento;
        private Button button1;
        private Button button2;
        private RadioButton rdoNombre;
        private RadioButton rdoDept;
    }
}