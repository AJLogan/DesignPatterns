Public Class Triangle
    Inherits Shape
    Public Overrides Sub paint(ByVal color As Integer)
    End Sub

    Public Overrides Sub draw(ByVal size As Integer)
        For i As Integer = 0 To size
            printLeftSize(size, i)
            printMiddle(size, i)
            printRightSize()
        Next i
        printBase(size)
    End Sub
    Private Sub printLeftSize(ByVal size As Integer, ByVal rowNum As Integer)
        For i As Integer = (size - rowNum) To 1 Step -1
            Console.Write(" ")
        Next i
        Console.Write("/")
    End Sub
    Private Sub printMiddle(ByVal size As Integer, ByVal rowNum As Integer)
        For i As Integer = 0 To rowNum
            Console.Write("  ")
        Next i
    End Sub
    Private Sub printRightSize()
        Console.WriteLine("\")
    End Sub
    Private Sub printBase(ByVal size As Integer)
        Dim baseSize As Integer = size * 2
        Console.Write(" ")
        For i As Integer = 0 To baseSize
            Console.Write("-")
        Next i
        Console.WriteLine()
    End Sub
End Class
