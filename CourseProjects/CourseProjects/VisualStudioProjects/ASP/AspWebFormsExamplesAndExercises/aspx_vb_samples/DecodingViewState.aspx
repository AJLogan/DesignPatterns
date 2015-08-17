<%@ Page language="VB" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Examining View State</title>
		<script runat="server">
		    Protected Overrides Sub OnLoad(ByVal e As EventArgs)
		        Dim num As Integer = Convert.ToInt32(number.InnerText)
		        number.InnerText = (num * 2).ToString()
		    End Sub
		</script>
	</head>
	<body>
		<form runat="server">
			<h3 id="number" runat="server">10</h3>
			<input type="submit" value="Double Number"/>
		</form>
		<h3>View State value is:</h3>
		<p>
			<%= Request.Params("__VIEWSTATE")%>
		</p>
	</body>
</html>
