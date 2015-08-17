Module Tester

    Sub Main()
        Dim e1 As New Employee("ABC123", "Joe Bloggs", 27, 20000)
        Dim e2 As New SalesPerson("DEF456", "Jane Smith", 32, 40000, 120000)

        Console.WriteLine(vbNewLine + "------Before awarding bonus------" + vbNewLine)
        Console.WriteLine("e1 is {0}", e1)
        Console.WriteLine("e2 is {0}", e2)

        e1.awardBonus(500)
        e2.awardBonus(500)

        Console.WriteLine(vbNewLine + "------After awarding bonus------" + vbNewLine)
        Console.WriteLine("e1 is {0}", e1)
        Console.WriteLine("e2 is {0}", e2)

    End Sub

End Module
