Module Tester

    Sub Main()
        Dim cust As New Customer("Joe Bloggs")
        Console.WriteLine("Customers name is: {0}", cust.Name)
        'Will not compile - Name is a Read Only Property
        'cust.Name = "Dave Bloggs"
        cust.Address = "10 Arcatia Road"
        Console.WriteLine("Just set address to {0}", cust.Address)
        cust.CreditLimit = 30000
        'Will not compile - CreditLimit is a Write Only Property
        'Dim tmp As Double = cust.CreditLimit
        Console.WriteLine("Final details are: {0}", cust)
    End Sub

End Module
