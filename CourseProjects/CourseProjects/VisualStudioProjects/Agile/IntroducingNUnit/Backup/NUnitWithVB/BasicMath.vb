Public Class BasicMath
    Public Sub New(ByVal no1 As Integer, ByVal no2 As Integer)
        Me.no1 = no1
        Me.no2 = no2
    End Sub
    Public Function add() As Integer
        Return no1 + no2
    End Function
    Public Function subtract() As Integer
        Return no1 - no2
    End Function
    Public Function multiply() As Integer
        Return no1 * no2
    End Function
    Private no1 As Integer
    Private no2 As Integer
End Class
