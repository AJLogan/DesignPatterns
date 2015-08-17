<%@ Page language="c#" Inherits="aspxsamples.DecodingViewState" CodeFile="DecodingViewState.aspx.cs" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Examining View State</title>
		<script runat="server">
		protected override void OnLoad(EventArgs e) {
			int num = Convert.ToInt32(number.InnerText); 
			number.InnerText = (num * 2).ToString();
		}
		</script>
	</head>
	<body>
		<form runat="server">
			<h3 id="number" runat="server">10</h3>
			<input type="submit" value="Double Number">
		</form>
		<h3>View State value is:</h3>
		<p>
			<%= Request.Params["__VIEWSTATE"]%>
		</p>
	</body>
</html>
