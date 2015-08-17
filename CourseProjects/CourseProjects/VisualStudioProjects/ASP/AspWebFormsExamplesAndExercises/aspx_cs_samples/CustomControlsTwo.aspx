<%@ Page Language="C#" %>
<%@ Register TagPrefix="p" Namespace="aspxsamples" %>
<script runat="server">
	public void Page_Load(object sender, EventArgs args) {
		if(!IsPostBack) {
			string[] data= new string[] {"abc","def","ghi","jkl"};
			myList.DataSource = data;
			myListTwo.DataSource = data;
			DataBind();
		}
	}
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Custom Controls Part Two</title>
	</head>
	<body>
		<form runat="server">
			<h2>This is the output of the 'ItemList' Custom Control</h2>
			<p:ItemList id="myList" Numbered="true" runat="server"/>
			<h2>This is the output of the 'ItemListTwo' Custom Control</h2>
			<p:ItemListTwo id="myListTwo" Numbered="true" runat="server"/>
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>
