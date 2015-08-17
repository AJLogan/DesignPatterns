<%@ Page Language="VB" %>
<%@ Register TagPrefix="p" Namespace="VisualBasicWebApp" %>
<script runat="server">
    Public Sub Page_Load(ByVal sender As Object, ByVal args As EventArgs)
        If Not IsPostBack Then
            myList.DataSource = New String() {"abc", "def", "ghi", "jkl"}
            DataBind()
        End If
    End Sub
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
