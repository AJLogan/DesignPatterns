Public Class Test
    Public Sub New(ByVal p1 As Double)
        num = p1
    End Sub
    Public Function multiply(ByVal p1 As Integer) As Double
        Return num * p1
    End Function
    Public Function divide(ByVal p1 As Integer) As Double
        Return num / p1
    End Function
    Private num As Double
End Class
