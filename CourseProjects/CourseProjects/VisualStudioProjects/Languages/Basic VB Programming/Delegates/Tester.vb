Delegate Function SomeFunc(ByVal i As Integer) As Double

Module Tester
    Sub Main()
        Dim sf1 As New SomeFunc(AddressOf square)
        Dim sf2 As New SomeFunc(AddressOf half)

        Dim t1 As New Test(20)
        Dim t2 As New Test(15)
        Dim sf3 As New SomeFunc(AddressOf t1.multiply)
        Dim sf4 As New SomeFunc(AddressOf t2.divide)

        applyDelegate(sf1, 20)
        applyDelegate(sf2, 15)
        applyDelegate(sf3, 2)
        applyDelegate(sf4, 10)

    End Sub

    Sub applyDelegate(ByVal sf As SomeFunc, ByVal val As Integer)
        Console.WriteLine("Result is {0}", sf(val))
    End Sub
    Function square(ByVal i As Integer) As Double
        Return i * i
    End Function

    Function half(ByVal i As Integer) As Double
        Return i / 2.0
    End Function

End Module
