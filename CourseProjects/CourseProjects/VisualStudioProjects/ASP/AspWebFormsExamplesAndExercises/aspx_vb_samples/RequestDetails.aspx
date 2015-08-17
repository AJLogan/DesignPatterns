<%@ Page Language="VB" %>
<html>
	<head>
		<title>Request Details</title>
	</head>
	<body>
		<h2>Request Details</h2>
		<table rules='cols'>
			<tr>
				<th>Property</th><th>Value</th>
			</tr>
			<tr>
				<td>Full URL</td>
				<td><%= Request.Url.AbsoluteUri %></td>
			</tr>
			<tr>
				<td>Path in URL</td>
				<td><%= Request.Url.AbsolutePath %></td>
			</tr>
			<tr>
				<td>Query String</td>
				<td><%= Request.Url.Query %></td>
			</tr>
			<tr>
				<td>Request Type</td>
				<td><%= Request.RequestType %></td>
			</tr>	
			<tr>
				<td>Application Path</td>
				<td><%= Request.ApplicationPath %></td>
			</tr>
		</table>
		<h2>Request Headers</h2>
		<table rules='cols'>
			<tr>
				<th>Header Name</th>
				<th>Value</th>
			</tr>
			<% 			    
			    For Each key As String In Request.Headers.AllKeys
			%>	
			<tr>
				<td><%= key %></td>
				<td><%= Request.Headers.Get(key) %></td>
			</tr>		
			<% next %>
		</table>
		<h2>User Details</h2>
		<table rules='cols'>
			<tr>
				<td>User Agent</td>
				<td><%= Request.UserAgent %></td>
			</tr>
			<tr>
				<td>User Host Address</td>
				<td><%= Request.UserHostAddress %></td>
			</tr>
			<tr>
				<td>User Host Name</td>
				<td><%= Request.UserHostName %></td>
			</tr>
		</table>
	</body>
</html>