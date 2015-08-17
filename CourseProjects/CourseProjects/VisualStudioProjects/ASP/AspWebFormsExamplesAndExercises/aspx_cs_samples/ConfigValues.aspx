<%@ Page Language="C#" %>
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
				<td><%= ConfigurationSettings.AppSettings["MaxThreads"] %></td>
			</tr>
			<tr>
				<td>DatabaseIP</td>
				<td><%= ConfigurationSettings.AppSettings["DatabaseIP"] %></td>
			</tr>
		</table>
		<h2>Settings read from custom section</h2>
		<%
			AspxDemos.CustomSettingsVO data = (AspxDemos.CustomSettingsVO)ConfigurationSettings.GetConfig("customSettingsGroup/customSettings");
		%>
		<table>
			<tr><th>Name</th><th>Value</th></tr>
			<tr>
				<td>MaxThreads</td>
				<td><%= data.MaxThreads %></td>
			</tr>
			<tr>
				<td>DatabaseIP</td>
				<td><%= data.DatabaseIP %></td>
			</tr>
		</table>
	</body>
</html>
