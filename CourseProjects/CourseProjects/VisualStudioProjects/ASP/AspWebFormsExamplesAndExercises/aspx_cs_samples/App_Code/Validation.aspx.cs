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

namespace aspxdemos
{
	/// <summary>
	/// Summary description for Validation.
	/// </summary>
	public class Validation : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.RequiredFieldValidator rv1;
		protected System.Web.UI.WebControls.RequiredFieldValidator rv2;
		protected System.Web.UI.WebControls.RequiredFieldValidator rv3;
		protected System.Web.UI.WebControls.RequiredFieldValidator rv4;
		protected System.Web.UI.WebControls.CompareValidator cv1;
		protected System.Web.UI.WebControls.RangeValidator rav1;
		protected System.Web.UI.WebControls.TextBox nameBox;
		protected System.Web.UI.WebControls.TextBox accountNoBox;
		protected System.Web.UI.WebControls.TextBox salaryBox;
		protected System.Web.UI.WebControls.TextBox ageBox;
		protected System.Web.UI.WebControls.RegularExpressionValidator rxv1;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// Put user code to initialize the page here
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
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion
	}
}
