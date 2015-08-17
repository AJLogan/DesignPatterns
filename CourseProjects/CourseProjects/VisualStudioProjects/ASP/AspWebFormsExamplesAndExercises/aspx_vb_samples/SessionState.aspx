<%@ Page language="VB" %>
<script runat="server">
    Public Sub Page_Load()
        contents = New ArrayList()
        If (Request.RequestType.Equals("POST")) Then
            Dim sessionKey As String = Request.Form("entryBox")
            Dim sessionValue As String = Request.Form("valueBox")
            If (Not sessionKey.Equals("")) Then
                If (Not sessionValue.Equals("")) Then
                    Session.Add(sessionKey, sessionValue)
                End If
            End If
        End If
        For Each key As String In Session.Keys
            Dim sb As StringBuilder = New StringBuilder()
            sb.Append(key)
            sb.Append(" = ")
            sb.Append(Session(key))
            contents.Add(sb.ToString())
        Next
    End Sub
    Private contents As ArrayList
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Using Session State</title>
	</head>
	<body>
		<form action="SessionState.aspx" method="post">
			<h2>Current Session Contents:</h2>
			<ul>
			    <% 
			        For Each s As String In contents
			    %>
		            <li><%= s %></li>
		        <% Next%>
			</ul>
			<p>
				Session Entry Name
				<input type="text" name="entryBox" maxlength="10"/>
			</p>
			<p>
				Session Entry Value
				<input type="text" name="valueBox" maxlength="10"/>
			</p>
			<p>
				<input type="submit" value="Add Item To Session"/>
			</p>
		</form>
	</body>
</html>
