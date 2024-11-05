namespace Ud2Hoja12
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
            listView1 = new ListView();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            lblElementos = new Label();
            lblSumatorio = new Label();
            lblMedia = new Label();
            lblMax = new Label();
            lblMin = new Label();
            txtNuevo = new TextBox();
            btnEliminar = new Button();
            btnOrdenar = new Button();
            btnAdd = new Button();
            SuspendLayout();
            // 
            // listView1
            // 
            listView1.BorderStyle = BorderStyle.FixedSingle;
            listView1.FullRowSelect = true;
            listView1.Location = new Point(12, 12);
            listView1.MultiSelect = false;
            listView1.Name = "listView1";
            listView1.Size = new Size(347, 224);
            listView1.TabIndex = 0;
            listView1.UseCompatibleStateImageBehavior = false;
            listView1.View = View.List;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(365, 12);
            label1.Name = "label1";
            label1.Size = new Size(125, 15);
            label1.TabIndex = 1;
            label1.Text = "Numero de elementos";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(365, 45);
            label2.Name = "label2";
            label2.Size = new Size(62, 15);
            label2.TabIndex = 2;
            label2.Text = "Sumatorio";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(365, 78);
            label3.Name = "label3";
            label3.Size = new Size(40, 15);
            label3.TabIndex = 3;
            label3.Text = "Media";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(365, 111);
            label4.Name = "label4";
            label4.Size = new Size(51, 15);
            label4.TabIndex = 4;
            label4.Text = "Maximo";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(367, 144);
            label5.Name = "label5";
            label5.Size = new Size(49, 15);
            label5.TabIndex = 5;
            label5.Text = "Minimo";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(367, 175);
            label6.Name = "label6";
            label6.Size = new Size(95, 15);
            label6.TabIndex = 6;
            label6.Text = "Nuevo elemento";
            // 
            // lblElementos
            // 
            lblElementos.BackColor = Color.White;
            lblElementos.BorderStyle = BorderStyle.FixedSingle;
            lblElementos.Location = new Point(512, 11);
            lblElementos.Name = "lblElementos";
            lblElementos.Size = new Size(200, 16);
            lblElementos.TabIndex = 7;
            // 
            // lblSumatorio
            // 
            lblSumatorio.BackColor = Color.White;
            lblSumatorio.BorderStyle = BorderStyle.FixedSingle;
            lblSumatorio.Location = new Point(512, 44);
            lblSumatorio.Name = "lblSumatorio";
            lblSumatorio.Size = new Size(200, 16);
            lblSumatorio.TabIndex = 8;
            // 
            // lblMedia
            // 
            lblMedia.BackColor = Color.White;
            lblMedia.BorderStyle = BorderStyle.FixedSingle;
            lblMedia.Location = new Point(512, 77);
            lblMedia.Name = "lblMedia";
            lblMedia.Size = new Size(200, 16);
            lblMedia.TabIndex = 9;
            // 
            // lblMax
            // 
            lblMax.BackColor = Color.White;
            lblMax.BorderStyle = BorderStyle.FixedSingle;
            lblMax.Location = new Point(512, 110);
            lblMax.Name = "lblMax";
            lblMax.Size = new Size(200, 16);
            lblMax.TabIndex = 10;
            // 
            // lblMin
            // 
            lblMin.BackColor = Color.White;
            lblMin.BorderStyle = BorderStyle.FixedSingle;
            lblMin.Location = new Point(512, 143);
            lblMin.Name = "lblMin";
            lblMin.Size = new Size(200, 16);
            lblMin.TabIndex = 11;
            // 
            // txtNuevo
            // 
            txtNuevo.Location = new Point(512, 172);
            txtNuevo.Name = "txtNuevo";
            txtNuevo.Size = new Size(117, 23);
            txtNuevo.TabIndex = 12;
            // 
            // btnEliminar
            // 
            btnEliminar.Location = new Point(512, 213);
            btnEliminar.Name = "btnEliminar";
            btnEliminar.Size = new Size(75, 23);
            btnEliminar.TabIndex = 13;
            btnEliminar.Text = "Eliminar";
            btnEliminar.UseVisualStyleBackColor = true;
            btnEliminar.Click += btnEliminar_Click;
            // 
            // btnOrdenar
            // 
            btnOrdenar.Location = new Point(637, 213);
            btnOrdenar.Name = "btnOrdenar";
            btnOrdenar.Size = new Size(75, 23);
            btnOrdenar.TabIndex = 14;
            btnOrdenar.Text = "Ordenar";
            btnOrdenar.UseVisualStyleBackColor = true;
            btnOrdenar.Click += btnOrdenar_Click;
            // 
            // btnAdd
            // 
            btnAdd.Location = new Point(637, 172);
            btnAdd.Name = "btnAdd";
            btnAdd.Size = new Size(75, 23);
            btnAdd.TabIndex = 15;
            btnAdd.Text = "Añadir";
            btnAdd.UseVisualStyleBackColor = true;
            btnAdd.Click += btnAdd_Click;
            // 
            // Form1
            // 
            AcceptButton = btnAdd;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(727, 245);
            Controls.Add(btnAdd);
            Controls.Add(btnOrdenar);
            Controls.Add(btnEliminar);
            Controls.Add(txtNuevo);
            Controls.Add(lblMin);
            Controls.Add(lblMax);
            Controls.Add(lblMedia);
            Controls.Add(lblSumatorio);
            Controls.Add(lblElementos);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(listView1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ListView listView1;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label lblElementos;
        private Label lblSumatorio;
        private Label lblMedia;
        private Label lblMax;
        private Label lblMin;
        private TextBox txtNuevo;
        private Button btnEliminar;
        private Button btnOrdenar;
        private Button btnAdd;
    }
}
