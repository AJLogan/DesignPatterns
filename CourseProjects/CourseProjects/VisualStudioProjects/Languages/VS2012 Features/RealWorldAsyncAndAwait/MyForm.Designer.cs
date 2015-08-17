namespace RealWorldAsyncAndAwait
{
    partial class MyForm
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
            this.btLoadStories = new System.Windows.Forms.Button();
            this.lbDisplayStories = new System.Windows.Forms.ListBox();
            this.lbDebugInfo = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // btLoadStories
            // 
            this.btLoadStories.Location = new System.Drawing.Point(13, 13);
            this.btLoadStories.Name = "btLoadStories";
            this.btLoadStories.Size = new System.Drawing.Size(298, 23);
            this.btLoadStories.TabIndex = 0;
            this.btLoadStories.Text = "Load Story Titles From BBC";
            this.btLoadStories.UseVisualStyleBackColor = true;
            this.btLoadStories.Click += new System.EventHandler(this.btLoadStories_Click);
            // 
            // lbDisplayStories
            // 
            this.lbDisplayStories.FormattingEnabled = true;
            this.lbDisplayStories.Location = new System.Drawing.Point(13, 42);
            this.lbDisplayStories.Name = "lbDisplayStories";
            this.lbDisplayStories.Size = new System.Drawing.Size(298, 121);
            this.lbDisplayStories.TabIndex = 1;
            // 
            // lbDebugInfo
            // 
            this.lbDebugInfo.FormattingEnabled = true;
            this.lbDebugInfo.Location = new System.Drawing.Point(13, 170);
            this.lbDebugInfo.Name = "lbDebugInfo";
            this.lbDebugInfo.Size = new System.Drawing.Size(298, 95);
            this.lbDebugInfo.TabIndex = 2;
            // 
            // MyForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(323, 280);
            this.Controls.Add(this.lbDebugInfo);
            this.Controls.Add(this.lbDisplayStories);
            this.Controls.Add(this.btLoadStories);
            this.Name = "MyForm";
            this.Text = "Async / Await Demo";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btLoadStories;
        private System.Windows.Forms.ListBox lbDisplayStories;
        private System.Windows.Forms.ListBox lbDebugInfo;
    }
}

