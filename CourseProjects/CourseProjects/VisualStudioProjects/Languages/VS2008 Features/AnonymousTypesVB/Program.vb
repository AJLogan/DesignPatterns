Imports System.Reflection

Module Program
    Sub Main()
        Dim obj1 = New With {.Name = "Dave", .Department = "IT", .Age = 32, .Salary = 40000.0}
        Console.WriteLine("obj1 is of type: {0}", obj1.GetType().Name)
        Dim p As PropertyInfo = Nothing
        For Each p In obj1.GetType().GetProperties
            Console.WriteLine(vbTab + "{0} has value {1}", p.Name, p.GetValue(obj1, Nothing))
        Next
    End Sub
End Module
