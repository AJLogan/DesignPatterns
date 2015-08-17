Module Launcher

    Sub Main()
        Dim r As New Random

        Dim randomOne As Integer
        randomOne = r.Next(20)

        Console.WriteLine("Random number is: {0}", randomOne)

        Console.WriteLine()

        For x As Integer = 0 To randomOne Step 1
            Console.WriteLine("Loop one iteration {0}", x)
        Next

        Console.WriteLine()

        For x As Integer = randomOne To 0 Step -1
            Console.WriteLine("Loop two iteration {0}", x)
        Next

        Console.WriteLine()

        Dim randomTwo As Integer
        randomTwo = r.Next(20)

        While randomTwo < 10
            Console.WriteLine("Loop three with value {0}", randomTwo)
            randomTwo = r.Next(20)
        End While
        Console.WriteLine("Loop three exited on value {0}", randomTwo)

        Console.WriteLine()

        Dim randomThree As Integer

        Do
            randomThree = r.Next(20)
            Console.WriteLine("Loop four with value {0}", randomThree)
        Loop While randomThree < 10

        Console.WriteLine()
    End Sub

End Module
