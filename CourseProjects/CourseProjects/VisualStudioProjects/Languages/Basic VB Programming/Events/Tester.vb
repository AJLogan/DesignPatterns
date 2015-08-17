Public Delegate Sub Callback(ByVal i As Integer, ByVal d As Double)

Module Tester

    Sub Main()
        Dim eh As New EventHolder
        AddHandler eh.MyEvent, New Callback(AddressOf MyCallbackOne)
        AddHandler eh.MyEvent, New Callback(AddressOf MyCallbackTwo)
        eh.TriggerEvent()
    End Sub

    Sub MyCallbackOne(ByVal i As Integer, ByVal d As Double)
        Console.WriteLine("MyCallbackOne {0}, {1}", i, d)
    End Sub
    Sub MyCallbackTwo(ByVal i As Integer, ByVal d As Double)
        Console.WriteLine("MyCallbackTwo {0}, {1}", i, d)
    End Sub

End Module
