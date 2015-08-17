<%@ Page Language="VB" %>
<script runat="server">
    Public Sub PrintToBrowser(ByVal s As String)
        Response.Write(s)
    End Sub
</script>
<html>
	<head>
		<title>A Very Simple Page</title>
	</head>
	<body>
		<h1>Hello ASP .NET</h1>
		<% 
			Dim messages() as String = {"Hello There","Dont Worry", "Be Happy", "Eat Fish"}
		    For i As Integer = 0 To (messages.Length - 1)
		%>
			<h3>Message No <%= i %> is: <% PrintToBrowser(messages(i))%></h3>
		<% next %>
	</body>
</html>