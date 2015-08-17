Module Tester

    Sub Main()
        Dim c1 As New Derived
        Console.WriteLine("First Object: {0}", c1)
        Console.WriteLine(vbNewLine + "----------------------------" + vbNewLine)
        Dim c2 As New Derived("abc")
        Console.WriteLine("Second Object: {0}", c2)
        Console.WriteLine(vbNewLine + " - ---------------------------" + vbNewLine)
        Dim c3 As New Derived("abc", "def")
        Console.WriteLine("Third Object: {0}", c3)
        Console.WriteLine(vbNewLine + " - ---------------------------" + vbNewLine)
        Dim c4 As New Derived("abc", "def", "ghi")
        Console.WriteLine("Fourth Object: {0}", c4)
    End Sub

End Module
