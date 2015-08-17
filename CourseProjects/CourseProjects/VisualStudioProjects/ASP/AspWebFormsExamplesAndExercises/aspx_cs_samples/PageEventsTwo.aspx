<%@ Page Language="C#" %>
<script  language="C#" runat="server">
	protected override void OnInit(EventArgs e){
		if(IsPostBack) {
			Response.Write("<h3>Page_Init after post back</h3>");
		} else {
			Response.Write("<h3>Page_Init before post back</h3>");
		}
	}
	protected override void OnPreRender(EventArgs e) {
		if(IsPostBack) {
			Response.Write("<h3>Page_PreRender after post back</h3>");
		} else {
			Response.Write("<h3>Page_PreRender before post back</h3>");
		}
	}
	protected override void OnLoad(EventArgs e) {
		if(IsPostBack) {
			Response.Write("<h3>Page_Load after post back</h3>");
		} else {
			Response.Write("<h3>Page_Load before post back</h3>");
		}
	}
	protected override void OnUnload(EventArgs e) {
		//Cannot write anything here as page rendered
	}
</script>
<form runat="server" ID="Form1">
	<input type="submit" runat="server" value="Submit" ID="Submit1" NAME="Submit1"/>
</form>

