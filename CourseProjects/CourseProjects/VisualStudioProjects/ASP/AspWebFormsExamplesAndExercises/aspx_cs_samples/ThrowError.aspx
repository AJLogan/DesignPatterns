<%@ Page Language="C#" ErrorPage="HandleError.aspx" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
	</head>
	<body>
		<%
			if(Request.QueryString["Throw"].Equals("Yes")) {
				throw new InvalidOperationException("BANG");
			}
		%>
		<h3>No exception thrown because 'Throw' parameter was not set to 'Yes'</h3>
	</body>
</html>
