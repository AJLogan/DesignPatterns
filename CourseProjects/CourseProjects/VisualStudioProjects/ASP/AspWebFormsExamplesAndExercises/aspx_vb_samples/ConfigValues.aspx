<%@ Page Language="VB" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
	</head>
	<body>
		<h2>Settings read from 'appSettings' element</h2>
		<table>
			<tr><th>Name</th><th>Value</th></tr>
			<tr>
				<td>MaxThreads</td>
				<td><%=System.Configuration.ConfigurationManager.AppSettings("MaxThreads")%></td>
			</tr>
			<tr>
				<td>DatabaseIP</td>
				<td><%=System.Configuration.ConfigurationManager.AppSettings("DatabaseIP")%></td>
			</tr>
		</table>
		<h2>Settings read from custom section</h2>
		<%
		    Dim obj As Object = System.Configuration.ConfigurationManager.GetSection("customSettingsGroup/customSettings")
		    Dim settings As CustomSettingsVO = CType(obj, CustomSettingsVO)
		%>
		<table>
			<tr><th>Name</th><th>Value</th></tr>
			<tr>
				<td>MaxThreads</td>
				<td><%=settings.MaxThreads%></td>
			</tr>
			<tr>
				<td>DatabaseIP</td>
				<td><%=settings.DatabaseIP%></td>
			</tr>
		</table>
	</body>
</html>
