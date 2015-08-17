Module Launcher
    Private numerals(8) As RomanNumeral

    Sub Main()
        numerals(0) = New RomanNumeral(100, "C")
        numerals(1) = New RomanNumeral(90, "XC")
        numerals(2) = New RomanNumeral(50, "L")
        numerals(3) = New RomanNumeral(40, "XL")
        numerals(4) = New RomanNumeral(10, "X")
        numerals(5) = New RomanNumeral(9, "IX")
        numerals(6) = New RomanNumeral(5, "V")
        numerals(7) = New RomanNumeral(4, "IV")
        numerals(8) = New RomanNumeral(1, "I")

        Console.WriteLine("Enter a number...")
        Dim number As Integer = Convert.ToInt32(Console.ReadLine())

        Console.Write("{0} as a roman numeral is ", number)
        For Each numeral As RomanNumeral In numerals
            Dim times As Integer = number \ numeral.DecimalValue

            If times > 0 Then
                For x As Integer = 1 To times Step 1
                    Console.Write(numeral.StringValue)
                Next
                number = number Mod numeral.DecimalValue
            End If
        Next

        Console.WriteLine()
    End Sub

End Module
