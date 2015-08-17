Imports Microsoft.VisualBasic
Namespace VisualBasicWebApp
    Public Class ItemListTwo
        Inherits System.Web.UI.Control
        Protected Overrides Sub LoadViewState(ByVal savedState As Object)
            If (Not savedState Is Nothing) Then
                Dim saved As Object() = CType(savedState, Object())
                _isNumbered = CType(saved(0), Boolean)
                _dataCache = CType(saved(1), ArrayList)
            End If
        End Sub

        Protected Overrides Function SaveViewState() As Object
            Dim toSave(2) As Object
            toSave(0) = _isNumbered
            toSave(1) = _dataCache
            Return toSave
        End Function
        Protected Overrides Sub OnDataBinding(ByVal e As EventArgs)
            MyBase.OnDataBinding(e)
            _dataCache = New ArrayList()
            For Each obj As Object In DataSource
                _dataCache.Add(obj)
            Next
        End Sub
        Protected Overrides Sub Render(ByVal writer As HtmlTextWriter)
            Dim listTag As String = Nothing
            If (_isNumbered) Then
                listTag = "ol"
            Else
                listTag = "ul"
            End If
            If (_dataCache Is Nothing) Then
                writer.Write("<ul><li>No Content</li></ul>")
            Else
                writer.WriteFullBeginTag(listTag)
                For Each obj As Object In _dataCache
                    writer.WriteFullBeginTag("li")
                    writer.Write(obj.ToString())
                    writer.WriteEndTag("li")
                Next
                writer.WriteEndTag(listTag)
            End If
        End Sub
        Public Property Numbered() As Boolean
            Get
                Return _isNumbered
            End Get
            Set(ByVal value As Boolean)
                _isNumbered = value
            End Set
        End Property
        Public Property DataSource() As IEnumerable
            Get
                Return _dataSource
            End Get

            Set(ByVal value As IEnumerable)
                _dataSource = value
            End Set
        End Property
        Private _isNumbered As Boolean
        Private _dataSource As IEnumerable
        Private _dataCache As ArrayList
    End Class
End Namespace
