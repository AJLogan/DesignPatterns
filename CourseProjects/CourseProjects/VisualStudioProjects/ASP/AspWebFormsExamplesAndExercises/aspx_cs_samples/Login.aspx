<%@ Page language="c#" Inherits="aspxsamples.Login" CodeFile="Login.aspx.cs" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Login</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
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
				Width="80px" Height="24px" Text="Log In" onclick="btSubmit_Click"></asp:Button>
		</form>
	</body>
</HTML>
