namespace Ud2Hoja9
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
            rdoAceptar = new RadioButton();
            rdoAcepCanc = new RadioButton();
            rdoAbReintIgn = new RadioButton();
            rdoSiNoCanc = new RadioButton();
            rdoSiNo = new RadioButton();
            rdoReintCanc = new RadioButton();
            groupBox1 = new GroupBox();
            groupBox2 = new GroupBox();
            rdoAlto = new RadioButton();
            rdoAviso = new RadioButton();
            rdoInfo = new RadioButton();
            rdoPregunta = new RadioButton();
            rdoMano = new RadioButton();
            rdoError = new RadioButton();
            rdoExclamacion = new RadioButton();
            rdoAsterisco = new RadioButton();
            label1 = new Label();
            label2 = new Label();
            txtTitulo = new TextBox();
            txtMsg = new TextBox();
            lblRes = new Label();
            btnMostrar = new Button();
            groupBox2.SuspendLayout();
            SuspendLayout();
            // 
            // rdoAceptar
            // 
            rdoAceptar.AutoSize = true;
            rdoAceptar.Location = new Point(20, 34);
            rdoAceptar.Name = "rdoAceptar";
            rdoAceptar.Size = new Size(66, 19);
            rdoAceptar.TabIndex = 1;
            rdoAceptar.Text = "Aceptar";
            rdoAceptar.UseVisualStyleBackColor = true;
            rdoAceptar.Click += botones_chekedChanged;
            // 
            // rdoAcepCanc
            // 
            rdoAcepCanc.AutoSize = true;
            rdoAcepCanc.Location = new Point(20, 59);
            rdoAcepCanc.Name = "rdoAcepCanc";
            rdoAcepCanc.Size = new Size(117, 19);
            rdoAcepCanc.TabIndex = 2;
            rdoAcepCanc.Text = "Aceptar/Cancelar";
            rdoAcepCanc.UseVisualStyleBackColor = true;
            rdoAcepCanc.Click += botones_chekedChanged;
            // 
            // rdoAbReintIgn
            // 
            rdoAbReintIgn.AutoSize = true;
            rdoAbReintIgn.Location = new Point(20, 84);
            rdoAbReintIgn.Name = "rdoAbReintIgn";
            rdoAbReintIgn.Size = new Size(167, 19);
            rdoAbReintIgn.TabIndex = 3;
            rdoAbReintIgn.Text = "Abortar/Reintentar/Ignorar";
            rdoAbReintIgn.UseVisualStyleBackColor = true;
            rdoAbReintIgn.Click += botones_chekedChanged;
            // 
            // rdoSiNoCanc
            // 
            rdoSiNoCanc.AutoSize = true;
            rdoSiNoCanc.Location = new Point(20, 109);
            rdoSiNoCanc.Name = "rdoSiNoCanc";
            rdoSiNoCanc.Size = new Size(102, 19);
            rdoSiNoCanc.TabIndex = 4;
            rdoSiNoCanc.Text = "Si/No/Cancela";
            rdoSiNoCanc.UseVisualStyleBackColor = true;
            rdoSiNoCanc.Click += botones_chekedChanged;
            // 
            // rdoSiNo
            // 
            rdoSiNo.AutoSize = true;
            rdoSiNo.Location = new Point(20, 134);
            rdoSiNo.Name = "rdoSiNo";
            rdoSiNo.Size = new Size(55, 19);
            rdoSiNo.TabIndex = 5;
            rdoSiNo.Text = "Si/No";
            rdoSiNo.UseVisualStyleBackColor = true;
            rdoSiNo.Click += botones_chekedChanged;
            // 
            // rdoReintCanc
            // 
            rdoReintCanc.AutoSize = true;
            rdoReintCanc.Location = new Point(20, 159);
            rdoReintCanc.Name = "rdoReintCanc";
            rdoReintCanc.Size = new Size(130, 19);
            rdoReintCanc.TabIndex = 6;
            rdoReintCanc.Text = "Reintentar/Cancelar";
            rdoReintCanc.UseVisualStyleBackColor = true;
            rdoReintCanc.Click += botones_chekedChanged;
            // 
            // groupBox1
            // 
            groupBox1.Location = new Point(12, 12);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(192, 234);
            groupBox1.TabIndex = 7;
            groupBox1.TabStop = false;
            groupBox1.Text = "groupBox1";
            // 
            // groupBox2
            // 
            groupBox2.Controls.Add(rdoAlto);
            groupBox2.Controls.Add(rdoAviso);
            groupBox2.Controls.Add(rdoInfo);
            groupBox2.Controls.Add(rdoPregunta);
            groupBox2.Controls.Add(rdoMano);
            groupBox2.Controls.Add(rdoError);
            groupBox2.Controls.Add(rdoExclamacion);
            groupBox2.Controls.Add(rdoAsterisco);
            groupBox2.Location = new Point(249, 12);
            groupBox2.Name = "groupBox2";
            groupBox2.Size = new Size(192, 234);
            groupBox2.TabIndex = 8;
            groupBox2.TabStop = false;
            groupBox2.Text = "Iconos";
            // 
            // rdoAlto
            // 
            rdoAlto.AutoSize = true;
            rdoAlto.Location = new Point(16, 172);
            rdoAlto.Name = "rdoAlto";
            rdoAlto.Size = new Size(47, 19);
            rdoAlto.TabIndex = 9;
            rdoAlto.Text = "Alto";
            rdoAlto.UseVisualStyleBackColor = true;
            rdoAlto.Click += Iconos_checkedChange;
            // 
            // rdoAviso
            // 
            rdoAviso.Location = new Point(16, 197);
            rdoAviso.Name = "rdoAviso";
            rdoAviso.Size = new Size(88, 19);
            rdoAviso.TabIndex = 8;
            rdoAviso.Text = "Advertencia";
            rdoAviso.UseVisualStyleBackColor = true;
            rdoAviso.Click += Iconos_checkedChange;
            // 
            // rdoInfo
            // 
            rdoInfo.AutoSize = true;
            rdoInfo.Location = new Point(16, 122);
            rdoInfo.Name = "rdoInfo";
            rdoInfo.Size = new Size(90, 19);
            rdoInfo.TabIndex = 7;
            rdoInfo.Text = "Informacion";
            rdoInfo.UseVisualStyleBackColor = true;
            rdoInfo.Click += Iconos_checkedChange;
            // 
            // rdoPregunta
            // 
            rdoPregunta.AutoSize = true;
            rdoPregunta.Location = new Point(16, 147);
            rdoPregunta.Name = "rdoPregunta";
            rdoPregunta.Size = new Size(73, 19);
            rdoPregunta.TabIndex = 6;
            rdoPregunta.Text = "Pregunta";
            rdoPregunta.UseVisualStyleBackColor = true;
            rdoPregunta.Click += Iconos_checkedChange;
            // 
            // rdoMano
            // 
            rdoMano.AutoSize = true;
            rdoMano.Location = new Point(16, 97);
            rdoMano.Name = "rdoMano";
            rdoMano.Size = new Size(56, 19);
            rdoMano.TabIndex = 5;
            rdoMano.Text = "Mano";
            rdoMano.UseVisualStyleBackColor = true;
            rdoMano.Click += Iconos_checkedChange;
            // 
            // rdoError
            // 
            rdoError.AutoSize = true;
            rdoError.Location = new Point(16, 47);
            rdoError.Name = "rdoError";
            rdoError.Size = new Size(50, 19);
            rdoError.TabIndex = 4;
            rdoError.Text = "Error";
            rdoError.UseVisualStyleBackColor = true;
            rdoError.Click += Iconos_checkedChange;
            // 
            // rdoExclamacion
            // 
            rdoExclamacion.AutoSize = true;
            rdoExclamacion.Location = new Point(16, 72);
            rdoExclamacion.Name = "rdoExclamacion";
            rdoExclamacion.Size = new Size(92, 19);
            rdoExclamacion.TabIndex = 3;
            rdoExclamacion.Text = "Exclamacion";
            rdoExclamacion.UseVisualStyleBackColor = true;
            rdoExclamacion.Click += Iconos_checkedChange;
            // 
            // rdoAsterisco
            // 
            rdoAsterisco.AutoSize = true;
            rdoAsterisco.Location = new Point(16, 22);
            rdoAsterisco.Name = "rdoAsterisco";
            rdoAsterisco.Size = new Size(73, 19);
            rdoAsterisco.TabIndex = 2;
            rdoAsterisco.Text = "Asterisco";
            rdoAsterisco.UseVisualStyleBackColor = true;
            rdoAsterisco.Click += Iconos_checkedChange;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(14, 286);
            label1.Name = "label1";
            label1.Size = new Size(37, 15);
            label1.TabIndex = 9;
            label1.Text = "TItulo";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(14, 315);
            label2.Name = "label2";
            label2.Size = new Size(51, 15);
            label2.TabIndex = 10;
            label2.Text = "Mensaje";
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(111, 278);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(330, 23);
            txtTitulo.TabIndex = 11;
            // 
            // txtMsg
            // 
            txtMsg.Location = new Point(111, 312);
            txtMsg.Name = "txtMsg";
            txtMsg.Size = new Size(330, 23);
            txtMsg.TabIndex = 12;
            // 
            // lblRes
            // 
            lblRes.AutoSize = true;
            lblRes.Location = new Point(12, 355);
            lblRes.Name = "lblRes";
            lblRes.Size = new Size(106, 15);
            lblRes.TabIndex = 13;
            lblRes.Text = "Resultado Mensaje";
            // 
            // btnMostrar
            // 
            btnMostrar.Location = new Point(366, 351);
            btnMostrar.Name = "btnMostrar";
            btnMostrar.Size = new Size(75, 23);
            btnMostrar.TabIndex = 14;
            btnMostrar.Text = "Mostrar";
            btnMostrar.UseVisualStyleBackColor = true;
            btnMostrar.Click += btnMostrar_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            AutoSize = true;
            ClientSize = new Size(452, 382);
            Controls.Add(btnMostrar);
            Controls.Add(lblRes);
            Controls.Add(txtMsg);
            Controls.Add(txtTitulo);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(groupBox2);
            Controls.Add(rdoReintCanc);
            Controls.Add(rdoSiNo);
            Controls.Add(rdoSiNoCanc);
            Controls.Add(rdoAbReintIgn);
            Controls.Add(rdoAcepCanc);
            Controls.Add(rdoAceptar);
            Controls.Add(groupBox1);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Radio butons y cajas de mensaje";
            groupBox2.ResumeLayout(false);
            groupBox2.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private RadioButton rdoAceptar;
        private RadioButton rdoAcepCanc;
        private RadioButton rdoAbReintIgn;
        private RadioButton rdoSiNoCanc;
        private RadioButton rdoSiNo;
        private RadioButton rdoReintCanc;
        private GroupBox groupBox1;
        private GroupBox groupBox2;
        private RadioButton rdoAlto;
        private RadioButton rdoAviso;
        private RadioButton rdoInfo;
        private RadioButton rdoPregunta;
        private RadioButton rdoMano;
        private RadioButton rdoError;
        private RadioButton rdoExclamacion;
        private RadioButton rdoAsterisco;
        private Label label1;
        private Label label2;
        private TextBox txtTitulo;
        private TextBox txtMsg;
        private Label lblRes;
        private Button btnMostrar;
    }
}
