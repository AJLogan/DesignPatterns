<%@ Page Language="VB" %>
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
				<td><%= Request.Form("name")%></td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td>
					<%
						select Request.Form("mstatus")
							case "S"
								Response.Write("Single")
							case "M"
								Response.Write("Married")
							case "D"
								Response.Write("Divorced")
						end select
					%>
				</td>
			</tr>
			<tr>
				<td>Age</td>
				<td>
					<%
						select Request.Form("age")
							case "U25"
								Response.Write("Under 25")
							case "U50"
								Response.Write("Under 50")
							case "U75"
								Response.Write("Under 75")
						end select
					%>
				</td>
			</tr>
			<tr>
				<td>Interests</td>
				<td>
					<%
						for each val as String in Request.Form.GetValues("interests")
							select case val
								case "S"
									Response.Write("Sports")
								case "M"
									Response.Write("Movies")
								case "B"
									Response.Write("Books")
								case "P"
									Response.Write("Pets")
							end select
							Response.Write(" ")
						next
					%>
				</td>
			</tr>
			<tr>
				<td>Comments</td>
				<td><%= Request.Form("comments")%></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><%= Request.Form("password")%></td>
			</tr>
		</table>
	</body>
</html>
