Module Launcher

    Sub Main()
        Console.WriteLine("Start of Main")
        'Try
        Op1()
        'Catch ex As Exception
        'Console.WriteLine("Just caught an exception")
        'End Try
        Console.WriteLine("End of Main")
    End Sub

    Sub Op1()
        Console.WriteLine(vbTab + "Start of Op1")
        Op2()
        Console.WriteLine(vbTab + "End of Op1")
    End Sub

    Sub Op2()
        Console.WriteLine(vbTab + vbTab + "Start of Op2")
        Try
            Op3()
        Catch ex As Exception
            Console.WriteLine("Just caught an exception")
        End Try
        Console.WriteLine(vbTab + vbTab + "End of Op2")
    End Sub

    Sub Op3()
        Console.WriteLine(vbTab + vbTab + vbTab + "Start of Op3")
        Op4()
        Console.WriteLine(vbTab + vbTab + vbTab + "End of Op3")
    End Sub

    Sub Op4()
        Console.WriteLine(vbTab + vbTab + vbTab + vbTab + "Start of Op4")
        Op5()
        Console.WriteLine(vbTab + vbTab + vbTab + vbTab + "End of Op4")
    End Sub

    Sub Op5()
        Console.WriteLine(vbTab + vbTab + vbTab + vbTab + vbTab + "Start of Op5")
        Op6()
        Console.WriteLine(vbTab + vbTab + vbTab + vbTab + vbTab + "End of Op5")
    End Sub

    Sub Op6()
        Dim r As New Random
        Dim tmp As Integer = r.Next(60)

        If tmp < 30 Then
            Throw New Exception("BOOM")
        Else
            Console.WriteLine("No exception thrown in Op6")
        End If
    End Sub

End Module
