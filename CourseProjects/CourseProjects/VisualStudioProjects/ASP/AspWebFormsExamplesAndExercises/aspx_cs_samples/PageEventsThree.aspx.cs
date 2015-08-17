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

namespace aspxsamples
{
	/// <summary>
	/// Summary description for PageEventsThree.
	/// </summary>
	public partial class PageEventsThree : System.Web.UI.Page
	{

	
		public PageEventsThree() {
			Init += new EventHandler(this.myInit);
			PreRender += new EventHandler(this.myPreRender);
			Load += new EventHandler(this.myLoad);
			Unload += new EventHandler(this.myUnload);
		}
		public void myInit(object sender, EventArgs e){
			if(IsPostBack) {
				Response.Write("<h3>Page_Init after post back</h3>");
			} else {
				Response.Write("<h3>Page_Init before post back</h3>");
			}
		}
		public void myPreRender(object sender, EventArgs e) {
			if(IsPostBack) {
				Response.Write("<h3>Page_PreRender after post back</h3>");
			} else {
				Response.Write("<h3>Page_PreRender before post back</h3>");
			}
		}
		public void myLoad(object sender, EventArgs e) {
			if(IsPostBack) {
				Response.Write("<h3>Page_Load after post back</h3>");
			} else {
				Response.Write("<h3>Page_Load before post back</h3>");
			}
		}
		public void myUnload(object sender, EventArgs e) {
			//Cannot write anything here as page rendered
		}

		protected void Page_Load(object sender, System.EventArgs e)
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

		}
		#endregion
	}
}
