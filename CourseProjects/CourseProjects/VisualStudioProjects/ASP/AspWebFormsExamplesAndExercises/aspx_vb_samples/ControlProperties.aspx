<%@ Page Language="VB" %>
<script runat="server">
    Public Sub Page_Load(ByVal sender As Object, ByVal args As EventArgs)
        If (IsPostBack) Then
            targetText.InnerText = newText.InnerText
            targetText.Style("font-size") = fontSize.Value + "pt"
            If (r1.Checked) Then
                targetText.Style("text-decoration") = "underline"
            ElseIf (r2.Checked) Then
                targetText.Style("text-decoration") = "overline"
            ElseIf (r3.Checked) Then
                targetText.Style("text-decoration") = "line-through"
            End If
        End If
    End Sub
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
				Underline <input type="radio" id="r1" name="decoration" runat="server" checked="true"/>
				Overline<input type="radio" id="r2" name="decoration" runat="server"/>
				Line-Through<input type="radio" id="r3" name="decoration" runat="server"/>
			</p>
			<p>
				Replacement text:<br/>
				<textarea cols="40" rows="5" id="newText" runat="server">REPLACEMENT TEXT</textarea>
			</p>
			<p>
				<input type="submit" value="submit"/>
			</p>
		</form>
	</body>
</html>
