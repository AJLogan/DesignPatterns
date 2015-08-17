<%@ Page Language="VB"%>
<html>
	<head>
		<title>Reading Parameters From The URL</title>
	</head>
	<body>
		<h2>Parameters Found In The URL</h2>
		<table rules='cols'>
			<tr>
				<th>Name</th>
				<th>Value</th>
			</tr>
			<% For Each key As String In Request.QueryString.AllKeys%>	
			<tr>
				<td><%= key %></td>
				<td><%= Request.QueryString.Get(key) %></td>
			</tr>		
			<% Next%>
		</table>
	</body>
</html>
