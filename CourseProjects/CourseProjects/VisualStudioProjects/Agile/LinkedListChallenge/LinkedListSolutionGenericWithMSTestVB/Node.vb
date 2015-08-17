Public Class Node(Of T)
    Public Sub New(ByVal item As T, ByVal n As Node(Of T))
        _payload = item
        _prev = n
    End Sub
    Public Property After() As Node(Of T)
        Get
            Return _next
        End Get
        Set(ByVal value As Node(Of T))
            _next = value
        End Set
    End Property
    Public Property Before() As Node(Of T)
        Get
            Return _prev
        End Get
        Set(ByVal value As Node(Of T))
            _prev = value
        End Set
    End Property
    Public ReadOnly Property Item() As T
        Get
            Return _payload
        End Get
    End Property
    Private _next As Node(Of T)
    Private _prev As Node(Of T)
    Private ReadOnly _payload As T
End Class
