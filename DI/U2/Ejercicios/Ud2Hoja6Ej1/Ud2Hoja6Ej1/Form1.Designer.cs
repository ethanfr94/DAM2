namespace Ud2Hoja6Ej1
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
            lblOp1 = new Label();
            lblOp2 = new Label();
            lblResultado = new Label();
            txtOp1 = new TextBox();
            txtOp2 = new TextBox();
            txtResult = new TextBox();
            btnSumar = new Button();
            btnRestar = new Button();
            btnMultip = new Button();
            btnDiv = new Button();
            SuspendLayout();
            // 
            // lblOp1
            // 
            lblOp1.AutoSize = true;
            lblOp1.Location = new Point(12, 9);
            lblOp1.Name = "lblOp1";
            lblOp1.Size = new Size(69, 15);
            lblOp1.TabIndex = 0;
            lblOp1.Text = "Operando 1";
            lblOp1.Click += label1_Click;
            // 
            // lblOp2
            // 
            lblOp2.AutoSize = true;
            lblOp2.Location = new Point(12, 53);
            lblOp2.Name = "lblOp2";
            lblOp2.Size = new Size(69, 15);
            lblOp2.TabIndex = 1;
            lblOp2.Text = "Operando 2";
            lblOp2.Click += label2_Click;
            // 
            // lblResultado
            // 
            lblResultado.AutoSize = true;
            lblResultado.Location = new Point(12, 97);
            lblResultado.Name = "lblResultado";
            lblResultado.Size = new Size(59, 15);
            lblResultado.TabIndex = 2;
            lblResultado.Text = "Resultado";
            // 
            // txtOp1
            // 
            txtOp1.Location = new Point(12, 27);
            txtOp1.Name = "txtOp1";
            txtOp1.Size = new Size(137, 23);
            txtOp1.TabIndex = 3;
            // 
            // txtOp2
            // 
            txtOp2.Location = new Point(12, 71);
            txtOp2.Name = "txtOp2";
            txtOp2.Size = new Size(137, 23);
            txtOp2.TabIndex = 4;
            // 
            // txtResult
            // 
            txtResult.Location = new Point(12, 115);
            txtResult.Name = "txtResult";
            txtResult.ReadOnly = true;
            txtResult.Size = new Size(137, 23);
            txtResult.TabIndex = 5;
            // 
            // btnSumar
            // 
            btnSumar.Location = new Point(171, 27);
            btnSumar.Name = "btnSumar";
            btnSumar.Size = new Size(75, 23);
            btnSumar.TabIndex = 6;
            btnSumar.Text = "Sumar";
            btnSumar.UseVisualStyleBackColor = true;
            btnSumar.Click += btnSumar_Click;
            // 
            // btnRestar
            // 
            btnRestar.Location = new Point(171, 56);
            btnRestar.Name = "btnRestar";
            btnRestar.Size = new Size(75, 23);
            btnRestar.TabIndex = 7;
            btnRestar.Text = "Restar";
            btnRestar.UseVisualStyleBackColor = true;
            btnRestar.Click += btnRestar_Click;
            // 
            // btnMultip
            // 
            btnMultip.Location = new Point(171, 85);
            btnMultip.Name = "btnMultip";
            btnMultip.Size = new Size(75, 23);
            btnMultip.TabIndex = 8;
            btnMultip.Text = "Multiplicar";
            btnMultip.UseVisualStyleBackColor = true;
            btnMultip.Click += btnMultip_Click;
            // 
            // btnDiv
            // 
            btnDiv.Location = new Point(171, 114);
            btnDiv.Name = "btnDiv";
            btnDiv.Size = new Size(75, 23);
            btnDiv.TabIndex = 9;
            btnDiv.Text = "Dividir";
            btnDiv.UseVisualStyleBackColor = true;
            btnDiv.Click += btnDiv_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(273, 158);
            Controls.Add(btnDiv);
            Controls.Add(btnMultip);
            Controls.Add(btnRestar);
            Controls.Add(btnSumar);
            Controls.Add(txtResult);
            Controls.Add(txtOp2);
            Controls.Add(txtOp1);
            Controls.Add(lblResultado);
            Controls.Add(lblOp2);
            Controls.Add(lblOp1);
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Calculadora";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblOp1;
        private Label lblOp2;
        private Label lblResultado;
        private TextBox txtOp1;
        private TextBox txtOp2;
        private TextBox txtResult;
        private Button btnSumar;
        private Button btnRestar;
        private Button btnMultip;
        private Button btnDiv;
    }
}
