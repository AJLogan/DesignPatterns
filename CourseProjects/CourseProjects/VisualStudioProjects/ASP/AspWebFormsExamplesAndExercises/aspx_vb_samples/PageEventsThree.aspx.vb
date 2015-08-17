
Partial Class PageEventsThree
    Inherits System.Web.UI.Page

    Public Sub New()
        AddHandler Init, New EventHandler(AddressOf myInit)
        AddHandler PreRender, New EventHandler(AddressOf myPreRender)
        AddHandler Load, New EventHandler(AddressOf myLoad)
        AddHandler Unload, New EventHandler(AddressOf myUnload)
    End Sub
    Public Sub myInit(ByVal sender As Object, ByVal e As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_Init after post back</h3>")
        Else
            Response.Write("<h3>Page_Init before post back</h3>")
        End If
    End Sub
    Public Sub myPreRender(ByVal sender As Object, ByVal e As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_PreRender after post back</h3>")
        Else
            Response.Write("<h3>Page_PreRender before post back</h3>")
        End If
    End Sub
    Public Sub myLoad(ByVal sender As Object, ByVal e As EventArgs)
        If (IsPostBack) Then
            Response.Write("<h3>Page_Load after post back</h3>")
        Else
            Response.Write("<h3>Page_Load before post back</h3>")
        End If
    End Sub
    Public Sub myUnload(ByVal sender As Object, ByVal e As EventArgs)
        'Cannot write anything here as page rendered
    End Sub
End Class
