using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using CSUnitV2.UserControls;

namespace CSUnitV2
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class MainForm : System.Windows.Forms.Form
	{
		private System.Windows.Forms.TreeView testMethodsTree;
		private System.Windows.Forms.Button runSelectedTestButton;
		private System.Windows.Forms.Button runAllTestsButton;
		private System.Windows.Forms.TextBox resultsBox;
		private System.Windows.Forms.TextBox errorsBox;
		private System.Windows.Forms.TabControl tabPane;
		private System.Windows.Forms.TabPage resultsPage;
		private System.Windows.Forms.TabPage errorsPage;
		private CSUnitV2.UserControls.ChooseAssemblyWidget chooseAssemblyWidget;
		private CSUnitV2.TestResultsProgressBar progressBar;

		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		//FIELDS ADDED MANUALLY
		private TestRunner tr;
		
		private bool readyToRunTests;

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
			this.testMethodsTree = new System.Windows.Forms.TreeView();
			this.runSelectedTestButton = new System.Windows.Forms.Button();
			this.runAllTestsButton = new System.Windows.Forms.Button();
			this.tabPane = new System.Windows.Forms.TabControl();
			this.resultsPage = new System.Windows.Forms.TabPage();
			this.resultsBox = new System.Windows.Forms.TextBox();
			this.errorsPage = new System.Windows.Forms.TabPage();
			this.errorsBox = new System.Windows.Forms.TextBox();
			this.chooseAssemblyWidget = new CSUnitV2.UserControls.ChooseAssemblyWidget();
			this.progressBar = new CSUnitV2.TestResultsProgressBar();
			this.tabPane.SuspendLayout();
			this.resultsPage.SuspendLayout();
			this.errorsPage.SuspendLayout();
			this.SuspendLayout();
			// 
			// testMethodsTree
			// 
			this.testMethodsTree.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left)));
			this.testMethodsTree.ImageIndex = -1;
			this.testMethodsTree.Location = new System.Drawing.Point(24, 152);
			this.testMethodsTree.Name = "testMethodsTree";
			this.testMethodsTree.SelectedImageIndex = -1;
			this.testMethodsTree.Size = new System.Drawing.Size(152, 192);
			this.testMethodsTree.TabIndex = 1;
			// 
			// runSelectedTestButton
			// 
			this.runSelectedTestButton.Location = new System.Drawing.Point(192, 152);
			this.runSelectedTestButton.Name = "runSelectedTestButton";
			this.runSelectedTestButton.Size = new System.Drawing.Size(112, 23);
			this.runSelectedTestButton.TabIndex = 2;
			this.runSelectedTestButton.Text = "Run Selected Test";
			this.runSelectedTestButton.Click += new System.EventHandler(this.runSelectedTestButton_Click);
			// 
			// runAllTestsButton
			// 
			this.runAllTestsButton.Location = new System.Drawing.Point(320, 152);
			this.runAllTestsButton.Name = "runAllTestsButton";
			this.runAllTestsButton.Size = new System.Drawing.Size(88, 23);
			this.runAllTestsButton.TabIndex = 3;
			this.runAllTestsButton.Text = "Run All Tests";
			this.runAllTestsButton.Click += new System.EventHandler(this.runAllTestsButton_Click);
			// 
			// tabPane
			// 
			this.tabPane.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.tabPane.Controls.Add(this.resultsPage);
			this.tabPane.Controls.Add(this.errorsPage);
			this.tabPane.Location = new System.Drawing.Point(192, 232);
			this.tabPane.Name = "tabPane";
			this.tabPane.SelectedIndex = 0;
			this.tabPane.Size = new System.Drawing.Size(216, 112);
			this.tabPane.TabIndex = 4;
			// 
			// resultsPage
			// 
			this.resultsPage.Controls.Add(this.resultsBox);
			this.resultsPage.Location = new System.Drawing.Point(4, 22);
			this.resultsPage.Name = "resultsPage";
			this.resultsPage.Size = new System.Drawing.Size(208, 86);
			this.resultsPage.TabIndex = 0;
			this.resultsPage.Text = "Results";
			// 
			// resultsBox
			// 
			this.resultsBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.resultsBox.Location = new System.Drawing.Point(8, 8);
			this.resultsBox.Multiline = true;
			this.resultsBox.Name = "resultsBox";
			this.resultsBox.Size = new System.Drawing.Size(192, 72);
			this.resultsBox.TabIndex = 0;
			this.resultsBox.Text = "";
			// 
			// errorsPage
			// 
			this.errorsPage.Controls.Add(this.errorsBox);
			this.errorsPage.Location = new System.Drawing.Point(4, 22);
			this.errorsPage.Name = "errorsPage";
			this.errorsPage.Size = new System.Drawing.Size(208, 86);
			this.errorsPage.TabIndex = 1;
			this.errorsPage.Text = "Errors";
			// 
			// errorsBox
			// 
			this.errorsBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.errorsBox.Location = new System.Drawing.Point(8, 8);
			this.errorsBox.Multiline = true;
			this.errorsBox.Name = "errorsBox";
			this.errorsBox.Size = new System.Drawing.Size(192, 72);
			this.errorsBox.TabIndex = 0;
			this.errorsBox.Text = "";
			// 
			// chooseAssemblyWidget
			// 
			this.chooseAssemblyWidget.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.chooseAssemblyWidget.Location = new System.Drawing.Point(8, 8);
			this.chooseAssemblyWidget.Name = "chooseAssemblyWidget";
			this.chooseAssemblyWidget.Size = new System.Drawing.Size(416, 136);
			this.chooseAssemblyWidget.TabIndex = 5;
			// 
			// progressBar
			// 
			this.progressBar.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.progressBar.Location = new System.Drawing.Point(192, 192);
			this.progressBar.Name = "progressBar";
			this.progressBar.NoOfTests = 0;
			this.progressBar.Size = new System.Drawing.Size(216, 23);
			this.progressBar.TabIndex = 6;
			this.progressBar.Text = "testResultsProgressBar1";
			// 
			// MainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(440, 365);
			this.Controls.Add(this.progressBar);
			this.Controls.Add(this.chooseAssemblyWidget);
			this.Controls.Add(this.tabPane);
			this.Controls.Add(this.runAllTestsButton);
			this.Controls.Add(this.runSelectedTestButton);
			this.Controls.Add(this.testMethodsTree);
			this.Name = "MainForm";
			this.Text = "Unit Test Tool V2";
			this.Load += new System.EventHandler(this.MainForm_Load);
			this.tabPane.ResumeLayout(false);
			this.resultsPage.ResumeLayout(false);
			this.errorsPage.ResumeLayout(false);
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

		private void MainForm_Load(object sender, System.EventArgs e) {
			chooseAssemblyWidget.TestClassSelected += new ChooseAssemblyWidget.TestClassSelectedHandler(OnTestClassSelected);
			readyToRunTests = false;
		}
		private void OnTestClassSelected(object source, Type selected) {
			//MessageBox.Show("A NEW TYPE HAS BEEN SELECTED");
			populateResultsTree(selected);
		}
		private void populateResultsTree(Type selected) {
			//Empty the tree view
			testMethodsTree.Nodes.Clear();
			
			//Create the root node for the tree
			TreeNode root = new TreeNode(selected.Name);

			//Create a new TestRunner to represent the current class
			tr = new TestRunner(selected);

			//Get the names of all the available test methods
			String[] testMethods = tr.getTestMethodNames();

			//If the current class contains test methods
			if(testMethods.Length > 0) {
				//Add each test method to the tree view	
				foreach(string method in testMethods) {
					//MessageBox.Show("Adding: " + method.Name);
					root.Nodes.Add(new TreeNode(method));
				}
				readyToRunTests = true;
			} else {
				root.Nodes.Add(new TreeNode("No Methods Available"));
				readyToRunTests = false;
			}

			//Add the root node to the tree view
			testMethodsTree.Nodes.Add(root);
		}

		private void runSelectedTestButton_Click(object sender, System.EventArgs e) {
			//prepare the progress bar
			setupProgressBar(1);
			//test the selected method
			TreeNode selected = testMethodsTree.SelectedNode;
			if(null == selected || !tr.methodExists(selected.Text)) {
				MessageBox.Show("Please select a test method");
			} else if(!readyToRunTests) {
				MessageBox.Show("Please select a valid test class");
			}else {
				TestResult result = tr.runSingleTestMethod(selected.Text);
				progressBar.testCompleted(result.passed);
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

		private void runAllTestsButton_Click(object sender, System.EventArgs e) {
			if(!readyToRunTests) {
				MessageBox.Show("Please select a valid test class");
				return;
			}
			//prepare the progress bar
			setupProgressBar(tr.getTestMethodNames().Length);
			//run all tests, passing a delegate to update the progress bar
			TestRunner.TestCompleteCallback callback = new TestRunner.TestCompleteCallback(progressBar.testCompleted);
			TestResult[] results = tr.runAllTestMethods(callback);
			//display the results
			if(results.Length == 0) {
				resultsBox.Text = "No methods executed";
			} else {
				displayTestResults(results);
			}
		}
		private void setupProgressBar(int numTests) {
			progressBar.reset();
			progressBar.NoOfTests = numTests;
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
