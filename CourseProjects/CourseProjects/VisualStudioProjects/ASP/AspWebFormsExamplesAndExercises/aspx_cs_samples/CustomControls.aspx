<%@ Page Language="C#" %>
<%@ Register TagPrefix="p" Namespace="aspxsamples" %>
<script runat="server">
	public void Page_Load(object sender, EventArgs args) {
        if(!IsPostBack) {
            myList.DataSource = new string[] {"abc", "def", "ghi", "jkl"};
            DataBind();
        }
	}
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Custom Controls Part One</title>
	</head>
	<body>
		<h2>This is the output of the 'ItemList' Custom Control</h2>
		<form runat="server">
			<p:ItemList id="myList" Numbered="true" runat="server"/>
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>
