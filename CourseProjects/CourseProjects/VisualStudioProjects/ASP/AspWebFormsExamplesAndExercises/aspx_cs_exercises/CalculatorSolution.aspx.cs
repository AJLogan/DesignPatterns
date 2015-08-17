using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace AspxExercises
{
	public partial class CalculatorSolution : System.Web.UI.Page
	{

		protected enum Operations { None, Add, Subtract, Divide, Multiply };
	
		protected void Page_Load(object sender, System.EventArgs e)
		{
			if(!IsPostBack) {
				setupSessionVariables();
			}
		}

		private void setupSessionVariables() {
			Session["CurrentOperation"] = Operations.None;
			Session["CurrentTotal"] = 0.0;
		}

		#region Web Form Designer generated code
		override protected void OnInit(EventArgs e)
		{
			//
			// CODEGEN: This call is required by the ASP.NET Web Form Designer.
			//
			InitializeComponent();
			base.OnInit(e);
		}
		
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{    

		}
		#endregion

		protected void btAdd_Click(object sender, System.EventArgs e) {
			Session["CurrentOperation"] = Operations.Add;
			dataBox.Text = Session["CurrentTotal"].ToString();
		}

		protected void btSubtract_Click(object sender, System.EventArgs e) {
			Session["CurrentOperation"] = Operations.Subtract;
			dataBox.Text = Session["CurrentTotal"].ToString();
		}

		protected void btMultiply_Click(object sender, System.EventArgs e) {
			Session["CurrentOperation"] = Operations.Multiply;
			dataBox.Text = Session["CurrentTotal"].ToString();
		}

		protected void btDivide_Click(object sender, System.EventArgs e) {
			Session["CurrentOperation"] = Operations.Divide;
			dataBox.Text = Session["CurrentTotal"].ToString();
		}
		protected void btEquals_Click(object sender, System.EventArgs e) {
			dataBox.Text = Session["CurrentTotal"].ToString();
		}

		protected void btClear_Click(object sender, System.EventArgs e) {
			dataBox.Text = "";
			setupSessionVariables();
		}
		private void processNumber(double number) {

			double total = (double)Session["CurrentTotal"];

			switch((Operations)Session["CurrentOperation"]) {
				case Operations.None:
					Session["CurrentTotal"] = number;
					break;
				case Operations.Add:
					Session["CurrentTotal"] = number + total;
					break;
				case Operations.Multiply:
					Session["CurrentTotal"] = number * total;
					break;
				case Operations.Divide:
					Session["CurrentTotal"] = total / number;
					break;
				case Operations.Subtract:
					Session["CurrentTotal"] = total - number;
					break;
			}

			dataBox.Text = number.ToString();
			Session["CurrentOperation"] = Operations.None;
		}

		protected void btOne_Click(object sender, System.EventArgs e) {
			processNumber(1);
		}

		protected void btTwo_Click(object sender, System.EventArgs e) {
			processNumber(2);
		}

		protected void btThree_Click(object sender, System.EventArgs e) {
			processNumber(3);
		}

		protected void btFour_Click(object sender, System.EventArgs e) {
			processNumber(4);
		}

		protected void btFive_Click(object sender, System.EventArgs e) {
			processNumber(5);
		}

		protected void btSix_Click(object sender, System.EventArgs e) {
			processNumber(6);
		}

		protected void btSeven_Click(object sender, System.EventArgs e) {
			processNumber(7);
		}

		protected void btEight_Click(object sender, System.EventArgs e) {
			processNumber(8);
		}

		protected void btNine_Click(object sender, System.EventArgs e) {
			processNumber(9);
		}

		protected void btZero_Click(object sender, System.EventArgs e) {
			processNumber(0);
		}
	}
}
