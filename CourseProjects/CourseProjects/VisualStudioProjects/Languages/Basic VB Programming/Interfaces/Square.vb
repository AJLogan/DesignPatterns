Public Class Square
    Inherits Shape

    Public Overrides Sub paint(ByVal color As Integer)
    End Sub
    Public Overrides Sub draw(ByVal size As Integer)
        drawTopOrBottom(size)
        drawSides(size)
        drawTopOrBottom(size)
    End Sub
    Private Sub drawTopOrBottom(ByVal size As Integer)
        For i As Integer = 0 To size
            Console.Write("+")
        Next i
        Console.WriteLine()
    End Sub
    Private Sub drawSides(ByVal size As Integer)
        For i As Integer = 0 To size
            Console.Write("+")
            For x As Integer = 2 To size
                Console.Write(" ")
            Next x
            Console.WriteLine("+")
        Next i
    End Sub
End Class
