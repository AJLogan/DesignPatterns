<%@ Page Language="C#" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
	</head>
	<body>
		<h2>Parameters Read From The Form</h2>
		<table>
			<tr><th>Name</th><th>Value</th></tr>
			<tr>
				<td>Name</td>
				<td><%= Request.Form["name"]%></td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td>
					<%
						switch(Request.Form["mstatus"]) {
							case "S":
								Response.Write("Single");
								break;
							case "M":
								Response.Write("Married");
								break;
							case "D":
								Response.Write("Divorced");
								break;
						}
					%>
				</td>
			</tr>
			<tr>
				<td>Age</td>
				<td>
					<%
						switch(Request.Form["age"]) {
							case "U25":
								Response.Write("Under 25");
								break;
							case "U50":
								Response.Write("Under 50");
								break;
							case "U75":
								Response.Write("Under 75");
								break;
						}
					%>
				</td>
			</tr>
			<tr>
				<td>Interests</td>
				<td>
					<%
						foreach(string val in Request.Form.GetValues("interests")) {
							switch(val) {
								case "S":
									Response.Write("Sports");
									break;
								case "M":
									Response.Write("Movies");
									break;
								case "B":
									Response.Write("Books");
									break;
								case "P":
									Response.Write("Pets");
									break;
							}
							Response.Write(" ");
						}
					%>
				</td>
			</tr>
			<tr>
				<td>Comments</td>
				<td><%= Request.Form["comments"]%></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><%= Request.Form["password"]%></td>
			</tr>
		</table>
	</body>
</html>
