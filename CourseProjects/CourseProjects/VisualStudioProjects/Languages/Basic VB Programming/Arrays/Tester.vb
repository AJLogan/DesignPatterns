Module Tester

    Sub Main()
        'A single dimension array initialized manually
        'int[] intArrayOne = new int[4]
        Dim intArrayOne(4) As Integer
        intArrayOne(0) = 10
        intArrayOne(1) = 20
        intArrayOne(2) = 30
        intArrayOne(3) = 40
        intArrayOne(4) = 50

        'Single dimension arrays initialized via lists of literals
        Dim intArrayTwo() As Integer = {10, 20, 30, 40, 50}
        Dim intArrayThree() As Integer = New Integer() {10, 20, 30, 40, 50}

        PrintArray(intArrayOne)
        PrintArray(intArrayTwo)
        PrintArray(intArrayThree)

        'A two dimensional rectangular array
        Dim intArrayFour(5, 5) As Integer
        For i As Integer = 0 To 5
            For x As Integer = 0 To 5
                intArrayFour(i, x) = i + x
            Next
        Next

        Print2DRegularArray(intArrayFour)

        'A two dimensional ragged array
        ' (implemented internally as an array of arrays)
        Dim intArrayFive(5)() As Integer
        intArrayFive(0) = New Integer() {1, 2, 3, 4, 5}
        intArrayFive(1) = New Integer() {1, 2, 3, 4}
        intArrayFive(2) = New Integer() {1, 2, 3}
        intArrayFive(3) = New Integer() {1, 2, 3, 4}
        intArrayFive(4) = New Integer() {1, 2, 3, 4, 5, 6, 7, 8}
        intArrayFive(5) = New Integer() {1, 2}

        'Dim sizeOfRowTwo = intArrayFive(1).Length
        'Console.WriteLine("Siae of row two is {0}", sizeOfRowTwo)

        Print2DJaggedArray(intArrayFive)

    End Sub

    Sub PrintArray(ByVal pArray() As Integer)
        'Dim value As Integer

        Console.WriteLine("Found ")
        For Each value As Integer In pArray
            Console.Write("{0} ", value)
        Next
        Console.WriteLine()

        Console.WriteLine("----------------")
    End Sub

    Sub Print2DRegularArray(ByVal pArray(,) As Integer)
        Console.WriteLine("Found ")
        For i As Integer = 0 To (pArray.GetLength(0) - 1)
            For x As Integer = 0 To (pArray.GetLength(1) - 1)
                Console.Write("{0} ", pArray(i, x))
            Next
            Console.WriteLine()
        Next
        Console.WriteLine()

        Console.WriteLine("----------------")
    End Sub

    Sub Print2DJaggedArray(ByVal pArray()() As Integer)
        Dim subArray() As Integer
        Dim value As Integer

        Console.WriteLine("Found ")
        For Each subArray In pArray
            For Each value In subArray
                Console.Write("{0} ", value)
            Next
            Console.WriteLine()
        Next
        Console.WriteLine()

        Console.WriteLine("----------------")
    End Sub
End Module
