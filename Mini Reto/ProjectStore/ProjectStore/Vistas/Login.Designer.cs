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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Login));
            lblTitle = new Label();
            btnLogin = new Button();
            lblEmail = new Label();
            lblPassword = new Label();
            txtEmail = new TextBox();
            txtPassword = new TextBox();
            llbForget = new LinkLabel();
            picProject = new PictureBox();
            lblDescription = new Label();
            ((System.ComponentModel.ISupportInitialize)picProject).BeginInit();
            SuspendLayout();
            // 
            // lblTitle
            // 
            lblTitle.AutoSize = true;
            lblTitle.Font = new Font("Segoe UI", 14.25F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblTitle.Location = new Point(405, 69);
            lblTitle.Name = "lblTitle";
            lblTitle.Size = new Size(151, 25);
            lblTitle.TabIndex = 0;
            lblTitle.Text = "Inicio de Sesión";
            // 
            // btnLogin
            // 
            btnLogin.BackColor = Color.DodgerBlue;
            btnLogin.Font = new Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnLogin.ForeColor = Color.White;
            btnLogin.Location = new Point(582, 278);
            btnLogin.Name = "btnLogin";
            btnLogin.Size = new Size(80, 26);
            btnLogin.TabIndex = 3;
            btnLogin.Text = "Login";
            btnLogin.UseVisualStyleBackColor = false;
            btnLogin.Click += OnClickLogin;
            // 
            // lblEmail
            // 
            lblEmail.AutoSize = true;
            lblEmail.Font = new Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblEmail.Location = new Point(405, 151);
            lblEmail.Name = "lblEmail";
            lblEmail.Size = new Size(104, 15);
            lblEmail.TabIndex = 3;
            lblEmail.Text = "Correo Electrónico";
            // 
            // lblPassword
            // 
            lblPassword.AutoSize = true;
            lblPassword.BackColor = Color.Transparent;
            lblPassword.Font = new Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblPassword.Location = new Point(405, 217);
            lblPassword.Name = "lblPassword";
            lblPassword.Size = new Size(66, 15);
            lblPassword.TabIndex = 4;
            lblPassword.Text = "Contraseña";
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(405, 169);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(257, 23);
            txtEmail.TabIndex = 1;
            // 
            // txtPassword
            // 
            txtPassword.Location = new Point(405, 235);
            txtPassword.Name = "txtPassword";
            txtPassword.Size = new Size(257, 23);
            txtPassword.TabIndex = 2;
            txtPassword.UseSystemPasswordChar = true;
            // 
            // llbForget
            // 
            llbForget.AutoSize = true;
            llbForget.Font = new Font("Segoe UI Semibold", 9F, FontStyle.Bold | FontStyle.Italic, GraphicsUnit.Point, 0);
            llbForget.LinkColor = Color.SteelBlue;
            llbForget.Location = new Point(405, 284);
            llbForget.Name = "llbForget";
            llbForget.Size = new Size(161, 15);
            llbForget.TabIndex = 4;
            llbForget.TabStop = true;
            llbForget.Text = "¿Ha olvidado su contraseña?";
            llbForget.LinkClicked += OnClickForget;
            // 
            // picProject
            // 
            picProject.BackColor = Color.LightGray;
            picProject.Dock = DockStyle.Left;
            picProject.Image = (Image)resources.GetObject("picProject.Image");
            picProject.Location = new Point(0, 0);
            picProject.Name = "picProject";
            picProject.Size = new Size(381, 381);
            picProject.SizeMode = PictureBoxSizeMode.CenterImage;
            picProject.TabIndex = 9;
            picProject.TabStop = false;
            // 
            // lblDescription
            // 
            lblDescription.AutoSize = true;
            lblDescription.Location = new Point(405, 99);
            lblDescription.Name = "lblDescription";
            lblDescription.Size = new Size(257, 30);
            lblDescription.TabIndex = 11;
            lblDescription.Text = "Por favor, ingrese sus credenciales para acceder\r\na la gestión de los proyectos.";
            // 
            // Login
            // 
            AcceptButton = btnLogin;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.LightGray;
            ClientSize = new Size(704, 381);
            Controls.Add(picProject);
            Controls.Add(lblDescription);
            Controls.Add(llbForget);
            Controls.Add(txtPassword);
            Controls.Add(txtEmail);
            Controls.Add(lblPassword);
            Controls.Add(lblEmail);
            Controls.Add(btnLogin);
            Controls.Add(lblTitle);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            Icon = (Icon)resources.GetObject("$this.Icon");
            MaximizeBox = false;
            Name = "Login";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "ProjectStore | Login";
            ((System.ComponentModel.ISupportInitialize)picProject).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblTitle;
        private Button btnLogin;
        private Label lblEmail;
        private Label lblPassword;
        private TextBox txtEmail;
        private TextBox txtPassword;
        private LinkLabel llbForget;
        private PictureBox picProject;
        private Label lblDescription;
    }
}
