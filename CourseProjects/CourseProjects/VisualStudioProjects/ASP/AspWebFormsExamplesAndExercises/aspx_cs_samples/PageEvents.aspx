<%@ Page Language="C#" %>
<script  language="C#" runat="server">
	public void Page_Init(object sender, EventArgs args) {
		if(IsPostBack) {
			Response.Write("<h3>Page_Init after post back</h3>");
		} else {
			Response.Write("<h3>Page_Init before post back</h3>");
		}
	}
	public void Page_PreRender(object sender, EventArgs args) {
		if(IsPostBack) {
			Response.Write("<h3>Page_PreRender after post back</h3>");
		} else {
			Response.Write("<h3>Page_PreRender before post back</h3>");
		}
	}
	public void Page_Load(object sender, EventArgs args) {
		if(IsPostBack) {
			Response.Write("<h3>Page_Load after post back</h3>");
		} else {
			Response.Write("<h3>Page_Load before post back</h3>");
		}
	}
	public void Page_Unload(object sender, EventArgs args) {
		//Cannot write anything here as page rendered
	}
</script>
<form runat="server">
	<input type="submit" runat="server" value="Submit"/>
</form>
