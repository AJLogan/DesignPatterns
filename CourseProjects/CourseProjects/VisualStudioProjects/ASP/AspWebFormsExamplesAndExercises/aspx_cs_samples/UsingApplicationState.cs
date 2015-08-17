using System;
using System.Collections;
using System.Text;
using System.Web.UI.WebControls;

namespace aspxdemos {
	public class UsingSessions : System.Web.UI.Page {
		protected TextBox entryBox;
		protected Button addButton;
		protected TextBox valueBox;
		protected ListBox contentsBox;

		protected override void OnPreRender(EventArgs e) {
			ArrayList contents = new ArrayList();
			foreach (string key in Session.Keys) {
				StringBuilder sb = new StringBuilder();
				sb.Append(key);
				sb.Append(" = ");
				sb.Append(Session[key]);
				contents.Add(sb.ToString());
			}
			contentsBox.DataSource = contents;
			contentsBox.DataBind();
		}

		protected override void OnInit(EventArgs e) {
			this.addButton.Click += new System.EventHandler(this.addButton_Click);
		}

		private void addButton_Click(object sender, System.EventArgs e) {
			string sessionName = entryBox.Text;
			string sessionValue = valueBox.Text;
			Session.Add(sessionName, sessionValue);
		}
	}
}