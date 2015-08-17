using System;
using System.IO;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace MockGenerator
{
	/// <summary>
	/// Summary description for MainForm.
	/// </summary>
	public class MainForm : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Button loadAssemblyButton;
		private System.Windows.Forms.OpenFileDialog openFileDialog;
		private System.Windows.Forms.ComboBox chooseClassBox;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.TextBox newNameBox;
		private System.Windows.Forms.GroupBox groupBox2;
		private System.Windows.Forms.RadioButton vbButton;
		private System.Windows.Forms.RadioButton csButton;
		private System.Windows.Forms.GroupBox groupBox3;
		private System.Windows.Forms.CheckBox wasCalledCheckBox;
		private System.Windows.Forms.CheckBox callLogCheckBox;
		private System.Windows.Forms.CheckBox returnValuesCheckBox;
		private System.Windows.Forms.Button createMockButton;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.CheckBox useOriginalNameCheckBox;
		private System.Windows.Forms.SaveFileDialog saveFileDialog;
		private System.Windows.Forms.CheckBox valuesConstructorCheckBox;
		private System.Windows.Forms.CheckBox crashTestDummyCheckBox;

		private Generator generator;

		public MainForm()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.loadAssemblyButton = new System.Windows.Forms.Button();
			this.openFileDialog = new System.Windows.Forms.OpenFileDialog();
			this.chooseClassBox = new System.Windows.Forms.ComboBox();
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.newNameBox = new System.Windows.Forms.TextBox();
			this.useOriginalNameCheckBox = new System.Windows.Forms.CheckBox();
			this.groupBox2 = new System.Windows.Forms.GroupBox();
			this.csButton = new System.Windows.Forms.RadioButton();
			this.vbButton = new System.Windows.Forms.RadioButton();
			this.groupBox3 = new System.Windows.Forms.GroupBox();
			this.valuesConstructorCheckBox = new System.Windows.Forms.CheckBox();
			this.callLogCheckBox = new System.Windows.Forms.CheckBox();
			this.wasCalledCheckBox = new System.Windows.Forms.CheckBox();
			this.returnValuesCheckBox = new System.Windows.Forms.CheckBox();
			this.createMockButton = new System.Windows.Forms.Button();
			this.saveFileDialog = new System.Windows.Forms.SaveFileDialog();
			this.crashTestDummyCheckBox = new System.Windows.Forms.CheckBox();
			this.groupBox1.SuspendLayout();
			this.groupBox2.SuspendLayout();
			this.groupBox3.SuspendLayout();
			this.SuspendLayout();
			// 
			// loadAssemblyButton
			// 
			this.loadAssemblyButton.Location = new System.Drawing.Point(24, 16);
			this.loadAssemblyButton.Name = "loadAssemblyButton";
			this.loadAssemblyButton.Size = new System.Drawing.Size(112, 24);
			this.loadAssemblyButton.TabIndex = 0;
			this.loadAssemblyButton.Text = "Load Assembly";
			this.loadAssemblyButton.Click += new System.EventHandler(this.loadAssemblyButton_Click);
			// 
			// chooseClassBox
			// 
			this.chooseClassBox.Enabled = false;
			this.chooseClassBox.Location = new System.Drawing.Point(24, 56);
			this.chooseClassBox.Name = "chooseClassBox";
			this.chooseClassBox.Size = new System.Drawing.Size(240, 21);
			this.chooseClassBox.TabIndex = 1;
			this.chooseClassBox.SelectedIndexChanged += new System.EventHandler(this.chooseClassBox_SelectedIndexChanged);
			// 
			// groupBox1
			// 
			this.groupBox1.Controls.Add(this.newNameBox);
			this.groupBox1.Controls.Add(this.useOriginalNameCheckBox);
			this.groupBox1.Location = new System.Drawing.Point(24, 96);
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.Size = new System.Drawing.Size(240, 80);
			this.groupBox1.TabIndex = 2;
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = "Name of Mock Class";
			// 
			// newNameBox
			// 
			this.newNameBox.Enabled = false;
			this.newNameBox.Location = new System.Drawing.Point(16, 48);
			this.newNameBox.Name = "newNameBox";
			this.newNameBox.Size = new System.Drawing.Size(208, 20);
			this.newNameBox.TabIndex = 1;
			this.newNameBox.Text = "";
			// 
			// useOriginalNameCheckBox
			// 
			this.useOriginalNameCheckBox.Checked = true;
			this.useOriginalNameCheckBox.CheckState = System.Windows.Forms.CheckState.Checked;
			this.useOriginalNameCheckBox.Location = new System.Drawing.Point(16, 24);
			this.useOriginalNameCheckBox.Name = "useOriginalNameCheckBox";
			this.useOriginalNameCheckBox.Size = new System.Drawing.Size(152, 16);
			this.useOriginalNameCheckBox.TabIndex = 0;
			this.useOriginalNameCheckBox.Text = "Use Name of Original";
			this.useOriginalNameCheckBox.CheckedChanged += new System.EventHandler(this.useOriginalNameCheckBox_CheckedChanged);
			// 
			// groupBox2
			// 
			this.groupBox2.Controls.Add(this.csButton);
			this.groupBox2.Controls.Add(this.vbButton);
			this.groupBox2.Location = new System.Drawing.Point(24, 192);
			this.groupBox2.Name = "groupBox2";
			this.groupBox2.Size = new System.Drawing.Size(184, 56);
			this.groupBox2.TabIndex = 3;
			this.groupBox2.TabStop = false;
			this.groupBox2.Text = "Code Generation Language";
			// 
			// csButton
			// 
			this.csButton.Checked = true;
			this.csButton.Location = new System.Drawing.Point(16, 24);
			this.csButton.Name = "csButton";
			this.csButton.Size = new System.Drawing.Size(48, 16);
			this.csButton.TabIndex = 1;
			this.csButton.TabStop = true;
			this.csButton.Text = "C#";
			// 
			// vbButton
			// 
			this.vbButton.Location = new System.Drawing.Point(80, 24);
			this.vbButton.Name = "vbButton";
			this.vbButton.Size = new System.Drawing.Size(72, 16);
			this.vbButton.TabIndex = 0;
			this.vbButton.Text = "VB .NET";
			// 
			// groupBox3
			// 
			this.groupBox3.Controls.Add(this.crashTestDummyCheckBox);
			this.groupBox3.Controls.Add(this.valuesConstructorCheckBox);
			this.groupBox3.Controls.Add(this.callLogCheckBox);
			this.groupBox3.Controls.Add(this.wasCalledCheckBox);
			this.groupBox3.Controls.Add(this.returnValuesCheckBox);
			this.groupBox3.Location = new System.Drawing.Point(24, 264);
			this.groupBox3.Name = "groupBox3";
			this.groupBox3.Size = new System.Drawing.Size(240, 136);
			this.groupBox3.TabIndex = 4;
			this.groupBox3.TabStop = false;
			this.groupBox3.Text = "Code Generation Options";
			// 
			// valuesConstructorCheckBox
			// 
			this.valuesConstructorCheckBox.Enabled = false;
			this.valuesConstructorCheckBox.Location = new System.Drawing.Point(16, 104);
			this.valuesConstructorCheckBox.Name = "valuesConstructorCheckBox";
			this.valuesConstructorCheckBox.Size = new System.Drawing.Size(208, 16);
			this.valuesConstructorCheckBox.TabIndex = 6;
			this.valuesConstructorCheckBox.Text = "Add constructor to set return values";
			// 
			// callLogCheckBox
			// 
			this.callLogCheckBox.Checked = true;
			this.callLogCheckBox.CheckState = System.Windows.Forms.CheckState.Checked;
			this.callLogCheckBox.Location = new System.Drawing.Point(16, 64);
			this.callLogCheckBox.Name = "callLogCheckBox";
			this.callLogCheckBox.Size = new System.Drawing.Size(176, 16);
			this.callLogCheckBox.TabIndex = 1;
			this.callLogCheckBox.Text = "Add \'CallLog\' StringBuilder";
			// 
			// wasCalledCheckBox
			// 
			this.wasCalledCheckBox.Checked = true;
			this.wasCalledCheckBox.CheckState = System.Windows.Forms.CheckState.Checked;
			this.wasCalledCheckBox.Location = new System.Drawing.Point(16, 40);
			this.wasCalledCheckBox.Name = "wasCalledCheckBox";
			this.wasCalledCheckBox.Size = new System.Drawing.Size(184, 24);
			this.wasCalledCheckBox.TabIndex = 0;
			this.wasCalledCheckBox.Text = "Add Boolean \'WasCalled\' fields";
			// 
			// returnValuesCheckBox
			// 
			this.returnValuesCheckBox.Checked = true;
			this.returnValuesCheckBox.CheckState = System.Windows.Forms.CheckState.Checked;
			this.returnValuesCheckBox.Enabled = false;
			this.returnValuesCheckBox.Location = new System.Drawing.Point(16, 80);
			this.returnValuesCheckBox.Name = "returnValuesCheckBox";
			this.returnValuesCheckBox.Size = new System.Drawing.Size(168, 24);
			this.returnValuesCheckBox.TabIndex = 5;
			this.returnValuesCheckBox.Text = "Use default return values";
			// 
			// createMockButton
			// 
			this.createMockButton.Enabled = false;
			this.createMockButton.Location = new System.Drawing.Point(152, 16);
			this.createMockButton.Name = "createMockButton";
			this.createMockButton.Size = new System.Drawing.Size(112, 24);
			this.createMockButton.TabIndex = 5;
			this.createMockButton.Text = "Create Mock";
			this.createMockButton.Click += new System.EventHandler(this.createMockButton_Click);
			// 
			// crashTestDummyCheckBox
			// 
			this.crashTestDummyCheckBox.Location = new System.Drawing.Point(16, 24);
			this.crashTestDummyCheckBox.Name = "crashTestDummyCheckBox";
			this.crashTestDummyCheckBox.Size = new System.Drawing.Size(176, 16);
			this.crashTestDummyCheckBox.TabIndex = 7;
			this.crashTestDummyCheckBox.Text = "Make Crash Test Dummy";
			// 
			// MainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(296, 413);
			this.Controls.Add(this.createMockButton);
			this.Controls.Add(this.groupBox3);
			this.Controls.Add(this.groupBox2);
			this.Controls.Add(this.groupBox1);
			this.Controls.Add(this.chooseClassBox);
			this.Controls.Add(this.loadAssemblyButton);
			this.Name = "MainForm";
			this.Text = "Mock Objects Generator";
			this.Load += new System.EventHandler(this.MainForm_Load);
			this.groupBox1.ResumeLayout(false);
			this.groupBox2.ResumeLayout(false);
			this.groupBox3.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void loadAssemblyButton_Click(object sender, System.EventArgs e) {
			openFileDialog.InitialDirectory = ".";
			//Pop up the dialog
			openFileDialog.InitialDirectory = @"..\..\..";
			DialogResult result = openFileDialog.ShowDialog();
			//If we found a file
			if(DialogResult.OK == result) {
				generator  = new Generator(openFileDialog.FileName);
				chooseClassBox.DataSource = generator.assembly.GetExportedTypes();
				chooseClassBox.Enabled = true;
			}
		}

		private void chooseClassBox_SelectedIndexChanged(object sender, System.EventArgs e) {
			newNameBox.Text = ((Type)chooseClassBox.SelectedItem).Name;
			createMockButton.Enabled = true;
		}

		private void useOriginalNameCheckBox_CheckedChanged(object sender, System.EventArgs e) {
			if(useOriginalNameCheckBox.CheckState == CheckState.Unchecked) {
				newNameBox.Enabled = true;
			} else {
				newNameBox.Enabled = false;
				newNameBox.Text = ((Type)chooseClassBox.SelectedItem).Name;
			}
		}

		private void MainForm_Load(object sender, System.EventArgs e) {
		
		}

		private void createMockButton_Click(object sender, System.EventArgs e) {
			IList strategies = new ArrayList();
			if(crashTestDummyCheckBox.Checked) {
				strategies.Add(new CrashTestDummyStrategy());
			}
			if(wasCalledCheckBox.Checked) {
				strategies.Add(new WasCalledStrategy());
			}
			if(callLogCheckBox.Checked) {
				strategies.Add(new CallLoggingStrategy());
			}
			generator.buildMockClass(chooseClassBox.SelectedValue.ToString(),newNameBox.Text,strategies);
			saveFileDialog.InitialDirectory = @"..\..\..";
			DialogResult result = saveFileDialog.ShowDialog();
			//If we found a file
			if(DialogResult.OK == result) {
				//Write to the file
				StreamWriter sw = new StreamWriter(saveFileDialog.OpenFile());
				if(csButton.Checked == true) {
					generator.writeCodeAsCSharp(sw);
				} else {
					generator.writeCodeAsVB(sw);
				}
				sw.Close();
			}
		}
	}
}
