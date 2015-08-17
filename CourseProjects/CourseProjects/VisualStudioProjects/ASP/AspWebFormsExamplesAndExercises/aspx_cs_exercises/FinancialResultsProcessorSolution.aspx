<%@ Page Language="C#"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Financial Results Processor</title>
	</head>
	<body>
		<%
			string[] years = {"00","99","98","97","96"};
			string[] parameterNames = {"incomeB","incomeA","other","incomeT","expensesT"};
			string[] tableTitles = { "Income Before", "Income After", "Additional Income", "Total Income", "Total Expenses" };
			for(int x=0; x < parameterNames.Length; x++) {
		%>
				<table rules="all" style="margin-bottom: 3em;">
					<tr>
						<th colspan="<%= years.Length %>"><%= tableTitles[x] %></th>
					</tr>
					<tr>
						<%  foreach(string year in years) {  %>
						<th>
							<%= year %>
						</th>
						<%  } %>
					</tr>
					<tr>
						<%  foreach(string year in years) {  %>
						<td>
							<%= Request.Form[parameterNames[x] + year] %>
						</td>
						<%  } %>
					</tr>
				</table>
		<%
			}
		%>
	
	</body>
</html>
