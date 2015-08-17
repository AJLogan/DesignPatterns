<%@ Page Language="C#" %>
<script runat="server">
	public void Page_Load(object sender, EventArgs args) {
		if(IsPostBack) {
			targetText.InnerText = newText.InnerText;
			targetText.Style["font-size"] = fontSize.Value + "pt"; 
			if(r1.Checked) {
				targetText.Style["text-decoration"] = "underline";
			} else if(r2.Checked) {
				targetText.Style["text-decoration"] = "overline";
			} else if(r3.Checked) {
				targetText.Style["text-decoration"] = "line-through";
			}
		}
	}
</script>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Using Control Properties</title>
	</head>
	<body>
		<hr/>
		<p id="targetText" runat="server">
			ORIGINAL TEXT
		</p>
		<hr/>
		<h3>Enter some new settings:</h3>
		<form runat="server">
			<p>
				Font size <input type="text" id="fontSize" value="24" maxlength="3" runat="server"/>
			</p>
			<p>
				Font decoration:<br/>
				Underline <input type="radio" id="r1" name="decoration" runat="server" checked/>
				Overline<input type="radio" id="r2" name="decoration" runat="server"/>
				Line-Through<input type="radio" id="r3" name="decoration" runat="server"/>
			</p>
			<p>
				Replacement text:<br/>
				<textarea id="newText" runat="server">REPLACEMENT TEXT</textarea>
			</p>
			<p>
				<input type="submit" value="submit"/>
			</p>
		</form>
	</body>
</html>
