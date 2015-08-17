Module Launcher

    Sub Main()
        Dim r As New Random

        Dim randomOne As Integer
        randomOne = r.Next(20)

        If randomOne < 5 Then
            Console.WriteLine("{0} is less than 5", randomOne)
        ElseIf randomOne < 10 Then
            Console.WriteLine("{0} is less than 10", randomOne)
        ElseIf randomOne < 15 Then
            Console.WriteLine("{0} is less than 15", randomOne)
        Else
            Console.WriteLine("{0} is less than 20", randomOne)
        End If

        Console.WriteLine()

        Select Case randomOne
            Case 0
                Console.WriteLine("Value is zero")
            Case 1 To 4
                Console.WriteLine("{0} is between one and four", randomOne)
            Case 5 To 15
                Console.WriteLine("{0} is between five and fifteen", randomOne)
            Case Else
                Console.WriteLine("{0} is greater then fifteen", randomOne)
        End Select

        Console.WriteLine()

        Dim randomTwo As Integer = r.Next(3)
        Dim randomTwoStr As String = randomTwo.ToString()

        Select Case randomTwoStr
            Case "0"
                Console.WriteLine("Value is zero")
            Case "1"
                Console.WriteLine("Value is one")
            Case "2"
                Console.WriteLine("Value is two")
            Case "3"
                Console.WriteLine("Value is three")
            Case Else
                Console.WriteLine("Value is something else ({0})", randomTwoStr)
        End Select

        Console.WriteLine()

    End Sub

End Module
