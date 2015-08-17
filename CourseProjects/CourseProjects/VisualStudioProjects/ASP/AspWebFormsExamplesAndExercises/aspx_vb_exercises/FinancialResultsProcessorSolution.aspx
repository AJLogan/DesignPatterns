<%@ Page Language="VB"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Financial Results Processor</title>
	</head>
	<body>
		<%
			Dim years as String() = {"00","99","98","97","96"}
			Dim parameterNames as String() = {"incomeB","incomeA","other","incomeT","expensesT"}
			Dim tableTitles as string() = { "Income Before", "Income After", "Additional Income", "Total Income", "Total Expenses" }
			for x as Integer =0 to parameterNames.Length -1 Step 1 
		%>
				<table rules="all" style="margin-bottom: 3em;">
					<tr>
						<th colspan="<%= years.Length %>"><%= tableTitles(x) %></th>
					</tr>
					<tr>
						<%For Each year As String In years%>
						<th>
							<%= year %>
						</th>
						<%Next%>
					</tr>
					<tr>
						<%For Each year As String In years%>
						<td>
							<%= Request.Form(parameterNames(x) + year) %>
						</td>
						<%Next%>
					</tr>
				</table>
		<%Next %>
	</body>
</html>
