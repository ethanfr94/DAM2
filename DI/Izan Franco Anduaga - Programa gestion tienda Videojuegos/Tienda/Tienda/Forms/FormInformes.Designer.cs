namespace Tienda
{
    partial class FormInformes
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormInformes));
            this.btnVideojuegos = new System.Windows.Forms.Button();
            this.btnEstudios = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnVideojuegos
            // 
            this.btnVideojuegos.Location = new System.Drawing.Point(87, 60);
            this.btnVideojuegos.Name = "btnVideojuegos";
            this.btnVideojuegos.Size = new System.Drawing.Size(96, 51);
            this.btnVideojuegos.TabIndex = 0;
            this.btnVideojuegos.Text = "Videojuegos";
            this.btnVideojuegos.UseVisualStyleBackColor = true;
            this.btnVideojuegos.Click += new System.EventHandler(this.btnVideojuegos_Click);
            // 
            // btnEstudios
            // 
            this.btnEstudios.Location = new System.Drawing.Point(87, 117);
            this.btnEstudios.Name = "btnEstudios";
            this.btnEstudios.Size = new System.Drawing.Size(96, 51);
            this.btnEstudios.TabIndex = 1;
            this.btnEstudios.Text = "Estudios";
            this.btnEstudios.UseVisualStyleBackColor = true;
            this.btnEstudios.Click += new System.EventHandler(this.btnEstudios_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(28, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(221, 25);
            this.label1.TabIndex = 2;
            this.label1.Text = "Seleccionar informe";
            // 
            // FormInformes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(274, 183);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnEstudios);
            this.Controls.Add(this.btnVideojuegos);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "FormInformes";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Video Game Store S.L.";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnVideojuegos;
        private System.Windows.Forms.Button btnEstudios;
        private System.Windows.Forms.Label label1;
    }
}