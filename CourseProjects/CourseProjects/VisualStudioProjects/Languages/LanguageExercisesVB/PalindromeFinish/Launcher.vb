Module Launcher
    Private Const data1 As String = "A man, a plan, a canal, Panama"
    Private Const data2 As String = "Gold is where you find it"
    Private Const data3 As String = "If I had a hi-fi"
    Private Const data4 As String = "Fortune favors the prepared mind"
    Private Const data5 As String = "Rats live on no evil star"
    Private Const data6 As String = "There is no abstract living"
    Private Const data7 As String = "Some men interpret nine memos"
    Sub Main()
        Test(data1)
        Test(data2)
        Test(data3)
        Test(data4)
        Test(data5)
        Test(data6)
        Test(data7)
    End Sub
    Private Sub Test(ByVal input As String)
        If TestForPalindrome(input) Then
            Console.WriteLine("{0} is a palindrome", input)
        Else
            Console.WriteLine("{0} is NOT a palindrome", input)
        End If
    End Sub
    Private Function TestForPalindrome(ByVal input As String) As Boolean
        Dim transformed As String = input.ToLower
        Dim forward As Integer = 0
        Dim backward As Integer = transformed.Length - 1

        While (forward < backward)
            While (Not IsLetter(transformed(forward)))
                forward += 1
            End While
            While (Not IsLetter(transformed(backward)))
                backward -= 1
            End While

            If transformed(forward) <> transformed(backward) Then
                Return False
            End If

            forward += 1
            backward -= 1
        End While

        Return True
    End Function
    Private Function IsLetter(ByVal c As Char) As Boolean
        Return c >= "a" And c <= "z"
    End Function
End Module
