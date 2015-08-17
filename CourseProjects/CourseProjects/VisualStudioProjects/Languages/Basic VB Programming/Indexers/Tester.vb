Module Tester

    Sub Main()
        Dim obj As New Indexed
        obj.Items(0) = 101
        obj.Items(1) = 202
        obj.Items(2) = 202
        obj.Items(3) = 303

        Console.WriteLine("Values are {0}, {1}, {2}, {3}", obj.Items(0), obj.Items(1), obj.Items(2), obj.Items(3))
    End Sub

End Module
