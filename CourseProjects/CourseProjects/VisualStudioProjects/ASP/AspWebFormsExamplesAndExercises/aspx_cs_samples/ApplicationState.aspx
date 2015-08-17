<%@ Page language="c#" %>
<script runat="server">
    public void Page_Load() {
        contents = new ArrayList();
        if (Request.RequestType.Equals("POST")) {
            string applicationKey = Request.Form["entryBox"];
            string applicationValue = Request.Form["valueBox"];
            if (!applicationKey.Equals("")) {
                if (!applicationValue.Equals("")) {
                    Application.Add(applicationKey, applicationValue);
                }
            }
        }
        foreach (string key in Application.Keys) {
            StringBuilder sb = new StringBuilder();
            sb.Append(key);
            sb.Append(" = ");
            sb.Append(Application[key]);
            contents.Add(sb.ToString());
        }
    }
    private ArrayList contents;
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Using Application State</title>
	</head>
	<body>
		<form action="ApplicationState.aspx" method="post">
			<h2>Current Application Contents:</h2>
			<ul>
			    <% foreach(string s in contents) { %>
		            <li><%= s %></li>
		        <% } %>
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

