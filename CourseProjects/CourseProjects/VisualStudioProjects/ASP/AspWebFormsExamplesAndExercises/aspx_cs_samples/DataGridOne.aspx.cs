using System;
using System.Data;
using System.Web.UI.WebControls;

namespace aspxdemos {
	public partial class DataGridOne : System.Web.UI.Page {
		protected DataSet coursesDataSet;

		protected override void OnLoad(EventArgs e) {
			coursesDataSet = new DataSet();
			coursesDataSet.ReadXml(Request.MapPath("coursesDataSet.xml"));
			coursesGrid.DataSource = coursesDataSet;
			coursesGrid.DataBind();
		}
	}
}