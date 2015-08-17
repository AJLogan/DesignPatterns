<%@ Page Language="C#" %>
<script runat=server>
    public void PrintToBrowser(string s) {
        Response.Write(s);
    }    
</script>
<html>
	<head>
		<title>A Very Simple Page</title>
	</head>
	<body>
		<h1>Hello ASP .NET</h1>
		<% 
			string[] messages = {"Hello There","Dont Worry", "Be Happy", "Eat Fish"};
			for(int i=0;i<messages.Length;i++) {
		%>
			<h3>Message No <%= i %> is: <% PrintToBrowser(messages[i]); %></h3>
		<% } %>
	</body>
</html>