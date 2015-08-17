Public Delegate Function MyDelegate(ByVal no1 As Integer, ByVal no2 As Integer) As Double

Module Program
    Sub main()
        Dim d1 As MyDelegate = Function(a As Integer, b As Integer) CDbl(a) / b
        Dim d2 As Func(Of Integer, Integer, Double) = Function(a As Integer, b As Integer) (CDbl(a) / b) + 1

        PrintResultV1(d1)
        PrintResultV2(d2)
        PrintResultV1(Function(a As Integer, b As Integer) (CDbl(a) / b) + 2)
        PrintResultV2(Function(a As Integer, b As Integer) (CDbl(a) / b) + 2)
    End Sub
    Sub PrintResultV1(ByVal param As MyDelegate)
        Console.WriteLine(param(17, 4))
    End Sub
    Sub PrintResultV2(ByVal param As Func(Of Integer, Integer, Double))
        Console.WriteLine(param(17, 4))
    End Sub
End Module
