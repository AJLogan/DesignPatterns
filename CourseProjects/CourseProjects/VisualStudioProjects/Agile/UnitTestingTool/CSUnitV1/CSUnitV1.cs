using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.IO;

namespace CSUnitV1
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class MainForm : System.Windows.Forms.Form
	{
		private System.Windows.Forms.ComboBox assemblyNamesBox;
		private System.Windows.Forms.GroupBox assemblyGroupBox;
		private System.Windows.Forms.Button browseButton;
		private System.Windows.Forms.TreeView testMethodsTree;
		private System.Windows.Forms.ProgressBar resultsBar;
		private System.Windows.Forms.TabControl resultsTab;
		private System.Windows.Forms.TabPage resultsSummaryTab;
		private System.Windows.Forms.TabPage errorsTab;
		private System.Windows.Forms.OpenFileDialog browseDialog;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.ComboBox classNamesBox;
		private System.Windows.Forms.Button runSelectedTestButton;
		private System.Windows.Forms.Button runAllTestsButton;
		private System.Windows.Forms.TextBox resultsBox;
		private System.Windows.Forms.TextBox errorsBox;

		//FIELDS ADDED MANUALLY
		private TestRunner tr;

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
				if (components != null) 
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
			this.assemblyNamesBox = new System.Windows.Forms.ComboBox();
			this.assemblyGroupBox = new System.Windows.Forms.GroupBox();
			this.classNamesBox = new System.Windows.Forms.ComboBox();
			this.browseButton = new System.Windows.Forms.Button();
			this.testMethodsTree = new System.Windows.Forms.TreeView();
			this.resultsBar = new System.Windows.Forms.ProgressBar();
			this.resultsTab = new System.Windows.Forms.TabControl();
			this.resultsSummaryTab = new System.Windows.Forms.TabPage();
			this.resultsBox = new System.Windows.Forms.TextBox();
			this.errorsTab = new System.Windows.Forms.TabPage();
			this.errorsBox = new System.Windows.Forms.TextBox();
			this.browseDialog = new System.Windows.Forms.OpenFileDialog();
			this.runSelectedTestButton = new System.Windows.Forms.Button();
			this.runAllTestsButton = new System.Windows.Forms.Button();
			this.assemblyGroupBox.SuspendLayout();
			this.resultsTab.SuspendLayout();
			this.resultsSummaryTab.SuspendLayout();
			this.errorsTab.SuspendLayout();
			this.SuspendLayout();
			// 
			// assemblyNamesBox
			// 
			this.assemblyNamesBox.Location = new System.Drawing.Point(16, 24);
			this.assemblyNamesBox.Name = "assemblyNamesBox";
			this.assemblyNamesBox.Size = new System.Drawing.Size(272, 21);
			this.assemblyNamesBox.TabIndex = 0;
			this.assemblyNamesBox.Text = "Assembly Name";
			// 
			// assemblyGroupBox
			// 
			this.assemblyGroupBox.Controls.Add(this.classNamesBox);
			this.assemblyGroupBox.Controls.Add(this.browseButton);
			this.assemblyGroupBox.Controls.Add(this.assemblyNamesBox);
			this.assemblyGroupBox.Location = new System.Drawing.Point(24, 16);
			this.assemblyGroupBox.Name = "assemblyGroupBox";
			this.assemblyGroupBox.Size = new System.Drawing.Size(400, 104);
			this.assemblyGroupBox.TabIndex = 1;
			this.assemblyGroupBox.TabStop = false;
			this.assemblyGroupBox.Text = "Select Assembly And Class";
			// 
			// classNamesBox
			// 
			this.classNamesBox.Location = new System.Drawing.Point(16, 64);
			this.classNamesBox.Name = "classNamesBox";
			this.classNamesBox.Size = new System.Drawing.Size(272, 21);
			this.classNamesBox.TabIndex = 2;
			this.classNamesBox.Text = "Class Names";
			this.classNamesBox.SelectedIndexChanged += new System.EventHandler(this.classNamesBox_SelectedIndexChanged);
			// 
			// browseButton
			// 
			this.browseButton.Location = new System.Drawing.Point(304, 24);
			this.browseButton.Name = "browseButton";
			this.browseButton.Size = new System.Drawing.Size(64, 23);
			this.browseButton.TabIndex = 1;
			this.browseButton.Text = "Browse";
			this.browseButton.Click += new System.EventHandler(this.browseButton_Click);
			// 
			// testMethodsTree
			// 
			this.testMethodsTree.ImageIndex = -1;
			this.testMethodsTree.Location = new System.Drawing.Point(24, 144);
			this.testMethodsTree.Name = "testMethodsTree";
			this.testMethodsTree.SelectedImageIndex = -1;
			this.testMethodsTree.Size = new System.Drawing.Size(160, 208);
			this.testMethodsTree.TabIndex = 2;
			// 
			// resultsBar
			// 
			this.resultsBar.Location = new System.Drawing.Point(200, 184);
			this.resultsBar.Name = "resultsBar";
			this.resultsBar.Size = new System.Drawing.Size(216, 23);
			this.resultsBar.TabIndex = 3;
			// 
			// resultsTab
			// 
			this.resultsTab.Controls.Add(this.resultsSummaryTab);
			this.resultsTab.Controls.Add(this.errorsTab);
			this.resultsTab.Location = new System.Drawing.Point(200, 224);
			this.resultsTab.Name = "resultsTab";
			this.resultsTab.SelectedIndex = 0;
			this.resultsTab.Size = new System.Drawing.Size(224, 128);
			this.resultsTab.TabIndex = 4;
			// 
			// resultsSummaryTab
			// 
			this.resultsSummaryTab.Controls.Add(this.resultsBox);
			this.resultsSummaryTab.Location = new System.Drawing.Point(4, 22);
			this.resultsSummaryTab.Name = "resultsSummaryTab";
			this.resultsSummaryTab.Size = new System.Drawing.Size(216, 102);
			this.resultsSummaryTab.TabIndex = 0;
			this.resultsSummaryTab.Text = "Results";
			// 
			// resultsBox
			// 
			this.resultsBox.Location = new System.Drawing.Point(8, 16);
			this.resultsBox.Multiline = true;
			this.resultsBox.Name = "resultsBox";
			this.resultsBox.Size = new System.Drawing.Size(200, 72);
			this.resultsBox.TabIndex = 0;
			this.resultsBox.Text = "";
			// 
			// errorsTab
			// 
			this.errorsTab.Controls.Add(this.errorsBox);
			this.errorsTab.Location = new System.Drawing.Point(4, 22);
			this.errorsTab.Name = "errorsTab";
			this.errorsTab.Size = new System.Drawing.Size(216, 102);
			this.errorsTab.TabIndex = 1;
			this.errorsTab.Text = "Errors";
			// 
			// errorsBox
			// 
			this.errorsBox.Location = new System.Drawing.Point(8, 16);
			this.errorsBox.Multiline = true;
			this.errorsBox.Name = "errorsBox";
			this.errorsBox.Size = new System.Drawing.Size(200, 72);
			this.errorsBox.TabIndex = 0;
			this.errorsBox.Text = "";
			// 
			// runSelectedTestButton
			// 
			this.runSelectedTestButton.Location = new System.Drawing.Point(200, 144);
			this.runSelectedTestButton.Name = "runSelectedTestButton";
			this.runSelectedTestButton.Size = new System.Drawing.Size(112, 23);
			this.runSelectedTestButton.TabIndex = 5;
			this.runSelectedTestButton.Text = "Run Selected Test";
			this.runSelectedTestButton.Click += new System.EventHandler(this.runSelectedTestButton_Click);
			// 
			// runAllTestsButton
			// 
			this.runAllTestsButton.Location = new System.Drawing.Point(336, 144);
			this.runAllTestsButton.Name = "runAllTestsButton";
			this.runAllTestsButton.Size = new System.Drawing.Size(80, 23);
			this.runAllTestsButton.TabIndex = 6;
			this.runAllTestsButton.Text = "Run All Tests";
			this.runAllTestsButton.Click += new System.EventHandler(this.runAllTestsButton_Click);
			// 
			// MainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(456, 373);
			this.Controls.Add(this.runAllTestsButton);
			this.Controls.Add(this.runSelectedTestButton);
			this.Controls.Add(this.resultsTab);
			this.Controls.Add(this.resultsBar);
			this.Controls.Add(this.testMethodsTree);
			this.Controls.Add(this.assemblyGroupBox);
			this.Name = "MainForm";
			this.Text = "CS Unit Version 1";
			this.Load += new System.EventHandler(this.mainForm_Load);
			this.assemblyGroupBox.ResumeLayout(false);
			this.resultsTab.ResumeLayout(false);
			this.resultsSummaryTab.ResumeLayout(false);
			this.errorsTab.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new MainForm());
		}

		private void mainForm_Load(object sender, System.EventArgs e) {
			tr = new TestRunner();
		}

		private void browseButton_Click(object sender, System.EventArgs e) {
			//Pop up the dialog to let the user select a file
			DialogResult result = browseDialog.ShowDialog(this);
			if(result == DialogResult.OK) {
				//Read in the assembly as an array of bytes
				BinaryReader reader = new BinaryReader(browseDialog.OpenFile());
				FileInfo file = new FileInfo(browseDialog.FileName);
				byte[] bytes = reader.ReadBytes((int)file.Length);
				//Tell the TestRunner that this is our test assembly
				tr.assembly = bytes;
				//Populate the assemblies combo box with the list of assemblies
				assemblyNamesBox.DisplayMember = "FullName";
				assemblyNamesBox.DataSource = tr.testedAssemblies;
				//Populate the classes box wih the new list of types
				classNamesBox.DisplayMember = "Name";
				classNamesBox.DataSource = tr.typesInAssembly;
			}
		}

		private void classNamesBox_SelectedIndexChanged(object sender, System.EventArgs e) {
			//Empty the tree view
			testMethodsTree.Nodes.Clear();
			//Get the selected type object
			Type selected = (Type)classNamesBox.SelectedValue;
			//Register the selected type with our TestRunner
			tr.testClass = selected;
			//If the current class contains test methods
			if(tr.testMethods.Length > 0) {
				//Add each test method to the tree view
				TreeNode root = new TreeNode(selected.Name);
				foreach(System.Reflection.MethodInfo method in tr.testMethods) {
					//MessageBox.Show("Adding: " + method.Name);
					root.Nodes.Add(new TreeNode(method.Name));
				}
				testMethodsTree.Nodes.Add(root);
			}
		}

		private void runAllTestsButton_Click(object sender, System.EventArgs e) {
			//set the progress bar
			setupResultsBar(tr.testMethods.Length);
			//run all tests, passing a delegate to update the progress bar
			TestResult[] results = tr.runAllTestMethods(new TestRunner.TestUpdate(resultsBar.PerformStep));
			//display the results
			if(results.Length == 0) {
				resultsBox.Text = "No methods executed";
			} else {
				displayTestResults(results);
			}
		}
		private void setupResultsBar(int max) {
			resultsBar.Value = 0;
			resultsBar.Minimum = 0;
			resultsBar.Maximum = max;
			resultsBar.Step = 1;
			resultsBar.Refresh();
		}
		private void runSelectedTestButton_Click(object sender, System.EventArgs e) {
			//set the progess bar for a single test
			setupResultsBar(1);
			//test the selected method
			TreeNode selected = testMethodsTree.SelectedNode;
			if(null == selected) {
				MessageBox.Show("Please select a test method");
			} else {
				TestResult result = tr.runSingleTestMethod(selected.Text);
				resultsBar.PerformStep();
				displayTestResults(result);
			}
		}
		//display results for multiple tests
		private void displayTestResults(TestResult[] results) {
			String resultsLine1 = Convert.ToString(results.Length) + " test methods executed";
			int errorCount = 0;
			ArrayList errors = new ArrayList();
			foreach(TestResult r in results) {
				if(!r.passed) {
					errorCount++;
					errors.Add(r.error.ToString());
				}
			}
			String resultsLine2 = "There were " + errorCount + " errors";
			resultsBox.Lines = new String[] { resultsLine1, resultsLine2 };
			errorsBox.Lines = (String[])errors.ToArray(typeof(String));
		}
		//display results for single test
		private void displayTestResults(TestResult result) {
			if(true == result.passed) {
				resultsBox.Text = result.methodName + " passed";
				errorsBox.Text = "";
			} else {
				resultsBox.Text = result.methodName + " failed";
				string[] output = new string[] { 
												   result.methodName + ":" ,
												   result.error.ToString(),
												   "-----------"
											   };
				errorsBox.Lines = output;
			}
		}
	}
}
