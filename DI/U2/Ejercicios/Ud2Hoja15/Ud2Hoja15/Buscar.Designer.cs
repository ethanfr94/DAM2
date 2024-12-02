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
            btnBuscar = new Button();
            btnCancel = new Button();
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
            // btnBuscar
            // 
            btnBuscar.Location = new Point(157, 112);
            btnBuscar.Name = "btnBuscar";
            btnBuscar.Size = new Size(75, 23);
            btnBuscar.TabIndex = 6;
            btnBuscar.Text = "Buscar";
            btnBuscar.UseVisualStyleBackColor = true;
            btnBuscar.Click += btnBuscar_Click;
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(245, 112);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(75, 23);
            btnCancel.TabIndex = 7;
            btnCancel.Text = "Cancelar";
            btnCancel.UseVisualStyleBackColor = true;
            btnCancel.Click += btnCancel_Click;
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
            Controls.Add(btnCancel);
            Controls.Add(btnBuscar);
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
        private Button btnBuscar;
        private Button btnCancel;
        private RadioButton rdoNombre;
        private RadioButton rdoDept;
    }
}