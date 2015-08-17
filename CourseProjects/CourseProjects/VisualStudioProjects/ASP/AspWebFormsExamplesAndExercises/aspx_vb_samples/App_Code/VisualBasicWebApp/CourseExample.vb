Imports Microsoft.VisualBasic

Public Class CourseExample
    Public Sub New(ByVal _title As String, ByVal _description As String, ByVal _URL As String)
        Me._title = _title
        Me._description = _description
        Me._URL = _URL
    End Sub
    Public Property URL() As String
        Get
            Return _URL
        End Get
        Set(ByVal value As String)
            _URL = value
        End Set
    End Property
    Public Property Description() As String
        Get
            Return _description
        End Get
        Set(ByVal value As String)
            _description = value
        End Set
    End Property
    Public Property Title() As String
        Get
            Return _title
        End Get
        Set(ByVal value As String)
            _title = value
        End Set
    End Property
    Private _URL As String
    Private _description As String
    Private _title As String
End Class
