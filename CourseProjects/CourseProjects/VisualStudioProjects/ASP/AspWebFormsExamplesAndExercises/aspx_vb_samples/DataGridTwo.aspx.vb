
Imports System.Data

Partial Class DataGridTwo
    Inherits System.Web.UI.Page
    Protected coursesDataSet As DataSet

    Protected Overrides Sub OnLoad(ByVal e As EventArgs)
        coursesDataSet = New DataSet()
        coursesDataSet.ReadXml(Request.MapPath("coursesDataSet.xml"))
        coursesGrid.DataSource = coursesDataSet
        coursesGrid.DataBind()
    End Sub
End Class
