<%@ Page language="c#" %>
<script runat=server>
    public void Page_Load() {
        contents = new ArrayList();
        if (Request.RequestType.Equals("POST")) {
            string sessionKey = Request.Form["entryBox"];
            string sessionValue = Request.Form["valueBox"];
            if (!sessionKey.Equals("")) {
                if (!sessionValue.Equals("")) {
                    Session.Add(sessionKey, sessionValue);
                }
            }
        }
        foreach (string key in Session.Keys) {
            StringBuilder sb = new StringBuilder();
            sb.Append(key);
            sb.Append(" = ");
            sb.Append(Session[key]);
            contents.Add(sb.ToString());
        }
    }
    private ArrayList contents;
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Using Session State</title>
	</head>
	<body>
		<form action="SessionState.aspx" method="post">
			<h2>Current Session Contents:</h2>
			<ul>
			    <% foreach(string s in contents) { %>
		            <li><%= s %></li>
		        <% } %>
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
				<input type="submit" value="Add Item To Session">
			</p>
		</form>
	</body>
</html>
