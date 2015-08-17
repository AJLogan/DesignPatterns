<%@ Page language="VB" %>
<script runat="server">
    public sub Page_Load() 
        contents = new ArrayList()
        if (Request.RequestType.Equals("POST")) then
            Dim applicationKey As String = Request.Form("entryBox")
            Dim applicationValue As String = Request.Form("valueBox")
            if (not applicationKey.Equals("")) then
                if (not applicationValue.Equals("")) then
                    Application.Add(applicationKey, applicationValue)
                end if
            end if
        end if
        For Each key As String In Application.Keys
            Dim sb As StringBuilder = New StringBuilder()
            sb.Append(key)
            sb.Append(" = ")
            sb.Append(Application(key))
            contents.Add(sb.ToString())
        Next
    End Sub
    private contents as ArrayList
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Using Application State</title>
	</head>
	<body>
		<form action="ApplicationState.aspx" method="post">
			<h2>Current Application Contents:</h2>
			<ul>
			    <% for each s as String in contents %>
		            <li><%= s %></li>
		        <% next %>
			</ul>
			<p>
				Application Entry Name
				<input type="text" name="entryBox" maxlength="10"/>
			</p>
			<p>
				Application Entry Value
				<input type="text" name="valueBox" maxlength="10"/>
			</p>
			<p>
				<input type="submit" value="Add Item To Application"/>
			</p>
		</form>
	</body>
</html>

