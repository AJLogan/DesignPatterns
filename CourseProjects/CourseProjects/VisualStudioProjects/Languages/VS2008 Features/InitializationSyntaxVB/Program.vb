Module Program

    Sub Main()
        Dim emp1 = New Employee With {.Name = "Fred", .Age = 27, .Salary = 30000.0}
        Dim emp2 = New Employee With {.Name = "Jane", .Age = 29, .Salary = 40000.0}

        Console.WriteLine(emp1)
        Console.WriteLine(emp2)
    End Sub

End Module
