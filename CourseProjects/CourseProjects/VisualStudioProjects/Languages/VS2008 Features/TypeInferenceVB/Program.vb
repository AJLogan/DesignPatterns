Module Program
    Sub Main()
        Dim obj1 = DateTime.Now
        Dim obj2 = "abcdef"
        Dim obj3 = New SomeClass(123.45)

        Console.WriteLine("The date is: {0}", obj1.ToShortDateString())
        Console.WriteLine("The time is: {0}", obj1.ToShortTimeString())
        Console.WriteLine("The length of the string is: {0}", obj2.Length)
        Console.WriteLine("Value returned from MyClass.Func is: {0}", obj3.Func())
    End Sub
End Module
