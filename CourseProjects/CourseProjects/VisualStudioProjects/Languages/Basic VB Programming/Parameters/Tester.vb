Imports System.Text


Module Tester

    Sub Main()
        Dim ival As Integer = 20
        Console.WriteLine("Value of variable is: {0}", ival)
        IncrementByValue(ival)
        Console.WriteLine("Value of variable is: {0}", ival)
        IncrementByReference(ival)
        Console.WriteLine("Value of variable is: {0}", ival)

        Console.WriteLine(vbNewLine + "--------------------------" + vbNewLine)

        Dim sb As StringBuilder
        sb = New StringBuilder
        sb.Append("ABC")
        Console.WriteLine("Value of object is: {0}", sb)
        ModifyByValue(sb)
        Console.WriteLine("Value of object is: {0}", sb)
        ModifyByReference(sb)
        Console.WriteLine("Value of object is: {0}", sb)

        Console.WriteLine(vbNewLine + "--------------------------" + vbNewLine)

        optionalDemo(50)
        optionalDemo()

        Console.WriteLine(vbNewLine + "--------------------------" + vbNewLine)

        paramArgs(10, 20, 30, 40, 50, 60, 70, 80)

        Console.WriteLine(vbNewLine + "--------------------------" + vbNewLine)


    End Sub

    Sub IncrementByValue(ByVal p1 As Integer)
        'this has no effect on the original variable
        ' because its value has been copies into p1
        p1 += 1
    End Sub
    Sub IncrementByReference(ByRef p1 As Integer)
        'this changes the original variable
        ' because p1 is linked to it
        p1 += 1
    End Sub
    Sub ModifyByValue(ByVal p1 As StringBuilder)
        'this adds to the original object because what
        ' we have copied is the REFERENCE to the object
        p1.Append("XXXX")
        'this has no affect on the original reference
        p1 = New StringBuilder
        p1.Append("QQQQQQQQ")
    End Sub

    Sub ModifyByReference(ByRef p1 As StringBuilder)
        'this changes the original reference
        p1 = New StringBuilder
        p1.Append("QQQQQQQQ")
    End Sub

    Sub optionalDemo(Optional ByVal p1 As Integer = 20)
        Console.WriteLine("optionalDemo called with value: {0}", p1)
    End Sub

    Sub paramArgs(ByVal ParamArray args As Integer())
        Dim arg As Integer
        Console.WriteLine("paramArgs called with: ")
        For Each arg In args
            Console.Write("{0} ", arg)
        Next
        Console.WriteLine()
    End Sub
End Module
