Public Class Person
    Public Sub New()
    End Sub
    Public Sub New(ByVal name As String, ByVal age As Integer)
        _name = name
        _age = age
    End Sub
    Public Property Name() As String
        Get
            Return _name
        End Get
        Set(ByVal value As String)
            _name = value
        End Set
    End Property
    Public Property Age() As Integer
        Get
            Return _age
        End Get
        Set(ByVal value As Integer)
            _age = value
        End Set
    End Property
    Private _name As String
    Private _age As Integer
End Class
