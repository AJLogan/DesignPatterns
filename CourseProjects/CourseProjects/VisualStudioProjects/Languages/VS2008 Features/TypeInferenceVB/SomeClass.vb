Public Class SomeClass
    Public Sub New(ByVal val As Double)
        Me.val = val
    End Sub
    Public Function Func() As Double
        Return val
    End Function
    Private val As Double
End Class
