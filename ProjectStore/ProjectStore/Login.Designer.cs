namespace ProjectStore
{
    partial class Login
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
            lblTitle = new Label();
            lblDescription = new Label();
            btnLogin = new Button();
            lblEmail = new Label();
            lblPassword = new Label();
            txtEmail = new TextBox();
            txtPassword = new TextBox();
            lblHelpDescription = new Label();
            lblHelpTitle = new Label();
            llbContact = new LinkLabel();
            SuspendLayout();
            // 
            // lblTitle
            // 
            lblTitle.AutoSize = true;
            lblTitle.Font = new Font("Segoe UI", 10F, FontStyle.Bold);
            lblTitle.Location = new Point(26, 22);
            lblTitle.Name = "lblTitle";
            lblTitle.Size = new Size(113, 19);
            lblTitle.TabIndex = 0;
            lblTitle.Text = "Inicio de Sesión";
            // 
            // lblDescription
            // 
            lblDescription.AutoSize = true;
            lblDescription.Location = new Point(26, 48);
            lblDescription.Name = "lblDescription";
            lblDescription.Size = new Size(297, 30);
            lblDescription.TabIndex = 1;
            lblDescription.Text = "Por favor, ingrese sus credenciales para iniciar sesión\r\ny acceder a la gestión de los proyectos de sus alumnos.";
            // 
            // btnLogin
            // 
            btnLogin.Location = new Point(192, 165);
            btnLogin.Name = "btnLogin";
            btnLogin.Size = new Size(90, 23);
            btnLogin.TabIndex = 3;
            btnLogin.Text = "Iniciar Sesión";
            btnLogin.UseVisualStyleBackColor = true;
            btnLogin.Click += OnClickLogin;
            // 
            // lblEmail
            // 
            lblEmail.AutoSize = true;
            lblEmail.Location = new Point(26, 100);
            lblEmail.Name = "lblEmail";
            lblEmail.Size = new Size(44, 15);
            lblEmail.TabIndex = 3;
            lblEmail.Text = "E-Mail:";
            // 
            // lblPassword
            // 
            lblPassword.AutoSize = true;
            lblPassword.Location = new Point(26, 134);
            lblPassword.Name = "lblPassword";
            lblPassword.Size = new Size(70, 15);
            lblPassword.TabIndex = 4;
            lblPassword.Text = "Contraseña:";
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(102, 97);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(180, 23);
            txtEmail.TabIndex = 1;
            // 
            // txtPassword
            // 
            txtPassword.Location = new Point(102, 131);
            txtPassword.Name = "txtPassword";
            txtPassword.Size = new Size(180, 23);
            txtPassword.TabIndex = 2;
            txtPassword.UseSystemPasswordChar = true;
            // 
            // lblHelpDescription
            // 
            lblHelpDescription.AutoSize = true;
            lblHelpDescription.Location = new Point(26, 240);
            lblHelpDescription.Name = "lblHelpDescription";
            lblHelpDescription.Size = new Size(166, 15);
            lblHelpDescription.TabIndex = 7;
            lblHelpDescription.Text = "Contacte con soporte técnico:";
            // 
            // lblHelpTitle
            // 
            lblHelpTitle.AutoSize = true;
            lblHelpTitle.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblHelpTitle.Location = new Point(26, 220);
            lblHelpTitle.Name = "lblHelpTitle";
            lblHelpTitle.Size = new Size(100, 15);
            lblHelpTitle.TabIndex = 8;
            lblHelpTitle.Text = "¿Necesita ayuda?";
            // 
            // llbContact
            // 
            llbContact.AutoSize = true;
            llbContact.Location = new Point(26, 255);
            llbContact.Name = "llbContact";
            llbContact.Size = new Size(148, 15);
            llbContact.TabIndex = 4;
            llbContact.TabStop = true;
            llbContact.Text = "soporte@projectstore.com";
            llbContact.LinkClicked += OnClickLink;
            // 
            // Login
            // 
            AcceptButton = btnLogin;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(348, 295);
            Controls.Add(llbContact);
            Controls.Add(lblHelpTitle);
            Controls.Add(lblHelpDescription);
            Controls.Add(txtPassword);
            Controls.Add(txtEmail);
            Controls.Add(lblPassword);
            Controls.Add(lblEmail);
            Controls.Add(btnLogin);
            Controls.Add(lblDescription);
            Controls.Add(lblTitle);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            Name = "Login";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "ProjectStore | Login";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblTitle;
        private Label lblDescription;
        private Button btnLogin;
        private Label lblEmail;
        private Label lblPassword;
        private TextBox txtEmail;
        private TextBox txtPassword;
        private Label lblHelpDescription;
        private Label lblHelpTitle;
        private LinkLabel llbContact;
    }
}
