<%@ Page Language="VB" %>
<%@ Register TagPrefix="p" Namespace="VisualBasicWebApp" %>
<script runat="server">
	public Sub Page_Load(sender as Object, args as EventArgs)
		if(not IsPostBack) then
            Dim data As String() = {"abc", "def", "ghi", "jkl"}
			myList.DataSource = data
			myListTwo.DataSource = data
			DataBind()
		end if
	end sub
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
