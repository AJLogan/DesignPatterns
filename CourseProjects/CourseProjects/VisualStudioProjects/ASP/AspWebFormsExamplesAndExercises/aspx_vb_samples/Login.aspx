<%@ Page language="VB" %>
<script  runat="server">
    Protected Sub handleSubmit(ByVal sender As Object, ByVal e As EventArgs)
        If (tbUsername.Text.Equals("Dave")) Then
            If (tbPassword.Text.Equals("wn1hgb")) Then
                'The second parameter determines if a cookie will be set
                FormsAuthentication.RedirectFromLoginPage(tbUsername.Text, True)
            End If
        End If
    End Sub
</script>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<form id="Form1" method="post" runat="server">
			<asp:TextBox id="tbUsername" style="Z-INDEX: 101; LEFT: 136px; POSITION: absolute; TOP: 40px"
				runat="server" Width="152px" Height="24px"></asp:TextBox>
			<asp:Label id="Label2" style="Z-INDEX: 104; LEFT: 56px; POSITION: absolute; TOP: 80px" runat="server"
				Width="56px" Height="24px">Password</asp:Label>
			<asp:TextBox id="tbPassword" style="Z-INDEX: 102; LEFT: 136px; POSITION: absolute; TOP: 80px"
				runat="server" Width="152px" Height="24px"></asp:TextBox>
			<asp:Label id="Label1" style="Z-INDEX: 103; LEFT: 56px; POSITION: absolute; TOP: 40px" runat="server"
				Width="64px" Height="24px">Username</asp:Label>
			<asp:Button id="btSubmit" style="Z-INDEX: 105; LEFT: 64px; POSITION: absolute; TOP: 128px" runat="server"
				Width="80px" Height="24px" Text="Log In" onclick="handleSubmit"></asp:Button>
		</form>
	</body>
</html>
