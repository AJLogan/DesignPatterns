Module Launcher

    Sub Main()
        Console.WriteLine("Enter the height of the pyramid...")
        Dim height As Integer = Convert.ToInt32(Console.ReadLine())
        Console.WriteLine("Here is a pyramid of height {0}", height)

        Dim numHashes As Integer = 1

        For x As Integer = 1 To height Step 1
            Dim numSpaces As Integer = height - x

            For y As Integer = 1 To numSpaces Step 1
                Console.Write(" ")
            Next

            For y As Integer = 1 To numHashes Step 1
                Console.Write("#")
            Next

            Console.WriteLine()
            numHashes += 2
        Next
    End Sub

End Module
