Module Launcher

    Sub Main()
        Dim s1 As Student = New Student("Joe Bloggs", "Philosophy", 2, New Double() {68.4, 72.3, 59.8, 62.1})
        Dim s2 As Student = New Student("Jane Smith", "Physics", 3, New Double() {84.5, 66.7, 73.2, 60.9})

        Console.WriteLine("--- Objects after creation ---")

        Console.WriteLine(s1)
        Console.WriteLine(s2)

        s1.Year = 3
        s2.Year = 4

        Console.WriteLine("{0}--- Objects after property change ---", Environment.NewLine)
        Console.WriteLine(s1)
        Console.WriteLine(s2)

        Console.WriteLine("{0}--- Average marks are ---", Environment.NewLine)
        Console.WriteLine(s1.average())
        Console.WriteLine(s2.average())
    End Sub

End Module
