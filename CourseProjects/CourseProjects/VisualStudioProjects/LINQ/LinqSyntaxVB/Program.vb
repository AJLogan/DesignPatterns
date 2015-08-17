Module Program

    Sub Main()
        Dim testData = BuildData()
        Query1(testData)
        Query2(testData)
        Query3(testData)
        Query4(testData)
        Query5(testData)
        Query6(testData)
        Query7(testData)
        Query8(testData)
        Query9(testData)
        Query10(testData)
    End Sub

    Private Sub Query1(ByVal testData As IEnumerable(Of Employee))
        Dim results = From e In testData _
                      Select e

        Console.WriteLine("----- Query 1 -----")
        For Each emp As Employee In results
            Console.WriteLine(emp)
        Next
    End Sub
    Private Sub Query2(ByVal testData As IEnumerable(Of Employee))
        Dim results = From e In testData _
                      Where e.Dept = "IT" _
                      Select e

        Console.WriteLine("----- Query 2 -----")
        For Each emp As Employee In results
            Console.WriteLine(emp)
        Next
    End Sub
    Private Sub Query3(ByVal testData As IEnumerable(Of Employee))
        Dim results = From e In testData _
                      Where e.Dept = "IT" _
                      Select e.Name

        Console.WriteLine("----- Query 3 -----")
        For Each empName As String In results
            Console.WriteLine(empName)
        Next
    End Sub
    Private Sub Query4(ByVal testData As IEnumerable(Of Employee))
        Dim results = From e In testData _
                      Where e.Dept = "IT" _
                      Select New With {e.Name, e.Dept}

        Console.WriteLine("----- Query 4 -----")
        For Each x In results
            Console.WriteLine("{0} working in {1}", x.Name, x.Dept)
        Next
    End Sub
    Private Sub Query5(ByVal testData As IEnumerable(Of Employee))
        Dim results = From e In testData _
                      Where e.Dept = "IT" _
                      Select New Person With {.Name = e.Name, .Age = e.Age}

        Console.WriteLine("----- Query 5 -----")
        For Each p As Person In results
            Console.WriteLine(p)
        Next
    End Sub
    Private Sub Query6(ByVal testData As IEnumerable(Of Employee))
        Dim results = From e In testData _
                      Order By e.Age _
                      Select New With {e.Name, e.Age}


            Console.WriteLine("----- Query 6 -----")
        For Each x In results
            Console.WriteLine("{0} of age {1}", x.Name, x.Age)
        Next
    End Sub
    Private Sub Query7(ByVal testData As IEnumerable(Of Employee))
        Dim results = From e In testData _
                      Order By e.Age Descending _
                      Select New With {e.Name, e.Age}


        Console.WriteLine("----- Query 7 -----")
        For Each x In results
            Console.WriteLine("{0} of age {1}", x.Name, x.Age)
        Next
    End Sub
    Private Sub Query8(ByVal testData As IEnumerable(Of Employee))
        Console.WriteLine("----- Query 8 -----")
        If (testData.All(Function(emp) (emp.Age >= 16 And emp.Age <= 65))) Then
            Console.WriteLine("All employees in legal age range")
        Else
            Console.WriteLine("One or more employees should not be employed!")
        End If
    End Sub
    Private Sub Query9(ByVal testData As IEnumerable(Of Employee))
        Dim results As IDictionary(Of String, Employee) = testData.ToDictionary(Function(emp) (emp.Name + "_" + emp.Dept))
        Console.WriteLine("----- Query 9 -----")
        For Each key As String In results.Keys
            Console.WriteLine("{0} indexes {1}", key, results(key))
        Next
    End Sub
    Private Sub Query10(ByVal testData As IEnumerable(Of Employee))
        Dim results = testData.ToLookup(Function(emp) (emp.Dept))
        Console.WriteLine("----- Query 10 -----")
        For Each group In results
            Console.Write("{0} indexes: ", group.Key)
            For Each e As Employee In results(group.Key)
                Console.Write(e.Name)
                Console.Write(" ")
            Next
            Console.WriteLine()
        Next
    End Sub
    Private Function BuildData() As IEnumerable(Of Employee)
        Dim data As New List(Of Employee)()
        'Test data built using consutructors
        data.Add(New Employee("Dave", "IT", 21, 30500.0))
        data.Add(New Employee("Jane", "HR", 22, 31000.0))
        data.Add(New Employee("Fred", "IT", 23, 31500.0))
        data.Add(New Employee("Mary", "HR", 24, 32000.0))
        'Test data built using initializer syntax
        data.Add(New Employee With {.Name = "Peter", .Dept = "IT", .Age = 25, .Salary = 32500.0})
        data.Add(New Employee With {.Name = "Lucy", .Dept = "HR", .Age = 26, .Salary = 33000.0})
        data.Add(New Employee With {.Name = "Simon", .Dept = "IT", .Age = 27, .Salary = 33500.0})
        data.Add(New Employee With {.Name = "Hazel", .Dept = "HR", .Age = 28, .Salary = 34000.0})
        Return data
    End Function
End Module
