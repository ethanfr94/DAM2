﻿namespace Ud2Hoja7
{
    partial class Form2
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
            label3 = new Label();
            label4 = new Label();
            txtAficiones = new TextBox();
            label5 = new Label();
            button1 = new Button();
            button2 = new Button();
            lblNombre = new Label();
            lblSituacion = new Label();
            lblAficiones = new Label();
            lblSexo = new Label();
            lblFecha = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 39);
            label1.Name = "label1";
            label1.Size = new Size(51, 15);
            label1.TabIndex = 1;
            label1.Text = "Nombre";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 89);
            label2.Name = "label2";
            label2.Size = new Size(69, 15);
            label2.TabIndex = 2;
            label2.Text = "Nacimineto";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 134);
            label3.Name = "label3";
            label3.Size = new Size(32, 15);
            label3.TabIndex = 3;
            label3.Text = "Sexo";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(12, 180);
            label4.Name = "label4";
            label4.Size = new Size(56, 15);
            label4.TabIndex = 4;
            label4.Text = "Aficiones";
            // 
            // txtAficiones
            // 
            txtAficiones.BackColor = Color.White;
            txtAficiones.Location = new Point(99, 225);
            txtAficiones.Multiline = true;
            txtAficiones.Name = "txtAficiones";
            txtAficiones.ReadOnly = true;
            txtAficiones.Size = new Size(309, 146);
            txtAficiones.TabIndex = 5;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(12, 406);
            label5.Name = "label5";
            label5.Size = new Size(56, 15);
            label5.TabIndex = 6;
            label5.Text = "Situacion";
            // 
            // button1
            // 
            button1.Location = new Point(333, 466);
            button1.Name = "button1";
            button1.Size = new Size(75, 23);
            button1.TabIndex = 7;
            button1.Text = "Confirmar";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(241, 466);
            button2.Name = "button2";
            button2.Size = new Size(75, 23);
            button2.TabIndex = 8;
            button2.Text = "Cerrar";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // lblNombre
            // 
            lblNombre.BackColor = Color.White;
            lblNombre.BorderStyle = BorderStyle.FixedSingle;
            lblNombre.Location = new Point(99, 38);
            lblNombre.Name = "lblNombre";
            lblNombre.Size = new Size(309, 17);
            lblNombre.TabIndex = 9;
            // 
            // lblSituacion
            // 
            lblSituacion.BackColor = Color.White;
            lblSituacion.BorderStyle = BorderStyle.FixedSingle;
            lblSituacion.Location = new Point(99, 405);
            lblSituacion.Name = "lblSituacion";
            lblSituacion.Size = new Size(309, 17);
            lblSituacion.TabIndex = 10;
            // 
            // lblAficiones
            // 
            lblAficiones.BackColor = Color.White;
            lblAficiones.BorderStyle = BorderStyle.FixedSingle;
            lblAficiones.Location = new Point(99, 179);
            lblAficiones.Name = "lblAficiones";
            lblAficiones.Size = new Size(309, 17);
            lblAficiones.TabIndex = 11;
            // 
            // lblSexo
            // 
            lblSexo.BackColor = Color.White;
            lblSexo.BorderStyle = BorderStyle.FixedSingle;
            lblSexo.Location = new Point(99, 133);
            lblSexo.Name = "lblSexo";
            lblSexo.Size = new Size(309, 17);
            lblSexo.TabIndex = 12;
            // 
            // lblFecha
            // 
            lblFecha.BackColor = Color.White;
            lblFecha.BorderStyle = BorderStyle.FixedSingle;
            lblFecha.Location = new Point(99, 88);
            lblFecha.Name = "lblFecha";
            lblFecha.Size = new Size(309, 17);
            lblFecha.TabIndex = 13;
            // 
            // Form2
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(428, 513);
            Controls.Add(lblFecha);
            Controls.Add(lblSexo);
            Controls.Add(lblAficiones);
            Controls.Add(lblSituacion);
            Controls.Add(lblNombre);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(label5);
            Controls.Add(txtAficiones);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "Form2";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Resumen";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox txtAficiones;
        private Label label5;
        private Button button1;
        private Button button2;
        private Label label6;
        private Label label7;
        private Label label8;
        private Label label9;
        private Label label10;
        private Label lblNombre;
        private Label lblFecha;
        private Label lblSexo;
        private Label lblAficiones;
        private Label lblSituacion;
    }
}