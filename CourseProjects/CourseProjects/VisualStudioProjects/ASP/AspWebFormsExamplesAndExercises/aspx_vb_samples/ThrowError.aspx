<%@ Page Language="VB" ErrorPage="HandleError.aspx" Debug="true" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
	</head>
	<body>
		<%
		    If (Request.QueryString("Throw").Equals("Yes")) Then
		        Throw New InvalidOperationException("BANG")
		    End If
		%>
		<h3>No exception thrown because 'Throw' parameter was not set to 'Yes'</h3>
	</body>
</html>
