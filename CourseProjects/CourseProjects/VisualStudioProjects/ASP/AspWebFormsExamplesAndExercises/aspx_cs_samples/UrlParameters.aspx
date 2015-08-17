<%@ Page Language="C#"%>
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
			<% foreach(String key in Request.QueryString.AllKeys) { %>	
			<tr>
				<td><%= key %></td>
				<td><%= Request.QueryString.Get(key) %></td>
			</tr>		
			<% } %>
		</table>
	</body>
</html>
