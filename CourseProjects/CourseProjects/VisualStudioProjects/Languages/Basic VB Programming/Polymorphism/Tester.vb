Module Tester

    Sub Main()
        'TestOne()
        TestTwo()
    End Sub
    Sub TestTwo()
        Dim employees(5) As Employee
        employees(0) = New Employee
        employees(1) = New Director
        employees(2) = New Employee
        employees(3) = New Manager
        employees(4) = New Director
        employees(5) = New Manager
        PromoteAll(employees)
    End Sub

    Sub PromoteAll(ByVal empArray() As Employee)
        For Each tmp As Employee In empArray
            tmp.promote()
        Next
    End Sub

    Sub TestOne()
        Dim e1 As Employee
        Dim e2 As Employee
        Dim e3 As Employee

        e1 = New Employee
        e2 = New Manager
        e3 = New Director

        e1.promote() 'Calls Employee.promote
        e2.promote() 'Calls Manager.promote
        e3.promote() 'Calls Director.promote

    End Sub

End Module
