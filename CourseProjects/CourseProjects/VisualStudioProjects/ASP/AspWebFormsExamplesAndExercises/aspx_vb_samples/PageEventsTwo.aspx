<%@ Page Language="VB" %>
<script  runat="server">
    Protected Overrides Sub OnInit(ByVal e As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_Init after post back</h3>")
        Else
            Response.Write("<h3>Page_Init before post back</h3>")
        End If
    End Sub
    Protected Overrides Sub OnPreRender(ByVal e As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_PreRender after post back</h3>")
        Else
            Response.Write("<h3>Page_PreRender before post back</h3>")
        End If
    End Sub
    Protected Overrides Sub OnLoad(ByVal e As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_Load after post back</h3>")
        Else
            Response.Write("<h3>Page_Load before post back</h3>")
        End If
    End Sub
    Protected Overrides Sub OnUnload(ByVal e As EventArgs)
        'Cannot write anything here as page rendered
    End Sub
</script>
<form runat="server" ID="Form1">
	<input type="submit" runat="server" value="Submit" ID="Submit1" NAME="Submit1"/>
</form>

