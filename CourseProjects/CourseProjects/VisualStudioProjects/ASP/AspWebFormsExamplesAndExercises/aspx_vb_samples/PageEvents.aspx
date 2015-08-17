<%@ Page Language="VB" %>
<script runat="server">
    Public Sub Page_Init(ByVal sender As Object, ByVal args As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_Init after post back</h3>")
        Else
            Response.Write("<h3>Page_Init before post back</h3>")
        End If
    End Sub
    Public Sub Page_PreRender(ByVal sender As Object, ByVal args As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_PreRender after post back</h3>")
        Else
            Response.Write("<h3>Page_PreRender before post back</h3>")
        End If
    End Sub
    Public Sub Page_Load(ByVal sender As Object, ByVal args As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_Load after post back</h3>")
        Else
            Response.Write("<h3>Page_Load before post back</h3>")
        End If
    End Sub
    Public Sub Page_Unload(ByVal sender As Object, ByVal args As EventArgs)
        'Cannot write anything here as page rendered
    End Sub
</script>
<form runat="server">
	<input type="submit" runat="server" value="Submit"/>
</form>
